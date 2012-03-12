class EnglishExam {
    public int vocab, grammar, listen;
    public static int englishScore(int v, int g, int l) {
        return v + g + l;
    }
}

public class EnglishExamDemo {
    public static void main(String argv[]) {
        EnglishExam ee = new EnglishExam();
        ee.vocab = 3;
        ee.grammar = 4;
        ee.listen = 5;
        System.out.print("The score of the exam is ");
        System.out.println(EnglishExam.englishScore(ee.vocab, ee.grammar, ee.listen));
    }
}

