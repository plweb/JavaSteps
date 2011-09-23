運算式、句子與條件判斷句
=====================

運算式（expression）執行完畢會後傳回一個值；句子（statement）在執行之後，則不回傳值。一個運算式與句子在執行時都可能會改變電腦的狀態，例如：更改變數、陣列或檔案的內容。算術運算式已經介紹了，而最簡單的句子，包括：

1. expression statement：在運算式後加一個 ";" 。
2. block statement：在 { } 內可以有 0 或多個變數宣告或句子。

這兩種句子，也都已經看過範例。這個單元將介紹關係運算式、邏輯運算式及 if、switch等句子。

關係運算式
---------

以下是在寫關係運算式（relational expression）時常常會使用到的關係運算子（relational operator），整理如下：

========	====	============	=============
關係運算子	名稱		範例1(=True)		範例2(=False)
========	====	============	=============
==			等於		6 == 6			6 == 4
!=			不等於	6 != 4			6 != 6
>			大於		6 > 4			4 > 6
>=			大於等於	6 >= 6			4 >= 6
<			小於		4 < 6			6 < 4
<=			小於等於	6 <= 6			6 <= 4
========	====	============	=============

* 需注意關係運算式使用的  **"=="**  ，和寫設值運算式（assignment expression）的 "=" 是不一樣的。

邏輯運算式
---------

Java 常用的邏輯運算子（logical operators）有三個，分別是 && (AND)、|| (OR)、! (NOT)。
邏輯運算式使用邏輯運算子以連結二個或以上的關係運算式。

* && (AND)

&& 是「AND（且）」運算：左右二邊「都」為 true，結果為 true；其餘情況其結果都為 false。

====	====	========
A		B		A && B
====	====	========
true	true	true
true	false	false
false	true	false
false	false	false
====	====	========

如果左邊為 false，則系統就不會去執行右邊；
因為結果必為 false；既然左邊已經為 false，不管右邊結果為何，結果一定為 false。

* || (OR)

|| 是「OR（或）」運算，左右二邊只要有一邊為 true，結果為 true；只有左右二邊都為 false，結果才為 false。

====	====	========
A		B		A || B
====	====	========
true	true	true
true	false	true
false	true	true
false	false	false
====	====	========

如果左邊為 true，則系統就不會去執行右邊；因為結果必為 true；
即然左邊已經為 true，不管右邊結果為何，結果一定為 true。

* ! (NOT)
! 是「NOT（相反）」運算，其結果為 ! 右邊的相反。

====	====
A		!A
====	====
true	false
false	true
====	====

運算子的優先順序
--------------

以下是在在寫運算式時常常會使用到的運算子的優先順序，整理如下： 

========	========
優先順序		運算子
========	========
1			**(** (左括號)  **)** (右括號) **++** (左遞增) **--** (左遞減)
2			**\+** (正) **-** (負) **!** (NOT) **++** (右遞增) **--** (右遞減)
3			**\*** (乘) **/** (除) **%** (取餘數)
4			**\+** (加) **-** (減)
5			**<** (小於) **<=** (小於等於) **>** (大於) **>=** (大於等於)
6			**==** (等於) **!=** (不等於)
7			**&&** (AND)
8			**||** (OR)
9			**?:** (條件判斷)
========	========

上表雖然不易記憶，然而，由於 "(" 與 ")" 的優先順序是最優先，
所以在程式的設計過程中，我們可以藉由使用左、右括號來指定運算式的優先順序。

立即練習：

.. code-block:: java

	a = 48
	b = 32
	c = 55
	
	d = a>b?a+b++*--c:a-b--*++c

1. 請問 d 的值是多少？

上面的程式碼，讀者可能需要查閱運算子優先次序，才能計算輸出的值是多少，
雖然對電腦來說，可以很快就按照規則計算出正確的數字，
但畢竟程式碼是由「人」撰寫和維護，要記住這些瑣碎的規則可是一點都不容易。

請再嘗試以下的練習：

1. 在上一個練習的程式碼加上 ( ) 括號，讓你自己可以很容易看懂計算的優先次序。

Java 條件判斷句的種類
-------------------

Java 的條件判斷句（statement）可以分成以下 3 種：

1. if...
2. if... else...
3. switch

if 條件判斷句
^^^^^^^^^^^^

Java 語言 if (...) {...} 條件判斷句的流程圖及語法如下：

Image If-1.png

.. code-block:: java

	if (/* 條件判斷 */) {
	  //條件判斷成立時執行的程式碼
	}

說明：

1. 如果第 1 行的條件判斷成立（值 == true），則會執行第 2 ~ 4 行的程式碼（圖形藍色的路徑）。而如果條件判斷不成立（值 == false），則會跳過第 2 ~ 4 行程式碼不執行（圖形黑色 False 的路徑）。
2. 如果第 1 行的條件判斷成立時，執行的程式碼只有一行，則區塊符號可以省略不寫。如果超過一行，其區塊符號 { } 不可以省略。

Example 1：請設計一個 Java 程式，讓使用者自行輸入一個成績，判斷輸入的成績是否「大於或等於」60 ，如果是就輸出「成績及格！」。

Image If-2.png

.. code-block:: java

	import java.util.Scanner;
	class if_loop {
	  public static void main(String[] args) {
	    if_condition();
	  }
	
	  public static void if_condition() {
	    System.out.print("請輸入成績:");
	    Scanner scanner = new Scanner(System.in);
	    int grade = scanner.nextInt();
	    
	    if (grade >= 60) {
	    	System.out.println("成績及格!");
	    }
	  }
	}

執行結果： ::

	請輸入成績:60
	成績及格!

說明：

* 輸入的 grade 為 60 ，條件判斷的結果為 true（60 >= 60），會執行條件判斷成立區塊內的程式碼，輸出「成績及格!」（圖形藍色的路徑）。
* 因為範例中條件判斷成立時，執行的程式碼只有一行： System.out.println("成績及格!"); 所以區塊符號可以省略不寫。

if… else… 條件判斷句
^^^^^^^^^^^^^^^^^^^

Java 語言 if (...) {...} else {...} 條件判斷句的語法如下：

Image If-else-1.png

.. code-block:: java

	if (條件判斷) 
	{
	  條件判斷成立時執行的程式碼;
	  ....
	}
	else
	{
	  條件判斷不成立時執行的程式碼;
	  ....
	}

說明：

* 如果第 1 行的條件判斷成立（值 == true），則執行第 2 ~ 5 行區塊符號內的程式碼（圖形藍色的路徑）。
* 如果第 1 行的條件判斷不成立（值 ==false），則跳過第 2 ~ 5 行的程式碼，而執行第 7 ~ 10 行區塊符號內的程式碼（圖形紅色的路徑）。
* 如果 if 條件判斷成立或不成立時，執行的程式碼只有一行，則該區塊符號可以省略不寫。而如果超過一行，則區塊符號不可以省略。
* if 和 else 是彼此互斥的關係，二個條件區塊在程式執行的過程中，只會選擇一個條件區塊去執行。

Example 2：請設計一個 Java 程式，讓使用者輸入一個成績，判斷該輸入的成績是否「大於或等於」60 ，如果是就輸出「成績及格!」；如果不是則輸出「成績不及格!」。

Image If-else-2.png

.. code-block:: java

	import java.util.Scanner;
	
	class if_else_loop {
	  public static void main(String[] args) {
	    if_else_condition();
	    if_else_condition();
	  }
	
	  public static void if_else_condition() {
	    System.out.print("請輸入成績:");
	　　 Scanner scanner = new Scanner(System.in);
	　　 int grade = scanner.nextInt(); 
	
	　　 if (grade >= 60) {
	      System.out.println("成績及格!"); 
	　　 }
	    else {
	      System.out.println("成績不及格!");
	    }
	  }
	}

執行結果： ::

	請輸入成績:88
	成績及格!
	請輸入成績:59
	成績不及格!

說明： 

* 第一次輸入的 grade 為 88 ，其條件判斷的結果為 True（88 >= 60），執行 if 成立區塊內的程式碼，輸出 「成績及格!」（圖形藍色的路徑）。
* 第二次輸入的 grade 為 59 ，其條件判斷的結果為 False（59 >= 60），執行 else 區塊內的程式碼，輸出 「成績不及格!」（圖形紅色的路徑）。 
* 因為 if 條件判斷成立和不成立時，執行的程式碼都只有一行，所以二者的區塊符號都可以省略不寫。

數個 if 的條件判斷
^^^^^^^^^^^^^^^^

幾個接續在一起的 if 句子，可以寫成： if (...) {...} else if (...) {...} else {...}：

[[Image:If-elseif-else-1.png]]

.. code-block:: java

	if (條件判斷1) {
	  條件判斷1成立時執行的程式碼;
	  ....
	}
	else if (條件判斷2) {
	  條件判斷2成立時執行的程式碼;
	  ....
	}
	：
	：
	else {
	  上述條件判斷都不成立時執行的程式碼;
	  ....
	}

說明：

* 如果在第 1 行的條件判斷1 成立（值 == true），則執行第 2 ~ 5 行區塊符號內的程式碼（圖形藍色的路徑），並略過其餘的程式碼。
* 如果在第 6 行的條件判斷2 成立（值 == true），則執行第 7 ~ 10 行區塊符號內的程式碼（圖形綠色的路徑），並略過其餘的程式碼。 
* 如果所有的條件判斷都不成立（值 == false），則跳過第 1 ~ 12 行的程式碼，而執行第 14 ~ 17 行區塊符號內的程式碼 (圖形紅色的路徑) 。 
* if 、 else if 和 else 是彼此互斥的關係，所有條件區塊在程式執行的過程中，只會選擇一個條件區塊去執行。 

Example 3：請設計一個 Java 程式，讓使用者自行輸入一個成績，判斷該輸入的成績是屬於 A, B, C, D 或 E 。

[[Image:If-elseif-else-2.png]]

.. code-block:: java

	import java.util.Scanner;
	class if_elseif_else_loop {
	　　public static void main(String[] args) {
	　　　　if_elseif_else_condition();
	　　　　if_elseif_else_condition();
	　　　　if_elseif_else_condition();
	　　　　if_elseif_else_condition();
	　　　　if_elseif_else_condition();
	　　}
	
	　　public static void if_elseif_else_condition() {
	　　　　System.out.print("請輸入成績:");
	　　　　Scanner scanner = new Scanner(System.in);
	　　　　int grade = scanner.nextInt();
	
	　　　　if (grade >= 90)
	　　　　　　System.out.println("成績為A");
	　　　　else if (grade >= 80)
	　　　　　　System.out.println("成績為B");
	　　　　else if (grade >= 70)
	　　　　　　System.out.println("成績為C");
	　　　　else if (grade >= 60)
	　　　　　　System.out.println("成績為D");
		   else
	　　　　　　System.out.println("成績為E");
	　　}
	}

執行結果： ::

	請輸入成績:90
	成績為A
	請輸入成績:89
	成績為B
	請輸入成績:70
	成績為C
	請輸入成績:60
	成績為D
	請輸入成績:59
	成績為E

說明：

* 第一次輸入的 grade 為 90 ，符合條件判斷 1，輸出 "成績為A" (圖形藍色的路徑) 。
* 第二次輸入的 grade 為 89 ，符合條件判斷 2，輸出 "成績為B" (圖形綠色的路徑) 。
* 第三次輸入的 grade 為 70 ，符合條件判斷 3，輸出 "成績為C" (圖形粉紅色的路徑) 。
* 第四次輸入的 grade 為 60 ，符合條件判斷 4，輸出 "成績為D" (圖形淺藍色的路徑) 。
* 第五次輸入的 grade 為 59 ，都不符合上面的條件判斷，會執行 else 區塊內的程式碼，輸出 "成績為E" (圖形紅色的路徑) 。
* 因為 if 條件判斷、所有 else if 條件判斷或 else 成立時，執行的程式碼都只有一行，所以區塊符號都可以省略不寫。 

switch 與 break
^^^^^^^^^^^^^^^

breake
"""""""

* break：在程式執行時，遇到 break，會跳過目前執行區塊後的程式碼，並跳出目前的區塊。

switch
"""""""

當需要對一個 int、short、char、byte 或是 enum 型態值做多種不同的判斷時，可以使用 switch ，以下是 switch 的語法：

[[Image:Switch-1.png]]

.. code-block:: java

	1  switch (變數或運算式) {
	2      case 值1:
	3          符合值1執行的程式碼;
	4          ....
	5          break;
	6      case 值2:
	7          符合值2執行的程式碼;
	8          ....
	9          break;
	10       ：
	11       ：
	12     case 值n:
	13         符合值n執行的程式碼;
	14         ....
	15         break;
	16     default:
	17         都不符合上述值執行的程式碼;
	18         ....
	19 }

說明：

* 第 1 行： Switch 後面括號內的程式碼，可以是變數（例如：grade）或是運算式，然而其型態必需是 int、short、char、byte 或是 enum 型態（圖形藍色菱形的部份）。
* 第 2 、 6 、 12 行：用以判斷 switch 後面括號內的變數或運算式的值是否符合值1（第2行；圖形藍色的路徑）、值2（第6行；圖形綠色的路徑）、值n（第12行；圖形粉紅色的路徑）的條件判斷。值1、值2、值n必須是常數（compile-time constant）。
* 第 (3~4) 、 (7~8) 、 (13~14) 行：如果符合值1（圖形藍色的路徑）、值2（圖形綠色的路徑）、值n（圖形粉紅色的路徑）時會執行的程式碼。
* 第 16 行：如果都不符合 case 值1 到 case 值n 的情況下，則會去執行 default 區塊內（第17、18行；圖形紅色的路徑）的程式碼，然後離開整個 swtich 的條件判斷。
* 第 5 、 9 、 15 行： **當程式執行遇到 break 敘述，會結束 swtich 的執行** 。
* 在 Java 語言中， **switch 條件判斷的 case 的值只能是單一的常數值（compile-time constant），不可以是範圍值（例如：>=90）** 。

Example 4：請使用 switch 來設計一個 Java 程式，讓使用者自行輸入一個成績，判斷該輸入的成績是介於哪一個區間之內。

[[Image:Switch-2.png]]

.. code-block:: java

	import java.util.Scanner;
	class Switch_Statement {
	　　public static void main(String[] args) {
	　　　　switch_statement();
	　　　　switch_statement();
		   switch_statement();
	　　　　switch_statement();
	　　　　switch_statement();
		   switch_statement();
	　　}
	
		public static void switch_statement() {
	　　　　System.out.print("請輸入成績:");
	　　　　Scanner scanner = new Scanner(System.in);
	　　　　int grade = scanner.nextInt();
		   grade = (int)grade / 10;
	
		   switch (grade) {
			   case 10:
			   case 9:
				   System.out.println("90~100");
				   break;
			   case 8:
				   System.out.println("80~89");
				   break;
			   case 7:
				   System.out.println("70~100");
				   break;
			   case 6:
				   System.out.println("60~69");
				   break;
			   default:
				   System.out.println("0~59");
		   }
		}
	}

執行結果： ::

	請輸入成績:100
	90~100
	請輸入成績:90
	90~100
	請輸入成績:89
	80~89
	請輸入成績:74
	70~59
	請輸入成績:60
	60~69
	請輸入成績:59
	0~59

說明：

* 第一次輸入的 grade 為 100，符合 case 10 的條件判斷，但 case 10 區塊內沒有 break 敘述（圖形藍色的路徑）會繼續往下執行到 case 9 區塊內的程式碼，輸出 "90~100"（圖形綠色的路徑），之後遇到 break 敘述跳離開整個 swtich。 
* 第二次輸入的 grade 為 90，符合 case 9 的條件判斷，會執行 case 9 區塊內的程式碼，輸出 "90~100"（圖形綠色的路徑），之後遇到 break 敘述跳離開整個 swtich 。 
* 第三次輸入的 grade 為 89，符合 case 8 的條件判斷，會執行 case 8 區塊內的程式碼，輸出 "80~89"（圖形粉紅色的路徑），之後遇到 break 敘述跳離開整個 swtich。 
* 第四次輸入的 grade 為 74，符合 case 7 的條件判斷，會執行 case 7 區塊內的程式碼，輸出 "70~79"（圖形淺藍色的路徑），之後遇到 break 敘述跳離開整個 swtich。
* 第五次輸入的 grade 為 60，符合 case 6 的條件判斷，會執行 case 6 區塊內的程式碼，輸出 "60~69"（圖形橘色的路徑），之後遇到 break 敘述跳離開整個 swtich。 
* 第六次輸入的 grade 為 59，都不符合上面 case 的條件判斷，會執行 default 區塊內的程式碼，輸出 "0~59"（圖形紅色的路徑），之後離開 swtich。 

巢狀條件判斷
^^^^^^^^^^^

巢狀條件判斷（nested-if）：是指在一個 if 裡面還有 if 。

Example 5：請寫一個判斷使用者輸入的數是否是2或3或6的倍數，或者都不是他們倍數的java程式。

[[Image:nested_if.png|link=]]

.. code-block:: java

	import java.util.Scanner;
	public class Times {
		public static Scanner keyboard = new Scanner(System.in);
	
		public static void main(String[] args) {
			times();
			times();
			times();
			times();
		}
		
		public static void times() {
			System.out.print("請輸入一個整數：");
			int num = keyboard.nextInt();
			
			if ((num % 2) == 0) {
				if ((num % 3) == 0) {
					System.out.println(num + "是2、3、6的倍數。");
				}
				else {
					System.out.println(num + "是2的倍數。");
				}
			}
			else {
				if ((num % 3) == 0) {
					System.out.println(num + "是3的倍數。");
				}
				else {
					System.out.println(num + "都不是2、3、6的倍數。");
				}
			}
		}
	}

輸出結果： ::

	請輸入一個整數：12
	12是2、3、6的倍數。
	請輸入一個整數：4
	4是2的倍數。
	請輸入一個整數：9
	9是3的倍數。
	請輸入一個整數：11
	11都不是2、3、6的倍數。

說明：

* 當輸入的 num 為 12 時，第一層（外層）可被 2 整除（執行 if 區塊），再往第二層（內層）可被 3 整除（執行 if 區塊），輸出 "12是2、3、6的倍數。"（圖形藍色的路徑）。
* 當輸入的 num 為 4 時，第一層（外層）可被 2 整除（執行 if 區塊），再往第二層（內層）不可被 3 整除（執行 else 區塊），輸出 "4是2的倍數。"（圖形粉紅色的路徑）。
* 當輸入的 num 為 9 時，第一層（外層）不可被 2 整除（執行 else 區塊），再往第二層（內層）可被 3 整除（執行 if 區塊內），輸出 "9是3的倍數。"（圖形綠色的路徑）。
* 當輸入的 num 為 11 時，第一層（外層）不可被 2 整除（執行 else 區塊），再往第二層（內層）不可被 3 整除（執行 else 區塊），輸出 "11都不是2、3、6的倍數。"（圖形紅色的路徑）。

? : 條件判斷式
^^^^^^^^^^^^^

條件判斷 ? 條件判斷成立時執行的程式碼 : 條件判斷不成立時執行的程式碼 ;

if 與 ? : 的差別在於 if 不傳回值；而 ? : 可以傳回值（見以下範例）

Example 6：請設計一個 Java 程式，可以判斷成績是否及格。

.. code-block:: java

	if (grade >= 60)
		message = "成績及格!";
	else
		message = "成績不及格!";

上面 Example 6 可以改寫成下面只有一行的 ? : 條件判斷式。

.. code-block:: java

	message = (grade >=60) ? "成績及格!" : "成績不及格!";
	
	message 的值是上例執行 ? : 運算式之後傳回的結果。
