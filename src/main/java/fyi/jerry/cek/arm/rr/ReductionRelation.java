/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fyi.jerry.cek.arm.rr;

/** 
 *
 * @author jerry
 */
public interface ReductionRelation {

    /** This method is a predicate used to determine if this realization can operate on a given instance of {@code CkPair}.
     *  
     * Call this method before {@code .reduce}.
     * 
     * @param p some {@code CkPair}
     * @return true iff this relation can be applied to {@code p}
     */
    boolean reducable(CkPair p);

    /** Performs a single step reduction. 
     * 
     * @param p
     * @throws IllegalStateException if {@code reducable(p)} is false;
     * @return 
     */
    CkPair reduce(CkPair p) throws IllegalStateException;
    
}
