class EnglishExam {
    public int vocab, grammar, listen;
    public static int score(EnglishExam THIS) {
        return THIS.vocab + THIS.grammar + THIS.listen;
    }
} 

public class EnglishExamDemo2 {
    public static void main(String argv[]) {
        EnglishExam ee = new EnglishExam();
        ee.vocab = 3;
        ee.grammar = 4;
        ee.listen = 5;
        System.out.print("The score of the exam is ");
        System.out.println(EnglishExam.score(ee));
    }
}

