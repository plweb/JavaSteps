class A {
    static String c1() {
        return "class method不需new就可使用";
    }
    String c2() {
        return "instance method需new才可使用";
    }
}

public class ClassInstanceMethod {
    public static void main(String argv[]) {
        System.out.println("=呼叫class method=");
        System.out.println(A.c1());
        System.out.println("=呼叫instance method=");
        //System.out.println(A.c2()); =>error
        A a = new A();
        System.out.println(a.c2());
    }
}

