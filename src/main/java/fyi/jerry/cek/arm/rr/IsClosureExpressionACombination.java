package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

public class IsClosureExpressionACombination extends DefaultCkPairVisitor<Boolean> {

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
    public Boolean forClosure(Expression m, Environment e) {
        return m.accept(this);
    }

    @Override
    public Boolean forCkPair(Closure c, Continuation k) {
        return c.accept(this);
    }
}
