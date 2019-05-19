package fyi.jerry.cek.lang.expr;

import fyi.jerry.cek.arm.rr.CkPairVisitor;

/** Marker interface that represents expressions.
 *
 * @author jerry
 */
@SuppressWarnings("MarkerInterface")
public interface Expression {
    <T> T accept(CkPairVisitor<T> ask);
}
