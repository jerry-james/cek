package fyi.jerry.cek.continuation;

import fyi.jerry.cek.arm.rr.CkPairVisitor;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.PrimitiveValue;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jerry
 */
final public class OpContinuation implements Continuation {
    private static final Logger logger = LoggerFactory.getLogger(OpContinuation.class);
    private final Primop o;
    private final List<Closure> cm;
    private final List<Closure> cl;
    private final Continuation k;

    public OpContinuation(Primop o, List<Closure> cm, List<Closure> cl, Continuation k) {
        this.o = o;
        this.cm = cm;
        this.cl = cl;
        this.k = k;
    }

    public Primop getOp() {
        return o;
    }

    public Continuation getK() {
        return k;
    }

    public List<Closure> getCm() {
        return cm;
    }

    public List<Closure> getCl() {
        return cl;
    }
    
    public List<PrimitiveValue<?>> dom() {
        return cm.stream().map((Closure closure) -> {
            PrimitiveValue<?> pv = (PrimitiveValue<?>) closure.getM();
            return pv;
        }).collect(Collectors.toList());
    }   

    @Override
    public String toString() {
        return String.format("(op (%s) (%s) %k)",cm,cl,k);
    }


    @Override
    public <T> T accept(CkPairVisitor<T> ask) {
        return ask.forOpContinuation(o, cm, cl, k);
    }
}
