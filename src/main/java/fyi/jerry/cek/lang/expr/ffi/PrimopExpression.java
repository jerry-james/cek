package fyi.jerry.cek.lang.expr.ffi;

import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import java.util.Collections;
import java.util.List;

/** Represents primitive operation expressions.
 * 
 * @author jerry
 */
final public class PrimopExpression implements Expression {
    private final Primop o;
    private final Expression m;
    private final List<? extends Expression> n;

    public PrimopExpression(Primop o, Expression m, List<? extends Expression> n) {
        this.o = o;
        this.m = m;
        this.n = n;
    }

    public Expression getM() {
        return m;
    }

    public List<? extends Expression> getN() {
        return Collections.unmodifiableList(n);
    }

    public Primop getO() {
        return o;
    }
}
