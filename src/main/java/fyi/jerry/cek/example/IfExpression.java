package fyi.jerry.cek.example;

import fyi.jerry.cek.arm.rr.Cek;
import fyi.jerry.cek.arm.rr.CkPair;
import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Combination;
import fyi.jerry.cek.lang.expr.value.Lambda;
import fyi.jerry.cek.lang.expr.value.Variable;

/**
 *
 * @author jerry
 */
public class IfExpression {
    public static void main(String[] args) {
        
        Variable       xx = new Variable("x");
        Variable       xy = new Variable("y");
        Variable       xt = new Variable("t");
        Variable       xf = new Variable("f");
        Variable       xv = new Variable("v");
        Lambda      ftrue = new Lambda(xx, new Lambda(xy, xx));
        
        Combination comb1 = new Combination(xv, xt);
        Combination comb2 = new Combination(comb1, xf);
        Lambda         f1 = new Lambda(xf, comb2);
        Lambda         f0 = new Lambda(xt, f1);
        Lambda     ifExpr = new Lambda(xv, f0);

        Combination comb3 = new Combination(ifExpr, ftrue);
        Combination comb4 = new Combination(comb3, ftrue);
        Combination comb5 = new Combination(comb4, ftrue);
        Closure         c = new Closure(comb5, Environment.NULL);
        CkPair         ck = new CkPair(c, Continuation.MT);
        
        Cek.stepEvaluator(ck);

    }
}
