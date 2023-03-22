/**
 * AddTwoNumbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            System.out.println("sum of numbers is: " + (num1 + num2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}