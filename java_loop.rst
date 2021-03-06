**********
迴圈與遞迴
**********

迴圈
====

我們在撰寫程式時，常常需要用到迴圈。
像是要讓使用者輸入10位學生的成績，
如果沒有使用迴圈，就必須將輸入成績的程式碼寫10次，
而這10次的程式碼卻完全一樣。
如果使用迴圈，便只需要寫 1 次就可以了。
使用迴圈讓這輸入成績的程式碼可以連續執行10次，以達到相同的效果，
因此可以讓程式設計的更精簡、有彈性。

Java 用來寫迴圈的句子有以下三個：

1. for
2. while
3. do-while

FOR-LOOP
---------

for-loop 的語法如下：

.. topic:: for-loop 語法

    ::
    
        for (控制變數的初始值設定; 控制變數的條件判斷; 控制變數值的改變) {
           符合控制變數的條件判斷時，執行的程式碼區塊;
           ....
        }

說明：

* for-loop 主要由四個部份所組成，分別是「控制變數的初始值設定」、「控制變數的條件判斷」、「控制變數值的改變」與「符合控制變數的條件判斷時，執行的程式碼區塊」。
* 「控制變數的初始值設定」：只有在迴圈第一次執行時才會執行，其目的是用來設定控制迴圈變數（loop control variable）初始值的設定。例如：int i = 0; 表示 for 迴圈一開始執行時，宣告一個 int 的控制變數，其值為0。
* 「控制變數的條件判斷」：每一次執行 {  } 內的程式碼區塊前，會先執行「控制變數的條件判斷」。如果符合該條件判斷，才會去執行迴圈內的程式碼；不符合便結束迴圈的執行。例如：i &lt; 5; 表示如果此時迴圈的控制變數 i 的值小於 5 才會去執行迴圈內的程式碼，否則便離開迴圈。
* 「控制變數值的改變」：每一次 for 執行完在 {  } 內的程式碼區塊之後，會執行的部份。它會改變迴圈控制變數的值。例如：i++; 表示每一次迴圈執行完之後，將變數 i 的值加 1。
* 「符合控制變數的條件判斷時，執行的程式碼區塊」（第 2 行的 { 至第5行的 }）：符合控制變數的條件判斷時，會執行的程式碼。例如：System.out.println(i); 表示將迴圈的控制變數 i 的值輸出。

Example 1：請利用 for-loop 來設計一個程式，讓迴圈執行5次，每次執行時都輸出迴圈執行到第幾次。

.. literalinclude:: src/main/java/ForLoop.java
   :language: java

.. topic:: 執行結果

    ::

        for迴圈執行第1次。
        for迴圈執行第2次。
        for迴圈執行第3次。
        for迴圈執行第4次。
        for迴圈執行第5次。

* 由於區塊內的程式碼只有一個句子，所以 { } 可以省略不寫。

Example 2：請利用 for-loop 搭配 if 條件判斷來設計一個 Java 程式，將 1 到 10 中的偶數輸出。

.. literalinclude:: src/main/java/ForLoop2.java
   :language: java

.. topic:: 執行結果

    ::
    
        1到10的偶數有：2
        1到10的偶數有：4
        1到10的偶數有：6
        1到10的偶數有：8
        1到10的偶數有：10

WHILE-LOOP
----------

while-loop 是前測式的迴圈，其語法如下：

.. topic:: while-loop 語法

    ::

        控制變數的初始值設定;
    
        while (控制變數的條件判斷) {
            符合控制變數的條件判斷時，執行的程式碼區塊;
            ....
            控制變數值的改變;
        }

說明：

* while-loop 和 for-loop 同樣由四個部分所組成，分別是「控制變數的初始值設定」、「控制變數的條件判斷」、「符合控制變數的條件判斷時，執行的程式碼區塊」與「控制變數值的改變」。
* while-loop 是「前測式迴圈」，因為控制變數的條件判斷位於迴圈一開始的地方，因此 while-loop 執行次數可以為0次，也就是控制變數的條件判斷在一開始便不符合。

Example 3：請利用 while-loop 設計一個 Java 程式，讓迴圈執行5次，每次執行時都輸出迴圈執行到第幾次。

.. literalinclude:: src/main/java/WhileLoop.java
   :language: java

.. topic:: 執行結果

    ::
    
        while迴圈執行第1次。
        while迴圈執行第2次。
        while迴圈執行第3次。
        while迴圈執行第4次。
        while迴圈執行第5次。

Example 4：請利用 while-loop 設計一個 Java 程式，這個程式一直讓使用者從鍵盤輸入數字，
直到輸入 -1 時為止。這個程式輸出這些數字的和。

.. literalinclude:: src/main/java/Sentinel.java
   :language: java

.. topic:: 執行結果

    ::

        Please enter score or enter -1 to stop: 3
        Please enter score or enter -1 to stop: 5
        Please enter score or enter -1 to stop: 7
        Please enter score or enter -1 to stop: 9
        Please enter score or enter -1 to stop: -1
        The sum of scores: 24

* 這個程式的特性是輸入數字的程式碼，在進入迴圈前及迴圈尾各出現一次。
* 這種迴圈叫旗標控制迴圈（sentinel-controlled loop）。

DO-WHILE LOOP
-------------

do-while loop 是一種後測式迴圈，其語法如下：

.. topic:: do-while loop 語法

    ::

        控制變數的初始值設定;
    
        do {
            符合控制變數的條件判斷時，執行的程式碼區塊;
            ....
            控制變數值的改變;
        } while (控制變數的條件判斷);

說明：

* do-while loop 和 for-loop、while-loop 同樣由四個部分所組成，分別是「控制變數的初始值設定」、「控制變數的條件判斷」、「符合控制變數的條件判斷時，執行的程式碼區塊」與「控制變數值的改變」。
* do-while loop 是「後測式迴圈」，因為控制變數的條件判斷位於最後面。
* do-while loop 最少會執行 1 次。因為一開始會先執行 do 區塊內的程式碼，之後才會進行 while 之後控制變數的條件判斷。
* 特別留意在最一行 while 控制變數的條件判斷後面，需加上「;」以表示 do-while loop 的結束。

Example 5：請利用 do-while loop 設計一個 Java 程式，
讓迴圈執行5次，每次執行時都輸出迴圈執行第幾次。

.. literalinclude:: src/main/java/DoWhileLoop.java
   :language: java

.. topic:: 執行結果

    ::

        do while迴圈執行第1次。
        do while迴圈執行第2次。
        do while迴圈執行第3次。
        do while迴圈執行第4次。
        do while迴圈執行第5次。

Example 6：請利用 do-while loop 搭配 if 條件判斷來設計一個 Java 程式，將 1 到 10 中間的偶數輸出。 

.. code-block:: java

    public class do_while_loop2 {
    　　public static void main(String[] args) {
         **int i = 1;
        do {
            if (i % 2 == 0)
                System.out.println("1到10的偶數有：" + i);
            i++;
        } while (i <= 10);** 
    　　}
    }

.. topic:: 執行結果

    ::

        1到10的偶數有：2
        1到10的偶數有：4
        1到10的偶數有：6
        1到10的偶數有：8
        1到10的偶數有：10

breake 與 continue
-----------------

**breake**

break：可以離開目前的 switch、for、while、do while 的區塊，並跳離至區塊後的下一行程式碼。在 switch 中主要用來離開；而在 for、while 與 do while 迴圈中，主要用於中斷目前迴圈的執行。

Example 7：下面是一個使用 break 敘述的 Java 程式，觀察程式碼及程式執行的過程。

.. literalinclude:: src/main/java/Break1.java
   :language: java

.. topic:: 執行結果

    ::

        迴圈執行第1次。
        迴圈執行第2次。
        迴圈執行第3次。
        迴圈執行第4次。

此迴圈只會執行 4 次，因為當 i==5 時就會執行 break; 述敘而離開迴圈。

**continue**

continue：作用與 break 敘述類似，主要使用於 for、while、do while 迴圈，所不同的是 break 敘述會結束迴圈區塊的執行，而continue 只會結束目前執行中區塊的程式碼，並跳回迴圈區塊的開頭繼續下一迴圈，而不是離開迴圈。

Example 8：下面是一個使用 continue 敘述的 Java 程式，觀察程式碼及程式執行的過程。

.. literalinclude:: src/main/java/Continue1.java
   :language: java

.. topic:: 執行結果

    ::

        迴圈執行第1次。
        迴圈執行第2次。
        迴圈執行第3次。
        迴圈執行第4次。
        迴圈執行第6次。
        迴圈執行第7次。
        迴圈執行第8次。
        迴圈執行第9次。
        迴圈執行第10次。

* 此迴圈會執行 1 ~ 4 加 6 ~ 9 次，當 i==5 時，會執行 continue; 述敘而跳離此次迴圈，然後從區塊開頭執行下一次迴圈，所以 i==5 並沒有被執行。

巢狀迴圈
--------

* 巢狀迴圈（nested loop）是指一個迴圈裡面還存在一個以上的迴圈。
* 巢狀迴圈執行的總次數為每一個迴圈執行次數的乘積。例如：一個輸出九九乘法表程式的執行次數，就是外層的8次乘以內層的9次，因此得到 8 x 9 = 72 次。
* 巢狀迴圈裡面的每一個迴圈都不可以與其它迴圈重疊，只能是彼此包含的關係。

Example 9：請使用巢狀迴圈設計一個輸出九九乘法表的程式，並計算巢狀迴圈總共執行了幾次。

.. literalinclude:: src/main/java/NineNineTable.java
   :language: java

.. topic:: 執行結果

    ::

        2*1= 2 2*2= 4 2*3= 6 2*4= 8 2*5=10 2*6=12 2*7=14 2*8=16 2*9=18
        3*1= 3 3*2= 6 3*3= 9 3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27
        4*1= 4 4*2= 8 4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36
        5*1= 5 5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45
        6*1= 6 6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54
        7*1= 7 7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63
        8*1= 8 8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72
        9*1= 9 9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81
        巢狀迴圈總共執行了72次

Example 10：請使用巢狀迴圈設計一個 Java 程式，這個程式持續輸入兩個整數 m, n，利用 while-loop 計算 m 的 n 次方，直到輸入 999 為止。 

.. literalinclude:: src/main/java/PowerOf.java
   :language: java

.. topic:: 執行結果

    ::

        Input:
        3
        4
        3^4=81
        Input:
        4
        5
        4^5=1024
        Input:
        5
        6
        5^6=15625
        Input:
        999

說明：

* 外層的 while 迴圈控制程式執行到輸入 999 才結束。
* 內層的 while 迴圈計算 m 的 n 次方。

迴圈語法的相互轉換
------------------

* for-loop、while-loop、do-while-loop可以彼此相互轉換，前面曾經介紹這三種迴圈主要由 4 個部分所組成，我們可以藉由搬動這4個部分的程式碼來完成迴圈的相互轉換。
* for-loop -> while-loop 可以遵從下面三個步驟：

1. 將「控制變數的初始值設定」從 for-loop 拉到 while-loop 前面。
2. 將「控制變數的條件判斷」保留在 while-loop 的「控制變數的條件判斷」內。
3. 將「控制變數值的改變」拉到 while-loop 的「符合控制變數的條件判斷時，執行的程式碼區塊」內的最後一行。

* while-loop -> do-while-loop ：

1. 將 while-loop 的「控制變數的條件判斷」拉到 do-while-loop 最後一行的「「控制變數的條件判斷」」內即可完成。

Example 11：請分別利用 for 、 while 與 do-while 設計計算 1 加到 100 的程式。

.. literalinclude:: src/main/java/LoopTransfer1.java
   :language: java

.. topic:: 執行結果

    ::
    
        for迴圈1加到100為5050
        while迴圈1加到100為5050
        do-while迴圈1加到100為5050

Example 12：請分別利用 for、while 與 do-while 設計計算 1 到 100 中間 3 的倍數的總合。 

.. literalinclude:: src/main/java/LoopTransfer2.java
   :language: java
   
.. topic:: 執行結果

    ::

        for迴圈1到100間3的倍數總合為1683
        while迴圈1到100間3的倍數總合為1683
        do-while迴圈1到100間3的倍數總合為1683

遞迴
====

遞迴是一個相當獨特，對訓練邏輯思考很有助益的程式設計方式，為了能循序漸進的闡述遞迴程式的撰寫，在本節中，我們將以 String 資料型態當作程式的輸入資料，並以 1 來表示 boolean 的 true；而以 0 來表示 boolean 的 false。

我們需要使用 Integer.parseInt(<String Variable>) 將 String 型態的資料轉換為 int 型態的資料。其轉換過後的值如果 == 1，則代表 true；如果 != 1，則代表 fasle。 [#PrimitiveTypeMapping]_

簡易的遞迴程序
--------------

！！！！缺少程式碼

以下是呼叫 and2 的範例：

.. code-block:: java

    System.out.println(and2("11")); //=> true 
    System.out.println(and2("10")); //=> false 
    System.out.println(and2("01")); //=> false
    System.out.println(and2("00")); //=> false

and2 的特性是，它的參數中的兩個資料值都要是 1 結果才是 true，要不然結果就是 false。

現在我們試著將 and2 的功能擴充，並將擴充後的方法命名為 allTrue。而 allTrue 可以判斷一個 string 中的值是否都是 true，這個 string 可以有不止兩個資料值。以下是呼叫 allTrue 的範例：

.. code-block:: java

    System.out.println(allTrue(""));      //=> true
    //輸入參數中沒有一個false，所以結果是true。
    System.out.println(allTrue("111"));   //=> true
    System.out.println(allTrue("1111"));  //=> true
    System.out.println(allTrue("11010")); //=> false

以下是 allTrue 的寫法：

.. literalinclude:: src/main/java/Recursive.java
   :language: java

* Integer.parseInt()：將 () 裡的 string 由 String 型態轉換為 int 型態，以提供 if 來判斷其為 true(== 1) 或 false(!= 1)。
* str.substring(0, 1)：取出 str 字串變數中的第 0 個位置（index）至第 1 個位置（index）間的資料。（例如："1234"  =>  "1"）
* str.substring(1)：取出 str 字串變數中第 1 個位置以後的資料。（例如："1234"  =>  "234"）

allTrue("111") ; 的執行過程可 trace 如下：

.. topic:: 追蹤程式的運作

    ::
    
           allTrue("111")
        => allTrue("11")
        => allTrue("1")
        => allTrue("")
        => true

allTrue("1101") ; 的執行過程可 trace 如下：

.. topic:: 追蹤程式的運作

    ::
    
           allTrue("1101")
        => allTrue("101")
        => allTrue("01")
        => false

觀察 allTrue 這個程序以及它的執行過程，我們發現： 

1. allTrue 內有三個執行的可能（if 條件判斷的三個條件情況）。 
2. 其中一行呼叫 allTrue 自己。這個呼叫自己的遞迴呼叫，傳入少了頭一筆資料值的 String(str.substring(1))。另外兩行沒有遞迴呼叫，而程式執行到這兩行之後便傳回 true 或 false，然後結束。 
3. if 條件判斷式，控制程式執行哪個式子。 
4. allTrue 這個程式的輸出入型態是：String -> boolean，也就是傳入一個 String、傳出一個布林值的意思。

一般而言，遞迴程式都有類似的模式：

1. 有終止條件（termination condition）如：str.equals("")、n == 0。 
2. 有遞迴呼叫，而遞迴呼叫所傳入的資料一定會趨近終止條件（例如使用 substring(1) 使 string 愈來愈縮短）。

這很合理，因為這樣程式才能結束。

這個單元的練習都是 String -> boolean 型態的程序。\
我們還會在後續的單元，陸續的介紹遞迴程式的其他型式。\
另外，在撰寫程式的過程中，最簡單的除錯工具是把變數的值印出來。\
System.out.println(<expression>) 與 System.out.println()
是可以顯示一個式子的傳回值與換行的兩個程序：

.. literalinclude:: src/main/java/Recursive2.java
   :language: java

執行以上的程式碼會列印與傳回以下的內容：

.. topic:: 執行結果

    ::
    
        str=111
        str=11
        str=1
        str=
        true

前面 4 行與最後 1 行分別顯示了每次呼叫 allTrue 的輸入參數的值與最後的執行結果。

累計答案值的遞迴程序
--------------------

上一單元我們練習了幾個傳回 true 或 false 的程序。\
這些題目的答案不需要經過累計，例如：累加、累乘、或累積成字串的過程。\
這個單元我們將練習需要經過累計才能計算出答案的遞迴程序。

假設我們需要撰寫一個能夠計算一個 string 中有幾個 true 的程序。\
我們將這個程序命名為 ``countTrue``\ ，測試案例如下： ::

    countTrue("");     => 0 
    countTrue("1101"); => 3

很顯然的，在程序執行的過程中如果遇到 1（true） 則需要將 1 加入結果之中。寫法如下：

.. literalinclude:: src/main/java/Recursive3.java
   :language: java

我們可以追蹤這個程式是怎麼執行的：

.. topic:: 追蹤程式的運作

    ::
    
           countTrue("");
        => 0

``""`` 使 ``str.equals("")`` 成立因此傳回0

.. topic:: 追蹤程式的運作

    ::
    
           countTrue("1");  
        => (1 + countTrue("");) 
        => (1 + 0) 
        => 1

``"1"`` 使 ``(Integer.parseInt(str.substring(0, 1)) == 1)`` 成立因此傳回1

.. topic:: 追蹤程式的運作

    ::
    
           countTrue("01");
        => countTrue("1");
        => 1 

``"01"`` 使 ``else`` 成立因此傳回1

.. topic:: 追蹤程式的運作

    ::
    
           countTrue("101"); 
        => (1 + countTrue("01"); 
        => (1 + 1) 
        => 2

``"101"`` 使 ``(Integer.parseInt(str.substring(0, 1)) == 1)`` 成立因此傳回2

接下來，我們可以追蹤將一個有四個資料值的 string 傳入 countTrue 的執行狀況：

.. topic:: 追蹤程式的運作

    ::
    
           countTrue("1101"); 
        => (1 + countTrue("101");)
        => (1 + (1 + countTrue("01");)) 
        => (1 + (1 + countTrue("1");)) 
        => (1 + (1 + (1 + countTrue("");))) 
        => (1 + (1 + (1 + 0)))
        => 3

另外，countTrue 的型態是： String -> int 。

將遞迴程序轉換成迴圈程序
------------------------

1. 階乘（factorial）是一個常見的遞迴程序的範例。如果「!」代表階乘的符號，則 ::

    0! = 1 
    N! = N * (N – 1)!

2. 加總（sum）是計算一個 string 變數內數字和的範例。 ::

    例如：sum("1234")  =>  10

在這一個單元，我們將以階乘（factorial）與加總（Sum）兩個程式為範例，說明如何將一個遞迴程式逐步的改寫成迴圈程式。

內涵式遞迴
^^^^^^^^^^

階乘函數可以用 Java 寫成如下的程式碼，我們將之命名為 factorial：

.. code-block:: java

    public class  Recursive {
        public static void main(String args[]) {
            System.out.println(factorial(3));
        }
    
        public static int factorial(int n) {
            if (n == 0)
                return 1;
            else
                return n * factorial(n - 1); 
        }
    }

追蹤程式的運作：

.. topic:: 追蹤程式的運作

    ::
    
           factorial(3)
        => return n * factorial(n - 1);             // n=3
        => return 3 * factorial(2);
        => return 3 * (n * factorial(n - 1));       // n=2 
        => return 3 * (2 * factorial(1));
        => return 3 * (2 * (n * factorial(n - 1))); // n=1 
        => return 3 * (2 * (1 * factorial(0)));
        => return 3 * (2 * (1 * 1));                // n=0
        => return 3 * (2 * (1 * 1));
        => 6

觀察以上的執行狀況，呼叫 factorial 的遞迴呼叫是內涵(embedded)在乘法算式 (n * ...) 之內。而程式的執行結果是在最後一個遞迴呼叫 factorial(0) 完成後才依序累乘 (3 * (2 * (1 * 1))) 而得的。這種類型的遞迴程序稱為內涵式遞迴（embedded recursion）。

加總涵式 sum 的寫法如下：

.. code-block:: java

    public class Recursive {
        public static void main(String args[]) {
            System.out.println(sum("1234"));
        }
        
        public static int sum(String str) {
            if (str.equals(""))
                return 0;
            else
                return  Integer.parseInt(str.substring(0, 1)) + sum(str.substring(1));
        }
    }

.. topic:: 追蹤程式的運作

    ::
    
           Sum("1234")
        => return Integer.parseInt(str.substring(0, 1))
                    + sum(str.substring(1));                    // str="1234"
        => return 1 + sum("234");
        => return 1 + (Integer.parseInt(str.substring(0, 1))
                    + sum(str.substring(1)));                   // str="234"
        => return 1 + (2 + sum("34"));
        => return 1 + (2 + (Integer.parseInt(str.substring(0, 1))
                    + sum(str.substring(1))));                  // str="34"
        => return 1 + (2 + (3 + sum("4")));
        => return 1 + (2 + (3 + (Integer.parseInt(str.substring(0, 1))
                    + sum(str.substring(1)))));                 // str="4"
        => return 1 + (2 + (3 + (4 + sum(""))));
        => return 1 + (2 + (3 + (4 + (Integer.parseInt(str.substring(0, 1))
                    + sum(str.substring(1)))));                 // str=""
        => return 1 + (2 + (3 + (4 + 0)));
        => 10

觀察以上的執行狀況，呼叫 sum 的遞迴呼叫也是內涵（embedded）在加總算式 ``(Integer.parseInt(str.substring(0, 1)) + ...)`` 之內。\
而程式的執行結果是在最後一個遞迴呼叫 ``sum("")`` 完成後才依序累加 ``(1 + (2 + (3 + (4 + 0))))`` 而得的。這是內涵式遞迴的另一個例子。

尾端式遞迴
^^^^^^^^^^

第二種形式的遞迴程序是尾端遞迴（tail recursion）。尾端遞迴的特色是遞迴呼叫沒有內涵在任何一個尚未執行完成的式子內。以下面的例子而言，呼叫 tail-fac 的遞迴呼叫雖然是在 if 之內，但是該 if 的條件判斷式已經執行完畢，所以是尾端遞迴。

.. code-block:: java
    public class  Recursive {
        public static void main(String args[]) {
            System.out.println(tail-fac(3, 1));
        }
        
        public static int tail-fac(int n, int m) {
            if (n == 0)
                return m;
            else
                return tail-fac(n - 1, n * m); 
        }
    }

.. topic:: 追蹤程式的運作

    ::
    
           tail-fac(3, 1)
        => tail-fac(2, 3)
        => tail-fac(1, 6)
        => tail-fac(0, 6)
        => 6

以上程序的執行狀況是「平的」。尾端遞迴在執行的過程中不會像內涵式遞迴累積一層又一層如同樓梯般的式子，原因是前面遞迴呼叫時所產生的區域變數區內的變數值，並不需要被保留，因此下一次遞迴呼叫的區域變數區可以直接的覆蓋上一次遞迴呼叫時所使用的區域變數區。

將內涵式遞迴程序轉換成尾端遞迴程序的技巧是增加傳入的參數。以 fac2 來說我們增加了一個能夠儲存累乘值的參數 m。增加這個參數後便不需要以累積乘法算式的方式來計算階乘的值了。

而尾端遞迴的加總函式 sum，也可以經由增加一個參數及改變遞迴的回傳值得到：

.. code-block:: java

    public class  Recursive {
        public static void main(String args[]) {
            System.out.println(tail-sum("1234", 0));
        }
        
        public static int tail-sum(String str, int n) {
            if (str.equals(""))
                return n;
            else 
                return  tail-sum(str.substring(1),
                    (n + Integer.parseInt(str.substring(0, 1))));
        }
    }

.. topic:: 追蹤程式的運作

    ::
    
           tail-sum("1234", 0)
        => tail-sum("234", 1)
        => tail-sum("34", 3)
        => tail-sum("4", 6)
        => tail-sum("", 10)
        => 10

迴圈
^^^^

第三種計算階乘的方式是使用一般程式語言常常使用的「迴圈」。一個內涵式遞迴程序在轉換成尾端式遞迴程序後，便可以改寫成迴圈程式了。

轉換的方式可以分成下面三個步驟：

1. 將尾端式遞迴的終止條件內的條件判斷拉到迴圈的條件判斷內，\
   並將它轉換成相反（Not）的條件判斷（加上 ! 或 !=）。
2. 將尾端式遞迴的參數拉到迴圈內並改寫成設值運算式，\
   但是要注意的是設值運算式的前後次序。
3. 將尾端式遞迴的終止條件成立時的回傳值拉到迴圈的後面，\
   讓程序結束後將結果值回傳回去。

使用 whlile-loop 將尾端式遞迴轉換成一般的程式語言常常使用的「迴圈」。

.. code-block:: java

    public class Recursive {  
        public static void main(String args[]){
            System.out.println(fac3(3, 1));
        }

        public static int fac3(int n, int m) {
            while (n != 0) {
                m = m * n;
                n = n - 1; 
                // 注意：上兩行次序不可顛倒。
            }
            return m;
        }
    }

.. topic:: 追蹤程式的運作

    ::

           fac3(3, 1) 
        => 6

.. code-block:: java

    public class Recursive {  
        public static void main(String args[]){
            System.out.println(sum3("1234", 0));
        }

        public static int sum3(String str, int n) {
            while (!str.equals("")) {
                n = n + Integer.parseInt(str.substring(0, 1));
                str = str.substring(1);
                // 注意：上兩行次序不可顛倒
            }
            return n;
        }
    }

.. topic:: 追蹤程式的運作

    ::
    
           sum3("1234", 0) 
        => 10

同樣也可以使用 Java 語言的 for Loop 來將尾端式遞迴轉換成一般的程式語言常常使用的「迴圈」。

.. code-block:: java

    public class Recursive {  
        public static void main(String args[]){
            System.out.println(fac3(3, 1));
        }

        public static int fac3(int n, int m) {
            for (int i=m; i<=n; i++)
                m = m * i;
            return r;
        }
    }

.. topic:: 追蹤程式的運作

    ::
    
           fac(3, 1) 
        => 6

.. code-block:: java

    public class Recursive {  
        public static void main(String args[]){
            System.out.println(sum3("1234", 0));
        }

        public static int sum3(String str, int n) {
            for (; !str.equals(""); str = str.substring(1))
                n = n + Integer.parseInt(str.substring(0, 1));
            return n;
        }
    }

.. topic:: 追蹤程式的運作

    ::

           sum3("1234", 0) 
        => 10


.. [#PrimitiveTypeMapping] Java 的每一個 primitive type 都有一個與之對應的 reference type 或類別，例如：int 與 Integer。parseInt 則是 Integer 的一個類別方法。Java 這麼設計的原因，會在《Java 物件導向程式設計》中的「泛型與 Collection」部分說明。


