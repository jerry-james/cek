package fyi.jerry.cek.env;

import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.List;

/** Represents the environment as a list of closures.
 *
 * @author jerry
 */
public interface Environment {
    /** The Null Environment
     * 
     */
    public static final Environment NULL = new NullEnvironment();
    
    /** Extends others with new bindings.
     *
     * @param others
     * @param xx variables
     * @param cc closures
     * @return the extended environment.
     */
    public static Environment extend(Environment others, List<Variable> xx, List<Closure> cc) {
        if(xx.size() != cc.size()) {
            throw new IllegalArgumentException();
        } else {
            if(xx.isEmpty()) {
                return others;
            } else {
                Variable x = xx.remove(0);
                Closure  c = cc.remove(0);
                return extend(extend(others,xx,cc),x,c);
            }
        }
    }

    /** Extends others with one new binding.
     *
     * @param others
     * @param x the variable
     * @param c the closure
     * @return the extended environment.
     */
    public static Environment extend(Environment others, Variable x, Closure c) {
        return new VariableEnvironment(others, x, c);
    }
    
    /** Lookup closure associated with a Variable.
     * 
     * @param x
     * @return Returns the closure bound to the Variable x.
     */
    Closure lookup(Variable x);
}
