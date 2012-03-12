import java.util.Scanner;
class SwitchStatement {
    public static void main(String[] args) {
        switch_statement();
        switch_statement();
        switch_statement();
        switch_statement();
        switch_statement();
        switch_statement();
    }
    public static void switch_statement() {
        System.out.print("請輸入成績:");
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();
        grade = (int)grade / 10;

        switch (grade) {
            case 10:
            case 9:
                System.out.println("90~100");
                break;
            case 8:
                System.out.println("80~89");
                break;
            case 7:
                System.out.println("70~100");
                break;
            case 6:
                System.out.println("60~69");
                break;
            default:
                System.out.println("0~59");
        }
    }
}


