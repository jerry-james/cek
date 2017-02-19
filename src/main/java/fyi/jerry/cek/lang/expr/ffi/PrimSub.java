package fyi.jerry.cek.lang.expr.ffi;

import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.IntegerValue;
import fyi.jerry.cek.lang.expr.value.PrimitiveValue;
import java.util.List;
import java.util.stream.Collectors;


public class PrimSub implements Primop {
    
    @Override
    public Expression eval(List<PrimitiveValue<?>> vv) {
        List<IntegerValue> vvv = vv.stream().map((PrimitiveValue<?> t) -> {
            if(t instanceof IntegerValue) {
                return (IntegerValue) t;
            } else {
                throw new IllegalStateException("Only ints supported");
            }
        }).collect(Collectors.toList());
        
        IntegerValue b0 = vvv.get(0);
        IntegerValue b1 = vvv.get(1);
        
        return new IntegerValue(b0.get() - b1.get());
    }
    
}
