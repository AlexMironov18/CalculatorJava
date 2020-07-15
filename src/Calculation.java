import java.util.ArrayList;
import java.util.Arrays;

public class Calculation {
    public static void main(String[] args) {
        System.out.println("Введите то, что нужно посчитать.");
        String theExpression = new StringReader().toRead();

        try {
            EnteredStringCheck enteredStringCheck = new EnteredStringCheck(theExpression);
            enteredStringCheck.toCheckmethod();
        } catch (DivisionByZeroException | EnteredSymbolsException e) {
            e.printStackTrace();
        }

        String[] expressionToCalculate = new StringToExpression(theExpression).toPutIntoArray();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(expressionToCalculate));

        //выполняем сначала умножение и деление

        while (list.contains("*") || list.contains("/")) {
            for (int i = 1; i < list.size() - 1; i += 2) {
                double left = Double.parseDouble(list.get(i - 1));
                double right = Double.parseDouble(list.get(i + 1));
                if (list.get(i).equals("*")) {
                    list.set(i+1, String.valueOf(left * right));
                    list.set(i, "");
                    list.set(i-1, "");
                }
                if (list.get(i).equals("/")){
                    list.set(i+1, String.valueOf(left / right));
                    list.set(i, "");
                    list.set(i-1, "");
                }
            }
            list.removeAll(Arrays.asList("", null));
        }

        //выполняем сложение и вычитание

        while (list.contains("+") || list.contains("-")) {
            for (int i = 1; i < list.size() - 1; i += 2) {
                double left = Double.parseDouble(list.get(i - 1));
                double right = Double.parseDouble(list.get(i + 1));
                if (list.get(i).equals("+")) {
                    list.set(i+1, String.valueOf(left + right));
                    list.set(i, "");
                    list.set(i-1, "");
                }
                if (list.get(i).equals("-")) {
                    list.set(i+1, String.valueOf(left - right));
                    list.set(i, "");
                    list.set(i-1, "");
                }
            }
            list.removeAll(Arrays.asList("", null));
        }
        System.out.println(list.get(0));
    }
}
