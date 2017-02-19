package fyi.jerry.cek.env;

import fyi.jerry.cek.lang.expr.value.Variable;

/** The full environment.
 * 
 * @author jerry
 */
public abstract class FullEnvironment implements Environment {

    protected final Environment others;

    public FullEnvironment(Environment others) {
        this.others = others;
    }

    @Override
    public Closure lookup(Variable x) {
        throw new IllegalStateException("Couldn't find variable " + x);
    }
    
}
