// Constructor template for ExpValBool:
//     new ExpValBool (b)
// Interpretation:
//     b is a boolean expression
public class ExpValBool extends ExpValAbstract {
    private boolean b;   // A boolean expression

    // Java Constructor
    public ExpValBool(boolean b) {
        this.b = b;
    }

    @Override
    // Returns true if the current object is Boolean
    public boolean isBoolean() {
        return true;
    }

    // Returns the given boolean expression
    @Override
    public boolean asBoolean() {
        return b;
    }

}
