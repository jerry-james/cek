package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

public interface CkPairVisitor<T> {
    T forArContinuation(Expression n, Environment e, Continuation k);

    T forVariable(String name);

    T forLambda(Variable x, Expression m);

    T forIntegerValue(Integer t);

    T forPrimopExpression(Primop o, Expression m, List<? extends Expression> n);

    T forCombination(Expression m, Expression n);

    T forOpContinuation(Primop o, List<Closure> cm, List<Closure> cl, Continuation k);

    T forFnContinuation(Closure c, Continuation k);

    T forEmptyContinuation();

    T forClosure(Expression m, Environment e);

    T forCkPair(Closure c, Continuation k);

}
