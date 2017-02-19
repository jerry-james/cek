package fyi.jerry.cek.example;

import fyi.jerry.cek.arm.rr.Cek;
import fyi.jerry.cek.arm.rr.CkPair;
import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Combination;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.value.IntegerValue;
import fyi.jerry.cek.lang.expr.value.Lambda;
import fyi.jerry.cek.lang.expr.value.Variable;

/**
 *
 * @author jerry
 */
public class Identity {
    public static void main(String[] args) {
        Variable     x = new Variable("x");

        Lambda    ident = new Lambda(x, x);   
        IntegerValue  v = new IntegerValue(1);
        Expression    m = new Combination(ident, v);
        
        Environment   e = Environment.NULL;
        Closure       c = new Closure(m, e);
        Continuation  k = Continuation.MT;
        CkPair       ck = new CkPair(c, k);
        
        Cek.stepEvaluator(ck);
        
    }
}
