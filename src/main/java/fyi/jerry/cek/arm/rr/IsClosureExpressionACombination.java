package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

public class IsClosureExpressionACombination implements CkPairVisitor<Boolean> {

    @Override
    public Boolean forVariable(String name) {
        return false;
    }

    @Override
    public Boolean forLambda(Variable x, Expression m) {
        return false;
    }

    @Override
    public Boolean forIntegerValue(Integer t) {
        return false;
    }

    @Override
    public Boolean forPrimopExpression(Primop o, Expression m, List<? extends Expression> n) {
        return false;
    }

    @Override
    public Boolean forCombination(Expression m, Expression n) {
        return true;
    }

    @Override
    public Boolean forArContinuation(Expression n, Environment e, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public Boolean forOpContinuation(Primop o, List<Closure> cm, List<Closure> cl, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public Boolean forFnContinuation(Closure c, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public Boolean forEmptyContinuation() {
        throw new IllegalStateException();
    }

    @Override
    public Boolean forClosure(Expression m, Environment e) {
        return m.accept(this);
    }

    @Override
    public Boolean forCkPair(Closure c, Continuation k) {
        return c.accept(this);
    }
}
