package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import java.util.List;

public class IsContinuationFn extends DefaultCkPairVisitor<Boolean> {
    @Override
    public Boolean forCkPair(Closure c, Continuation k) {
        return k.accept(this);
    }

    @Override
    public Boolean forFnContinuation(Closure c, Continuation k) {
        return true;
    }

    @Override
    public Boolean forArContinuation(Expression n, Environment e, Continuation k) {
        return false;
    }

    @Override
    public Boolean forOpContinuation(Primop o, List<Closure> cm, List<Closure> cl, Continuation k) {
        return false;
    }

    @Override
    public Boolean forEmptyContinuation() {
        return false;
    }
}
