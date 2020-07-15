public class EnteredStringCheck {
    String toCheckString;

    public EnteredStringCheck(String toCheckString) {
        this.toCheckString = toCheckString;
    }

    public void toCheckmethod() throws DivisionByZeroException, EnteredSymbolsException {
        if (toCheckString.contains("/0")) throw new DivisionByZeroException();
        String s = new String(toCheckString);
        if (s.replaceAll("[\\d+.\\+\\-\\/\\*]", "").length() != 0) throw new EnteredSymbolsException();
        if (toCheckString.startsWith("+") || toCheckString.startsWith("-") ||
                toCheckString.startsWith("*") || toCheckString.startsWith("/")) throw new EnteredSymbolsException();
    }
}
