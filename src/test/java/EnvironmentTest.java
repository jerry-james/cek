
import fyi.jerry.cek.lang.expr.ffi.PrimAdd;
import fyi.jerry.cek.lang.expr.Expression;
import fyi.jerry.cek.lang.expr.ffi.PrimopExpression;
import fyi.jerry.cek.lang.expr.value.IntegerValue;
import fyi.jerry.cek.lang.expr.value.Lambda;
import fyi.jerry.cek.lang.expr.value.Value;
import fyi.jerry.cek.lang.expr.value.Variable;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jerry
 */
public class EnvironmentTest {
    
    public EnvironmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void hello() {
      
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Value<Integer> v = new IntegerValue(1);
        Integer get = v.get();
        
        
        List<Variable> yy = new LinkedList<>();
        yy.add(y);
        PrimopExpression op = new PrimopExpression(new PrimAdd(), x, yy);
        Expression e = op;
        
    }
}
