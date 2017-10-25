// Constructor template for IdentifierExpImpl:
//     new IdentifierExpImpl (id)
// Interpretation:
//     id is the name of the identifier

import java.util.Map;

public class IdentifierExpImpl extends ExpAbstract implements IdentifierExp {

    private String id;  // Name of the identifier

    // Java Constructor
    public IdentifierExpImpl(String id) {
        this.id = id;
    }

    @Override
    // Returns the name of the identifier
    public String name() {
        return id;
    }

    @Override
    // Returns true if the given object is an IdentifierExp
    public boolean isIdentifier() {
        return true;
    }

    @Override
    // Returns the given IdentifierExp object
    public IdentifierExp asIdentifier() {
        return this;
    }

    @Override
    // Given: current Environment field 
    // Returns: the value of the name of current object
    // Example: value(Map(args1,"fibo")) -> "fibo"
        public ExpVal value(Map<String, ExpVal> env) {
        return env.get(this.name());
    }

    @Override
    public String toString() {
        return "Ident{" +
                "id='" + id + '\'' +
                '}';
    }

}
