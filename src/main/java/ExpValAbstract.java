// Abstract base class for classes that implement Exp.
// To define a class that implements Exp:
//     make that class a subclass of this base class
//     within that class, override any of the following methods:
//      public boolean isBoolean()
//      public boolean isInteger()
//      public boolean isFunction()
//      public boolean asBoolean()
//      public boolean asInteger()
//      public boolean asFunction()

public abstract class ExpValAbstract implements ExpVal {

    @Override
    // Checks if current object is boolean
    public boolean isBoolean() {
        return false;
    }

    @Override
    // Checks if current object is an Integer
    public boolean isInteger() { return false; }

    @Override
    // Checks if current object is a Function
    public boolean isFunction() {
        return false;
    }

    @Override
    // Returns current Boolean object 
    public boolean asBoolean() {
        throw new RuntimeException("Invalid bool operation");
    }

    @Override
    // Returns current long object 
    public long asInteger() {
        throw new RuntimeException("exp Invalid operation");
    }

    @Override
    // Returns current FunVal object 
    public FunVal asFunction() {
        throw new RuntimeException("Invalid operation");
    }
}
