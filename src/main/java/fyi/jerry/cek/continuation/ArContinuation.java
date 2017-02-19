package fyi.jerry.cek.continuation;

import fyi.jerry.cek.env.Closure;
import fyi.jerry.cek.env.Environment;
import fyi.jerry.cek.lang.expr.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Argument Continuation.
 * 
 * @author jerry
 */
public class ArContinuation implements Continuation {
    private static final Logger logger = LoggerFactory.getLogger(ArContinuation.class);

    private final Expression   n;
    private final Environment  e;
    private final Continuation k;

    public ArContinuation(Expression n, Environment e, Continuation k) {
        this.n = n;
        this.e = e;
        this.k = k;
    }

    public ArContinuation(Closure cn, Continuation k) {
        this.n = cn.getM();
        this.e = cn.getE();
        this.k = k;
    }

    public Environment getE() {
        return e;
    }

    public Continuation getK() {
        return k;
    }

    public Expression getN() {
        return n;
    }

    @Override
    public String toString() {
        return String.format("(ar (%s (%s)) %s)",n,e,k);
    }

}
