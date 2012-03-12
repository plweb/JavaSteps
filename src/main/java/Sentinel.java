import java.util.Scanner;

public class Sentinel {
    static Scanner keyboard = new Scanner(System.in);
    static int i = -1;

    public static void main(String[] args) {
        int total = 0;
        int s = 0;

        System.out.print("Please enter score or enter -1 to stop: ");
        s = keyboard.nextInt();
        while (s != i) {
            total = total + s;
            System.out.print("Please enter score or enter -1 to stop: ");
            s = keyboard.nextInt();
        }
        System.out.println("The sum of scores: "+ total);
    }
}

