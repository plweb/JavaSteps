public class Continue1 {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            if (i == 5)
                continue;
            System.out.println("迴圈執行第" + i + "次。");
        }
    }
}

