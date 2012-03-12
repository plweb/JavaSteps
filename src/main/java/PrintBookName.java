class Book {
    String name = "Sun";
    String getName() {
        return name;
    }
}

public class PrintBookName {
    public static void main(String argv[]) {
        Book b1 = new Book();
        Book b2 = new Book();
        System.out.println("Name of b1:" + b1.getName());
        System.out.println("Name of b2:" + b2.getName());
    }
}

