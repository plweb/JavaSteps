class EnglishExam {
    public int vocab, grammar, listen;
    public int score() {
        return vocab + grammar + listen;
    }
}

class ChineseExam {
    public int word, sentence, composition;
    public int score() {
        return word + sentence + composition;
    }
}

public class MoreExamDemo {
    public static void main(String argv[]) {
        EnglishExam ee = new EnglishExam();
        ee.vocab = 3; ee.grammar = 4; ee.listen = 5;
        ChineseExam cc = new ChineseExam();
        cc.word = 2; cc.sentence = 3; cc.composition = 4;
        System.out.print("The score of the English exam is ");
        System.out.println(ee.score());
        System.out.print("The score of the Chinese exam is ");
        System.out.println(cc.score());
    }
}
