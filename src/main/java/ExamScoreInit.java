class EnglishExam {
    public int vocab, grammar, listen;
    EnglishExam() {
        vocab = 6; grammar = 7; listen = 8;
    }
    EnglishExam(int v, int g, int l) {
        vocab = v; grammar = g; listen = l;
    }
    public int score() {
        return vocab + grammar + listen;
    }
}

public class ExamScoreInit {
    public static void main(String args[]) {
        EnglishExam ee = new EnglishExam();
        System.out.println("The score of the first exam is: "
            + ee.score());
        ee = new EnglishExam(7, 8, 9);
        System.out.println("The score of the second exam is: "
            + ee.score());
    }
}

