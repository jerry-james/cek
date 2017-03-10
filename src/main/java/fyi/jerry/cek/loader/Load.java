package fyi.jerry.cek.loader;

import java.io.IOException;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import src.main.antlr4.SexpLexer;
import src.main.antlr4.SexpParser;

/**
 *
 * @author jerry
 */
public class Load {
    public static void load(InputStream is) throws IOException {
        ANTLRInputStream   input = new ANTLRInputStream(is);
        SexpLexer          lexer = new SexpLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SexpParser        parser = new SexpParser(tokens);
        ParseTree           tree = parser.sexps();
        System.out.println(new Visitor().visit(tree));
        System.out.println(tree.toStringTree(parser)); // print LISP-style t
    }
    
    public static void main(String[] args) throws IOException {
        InputStream is = Load.class.getResourceAsStream("/test.scm");
        Load.load(is);    
    }
    
    
}
