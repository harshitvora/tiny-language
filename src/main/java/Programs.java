import java.util.*;

// Interpretation: This class contains static method for run
public class Programs {
    //********** for Example Purpose**********************************
    // fact (n) if n = 0 then 1 else n * fact (n - 1) fi
    //    Exp exp1 = Asts.arithmeticExp (Asts.identifierExp ("n"),
    //            "MINUS",
    //            Asts.constantExp (Asts.expVal (1)));
    //    Exp call1
    //            = Asts.callExp (Asts.identifierExp ("fact"),
    //            Asts.list (exp1));
    //    Exp testPart
    //            = Asts.arithmeticExp (Asts.identifierExp ("n"),
    //            "EQ",
    //            Asts.constantExp (Asts.expVal (0)));
    //    Exp thenPart
    //            = Asts.constantExp (Asts.expVal (1));
    //    Exp elsePart
    //            = Asts.arithmeticExp (Asts.identifierExp ("n"),
    //            "TIMES",
    //            call1);
    //    Def def1 = Asts.def ("fact", Asts.lambdaExp (Asts.list ("n"),
    //                    Asts.ifExp (testPart,thenPart, elsePart)));
    //*****************************************************************


    //Given: A program and a list of inputs
    // Returns: Output value of the given program for the given list of inputs
    // Example:
    // Programs.run (Asts.list (def1),Asts.list (Asts.expVal (5))) --> 120
    // Design Strategy: Divide into cases based on first definition
    public static ExpVal run(List<Def> pgm, List<ExpVal> inputs) {
        // Create new environment
        Map<String, ExpVal> env = new HashMap<>();
        ExpVal result;
        Exp entry = pgm.get(0).rhs();

        // Populate environment with the program definitions
        for (Def d : pgm) {
            if (d.rhs().isLambda()) {
                result = Asts.expVal(d.rhs().asLambda(), env);
            } else if(d.rhs().isConstant()){
                result = d.rhs().value(env);
            } else {
                throw new RuntimeException("Invalid definition");
            }
            env.put(d.lhs(), result);
        }

        // Evaluate program starting from entry point
        if (entry.isLambda()) {
            Map<String, ExpVal> newEnv = new HashMap<>();
            newEnv.putAll(env);
            // Put all the formals for the lambda expression into the
            // environment
            List<String> formals = entry.asLambda().formals();
            for (int i = 0; i < inputs.size(); i++) {
                newEnv.put(formals.get(i), inputs.get(i));
            }

            // Evaluate body of lambda expression
            return entry.asLambda().body().value(newEnv);
        } else if (entry.isConstant()) {
            return entry.value(env);
        } else {
            throw new RuntimeException("Invalid definition");
        }
    }

    // GIVEN: a list of definitions
    // EFFECT:
    // Reads the ps11 program found in the file named by the given string
    // and returns the set of all variable names that occur free within
    // the program.

    public static Set<String> undefined(List<Def> defList) {

        List<String> defLhs = new ArrayList<>();   // Temporary list used to
                                                   // store lhs of all Def
        Set<String> freeVariables = new HashSet<>();  // Set of free Variables

        // For each def, get the identifier
        for (Def d : defList) {
            defLhs.add(d.lhs());
        }

        //For each Def, get the fetch the set of Free Variables
        for (Def d : defList) {
            if (d.rhs().isLambda()) {
                Exp rhs = d.rhs();
                List<String> scopeVariables = new ArrayList<>();
                // List of formals
                scopeVariables.addAll(defLhs);
                scopeVariables.addAll(rhs.asLambda().formals());
                freeVariables.addAll
                        (getFree(rhs.asLambda().body(), scopeVariables));
            }
        }
        return freeVariables;
    }

    // Given: An Expression, a List of formals in a Def
    // Returns: A set of variables which occur free within the program
    // Examples: getFree([f,g,x,y],z) -> [z]
    // Design Strategy: Use cases on Exp1
    // Halting measure: Number of sub-expressions
    // Termination condition: When entire ast is traversed
    public static Set<String> getFree(Exp exp1, List<String> scope) {
        Set<String> freeVariables = new HashSet<>();//List of free variables
        // If the input argument is a Constant
        if (exp1.isConstant()) {
            return freeVariables;
        }
        // If the input argument is an Identifier, check list of formals.
        // Add to the set of free variables, if not present in formals
        else if (exp1.isIdentifier()) {
            if (!scope.contains(exp1.asIdentifier().name())) {
                freeVariables.add(exp1.asIdentifier().name());
            }
            return freeVariables;
        }
        //If the input argument is an Arithmetic expressions.
        //Check each operand of the Arithmetic expression for free variables
        else if (exp1.isArithmetic()) {
            Exp oper1 = exp1.asArithmetic().leftOperand();
            Exp oper2 = exp1.asArithmetic().rightOperand();
            freeVariables.addAll(getFree(oper1, scope));
            freeVariables.addAll(getFree(oper2, scope));
            return freeVariables;
        }
        //If the input argument is an IfExpression,
        //Check each of the three parts of the expression for free variables
        else if (exp1.isIf()) {
            Exp testPart = exp1.asIf().testPart();
            Exp thenPart = exp1.asIf().thenPart();
            Exp elsePart = exp1.asIf().elsePart();
            freeVariables.addAll(getFree(testPart, scope));
            freeVariables.addAll(getFree(thenPart, scope));
            freeVariables.addAll(getFree(elsePart, scope));
            return freeVariables;
        }
        //If the input argument is a Lambda,
        // add all the formals to scope list and check for free variables
        // in the body of LambdaExp
        else if (exp1.isLambda()) {
            List<String> tempScope = new ArrayList<>();
            tempScope.addAll(scope);
            tempScope.addAll(exp1.asLambda().formals());
            freeVariables.addAll(getFree(exp1.asLambda().body(), tempScope));
            return freeVariables;
        }
        //If the input argument is a CallExp,
        //check each argument in the list of arguments for free variables
        else if (exp1.isCall()){
            List<Exp> lexp = exp1.asCall().arguments();
            Exp oper = exp1.asCall().operator();
            for (Exp aLexp : lexp) {
                freeVariables.addAll(getFree(aLexp, scope));
            }
            freeVariables.addAll(getFree(oper,scope));
            return freeVariables;
        }
        //Any other operation apart from the above should throw an Exception
        else
            throw new RuntimeException("Invalid operation");

    }
}
