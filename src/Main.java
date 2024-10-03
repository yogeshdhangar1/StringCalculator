// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            StringCalculator calculator = new StringCalculator();
            System.out.println(calculator.add(""));             // 0
            System.out.println(calculator.add("1"));            // 1
            System.out.println(calculator.add("1,2"));          // 3
            System.out.println(calculator.add("1\n2,3"));       // 6
            System.out.println(calculator.add("//;\n1;2"));     // 3
            System.out.println(calculator.add("//;\n1;-2"));    // Exception: Negative numbers not allowed: [-2]
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        }

