螢幕輸出及鍵盤輸入
================

螢幕輸出有幾種方式。
第一種是前面章節已經使用過的 System.out.print 及 System.out.println。
這兩種方法的的差別是前者沒有換行，而後者有換行。
如果有數個資料需要一起印出時，則可以使用 + 進行串接。例如：

.. code-block:: java

	public class Show {                      
		public static void main(String argv[]) {
			int design, acting;    
	
			design = 3;
			acting = 5;
			System.out.println( "Design is " + design + "and acting is " + acting );
		}
	}

第二種方式是在 J2SDK5 之後才支援 [#JavaSystemOutPrintf]_ 。
這個方式與 C 語言的 printf 功能類似。例如：::

	System.out.printf("Today is %s, %d.\n", "January", 18);
	// %s 的位置替換成 January 這個 String
	// %d 的位置替換成 18 這個整數 
	// \n 表示換行符號

顯示：::

	Today is January, 18

例如：::

	double score = 92.345
	System.out.printf("My score is %.2f.\n", score);
	// %.2f 的意義是小數點以下取兩位，並四捨五入。
	System.out.printf("My score is %6.2f.%n", score);
	// %6.2f 的意義是：包括小數點共6位，小數點以下取兩位，
	// 並四捨五入。所以9的左邊多空一格。

顯示：::

	My score is 92.35.
	My score is  92.35.

鍵盤輸入則可以透過 [#JavaUtilScanner]_ 。例如：

.. code-block:: java

	// 使用時先載入 Scanner 所屬的 package
	import java.util.*;  // * 的意義是 java.util 內所有的類別
	
	// 定義物件：
	Scanner scanner = new Scanner(System.in);
	
	// 輸入字串：
	String name = scanner.nextLine();
	
	// 輸入整數：
	int score = scanner.nextInt();
	
	// 輸入double
	double height = scanner.nextDouble();
	
	// 輸入float
	float weight = scanner.nextFloat();

以下是一個完整的範例：

.. code-block:: java

	import java.util.*;  
	
	public class EnglishExam {                      
		public static void main(String argv[]) {
			int vocab, grammar, listen, score;
			
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			vocab = scanner.nextInt();
			grammar = scanner.nextInt();
			listen = scanner.nextInt();
			score = vocab + grammar + listen;
			System.out.printf("The total score of %s is %d.%n", name, score);
		}
	}

.. [#JavaSystemOutPrintf] System.out.printf(), http://www.java2s.com/Code/JavaAPI/java.lang/System.out.printf.htm
.. [#JavaUtilScanner] java.util.Scanner, http://www.java2s.com/Code/JavaAPI/java.util/Scanner.htm