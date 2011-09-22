簡介
====

Java 程式語言的特色
-----------------

Java 程式語言起源於 1991 年，
Green Team 軟體開發團隊用它來開發 Star 7 機器上的應用程式，
當時設計此語言的 James Gosling 因為看見窗外的「橡樹（oak）」，
決定將新語言命名為 Oak 。
但是由於工程師們喜歡邊喝咖啡邊討論，
隨後又將名稱改為 Java（一種咖啡的名稱），
這個名稱就一直沿用到現在。

Java 原本是為了控制冰箱、冷氣、微波爐等家電用品而設計的程式語言。
由於家電用品相當多樣，因此 Java 選用了一個與傳統的程式語言不一樣的執行模式：

* 傳統的程式語言在編譯後會產生 machince code（機器碼），
  然後直接在硬體上執行；
* Java 在編譯後則會產生 Byte Code 並間接的在 Java Virtual Machine（JVM）上執行。
  這個 JVM（Java虛擬機器）其實是一個軟體，其功用是解譯並執行 Byte Code，而 JVM 仍然是在硬體上執行。

因為 JVM 是軟體，所以 Java 也有跨平台的特性：
只要為不同的處理器或作業系統設計其專屬的 JVM，
Java 的程式便可以不需改寫的在這些處理器或作業系統上執行。
這便是「Write once, runs everywhere或一次編譯、到處執行」的由來。

Java 也支援物件導向程式設計（Object-Oriented Programming），
所謂「物件」，簡單的說有「屬性」也有「方法」，
例如冷氣機的「屬性」可以包括：「開關」及「溫度」；
而「方法」則可以包括：「開機」、「關機」及「設定溫度」等。
為了讓程式設計師，可以比較容易的使用物件撰寫模擬、控制與
應用電腦本身（如滑鼠與鍵盤等也是物件）和我們生活周遭的物件的程式，
因此便有研究人員發明了支援物件導向程式設計的語言。

Java 的設計搭上了全球資訊網的順風車，
原因是 Java 的設計團隊可以寫一個能夠在瀏覽器中執行的 JVM，
而讓 Java 的程式可以透過網路下載至瀏覽器中執行。
這個「網路」＋「物件導向」的特性讓 Java 瞬間爆紅。

除了跨平台、物件導向、可透過網路動態的載入及執行程式等功能之外，
Java 還支援多執行緒、例外狀態處理與自動記憶體回收的功能：

* 多執行緒讓一個程式可以執行數個工作；
* 例外狀態處理讓處理例外的程式碼也能夠物件化；
* 自動記憶體回收則讓程式設計師免除了使用低階的指標（pointers）來設計資料結構及管理記憶體的負擔。
  這個特色成了 C 語言程式設計師的福音，因為它可以為程式設計師減少許多不容易 debug 的錯誤。

安裝JDK
-------

在編譯與執行 Java 程式前，你的電腦必須先安裝 JDK（Java Development Kit）：

* 可以從這裡下載新版的JDK `<http://java.sun.com/javase/downloads/index.jsp>`_

在安裝完成後，也需要完成 path 及 classpath 的設定： ::

	path=C:\Program Files\Java\jdk1.6.0\bin;....
	classpath=.;C:\Program Files\Java\jdk1.6.0\lib;....

請注意：以上路徑中的 jdk1.6.0 會因版本的不同而異。
此外，在設定 classpath 時要特別注意在 ＝ 號的右邊要輸入這個 **「.」** 。
這個點的意義是目前的目錄（current directory），也是執行 Java 程式時用來搜尋執行檔的目錄。

編譯及執行Java程式
----------------

有兩種方式可以編譯及執行一個 Java 程式。
第一種是使用程式開發環境（program development environment），
例如： `Eclipse <http://eclipse.org/>`_ ；
另一種則是使用一般的程式編輯器。
以下是使用「記事本」寫 Java 程式時所需要進行的三個步驟：

1. 使用「記事本」輸入以下的程式並將檔案命名為 EnglishExam.java
   （注意：附檔名必須是 .java 而不是 .txt，
   **而這個檔案的主檔名必須與 public class 後面的 EnglishExam 相同** ）：

.. code-block:: java
	
	public class EnglishExam {                     
		public static void main(String argv[]) {        
			System.out.println("Your score is 97.");      
  		}
  	}

2. 執行「命令提示字元」並將目錄切換至儲存 EnglishExam.java 的目錄，然後執行： ::

	javac EnglishExam.java

   執行這個 javac 指令就是執行 Java 的編譯器（compiler），
   其結果是在同樣的目錄產生一個 EnglishExam.class 的 byte code 檔。

3. 上面的步驟如果有編譯錯誤則繼續修改程式。如果沒有編譯錯誤則可以執行： ::

    java EnglishExam

   執行後 Your score is 97。便會顯示在螢幕上。

在開發 Java 程式的過程中，有可能發生編譯錯誤（compile-time error）。
這時便需要再次的使用編輯器修改錯誤，直到沒有任何的編譯錯誤為止。
編譯完畢之後，在程式執行時也有可能發生 run-time error。
同樣的，這時也需要使用編輯器修改、編譯、執行、除錯，直到沒有錯誤為止。

一般的 Java 程式都是由一或多個類別（class）所組成，
**其中的一個類別至少要有一個命名為 public static void main 的方法（method），
而這個程式就是由 main 開始執行** 。
（透過網路瀏覽器執行的 Java applet 不適用此規則。）

上例中的 public class EnglishExam 是指定 EnglishExam 這個類別是 public 是公用的，
也就是可以被程式中其他的類別引用。而 public static void main(String argv[]) 的意義是：

1. public：指定 main 為一個可以被其他類別使用的 public method；
2. static：指定 main 為一個類別方法（static method），一個類別方法隸屬於一個 class；
3. void：代表 main 執行完畢後回傳的型態，因為 main 沒有回傳任何數值，因此它的回傳型態是 void；
4. String argv[]：指這個方法的輸入參數是 argv[] 而 String 則是它的型態。
   main 的輸入參數 String argv[] 可以在執行一個 Java 程式時將字串（String）資料輸入這個程式。
   例如在編譯以下的程式之後：

.. code-block:: java
	public class HelloJava {                     
		public static void main(String argv[]) {
			System.out.println("Hello " + argv[0] + argv[1]);      
  		}                               
	}

以「命令提示字元」執行： ::

	java HelloJava Basic C++

便會呼叫 System.out.println 並輸出： ::

	Hello Basic C++

這個程式的 argv[] 代表 argv 這個變數是一個陣列，
而 argv[0]、argv[1] 則取用 argv 內第0、1個儲存格的內容。

Java 程式中 **用大刮號 { } 標示的 Block（區塊）** 是用來組織程式層次關係的語法。

例如上例的程式就有兩個區塊，一組用來標示 class 的區塊，
另一組則用來標示 main 的區域。區塊中可以包含其他的區塊，
在撰寫程式時也應注意要把區塊的內容往右縮排。
一組用來標示類別的區塊內，可以有數個變數與方法。
而一組用來標示方法的區塊內可以有一或多句以「；」結束的程式碼。這些程式碼共同構成了這個方法的 body。

為 Java 程式中使用的名字命名，有一個不成文的規定：
**類別名稱的第一個字母要用大寫** 。
**方法或變數的第一個字母則是小寫** ，
若有數個字合併時則 **後續的字的第一個字母也習慣用大寫** 。

`動手練習：修正程式碼的錯誤 <http://v2.plweb.org/webstart.groovy?mode=student&course_id=158&lesson_id=2&class_id=2011100006>`_