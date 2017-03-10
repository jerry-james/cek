package fyi.jerry.cek.loader;

import fyi.jerry.cek.arm.rr.CkPair;
import java.util.List;
import src.main.antlr4.SexpBaseVisitor;
import src.main.antlr4.SexpParser;

/**
 *
 * @author jerry
 */
public class Visitor extends SexpBaseVisitor<CkPair>{

    @Override
    public CkPair visitSexp(SexpParser.SexpContext ctx) {
        System.out.println(super.visitSexp(ctx));
        return super.visitSexp(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CkPair visitFundefn(SexpParser.FundefnContext ctx) {

        return super.visitFundefn(ctx); //To change body of generated methods, choose Tools | Templates.
    }

  


    
}
