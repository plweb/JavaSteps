public class LoopTransfer2 {
    public static void main(String[] args) {
        // for-loop
        System.out.println("for迴圈1到100間3的倍數總合為" + for_loop());

        // while-loop
        System.out.println("while迴圈1到100間3的倍數總合為" + while_loop());

        // do-while-loop
        System.out.println("do-while迴圈1到100間3的倍數總合為" + do_while_loop());
    }

    public static int for_loop() {
        int count = 0;
        for (int i=1; i <=100; i++)
            if (i % 3 == 0)
                count += i;
        return count;
    }

    public static int while_loop() {
        int count = 0;
        int i = 1;
        while (i <= 100) {
            if (i % 3 == 0)
                count += i;
            i++;
        }
        return count;
    }

    public static int do_while_loop() {
        int count = 0;
        int i = 1;
        do {
            if (i % 3 == 0)
                count += i;
            i++;
        } while (i <= 100);
        return count;
    }
}

