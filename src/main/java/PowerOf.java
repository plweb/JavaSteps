import java.util.Scanner;
public class PowerOf {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, m;

        System.out.println("Input: "); 
        m = input.nextInt();

        while (m != 999) {
            n = input.nextInt();

            System.out.print(m + "^" + n + "=");

            int result = 1;
            while (n > 0) {
                result *= m;
                n--;
            }

            System.out.println(result);

            System.out.println("Input: "); 
            m = input.nextInt();
        }
    }
}

