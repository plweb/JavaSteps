public class Recursive {
    public static void main(String args[]) {
        System.out.println(allTrue(""));       // => true
        //輸入參數中沒有一個false的值，所以結果是true。
        System.out.println(allTrue("111"));    // => true
        System.out.println(allTrue("1111"));   // => true
        System.out.println(allTrue("11010"));  // => false
    }

    public static boolean allTrue(String str) {
        if (str.equals(""))
            return true;
        else if (Integer.parseInt(str.substring(0, 1)) == 1 )
            return allTrue(str.substring(1));
        else
            return false;
    }
}

