// Constructor template for LambdaExpImpl:
//     new LambdaExpImpl (formals,body)
// Interpretation:
//     formals is a list of strings representing variables used in a LambdaExp
//     body is the expression used to evaluate a LambdaExp
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaExpImpl extends ExpAbstract implements LambdaExp {

    private List<String> formals;   //     formals is a list of strings representing
    // variables used in a LambdaExp
    private Exp body;               //   body is the expression used to evaluate a
    // LambdaExp

    //Java Constructor
    public LambdaExpImpl(List<String> formals, Exp body) {
        this.formals = formals;
        this.body = body;
    }

    @Override
    // Returns formals from the current LambdaExp object
    public List<String> formals() {
        return formals;
    }

    @Override
    // Returns body from the current LambdaExp object
    public Exp body() {
        return body;
    }

    @Override
    // Checks if the current object is a LambdaExp, returns true
    public boolean isLambda() {
        return true;
    }

    @Override
    // Returns the current object as LambdaExp
    public LambdaExp asLambda() {
        return this;
    }

    @Override
    // Given: An environment variable
    // Returns: value of the current LambdaExp
    // Example: Value(Map(args1,List<k>)(args2,k*k)(args3,2)) -> 4
    public ExpVal value(Map<String, ExpVal> env) {
        // Return the lambda expression as a FunVal object
        return Asts.expVal(this, env);
    }

    @Override
    public String toString() {
        return "Lambda{\n" +
                "formals=" + formals +
                ",\n body=" + body +
                '}';
    }
}
