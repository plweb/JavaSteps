class EnglishExam {
    public int vocab, grammar, listen;
    public double score(double wb, double wg, double wl) {
        return wb * vocab + wg * grammar + wl * listen;
    }
}

public class MoreExamDemo3 {
    public static void main(String argv[]) {
        EnglishExam ee = new EnglishExam();
        ee.vocab = 3; ee.grammar = 4; ee.listen = 5;
        System.out.print("The score of the English exam is ");
        System.out.println(ee.score(0.2, 0.3, 0.5));
    }
}
