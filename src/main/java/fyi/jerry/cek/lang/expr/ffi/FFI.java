package fyi.jerry.cek.lang.expr.ffi;

import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.Primop;
import fyi.jerry.cek.lang.expr.value.PrimitiveValue;
import java.util.List;

/** The FFI to primitive operations.
 *
 * @author jerry
 */
final public class FFI {

    public static Expression eval(Primop op, List<PrimitiveValue<?>> bb, PrimitiveValue<?> n) {
        bb.add(n);
        return op.eval(bb);
    }

    private FFI() {
    }

}
