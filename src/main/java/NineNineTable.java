public class NineNineTable {
    public static void main(String[] args) {
        int count = 0;
        for (int i=2; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                System.out.printf("%d*%d=%2d ", i, j, i*j);
                count++;
            }
            System.out.printf("\n");
        }
        System.out.printf("巢狀迴圈總共執行了%d次\n", count);
    }
}

