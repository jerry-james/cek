package fyi.jerry.cek.env;

/** The Null, empty, environment.
 *
 * @author jerry
 */
final public class NullEnvironment extends FullEnvironment {

    public NullEnvironment() {
        super(null);
    }
    
    public NullEnvironment(Environment others) {
        super(others);
    }

    @Override
    public String toString() {
        return "";
    }
  
}
