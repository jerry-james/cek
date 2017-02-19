package fyi.jerry.cek.continuation;

import fyi.jerry.cek.env.Closure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


final public class FnContinuation implements Continuation {
    private static final Logger logger = LoggerFactory.getLogger(FnContinuation.class);

    private final Continuation k;
    private final Closure c;

    public FnContinuation(Closure c, Continuation k) {
        this.c = c;
        this.k = k;
    }

    public Continuation getK() {
        return k;
    }

    public Closure getC() {
        return c;
    }
    

    @Override
    public String toString() {
        return String.format("(fn %s %s)",c,k);
    }

}
