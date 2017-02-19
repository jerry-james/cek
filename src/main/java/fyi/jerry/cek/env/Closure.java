package fyi.jerry.cek.env;

import fyi.jerry.cek.lang.expr.Expression;

/** An Expression-Environment Pair.
 *
 * @author jerry
 */
public class Closure {
 
    private final Expression m;
    private final Environment e;

    public Closure(Expression m, Environment e) {
        this.m = m;
        this.e = e;
    }
  
    public Environment getE() {
        return e;
    }

    public Expression getM() {
        return m;
    }
    
    @Override
    public String toString() {
        return String.format("(%s (%s))",m,e);
    }

}
