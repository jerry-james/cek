package fyi.jerry.cek.env;

import fyi.jerry.cek.api.Box;
import fyi.jerry.cek.lang.expr.value.Variable;

/** The variable binding environment.
 * 
 * @author jerry
 */
final public class VariableEnvironment extends FullEnvironment {

    private final Variable x;
    private final Box<Closure> v;

    public VariableEnvironment(Environment others, Variable x, Closure v) {
        super(others);
        this.x = x;
        this.v = Box.create(v);
    }

    @Override
    public Closure lookup(Variable x) {
        if(this.x.equals(x)) {
            return v.get();
        } else {
            return others.lookup(x);
        }
    }

    @Override
    public String toString() {
        return String.format("(%s %s) %s",x,v.get(),others.toString());
    }
    
}
