import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {
    public String toRead() {
        String theExpressionString = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            theExpressionString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theExpressionString;
    }
}
