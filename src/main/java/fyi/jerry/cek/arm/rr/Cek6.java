package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.continuation.OpContinuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.Value;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

/**
 * 
 * @author jerry
 */
final public class Cek6 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return       p.getC().getM() instanceof Value
                && !(p.getC().getM() instanceof Variable)
                &&   p.getK()        instanceof OpContinuation
                && !((OpContinuation)p.getK()).getCl().isEmpty();
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure        c0 = p.getC();
            Environment    e0 = c0.getE();
            OpContinuation k0 = (OpContinuation) p.getK();

            List<Closure> cl = k0.getCl();
            List<Closure> cm = k0.getCm();
            Continuation  k1 = k0.getK();
            Primop        op = k0.getOp();

            Closure    cl0 = cl.remove(0);
            Expression   n = cl0.getM();
            Environment en = cl0.getE();
            
            cm.add(c0);
            
            OpContinuation k2 = new OpContinuation(op, cm, cl, k1);
            CkPair         ck = new CkPair(cl0, k2);
            
            return ck;
            
        } else {
            throw new IllegalStateException();
        }
    }

    
    @Override
    public String toString() {
        return "cek6";
    }
}
