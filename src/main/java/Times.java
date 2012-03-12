import java.util.Scanner;

public class Times {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        times();
        times();
        times();
        times();
    }

    public static void times() {
        System.out.print("請輸入一個整數：");
        int num = keyboard.nextInt();

        if ((num % 2) == 0) {
            if ((num % 3) == 0) {
                System.out.println(num + "是2、3、6的倍數。");
            }
            else {
                System.out.println(num + "是2的倍數。");
            }
        }
        else {
            if ((num % 3) == 0) {
                System.out.println(num + "是3的倍數。");
            }
            else {
                System.out.println(num + "都不是2、3、6的倍數。");
            }
        }
    }
}


