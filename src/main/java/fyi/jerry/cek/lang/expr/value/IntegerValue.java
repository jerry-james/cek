package fyi.jerry.cek.lang.expr.value;


import fyi.jerry.cek.arm.rr.CkPairVisitor;

/** A primitive integer
 * 
 * @author jerry
 */
final public class IntegerValue extends PrimitiveValue<Integer> {

    private final Integer t;

    public IntegerValue(Integer t) {
        super(t);
        this.t = t;
    }

    @Override
    public <S> S accept(CkPairVisitor<S> ask) {
        return ask.forIntegerValue(t);
    }

}
