package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.Variable;

public class IsClosureExpressionAValue extends DefaultCkPairVisitor<Boolean> {
    @Override
    public Boolean forCkPair(Closure c, Continuation k) {
        return c.accept(this);
    }

    @Override
    public Boolean forClosure(Expression m, Environment e) {
        return m.accept(this);
    }

    @Override
    public Boolean forIntegerValue(Integer t) {
        return true;
    }

    @Override
    public Boolean forLambda(Variable x, Expression m) {
        return true;
    }

    @Override
    public Boolean forVariable(String name) {
        return true;
    }

    @Override
    public Boolean forCombination(Expression m, Expression n) {
        return false;
    }
}
