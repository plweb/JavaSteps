import java.util.Scanner;
class IfElseIfElseLoop {
    public static void main(String[] args) {
        if_elseif_else_condition();
        if_elseif_else_condition();
        if_elseif_else_condition();
        if_elseif_else_condition();
        if_elseif_else_condition();
    }
    public static void if_elseif_else_condition() {
        System.out.print("請輸入成績:");
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();

        if (grade >= 90)
            System.out.println("成績為A");
        else if (grade >= 80)
            System.out.println("成績為B");
        else if (grade >= 70)
            System.out.println("成績為C");
        else if (grade >= 60)
            System.out.println("成績為D");
        else
            System.out.println("成績為E");
    }
}


