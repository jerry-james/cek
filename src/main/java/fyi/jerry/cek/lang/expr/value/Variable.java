package fyi.jerry.cek.lang.expr.value;

import fyi.jerry.cek.lang.expr.Expression;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Represents variable expressions.
 *
 * @author jerry
 */
final public class Variable implements Value<Variable>, Expression {
    private static final Logger logger = LoggerFactory.getLogger(Variable.class);
    
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if (!(obj instanceof Variable)) {
            return false;
        } else {
            Variable other = (Variable) obj;
            return this.name.equals(other.getName());
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Variable get() {
        return this;
    }

    
    
}
