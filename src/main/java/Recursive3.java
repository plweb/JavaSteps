public class Recursive3 {
    public static void main(String args[]) {
        System.out.println(countTrue(""));       // => 0
        //輸入參數中沒有一個false的值，所以結果是0。
        System.out.println(countTrue("1"));      // => 1
        System.out.println(countTrue("01"));     // => 1
        System.out.println(countTrue("101"));    // => 2
        System.out.println(countTrue("1101"));   // => 3
    }

    public static int countTrue(String str) {
        if (str.equals(""))
            return 0;
        else if (Integer.parseInt(str.substring(0, 1)) == 1)  // 1(true)
            return 1 + countTrue(str.substring(1));
        else                                                 // 0(false)
            return countTrue(str.substring(1));
    }
}


