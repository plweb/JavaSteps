***********************
Java 的變數、方法與型態
***********************

一個電腦程式，基本上是由兩個部分組成：

.. topic::

   .. centered:: 資料 + 處理 = 程式

1. **資料**\ ：這部分的程式碼要為所處理的資料命名、指定其型態、並存放於記憶體中。 ::

    int a = 3, b = 4, c = 5

2. **處理**\ ：這部分的程式碼要使用撰寫在方法（method）中的運算式、條件判斷式、迴圈，\
   來存取資料、計算結果、然後輸出。 ::

    System.out.println(a + b * c);

這兩部分的內容（程式碼），\
不但是機器（電腦）要知道如何執行，\
更要讓人（程式設計師）容易寫，也容易讀。\
而讓程式碼易寫、易讀的最基本的方法，\
就像收拾家中的衣櫃一般：\
按照種類與性質，分別放置整齊。

Java 語言整理程式碼的最基本的單元稱做「類別」。\
一個類別可以有儲存資料的「變數」與負責處理資料的「方法」。

.. literalinclude:: src/main/java/Person.java
   :language: java

「類別」可以提供兩種整理程式碼的方式：\
一種是以程式的邏輯結構當作分類的方式（俗稱的結構化程式設計）；\
另一種則是以物件的種類來歸類。\
而有的時候，一個類別也可以同時提供這兩種方式。

以程式的邏輯結構（例如將迴圈的邏輯放入一個方法中，\
或將一個判斷分數高低的邏輯放入一個方法中）來分類時，\
所使用到的變數稱為類別變數或 static field，\
而所用到的方法稱為類別方法或 static method。\
稱做static（靜態）的原因是，\
這類的變數與方法是在程式開始執行時便在記憶體中產生了，\
而且它們的壽命一直到程式結束時才結束。

以物件來歸類的話，\
則是將類別內的程式碼，\
看成是產生這種類別的物件的「規格」。\
由於只是規格，\
所以只有在使用這個類別製造物件時，\
所對應的記憶體才會產生。\
而這種在程式執行時「動態」產生的物件實例中的變數與方法，\
稱為實例變數（instance variable），\
與實例方法（instance method）。

類別方法或實例方法，\
也需要自己有儲存資料的地方，\
而在類別方法或實例方法中儲存資料的變數，\
都叫區域變數（local variable），\
意思是在一個方法所屬的區域內才可以使用的變數。

Java 如何分區呢？主要是使用大刮號，例如：

.. code-block:: java

   {
       //區域1
       int numA = 1;
   
       {
           //區域2
           int numB = 2 + numA;
       }
   
       {
           //區域3
           int numB = 3 + numA;
       }
   }

說明：

* 區域2及區域3可以存取區域1的變數 numA
* 區域2的 numB 變數值為 3
* 區域3的 numB 變數值為 4

程式語言的句子與一般說話的語言，\
一樣是由基本的字詞（names）組合而成。\
Java 為這些字詞命名的規定是：\
一個字詞可以包含一個或多個英文字母、數字、_ 及 $ 所組成的字元，\
而第一個字元不可以是數字。

以下是正確的使用範例：

* teacher
* teacherName
* teacher_name
* student1
* student_2
* _classmates

不正確的用法，會使程式碼無法編譯，例如：

* 0school

Java 語言有 public, class, void, if, while, for 等保留字 [#JavaKeywords]_ 。\
除了開始認識這些保留字的意義與用法之外，程式設計師所要學習的第一件事，\
就是為儲存資料的\ **變數**\ 與執行處理的\ **方法**\ 命名。

**變數（variable）**\ 是程式中的一種字詞。\
一個變數有一個\ **名字（name）**\ 、一個\ **資料值（value）**\ 、\
一塊儲存資料值的\ **記憶體**\ 以及這個資料值的\ **型態（type）**\ （如 int、double 等）。
由於一個變數的型態，\
定義了這個變數的值所需要的記憶體的大小，\
所以一個 Java 程式在編譯時，\
就可以知道如何為這些變數，\
在執行時，\
配置適當大小的記憶體空間，\
以存放這些變數的值。

Java 的變數主要有三種類型：

1. **區域變數**\ （local variable）：
   
   宣告在方法內或參數部分的變數；

2. **類別變數**\ （class variable or static field）：
   
   在一個類別中以 static 宣告的變數；

3. **實例變數**\ （instance variable or non-static field）：
   
   在一個類別中沒有使用 static 宣告的變數。

Java 也有兩種方法：

1. **類別方法**\ （class method or static method）：
   
   這種方法以 static 宣告。\
   呼叫的方式是 ``ClassName.methodName(...)``\ ，\
   其中 ClassName 是類別名稱，\
   methodName 是類別方法名稱，\
   ... 則是傳入的參數（可以沒有、一個或是多個參數）。

2. **實例方法**\ （instance method or non-static method）：
   
   這種方法不以 static 宣告，\
   隸屬於一個類別所產生的實例。
   呼叫的方式是 o.m(...)，\
   其中 o 是這個類別或其子類別的實例，\
   而 m 是其方法名稱，\
   ... 則是0至多個傳入的參數。

Java 之所以有種類這麼多的變數與方法，\
是因為 Java 同時支援結構化（例如：C 與 Basic）\
與物件導向兩種普遍使用的程式設計方式。\
撰寫結構化程式時需要使用類別變數與類別方法。\
類別變數在概念上與結構化程式語言的全域變數（global variable）一致；\
而類別方法在概念上則與結構化程式語言的函式（function）或程序（procedure）一致。\
實例變數、實例方法，則屬物件導向程式設計的功能。\
一般的 Java 程式可以同時使用結構化與物件導向並存的方式設計程式。

這本書的前半部介紹 Java 結構化程式設計的語法及語意，\
後半部則介紹 Java 物件導向程式設計的功能。

此外，Java 變數的型態也有兩大類：


test

1. **primitive type**\ ，包括：int、double、boolean、char [#JavaDataTypes]_ 等。

2. **reference type**\ ，包括：
	1. 類別型態：經由類別（class）的宣告而得到。如果 Car 是一個類別，而 aCar 是一個這個類別的變數，則 Car 便是 aCar 的型態（type）。之所以稱為 reference type，是因為 aCar 這個變數在記憶體中的位置，實際上是存著指向（reference）一個 Car 實例的地址。
	2. 介面型態：經由介面（interface）的宣告而得到。
	3. 陣列（array）型態。
	4. enum 型態：一種特別的類別宣告方式，用於宣告月份、一週的七天等。

refer [test01]_
refer [董少桓79]_

.. rubric:: Footnotes

.. [#JavaKeywords] http://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html
.. [#JavaDataTypes] http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

.. [test01] test01
.. [董少桓79] 測試
