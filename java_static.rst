類別變數與類別方法
==================

非物件導向程式語言（例如：C語言），\
程式設計師主要是使用函式（function）、全域變數與區域變數，\
將一個大的程式分割成幾個小的部份，以簡化程式的撰寫。\
這些觀念在 Java 中仍然可以使用，\
而使用的方式是透過類別變數與類別方法。

舉例而言，如果要為英文檢定考試寫一個計算成績的程式，
那麼這個程式應該有一個計算成績的方法。例如：

.. code-block:: java

    public class EnglishExam {    
        public static int englishScore(int v, int g, int l) {
            return v + g + l;
        } 
        public static void main(String argv[]) {
            System.out.print("The score of the exam is ");
            System.out.println(englishScore(24, 27, 32));
        }
    }
 
執行結果： ::

	The score of the exam is 83

``public static int englishScore(int v, int g, int l)``
定義了 ``englishScore`` 這個類別方法，\
這個方法有三個命名為 v, g, l 的輸入參數，\
它們的型態都是 int。\
這個方法的輸出型態也是 int，\
也就是會使用 return 傳出一個 int 的值 (v + g + l)。\
Java 使用 static 這個保留字來定義類別方法。\
因為這種方法是靜態的，也就是在程式執行時，\
呼叫這個方法的程式碼，一定都會執行相同的方法。

在 main 中的 ``System.out.println(englishScore(24, 27, 32))``
將 24, 27, 32 傳入 englishScore 中，並依序成為 v, g, l 三個輸入參數的值，\
而這三個數相加的結果 83 會繼續的傳入 System.out.println，然後顯示在螢幕上。\
一個方法的輸入參數也是那個方法的區域變數。\
所以 v, g, l 三個輸入參數也是 englishScore 的區域變數。

除了直接將數值傳入方法中以外，\
還可以將變數或其他也有傳回值的式子，\
寫在方法呼叫中傳入的位置。例如：

.. code-block:: java

    public class EnglishExam {
        public static int englishScore(int v, int g, int l) {
            return v + g + l;
        }        
        public static void main(String argv[]) {
            int a = 3, b = 4;
            System.out.print("The score of the exam is ");
            System.out.println(englishScore( a, b, a + b ));
        }
    }
 
執行結果： ::

	The score of the exam is 14

Java 會在得到 a, b, a + b 的數值後，才將 3, 4, 7 傳入 englishScore 中。\
也就是先得到數值再傳入，然後 v, g, l 便使用傳入的數值生成三個區域變數。\
這個特性稱為\ **傳值呼叫**\ （call-by-value）。\
v, g, l 三個參數之所以也是區域變數，\
因為這三個變數的可見範圍（scope）只包含 englishScore 的區塊。

如果一個方法沒有傳回值，那麼這個方法的輸出型態便是 void。例如：

.. code-block:: java

    public class EnglishExam {
        public static void displayScore(int v, int g, int l) {
            System.out.print("The score of the exam is ");    
            System.out.println(v + g + l);
        }
        
        public static void main(String argv[]) {
            displayScore(24, 27, 32);
        }
    }
 
執行結果： ::

	The score of the exam is 83

displayScore 這個方法將字串顯示在螢幕上，不需要傳回值，\
因此它的輸出型態是宣告成 void，而 main 的輸出型態也是 void。

不同的類別中也可以定義同名的方法。\
這個功能稱做\ **重載**\ （overloading）。\
而 Java 是以 ``類別名稱.方法名稱(0或多個參數)；`` 呼叫宣告在不同類別的類別方法。\
例如：

.. code-block:: java

    public class Exam {
        public static void main(String argv[]) {
            int voc = 3, grammar = 7, listen = 8;
            System.out.print("The score of the english exam is ");    
            System.out.println(EnglishExam.displayScore(voc, grammar, listen));
            System.out.print("The score of simple english exam is ");    
            System.out.println(SimpleEnglishExam.displayScore(voc, grammar, listen));
        }
    }
        
    class EnglishExam {  
        public static int displayScore(int v, int g, int l) {  
            return v + g + l;
        }
    }
    
    class SimpleEnglishExam {
        public static int displayScore(int v, int g, int l) {  
            return v + g + 0;
        }
    }

執行結果： ::

	The score of the english exam is 18
	The score of simple english exam is 10

一個類別中也可以有同名的方法，但是他們必須有不同的輸出入型態。例如：

.. code-block:: java

    public class Exam {
        public static void main(String argv[]) {
            int voc = 3, grammar = 7, listen = 8;
            System.out.print("The int score of the exam is ");   
            System.out.println(
                EnglishExam.displayScore(3, 7, 8));
            System.out.print("The double score of the exam is ");    
            System.out.println(
                EnglishExam.displayScore(3.0, 8.0, 7.0));
        }
    }
        
    class EnglishExam {  
        public static int displayScore(int v, int g, int l) {  
            return v + g + l;
        }
        public static double displayScore(double v, double g, double l) {  
            return v + g + l;
        }
    }

執行結果： ::

	The int score of the exam is 18
	The double score of the exam is 18.0

另一個 overloading 的例子是：＋。＋可以用來將數字相加，也可以將字串合併。例如：

.. code-block:: java

	int a = 4, b = 5;
	System.out.print(3 + a + b);

執行結果： ::

	12

例如： ::

.. code-block:: java

	String a = "xy", b = "Z";
	System.out.print("3" + a + b);
 
執行結果： ::

	3xyz

使用類別方法在程式中有許多好處：

1. 增加程式碼的再用性：
   
   同樣的計算步驟，只需要透過呼叫類別方法便可以重複使用。
2. 讓程式碼的細節，被隱藏在類別方法中：
   
   程式設計師在完成類別方法的撰寫後，\
   便只需要知道那個類別方法的輸入、輸出與功用即可，\
   而不用擔心執行的細節。
3. 容易除錯：
   
   除錯的過程可以一個類別方法、一個類別方法的進行，\
   容易找出錯誤的根源。
4. 容易擴充類別方法內程式碼的功能：
   
   只要在類別方法內擴充其功能，而不用在每次呼叫時都重複的擴充。\
   例如以下的程式碼擴充了成績的計算方式，\
   所有 displayScore 的呼叫的計算結果都同步改變：

.. code-block:: java

    class SimpleEnglishExam {
        public static int displayScore(int v, int g, int l) {  
            return  v * 0.3 + g * 0.3 + l * 0.4;
        }
    }

除了使用 static 宣告類別方法外，\
還有也是使用 static 宣告的類別變數。\
以下是一個在程式中內建三筆考試成績的資料，\
呼叫 displayScore 計算成績後，\
將三筆資料加總並存入 total 這個類別變數中的範例：

.. code-block:: java

    public class Exam {
        public static int total = 0;
        
        public static void main(String argv[]) {
            total = displayScore(3, 4, 5); // total = 12
            total = total + displayScore(4, 5, 6);        // total = 27
            total = total + displayScore(1, 2, 3);        // total = 33
            System.out.print("The total score is ");    
            System.out.println(total);
        }
        
        public static int displayScore(int v, int g, int l) {  
            return v + g + l;
        }
    }

執行結果： ::

	The total score is 33

程式設計師也可以使用不是定義在自己類別中的類別變數，\
而 Java 是以 ``類別名稱.變數名稱*``
使用定義在其他類別中的類別變數。\
以下便是一種將 total 宣告在另一個類別 EnglishExam 中的寫法是：

.. code-block:: java

    public class Exam {
        public static void main(String argv[]) {
            EnglishExam.computeScore(3, 4, 5);
            EnglishExam.computeScore(4, 5, 6);
            EnglishExam.computeScore(1, 2, 3);
            System.out.print("The total score is ");    
            System.out.println(EnglishExam.total);
        }
    }
    
    class EnglishExam {
        public static int total = 0;
    
        public static void computeScore(int v, int g, int l) {
            total = total + (v + g + l);
        }
    }
 
執行結果： ::

	The total score is 33

以下則是一個為考試成績的計算，加入權重的範例。
在這個範例中是以 Exam.wV, Exam.wG, Exam.wL 來使用這三個類別變數：

.. code-block:: java

    public class Exam {
    
        public static double wV = 0.3, wG = 0.3, wL = 0.4;
    
        public static void main(String argv[]) {
            int voc = 3, grammar = 7, listen = 8;
            System.out.print("The score of the english exam is ");    
            System.out.println(EnglishExam.displayScore(voc, grammar, listen));
            System.out.print("The score of simple english exam is ");    
            System.out.println(SimpleEnglishExam.displayScore(voc, grammar, listen));
        }
    }
        
    class EnglishExam {  
        public static double displayScore(int v, int g, int l) {  
        return v * Exam.wV + g * Exam.wG + l * Exam.wL;
        }
    }
        
    class SimpleEnglishExam {
        public static double displayScore(int v, int g, int l) {  
            return v * Exam.wV + g * Exam.wG + 0;
        }
    }
 
執行結果： ::

	The score of the english exam is 6.2
	The score of simple english exam is 3.0

類別變數與區域變數，\
在變數的可用「區域」與存在的「時間」上都不相同。\
類別變數若是定義為 public，\
則它的可用區域便包括整個程式，\
而且在整個程式執行時都存在。\
區域變數則是在程式執行到一個區塊或方法內時，\
那個區塊或方法的區域變數才存在，\
一旦離開那個區塊或方法，便消失了。\
因此區域變數的可用區域，\
只在定義該區域變數的區塊或方法內。

以下是一個「計算蛋與水果總價」的程式及其執行過程的動畫：

.. code-block:: java

    class Market {
        static int sEgg = 5, sFruit = 20;
            static int getMoney(int nEgg, int nFruit) {
            return sEgg * nEgg + sFruit * nFruit;
        }
    } 
    
    public class Ex1 {
        public static void main(String argv[]) {
            int egg = 20, fruit = 30;
            System.out.print("Money:");
            System.out.println(Market.getMoney(egg, fruit));
        }
    }

執行結果： ::

	Money:700

Media:Ex1new.swf 觀看執行過程
