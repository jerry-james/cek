package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.continuation.OpContinuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.ffi.PrimopExpression;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author jerry
 */
final public class Cek2 implements ReductionRelation {

    @Override
    public boolean reducable(CkPair p) {
        return p.getC().getM() instanceof PrimopExpression;
    }

    @Override
    public CkPair reduce(CkPair p) {
        if(reducable(p)) {
            
            Closure      c = p.getC();
            Environment  e = c.getE();
            Continuation k = p.getK();
            
            PrimopExpression           m0 = (PrimopExpression) c.getM();
            Primop                     op = m0.getO();
            Expression                 m1 = m0.getM();
            List<? extends Expression> nn = m0.getN();

            Closure        cm = new Closure(m1, e);
            List<Closure>  cc = nn.stream().map(e1 -> new Closure(e1, e)).collect(Collectors.toList());
            OpContinuation k1 = new OpContinuation(op, cc, new LinkedList<>(),k);
            CkPair         ck = new CkPair(cm, k1);
            
            return ck;
            
        } else {
            throw new IllegalStateException();
        }
    }
    
    
    @Override
    public String toString() {
        return "cek2";
    }

}
