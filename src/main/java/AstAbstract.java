// Abstract base class for classes that implement Ast.
// To define a class that implements Ast:
//     make that class a subclass of this base class
//     within that class, override any of the following methods:
//      public boolean isPgm()
//      public boolean isDef()
//      public boolean isExp()
//      public List<Def> asPgm()
//      public Def asDef()
//      public Exp asExp()

import java.util.List;

public abstract class AstAbstract implements Ast {
    @Override
    // Checks if current object is a Program, returns false
    public boolean isPgm() {
        return false;
    }

    // Checks if current object is a Def, returns false
    @Override
    public boolean isDef() {
        return false;
    }

    // Checks if current object is an Exp, returns false
    @Override
    public boolean isExp() {
        return false;
    }

    // Typecasts current object as Program
    @Override
    public List<Def> asPgm() {
        throw new RuntimeException("Invalid operation");
    }

    // Typecasts given object as Def
    @Override
    public Def asDef() {
        throw new RuntimeException("Invalid operation");
    }

    // Typecasts given object as Exp
    @Override
    public Exp asExp() {
        throw new RuntimeException("Invalid operation");
    }
}
