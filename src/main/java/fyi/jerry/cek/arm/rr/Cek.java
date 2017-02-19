package fyi.jerry.cek.arm.rr;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

/** Entry point into CEK machine
 *
 * @author jerry
 */
public class Cek extends ARMachine {

    /** Runs the CEK machine starting from {@code CkPair}
     *
     * @param p
     */
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static void stepEvaluator(CkPair p) {
        ServiceLoader<ReductionRelation> rr = ServiceLoader.load(ReductionRelation.class);
        List<ReductionRelation> rrs = new LinkedList<>();
        rr.forEach((ReductionRelation t) -> rrs.add(t));
        CkPair current = p;
        System.out.println(current);
        while(true) {
            Optional<CkPair> next = step(rrs,current);
            if(next.isPresent()) {
                current = next.get();
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    private static Optional<CkPair> step(List<ReductionRelation> rrs, CkPair current) {
        Optional<ReductionRelation> rr = rrs.stream().filter(t -> t.reducable(current)).findFirst();
        if(rr.isPresent()) {
            CkPair reduce = rr.get().reduce(current);
            System.out.printf("=%s=> %s\n",rr.get(),reduce);
            return Optional.of(reduce);
        } else {
            return Optional.empty();
        }
    }
    
}
