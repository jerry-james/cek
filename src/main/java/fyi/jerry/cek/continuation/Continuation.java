package fyi.jerry.cek.continuation;

import fyi.jerry.cek.arm.rr.CkPairVisitor;

/**
 *
 * @author jerry
 */
public interface Continuation {
    public static final Continuation MT = new EmptyContinuation();
    <T> T accept(CkPairVisitor<T> ask);
}
