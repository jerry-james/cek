package fyi.jerry.cek.continuation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents the bottom of the continuation stack.
 * 
 * @author jerry
 */
final public class EmptyContinuation implements Continuation {
    private static final Logger logger = LoggerFactory.getLogger(EmptyContinuation.class);

    @Override
    public String toString() {
        return "mt";
    }
    
}
