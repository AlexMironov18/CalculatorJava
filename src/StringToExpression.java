public class StringToExpression {
    String[] theExpression;

    public StringToExpression (String theExpression) {
        this.theExpression = theExpression.split("(?=[\\-\\+\\/\\*])|(?<=[\\-\\+\\/\\*])");
    }

    public String[] toPutIntoArray() {
        return theExpression;
    }
}
