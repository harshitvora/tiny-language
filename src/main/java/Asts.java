import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Interpretation: This class contains static factory methods for Def, Exp, ExpVal and creating short lists.
public class Asts {

    // Static factory methods for Def

    // Returns a Def with the given left and right hand sides.

    public static Def def (String id1, Exp rhs) {
        return new DefImpl(id1, rhs);
    }

    // Static factory methods for Exp

    // Returns an ArithmeticExp representing e1 op e2.

    public static ArithmeticExp arithmeticExp (Exp e1, String op, Exp e2) {
        return new ArithmeticExpImpl(e1, op, e2);
    }

    // Returns a CallExp with the given operator and operand expressions.

    public static CallExp callExp (Exp operator, List<Exp> operands) {
        return new CallExpImpl(operator, operands);
    }

    // Returns a ConstantExp with the given value.

    public static ConstantExp constantExp (ExpVal value) {
        return new ConstantExpImpl(value);
    }

    // Returns an IdentifierExp with the given identifier name.

    public static IdentifierExp identifierExp (String id) {
        return new IdentifierExpImpl(id);
    }

    // Returns an IfExp with the given components.

    public static IfExp ifExp (Exp testPart, Exp thenPart, Exp elsePart) {
        return new IfExpImpl(testPart, thenPart, elsePart);
    }

    // Returns a LambdaExp with the given formals and body.

    public static LambdaExp lambdaExp (List<String> formals, Exp body) {
        return new LambdaExpImpl(formals, body);
    }

    // Static factory methods for ExpVal

    // Returns a value encapsulating the given boolean.

    public static ExpVal expVal (boolean b) {
        return new ExpValBool(b);
    }

    // Returns a value encapsulating the given (long) integer.

    public static ExpVal expVal (long n) {
        return new ExpValInt(n);
    }

    // Returns a value encapsulating the given lambda expression
    // and environment.

    public static FunVal expVal (LambdaExp exp, Map<String,ExpVal> env) {
        return new FunValImpl(exp, env);
    }

    // Static methods for creating short lists

    //Given: an object of type X
    //Returns:  an arraylist with object inserted into it
    public static <X> List<X> list (X x1) {
        ArrayList<X> newList = new ArrayList<>();
        newList.add(x1);
        return newList;
    }

    //Given: 2 objects of type X
    //Returns:  an arraylist with given objects inserted into it
    public static <X> List<X> list (X x1, X x2) {
        ArrayList<X> newList = new ArrayList<>();
        newList.add(x1);
        newList.add(x2);
        return newList;
    }

    //Given: 3 objects of type X
    //Returns:  an arraylist with given objects inserted into it
    public static <X> List<X> list (X x1, X x2, X x3) {
        ArrayList<X> newList = new ArrayList<>();
        newList.add(x1);
        newList.add(x2);
        newList.add(x3);
        return newList;
    }

    //Given: 4 objects of type X
    //Returns:  an arraylist with given objects inserted into it
    public static <X> List<X> list (X x1, X x2, X x3, X x4) {
        ArrayList<X> newList = new ArrayList<X>();
        newList.add(x1);
        newList.add(x2);
        newList.add(x3);
        newList.add(x4);
        return newList;
    }
}
