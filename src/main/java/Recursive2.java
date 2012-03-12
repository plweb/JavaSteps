public class Recursive2 {
    public static void main(String args[]) {
        System.out.println(allTrue("111"));
    }

    public static boolean allTrue(String str) {
        System.out.println("str=" + str);

        if (str.equals(""))
            return true;
        else if (Integer.parseInt(str.substring(0, 1)) > 0)
            return allTrue(str.substring(1));
        else
            return false;
    }
}
