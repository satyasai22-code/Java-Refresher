import java.util.Scanner;

enum PerformanceType{
    GOOD, AVERAGE, POOR
}
public class StringToEnum {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            PerformanceType convertedString = PerformanceType.valueOf(str);
            System.out.println(convertedString);
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
