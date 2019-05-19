package fyi.jerry.cek.arm.rr;

import fyi.jerry.cek.continuation.Continuation;
import fyi.jerry.cek.env.Closure;

/** Closure-Continuation Pair.
 *
 * @author jerry
 */
final public class CkPair {
    private final Closure c;
    private final Continuation k;

    public CkPair(Closure c, Continuation k) {
        this.c = c;
        this.k = k;
    }

    public Closure getC() {
        return c;
    }

    public Continuation getK() {
        return k;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)",c,k);//<"+c+","+k+">";
    }

    <T> T accept(CkPairVisitor<T> ask) {
        return ask.forCkPair(c, k);
    }
}
