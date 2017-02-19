package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.ArContinuation;
import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.continuation.FnContinuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.Value;
import fyi.jerry.cek.lang.expr.value.Variable;

/**
 * 
 * @author jerry
 */
final public class Cek4 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return       p.getC().getM() instanceof Value
                && !(p.getC().getM() instanceof Variable)
                &&   p.getK()        instanceof ArContinuation;
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure        c = p.getC();
            Environment    e = c.getE();
            ArContinuation k = (ArContinuation) p.getK();


            Environment    ek = k.getE();
            Continuation   kk = k.getK();
            Expression     nk = k.getN();
            
            Closure        c1 = new Closure(nk, ek);
            FnContinuation k1 = new FnContinuation(c, kk);
            CkPair         ck = new CkPair(c1, k1);
            
            return ck;
            
        } else {
            throw new IllegalStateException();
        }     
    }

    
    @Override
    public String toString() {
        return "cek4";
    }
}
