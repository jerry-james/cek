package fyi.jerry.cek.lang.expr.ffi;

import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.PrimitiveValue;
import java.util.List;

/** Interface for defining primitive operations.
 *
 * @author jerry
 */
public interface Primop {
    public Expression eval(List<PrimitiveValue<?>> vv);
}
