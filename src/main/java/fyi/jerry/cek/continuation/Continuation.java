package fyi.jerry.cek.continuation;

/** 
 *
 * @author jerry
 */
public interface Continuation {
    public static final Continuation MT = new EmptyContinuation();
}
