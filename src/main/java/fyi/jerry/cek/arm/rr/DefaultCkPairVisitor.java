package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

public class DefaultCkPairVisitor<T> implements CkPairVisitor<T> {
    @Override
    public T forArContinuation(Expression n, Environment e, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public T forVariable(String name) {
        throw new IllegalStateException();
    }

    @Override
    public T forLambda(Variable x, Expression m) {
        throw new IllegalStateException();
    }

    @Override
    public T forIntegerValue(Integer t) {
        throw new IllegalStateException();
    }

    @Override
    public T forPrimopExpression(Primop o, Expression m, List<? extends Expression> n) {
        throw new IllegalStateException();
    }

    @Override
    public T forCombination(Expression m, Expression n) {
        throw new IllegalStateException();
    }

    @Override
    public T forOpContinuation(Primop o, List<Closure> cm, List<Closure> cl, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public T forFnContinuation(Closure c, Continuation k) {
        throw new IllegalStateException();
    }

    @Override
    public T forEmptyContinuation() {
        throw new IllegalStateException();
    }

    @Override
    public T forClosure(Expression m, Environment e) {
        throw new IllegalStateException();
    }

    @Override
    public T forCkPair(Closure c, Continuation k) {
        throw new IllegalStateException();
    }
}
