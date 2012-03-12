class EnglishExam {
    public int vocab, grammar, listen;
    public int score() {
        return vocab + grammar + listen;
    }
} 

public class EnglishExamDemo3 {
    public static void main(String argv[]) {
        EnglishExam ee = new EnglishExam();
        ee.vocab = 3; ee.grammar = 4; ee.listen = 5;
        System.out.print("The score of the exam is ");
        System.out.println(ee.score());
    }
}

