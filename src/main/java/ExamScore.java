class EnglishExam {
    public int vocab, grammar, listen;
    EnglishExam() {
        vocab = 6;
        grammar = 7;
        listen = 8;
    }
    public int score() {
        return vocab + grammar + listen;
    }
}

public class ExamScore {
    public static void main(String args[]) {
        EnglishExam ee = new EnglishExam();
        System.out.println("The score of the exam is: "
            + ee.score());
    }
}

