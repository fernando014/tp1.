import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Le {
    private Le() {
    }

    public static int umInt() {
        while(true) {
            try {
                return Integer.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("!!! NÃ£o Ã© um inteiro !!!");
            }
        }
    }

    public static double umDouble() {
        while(true) {
            try {
                return Double.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("!!! NÃ£o Ã© um double !!!");
            }
        }
    }

    public static float umFloat() {
        while(true) {
            try {
                return Float.valueOf(umaString().trim());
            } catch (Exception var1) {
                System.out.println("!!! NÃ£o Ã© um float !!!");
            }
        }
    }

    public static String umaString() {
        String var0 = "";

        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in), 1);
            var0 = var1.readLine();
        } catch (IOException var2) {
            System.out.println("Error reading from the input stream.");
        }

        return var0;
    }

    public static char umChar() {
        char var0 = ' ';

        try {
            BufferedReader var1 = new BufferedReader(new InputStreamReader(System.in), 1);
            var0 = (char)var1.read();
        } catch (IOException var2) {
            System.out.println("Error reading from the input stream.");
        }

        return var0;
    }
}
