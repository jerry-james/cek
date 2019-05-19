package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.continuation.FnContinuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.Lambda;
import fyi.jerry.cek.lang.expr.value.Value;
import fyi.jerry.cek.lang.expr.value.Variable;

/**
 * 
 * @author jerry
 */
final public class Cek3 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return       isClosureExpressionAValue(p)
                && isClosureExpressionNotAVariable(p)
                && isContinuationFn(p)
                && isFnContinuationClosureExpressionALambda(p);
    }

    private boolean isFnContinuationClosureExpressionALambda(CkPair p) {
        return p.accept(new IsFnContinuationClosureExpressionALambda());
    }

    private boolean isContinuationFn(CkPair p) {
        return p.accept(new IsContinuationFn());
    }

    private boolean isClosureExpressionNotAVariable(CkPair p) {
        return p.accept(new IsClosureExpressionNotAVariable());
    }

    private boolean isClosureExpressionAValue(CkPair p) {
        return p.accept(new IsClosureExpressionAValue());
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure        c = p.getC();
            Environment    e = c.getE();
            FnContinuation k = (FnContinuation) p.getK();

            Environment    ek = k.getC().getE();
            Continuation   kk = k.getK();
            Lambda         f  = (Lambda) k.getC().getM();
            Variable       x  = f.getX();
            Expression     m  = f.getM();
            
            Environment e1 = Environment.extend(ek, x, c);            

            Closure     cm = new Closure(m, e1);
            CkPair      ck = new CkPair(cm, kk);
            
            return ck;
            
        } else {
            throw new IllegalStateException();
        }

    }
    
    
    @Override
    public String toString() {
        return "cek3";
    }

}
