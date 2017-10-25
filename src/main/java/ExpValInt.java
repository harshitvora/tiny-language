// Constructor template for ExpValInt:
//     new ExpValInt (n)
// Interpretation:
//     n is an expression of type long
public class ExpValInt extends ExpValAbstract {
    private long n; // an expression of type long

    // Java Constructor
    public ExpValInt(long n) {
        this.n = n;
    }

    @Override
    // Returns true if the current object is an Integer
    public boolean isInteger() {
        return true;
    }

    @Override
    public String toString() {
        return ""+n;
    }

    @Override
    // Returns the given long expression
    public long asInteger() {
        return n;
    }
}
