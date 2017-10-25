// Constructor template for FunValImpl:
//     new FunValImpl (exp,env)
// Interpretation:
//     exp is a lambda expression
//     env is an environment field, a map with String,ExpVal pair
import java.util.Map;

public class FunValImpl extends ExpValAbstract implements FunVal {

    LambdaExp exp;     //the lambda exp from which the function was created
    Map<String, ExpVal> env;  //A Key(String), Value(ExpVal) pair of argument name and its value
                              // representing the environment

    // Java Constructor
    public FunValImpl(LambdaExp exp, Map<String, ExpVal> env) {
        this.exp = exp;
        this.env = env;
    }

    @Override
    //Returns true if the current object is a FunVal
    public boolean isFunction() {
        return true;
    }

    @Override
    // Returns current FunVal object
    public FunVal asFunction() {
        return this;
    }

    @Override
    // Returns current Lambda expression
    public LambdaExp code() {
        return exp;
    }

    @Override
    // Returns the current environment
    public Map<String, ExpVal> environment() {
        return env;
    }
}
