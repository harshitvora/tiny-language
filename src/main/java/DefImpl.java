// Constructor template for DefImpl:
//     new DefImpl (id1,rhs)
// Interpretation:
//     id1 is the left hand side of a Def, which will be an identifier represented as a string
//     rhs is the right hand side of a Def, which will be a ConstantExp or a LambdaExp

public class DefImpl extends AstAbstract implements Def {
    private String id1; //the left hand side of this definition, which will be an identifier represented as a String
    private Exp rhs;    //the right hand side of this definition, which will be a ConstantExp or a LambdaExp

    //Java Constructor
    public DefImpl(String id1, Exp rhs) {
        this.id1 = id1;
        this.rhs = rhs;
    }

    @Override
    // Returns the left hand side of the Definition(A string)
    public String lhs() {
        return id1;
    }

    @Override
    // Returns the right hand side of the Definition( a ConstantExp or a LambdaExp)
    public Exp rhs() {
        return rhs;
    }

    @Override
    // Checks if current object is of type Def and returns true
    public boolean isDef() {
        return true;
    }

    @Override
    //Typecasts current object as Def
    public Def asDef() {
        return this;
    }
}
