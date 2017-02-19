package fyi.jerry.cek.lang.expr.value;

import fyi.jerry.cek.lang.expr.Expression;

/** Represents value expressions.
 * 
 * @author jerry
 * @param <T> 
 */
public interface Value<T> extends Expression {
    T get();
}
