import java.util.Map;
// Constructor template for IfExpImpl:
//     new IfExpImpl (testPart,thenPart,elsePart)
// Interpretation:
//     IfExpImpl represents  an if condition having following 3 parts
//     testPart is an expression(boolean) containing result of an ifExp
//     thenPart is an expression which would be executed if testPart is true
//     elsePart is an expression which would be executed if testPart is false


public class IfExpImpl extends ExpAbstract implements IfExp {

    private Exp testPart;   //     testPart is an expression(boolean) containing result of an ifExp
    private Exp thenPart;   //     thenPart is an expression which would be executed if testPart is true
    private Exp elsePart;   //     elsePart is an expression which would be executed if testPart is false

    //Java Constructor
    public IfExpImpl(Exp testPart, Exp thenPart, Exp elsePart) {
        this.testPart = testPart;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    @Override
    // returns the testPart of the given ifExp
    public Exp testPart() {
        return testPart;
    }

    @Override
    // returns the thenPart of the given ifExp
    public Exp thenPart() {
        return thenPart;
    }

    @Override
    // returns the elsePart of the given ifExp
    public Exp elsePart() {
        return elsePart;
    }

    @Override
    // Checks if the current object is an IfExp, returns true
    public boolean isIf() {
        return true;
    }

    @Override
    //returns the current Object as IfExp
    public IfExp asIf() {
        return this;
    }

    @Override
    public String toString() {
        return "If{\n" +
                "test=" + testPart +
                ",\n then=" + thenPart +
                ",\n else=" + elsePart +
                '}';
    }

    @Override
    // Given: An Environment variable
    // Returns: result of the IfExp
    // Example: value(Map(args1,true)(args,3)(args,4)) -> 3(thenpart)
    public ExpVal value(Map<String, ExpVal> env) {
        ExpVal testPartValue = this.testPart().value(env);
        // If testPart evaluates to true, evaluate and return thenPart
        if(testPartValue.isBoolean()){
            if(testPartValue.asBoolean()){
                return this.thenPart().value(env);
            }
            // else evaluate and return elsePart
            else {
                return this.elsePart().value(env);
            }
        }
        else {
            throw new RuntimeException("Invalid operation");
        }

    }

}
