public class LoopTransfer1 {
    public static void main(String[] args) {
        // for-loop
        System.out.println("for迴圈1加到100為" + for_loop());

        // while-loop
        System.out.println("while迴圈1加到100為" + while_loop());

        // do-while-loop
        System.out.println("do-while迴圈1加到100為" + do_while_loop());
    }

    public static int for_loop() {
        int sum = 0;
        for(int i=1; i<=100; i++)
            sum += i;
        return sum;
    }

    public static int while_loop() {
        int sum = 0;
        int i = 1;
        while (i <= 100) {
            sum += i;
            i++;
        }
        return sum;
    }

    public static int do_while_loop() {
        int sum = 0;
        i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 100);
        return sum;
    }
}

