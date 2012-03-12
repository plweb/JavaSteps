****
介面
****

前一個單元，介紹了以抽象類別內的抽象方法，\
來將需求強制加在抽象類別的直接子類別上。\
這種功能提供了程式設計師必需先想、先設計，\
然後才開始寫程式的好習慣。\
這個功能還提供了程式設計師以下的可能：

1. 將額外的註解放入抽象方法中，讓程式碼有更容易瞭解；
2. 可以將一個類別交給其他人來寫；
3. 如果某個程式設計師忘了按照需求定義抽象方法所強制的名稱與類別，\
   編譯器可以自動產生錯誤信息。

除了抽象類別能宣告抽象方法之外，\
Java 還提供了\ **介面**\ （interface）來宣告抽象方法。\
不同於抽象類別：

1. 介面只提供抽象方法或常數宣告，而不能定義變數或一般的方法。
2. 一個子類別只能繼承一個父類別，但卻可以\ **實作**\ （implements）許多個介面。\
   因此，介面模擬了\ **多重繼承**\ （multiple inheritance）的功能，\
   但是卻可以避免一個類別繼承了多個父類別，\
   但卻可能同時繼承了多個同名的變數或方法而造成混淆。

假設在設計 Exam 這個程式時，\
你已經想過要提供一個 ``score`` 方法給 ``ChineseExam`` 與 ``EnglishExam``\ 。\
這時你可以先將 ``ScoreInterface`` 設計如下：

.. code-block:: java

    public interface ScoreInterface {
        public abstract int score();
    }

而 ``ChineseExam`` 與 ``EnglishExam`` 則 ``implements`` 這個 interface：

.. code-block:: java

    class ChineseExam extends Exam implements ScoreInterface {
        //...
    }
    class EnglishExam extends Exam implements ScoreInterface {
        //...
    }

這時 ``ChineseExam`` 與 ``EnglishExam`` 必須提供 ``score`` 方法，\
而且要有同樣的輸出入參數的型態，\
否則 Java 的編譯器便會產生錯誤信息。\
因此使用 interface 的一大好處是讓 Java 的編譯器，\
也可以幫助維持程式的一致性；\
而不用透過人工，這個容易出錯的方式來維持。

Interface 也可以成為一個變數的型態，\
而所宣告的變數可以用來呼叫這個 interface 內宣告的方法。\
例如：

.. code-block:: java

    // ...

    public class Demo {
        public static void main(String argv[]) {
            ScoreInterface ex;
            ex = new ChineseExam(35, 35, 18, "Chinese exam");
            ex.score();
            ex = new EnglishExam(30, 20, 26, "English exam");
            ex.score();
        }
    }

然而，如果上例的 ``ChineseExam`` 與 ``EnglishExam`` 類別中定義了 ``report`` 方法，\
而 ScoreInterface 中卻沒有宣告。\
這時下列的程式碼便會在編譯時產生型態錯誤：

.. code-block:: java

    // ...
    
    public class Demo {
        public static void main(String argv[]) {
            ScoreInterface ex;
            ex = new ChineseExam(35, 35, 18, "Chinese exam");
            ex.report();
            ex = new EnglishExam(30, 20, 26, "English exam");
            ex.report();
        }
    }

改正的方式是透過轉型：

.. code-block:: java

    // ...
    
    public class Demo {
        public static void main(String argv[]) {
            ScoreInterface ex;
            ex = new ChineseExam(35, 35, 18, "Chinese exam");    
            ((ChineseExam)ex).report();
            ex = new EnglishExam(30, 20, 26, "English exam");
            ((EnglishExam)ex).report();
        }
    }
