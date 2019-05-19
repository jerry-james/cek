package fyi.jerry.cek.lang.expr;

import fyi.jerry.cek.arm.rr.CkPairVisitor;

/** Applies the expression M to parameter N. E.g. (M N)
 * 
 * @author jerry
 */
public class Combination implements Expression {
    private final Expression m;
    private final Expression n;

    public Combination(Expression m, Expression n) {
        this.m = m;
        this.n = n;
    }

    public Expression getM() {
        return m;
    }

    public Expression getN() {
        return n;
    }

    @Override
    public String toString() {
        return "("+m+" "+n+")";
    }

    @Override
    public <T> T accept(CkPairVisitor<T> ask) {
        return ask.forCombination(m, n);
    }
}
