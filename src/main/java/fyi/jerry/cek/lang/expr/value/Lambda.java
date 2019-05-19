package fyi.jerry.cek.lang.expr.value;

import fyi.jerry.cek.arm.rr.CkPairVisitor;
import fyi.jerry.cek.lang.expr.Expression;

/** Represents Lambda expressions.
 * 
 * @author jerry
 */
public class Lambda implements Expression, Value<String> {
    private final Variable x;
    private final Expression m;

    public Lambda(Variable x, Expression m) {
        this.x = x;
        this.m = m;
    }

    public Expression getM() {
        return m;
    }

    public Variable getX() {
        return x;
    }

    @Override
    public String get() {
        return "#<function>";        
    }

    @Override
    public String toString() {
        return String.format("(L %s %s)",x,m);
    }

    @Override
    public <T> T accept(CkPairVisitor<T> ask) {
        return ask.forLambda(x, m);
    }
}
