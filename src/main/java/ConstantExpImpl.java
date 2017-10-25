// Constructor template for ConstantExpImpl:
//     new ConstantExpImpl (value)
// Interpretation:
//     value is the value of the ConstantExp

import java.util.Map;

public class ConstantExpImpl extends ExpAbstract implements ConstantExp {

    ExpVal value;   // Value of the ConstantExp

    //Java Constructor
    public ConstantExpImpl(ExpVal value) {
        this.value = value;
    }

    @Override
    //Returns value of the current ConstantExp
    public ExpVal value() {
        return value;
    }

    @Override
    //Returns true if the current field is a ConstantExp
    public boolean isConstant() {
        return true;
    }

    @Override
    // Typecasts the current object as ConstantExp
    public ConstantExp asConstant() {
        return this;
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    //Given: an Environment
    //Returns: returns value of the ConstantExp
    //Example: value(Map(args1:3)) -> 3
    public ExpVal value(Map<String, ExpVal> env) {
        return value;
    }

}
