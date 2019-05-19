package fyi.jerry.cek.lang.expr.value;

import fyi.jerry.cek.arm.rr.CkPairVisitor;
import fyi.jerry.cek.lang.expr.Expression;


/** Base class for defining primitive values.
 * 
 * @author jerry
 * @param <T> 
 */
public abstract class PrimitiveValue<T> implements Expression, Value<T> {
    private final T t;

    public PrimitiveValue(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return t.toString();
    }


}
