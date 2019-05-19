package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.ArContinuation;
import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Combination;
import fyi.jerry.cek.lang.expr.Expression;

/**
 * 
 * @author jerry
 */
final public class Cek1 implements ReductionRelation {
    
    @Override
    public boolean reducable(CkPair p) {
        return p.accept(new IsClosureExpressionACombination());
    }
    
    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure      c = p.getC();
            Environment  e = c.getE();
            Continuation k = p.getK();
            
            Combination  combination = (Combination) c.getM();
            Expression   m = combination.getM();
            Expression   n = combination.getN();

            Closure        cm = new Closure(m, e);
            Closure        cn = new Closure(n, e);
            ArContinuation k1 = new ArContinuation(cn, k);
            CkPair         ck = new CkPair(cm, k1);
            
            return ck;
            
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return "cek1";
    }
}
