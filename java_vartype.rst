**********************
區域變數與基本資料型態
**********************

區域變數是一個方法的參數或是宣告在一個方法的區塊中。\
以下是宣告區域變數的幾個範例，\
其中 ``int`` 代表整數，\
而 ``double`` 代表倍精準浮點數，\
宣告的意義是告訴編譯器一個變數的型態是什麼：

.. code-block:: java

    public class EnglishExam {                     
        public static void main(String argv[]) {
            // argv 是傳入參數，同時也是一種區域變數 
            
            // 宣告三個區域變數
            int vocabulary;
            int grammar;
            int listening;
            
            // 略...
        }                                        
    }

多個變數的宣告，可以合併在一行：

.. code-block:: java

    public class EnglishExam {                     
        public static void main(String argv[]) {
            // 將以上三個區域變數，合併在一行
            int vocabulary, grammar, listening;
            
            // 略...
        }                                        
    }

宣告變數時，也可以同時指定數值：

.. code-block:: java

    public class EnglishExam {
        public static void main(String argv[]) {
            // 在宣告時也將數值存入這三個區域變數中
            int vocabulary = 24;
            int grammar = 26;
            int listening = 33;
            
            // 略...
        }
    }

宣告時指定數值，且合併在同一行：

.. code-block:: java

    public class EnglishExam {
        public static void main(String argv[]) {
            // 也可以這樣寫：
            double vocabulary = 22.5, grammar = 25.4, listening = 32.0;
            
            // 略 ...
        }
    }

有了變數之後，可以使用設值運算符號（\ ``=``\ ），\
將數值存入區域變數中，\
如果一個區域變數尚未被存入數值，\
則其預設值（default value）會被存入，\
而數字的預設值是 0。例如：

.. code-block:: java

    public class EnglishExam {                     
        public static void main(String argv[]) {
            int vocabulary, grammar, listening;
            int score;
            
            vocabulary = 22;
            grammar = 26;
            score = vocabulary + grammar + listening;
            
            System.out.print("The score of the exam is ");
            System.out.println(score);  
            // listening 的預設值是0, 所以印出 48
        }                                        
    }

以上程式碼執行的結果為： ::

	The score of the exam is 48

Java的註解是以 **//** 或 **/* */** 表示，例如：

.. code-block:: java

    // 這是註解
    
    /* 這也是註解 */
    
    /*
       這還是註解
       這是多行的註解
    */
