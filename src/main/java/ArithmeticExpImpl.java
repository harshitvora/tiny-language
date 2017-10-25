// Constructor template for ArithmeticExpImpl:
//     new ArithmeticExpImpl (e1, op, e2)
// Interpretation:
//     e1 and e2 are expressions
//     op is one of these binary operators: < = > + - *

import java.util.Map;
public class ArithmeticExpImpl extends ExpAbstract implements ArithmeticExp {

    private Exp e1;     // The left subexpression of the maine expression
    private String op;  // An operator which is one of LT, GT, EQ, PLUS, MINUS OR TIMES
    private Exp e2;     // The right subexpression of the main expression

    // Java Constructor
    public ArithmeticExpImpl(Exp e1, String op, Exp e2) {
        this.e1 = e1;
        this.op = op;
        this.e2 = e2;
    }

    @Override
    // Returns the left subexpression (e1)
    public Exp leftOperand() {
        return e1;
    }

    @Override
    // Returns the right subexpression (e2)
    public Exp rightOperand() {
        return e2;
    }

    @Override
    //Returns the binary operation as one of these strings: LT EQ GT PLUS MINUS TIMES
    public String operation() {
        return op;
    }

    @Override
    // Returns the boolean value True if the given expression is Arithmetic
    public boolean isArithmetic() {
        return true;
    }

    @Override
    // Returns the current expression object
    public ArithmeticExp asArithmetic() {
        return this;
    }

    @Override
    public String toString() {
        return "Arith{\n" +
                "e1=" + e1 +
                ",\n op='" + op + '\'' +
                ",\n e2=" + e2 +
                '}';
    }

    @Override
    // Given: An expression environment
    // Returns: Value of given Expression
    // Examples: value(Map(args1,3)(args2,<) (args3,4)) -> True
    // Design Strategy: Use cases on operator

    public ExpVal value(Map<String, ExpVal> env) {
        // Evaluate left and right operand
        ExpVal leftOp = leftOperand().value(env);
        ExpVal rightOp = rightOperand().value(env);
        long r;
        long l;

         //Check if operands evaluate to integer or function
        if(rightOp.isBoolean() || leftOp.isBoolean()){
            throw new RuntimeException("Invalid operation");
        }
        else {
            r = rightOp.asInteger();
            l = leftOp.asInteger();
        }

        // Check operator type and perform appropriate operation
        switch (operation()){
            //Operator: <
            case "LT":
                    return Asts.expVal(r > l);
            //Operator: =
            case "EQ":
                return Asts.expVal(r == l);
            //Operator: >
            case "GT":
                    return Asts.expVal(r < l);
            //Operator: +
            case "PLUS":
                    return Asts.expVal(l + r);
             //Operator: -
            case "MINUS":
                    return Asts.expVal(l - r);
            //Operator: *
            case "TIMES":
                    return Asts.expVal(l * r);
            //Operator: Default
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
