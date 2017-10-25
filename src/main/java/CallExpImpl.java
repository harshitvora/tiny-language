// Constructor template for CallExpImpl:
//     new CallExpImpl (operator, operands)
// Interpretation:
//     operator is the expression for the function part of the call
//     operands is a list of expressions used as input arguments
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallExpImpl extends ExpAbstract implements CallExp {

    Exp operator;       // expression for function part of the call
    List<Exp> operands; // list of expressions used as input arguments

    //Java Constructor
    public CallExpImpl(Exp operator, List<Exp> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    // Returns the operator from the function
    public Exp operator() {
        return operator;
    }

    @Override
    // Returns the List of expressions (operands) from the function
    public List<Exp> arguments() {
        return operands;
    }

    @Override
    // Checks if current object is a Call and returns true
    public boolean isCall() {
        return true;
    }

    @Override
    // Typecasts current object as call
    public CallExp asCall() {
        return this;
    }

    @Override
    // Given: An expression environment
    // Returns: Value of operator from given expression
    // Examples: value(Map((args1,add)(args2,3)(args4))) -> 7
    public ExpVal value(Map<String, ExpVal> env) {
        // Create FunVal object on evaluating operator
        ExpVal op = this.operator().value(env);

        if(op.isFunction()){
            List<String> formals = op.asFunction().code().formals();
            // Create new environment and copy all entries from the
            // environment retrieved from the FunVal object
            Map<String, ExpVal> newEnv = new HashMap<>();
            newEnv.putAll(op.asFunction().environment());

            // Put all formals of the lambda exp retrieved from the funval
            // object
            for(int i=0; i< formals.size(); i++){
                newEnv.put(formals.get(i), this.arguments().get(i).value
                        (env));
            }

            // Evaluate and return the value for the body of the lambda exp
            // retrieved from the FunVal object using the newly created
            // environment
            return op.asFunction().code().body().value(newEnv);
        }
        else {
            throw new RuntimeException("Invalid operation");
        }
    }

}
