import java.util.Scanner;

class IfElseLoop {
    public static void main(String[] args) {
        if_else_condition();
        if_else_condition();
    }

    public static void if_else_condition() {
        System.out.print("請輸入成績:");
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt(); 

        if (grade >= 60) {
            System.out.println("成績及格!");
        }
        else {
            System.out.println("成績不及格!");
        }
    }
}

