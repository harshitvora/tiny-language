// Abstract base class for classes that implement Exp.
// To define a class that implements Exp:
//     make that class a subclass of this base class
//     within that class, override any of the following methods:
//      public boolean isExp()
//      public boolean isConstant()
//      public boolean isIdentifier()
//      public boolean isLambda()
//      public boolean isArithmetic()
//      public boolean isCall()
//      public boolean isIf()
//      public ConstantExp asConstant()
//      public IdentifierExp asIdentifier()
//      public LambdaExp asLambda()
//      public ArithmeticExp asArithmetic()
//      public CallExp asCall()
//      public IfExp asIf()
//      public ExpVal value(Map<String, ExpVal> env)

import java.util.Map;
public abstract class ExpAbstract extends AstAbstract implements Exp {


    @Override
    // Returns true only if current object is of type Exp
    public boolean isExp() {
        return true;
    }


    @Override
    // Checks if current object is of type Constant, Returns false
    public boolean isConstant() {
        return false;
    }

    @Override
    // Checks if current object is of type Identifier, Returns false
    public boolean isIdentifier() {
        return false;
    }

    @Override
    // Checks if current object is of type Lambda, Returns false
    public boolean isLambda() {
        return false;
    }

    @Override
    // Checks if current object is of type Arithmetic, Returns false
    public boolean isArithmetic() {
        return false;
    }

    @Override
    // Checks if current object is of type Call, Returns false
    public boolean isCall() {
        return false;
    }

    @Override
    // Checks if current object is of type IfExp, Returns false
    public boolean isIf() {
        return false;
    }

    @Override
    // Returns current ConstantExp value 
    public ConstantExp asConstant() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Returns current IdentifierExp value 
    public IdentifierExp asIdentifier() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Returns current LambdaExp value 
    public LambdaExp asLambda() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Returns current AritmeticExp value 
    public ArithmeticExp asArithmetic() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Returns current CallExp value 
    public CallExp asCall() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Returns current IfExp value 
    public IfExp asIf() {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    // Given: An environment field
    // Returns: Expval object
    public ExpVal value(Map<String, ExpVal> env) {
        throw new RuntimeException("Invalid operation");
    }

    @Override
    public Exp asExp() {
        return this;
    }


}
