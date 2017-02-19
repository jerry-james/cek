package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.value.Variable;

/**
 * 
 * @author jerry
 */
final public class Cek7 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return p.getC().getM() instanceof Variable;
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {

            Closure      c = p.getC();
            Environment  e = c.getE();
            Continuation k = p.getK();

            Variable     x = (Variable) c.getM();

            Closure     c1 = e.lookup(x);
            CkPair      ck = new CkPair(c1, k);

            return ck;

        } else {
            throw new IllegalStateException();
        }
    }
    
    
    @Override
    public String toString() {
        return "cek7";
    }

}
