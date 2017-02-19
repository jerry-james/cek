package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.continuation.OpContinuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.FFI;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.PrimitiveValue;
import java.util.List;

/**
 * 
 * @author jerry
 */
final public class Cek5 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return     p.getC().getM() instanceof PrimitiveValue
                && p.getK()        instanceof OpContinuation
                && ((OpContinuation)p.getK()).getCl().isEmpty();
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure           c = p.getC();
            Environment       e = c.getE();
            OpContinuation    k = (OpContinuation) p.getK();
        
            PrimitiveValue<?>       bm = (PrimitiveValue<?>) c.getM();

            List<PrimitiveValue<?>> vv = k.dom();
            Primop                  op = k.getOp();            
            Continuation            k1 = k.getK();
            
            Expression m = FFI.eval(op,vv,bm);
            Closure   c1 = new Closure(m,Environment.NULL);
            CkPair    ck = new CkPair(c1,k1);
            
            return ck;

        } else {
            throw new IllegalStateException();
        }
    }

    
    @Override
    public String toString() {
        return "cek5";
    }
}
