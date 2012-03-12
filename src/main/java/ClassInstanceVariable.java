class A {
    static int a = 0;
    int b = 5;
    int getA() {
        return a;
    }
    void setA(int value) {
        a = value;
    }
    int getB() {
        return b;
    }
    void setB(int value) {
        b = value;
    }
}

public class ClassInstanceVariable {
    public static void main(String argv[]) {
        A obj1 = new A();
        A obj2 = new A();
        obj1.setA(1);
        obj1.setB(20);
        obj2.setA(2);
        obj2.setB(30);
        System.out.println("a of obj1:" + obj1.getA());
        System.out.println("a of obj2:" + obj2.getA());
        System.out.println("b of obj1:" + obj1.getB());
        System.out.println("b of obj2:" + obj2.getB());
    }
}
