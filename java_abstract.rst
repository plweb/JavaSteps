繼承、抽象類別
============

假設我們要將前面的 EnglishExam 及 ChineseExam 增加一個 minutes 的實例變數。
那麼一個不好的方式是將這個實例變數分別的放入這兩個類別中：

.. code-block:: java

	class EnglishExam {
	  public int minutes;
	  public int vocab, grammar, listen;
	  public int getMinutes() {
	    return minutes;
	  }
	  public int score() {
	    return vocab + grammar + listen;
	  }
	}
	class ChineseExam {
	  public int minutes;
	  public int word, sentence, composition;
	  public int getMinutes() {
	    return minutes;
	  }
	  public int score() {
	    return word + sentence + composition;
	  }
	}
	public class Demo {
	  public static void main(String argv[]) {
	    EnglishExam ee = new EnglishExam();
	    ee.minutes = 75;
	    ee.vocab = 3; ee.grammar = 4; ee.listen = 5;
	    ChineseExam cc = new ChineseExam();
	    ee.minutes = 75;
	    cc.word = 2; cc.sentence = 3; cc.composition = 4;
	    System.out.print("The score of the English exam is ");
	    System.out.println(ee.score());
	    System.out.println("English exam takes " + ee.getMinutes() + "minutes.");
	    System.out.print("The score of the Chinese exam is ");
	    System.out.println(cc.score());
	    System.out.println("Chinese exam takes " + cc.getMinutes() + "minutes.");
	  }
	}

不好的原因是 EnglishExam 及 ChineseExam 中有許多 **重複的程式碼** 。
而這些重複的程式碼會增加開發的成本及維護的負擔。
所幸 Java 容許我們將類別設計成階層式的結構，
而這個階層的結構可以自然的將不同類別間的繼承關係表達出來。
因此，我們可以設計一個 Exam 類別，並將 minutes 宣告在 Exam 內；
再由 EnglishExam 及 ChineseExam 繼承 Exam 即可。
Java 使用 **extends** 這個保留字讓一個類別繼承另一個類別。

.. code-block:: java

	class Exam {
	  public int minutes;
	  public Exam() {
		System.out.println("Calling Exam()...");
		minutes = 75;
	  }
	  public int getMinutes() {
		return minutes;
	  }
	}
	
	class EnglishExam extends Exam {
	  public int vocab, grammar, listen; 
	  public int score() {
		return vocab + grammar + listen;
	  }
	}
	
	class ChineseExam extends Exam {
	  public int word, sentence, composition;
	  public int score() {
		return word + sentence + composition;
	  }
	}
	
	public class Demo {
	  public static void main(String argv[]) {
		EnglishExam ee = new EnglishExam();
		ee.vocab = 3; ee.grammar = 4; ee.listen = 5;
		ChineseExam cc = new ChineseExam();
		cc.word = 2; cc.sentence = 3; cc.composition = 4;
		System.out.print("The score of the English exam is ");
		System.out.println(ee.score());
		System.out.println("English exam takes " + ee.getMinutes() + "minutes.");
		System.out.print("The score of the Chinese exam is ");
		System.out.println(cc.score());
		System.out.println("Chinese exam takes " + cc.getMinutes() + "minutes.");
	  }
	}

這時 Exam 是 EnglishExam 及 ChineseExam 的父類別，
而 EnglishExam 及 ChineseExam 是 Exam 的子類別。
Exam 也有一個父類別，這個類別是 Java 內建的 Object 類別。
一個 Java 程式內所有的類別都直接或間接的繼承了 Object 類別。Exam 也可以寫成：

.. code-block:: java

	class Exam extends Object {
	  // ...
	}

除了減少重複不必要的程式碼以外，類別的繼承還有以下兩個好處：

1. 讓父類別的程式碼可以在完全除錯後，才被子類別繼承。這樣可以讓程式的偵錯更為容易。
2. 可以購買軟體廠商已經開發好的類別，再透過繼承擴充其功能。

一個子類別的實例，含有自己類別的實例變數與方法，以及所有父類別的實例變數與方法。例如：ee 這個實例便有自己定義的 vocab, grammar, listen 及繼承而來的 minutes 四個實例變數及 score 及 getMinutes 兩個方法。

通常將實例變數與實例方法放置於父類別時，需要滿足以下兩個條件：

1. 可以減少重複的程式碼。
2. 父類別的實例變數或實例方法對子類別有用處。例如：Exam 內的 minutes 便對 ChineseExam 及 EnglishExam 有用。

當類別間有繼承關係時，建構子的呼叫順序是先執行父類別的建構子。例如：

.. code-block:: java

	 class Exam {
	   public int minutes;
	   public Exam() {
		 System.out.println("Calling Exam()...");
		 minutes = 75;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	 }
	 
	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen; 
	   public EnglishExam() {
		 System.out.println("Calling EnglishExam()...");
		 vocab = 7; grammar = 7; listen = 7;
	   }
	   public int score() {
		 return vocab + grammar + listen;
	   }
	 }
	 
	 class ChineseExam extends Exam{
	   public int word, sentence, composition;
	   public ChineseExam() {
		 System.out.println("Calling ChineseExam()...");
		 word = 7; sentence = 7; composition = 7;
	   }
	   public int score() {
		 return word + sentence + composition;
	   }
	 }
	 
	 public class Demo {
	   public static void main(String argv[]) {
		 EnglishExam ee = new EnglishExam();
		 ChineseExam cc = new ChineseExam();
	   }
	 }

會得到以下的執行結果： ::

	Calling Exam()...
	Calling EnglishExam()...
	Calling Exam()...
	Calling ChineseExam()...

如果我們需要將 EnglishExam 更加的細分。
例如：增加一個 GREEnglishExam 類別，而這個類別的特性是 listen 實例變數的值是 0：

.. code-block:: java

	 class Exam {
	   public int minutes;
	   public Exam() {
		 minutes = 75;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	 }
	 
	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen; 
	   public EnglishExam() {
		 vocab = 7; grammar = 7; listen = 7;
	   }
	   public int score() {
		 return vocab + grammar + listen;
	   }
	 }
	 
	 class GREEnglishExam extends EnglishExam {
	   public int score() {
		 return vocab + grammar + 0;
	   }
	 }
	 
	 class ChineseExam extends Exam{
	   public int word, sentence, composition;
	   public ChineseExam() {
		 word = 7; sentence = 7; composition = 7;
	   }
	   public int score() {
		 return word + sentence + composition;
	   }
	 }
	 
	 public class Demo {
	   public static void main(String argv[]) {
		 EnglishExam ee = new EnglishExam();
		 GREEnglishExam gre = new GREEnglishExam();
		 System.out.println("English exam score is " + ee.score());
		 System.out.println("GRE English exam score is " + gre.score());
	   }
	 }

這時執行的結果會得到： ::

	English exam score is 21
	GRE English exam score is 14

呼叫 gre.score() 得到 14 的原因是，
GREEnglishExam 的 score 方法遮蔽了 EnglishExam 的 score 方法，
而名稱相同的方法有以下兩種關係：

1. Overloading：是指參數輸入的個數或類別不同，但是卻同名的方法。
2. Shadowing：這是指數個方法同名，而參數的個數與型態也相同，
   但是卻分別的定義在不同的類別的方法。

以上例而言 gre.score() 會呼叫 GREEnglishExam 的 score 方法，
而 ee.score() 則會呼叫 EnglishExam 的 score 方法。
在執行時呼叫幾個同名的方法的哪一個，是根據實例所屬的類別，
例如：gre 的類別是 GREEnglishExam 所以 gre.score()
會呼叫 GREEnglishExam 的 score 方法。如果 GREEnglishExam 沒有定義被呼叫的方法，例如：gre.getMinutes()，這時則會呼叫其父類別的方法，如果父類別中也沒有定義，則會呼叫祖父類別的方法，依此類推。所以 gre.getMinutes()會呼叫到 Exam 的 getMinutes 方法。

private 與 protected 變數與方法
------------------------------

在討論 getter, setter 方法時，我們談到資料抽象化的好處。
但是如果那個實例變數本身（例如：minutes）仍然是定義成 public 那麼將失去強制性，
也就是其他的程式設計師仍然可以繞過 getter 與 setter 方法而直接的存取 minutes。

private 與 protected 兩個保留字可以設定某個變數或方法的存取範圍。
private 變數或方法的存取範圍為自己的類別內，
而 protected 變數或方法則包括自己的類別、子類別及所屬的 package 內。
至於一個 package 則是由數個為了完成某種功能的類別所組合而成。
例如：一個類別 C 若屬於一個 package p，則 C 的程式碼必須以 ::

	package p; 

起始，而且也必須存放在一個命名為 p 的目錄中。一個 Java 的檔案，
如果要使用 C 或 p 所提供的功能，則可以用下兩種方式，
輸入 C 或 p 內所有非 private 的名字： ::

	import p.C;
	import p.*;

一個 package 也可以使用 ::

	jar vcf p.jar p

指令將其中的 .class 檔包裹起來，放在 jdk...\jre\lib\ext 的目錄中供其他程式使用。

private 與 protected 的變數與方法可以有許多交替使用的可能。例如：

.. code-block:: java

	 class Exam {
	   public Exam() {
		 minutes = 75;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	   public void setMinutes(int m) {
		 minutes = m;
	   }
	   private int minutes;
	 }

以上的範例將 minutes 宣告為 private 而將 getMinutes, setMinutes 宣告為 public。
這時只有 Exam 能直接存取 minutes，
而程式中所有其他的類別都可以透過 getMinutes, setMinutes 間接的存取 minutes。
Java 的習慣是將 private 的變數或方法宣告在 public 的變數或方法的下方。
一個類別的 public 變數或方法，
形成了這個類別對其他類別的 public interface 或公開的介面。

.. code-block:: java

	 class Exam {
	   public Exam() {
		 minutes = 75;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	   private int minutes;
	 }

而這個範例，則讓實例在初始化時便將 minutes 設值為75，
由於沒有 setMinutes 而 minutes 又是 private，
所以其他類別的程式碼將無法更動 minutes 的值。

.. code-block:: java

	 class Exam {
	   public Exam() {
		 minutes = 75;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	   protected int minutes;
	 }

這個範例則容許 Exam 的子類別及與 Exam 位於同樣 package 內的類別直接存取 minutes。

.. code-block:: java

	 class Exam {
	   public Exam() {
		 minutes = 75;
	   }
	   protected int getMinutes() {
		 return minutes;
	   }
	   protected void setMinutes(int m) {
		 minutes = m;
	   }
	   private int minutes;
	 }

而這個範例則只有 Exam 能直接存取 minutes，
同時也只有 Exam 的子類別及位於相同 package 中的類別能夠透過 getMinutes 及 setMinutes 間接的存取 minutes。

建構子之間的呼叫
--------------

如果在建構一個 EnglishExam 實例時要同時傳入四個參數值給 vocab, grammar, listen, minutes 四個實例變數，並將其初始化。而且也要能夠只傳入三個參數值給 vocab, grammar, listen，
那麼一種寫這些建構子的方式是：

.. code-block:: java

	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen;
	   public EnglishExam() {
		vocab = 6; grammar = 6; listen = 6;
	   }
	   public EnglishExam(int v, int g, int l) {
		 vocab = v; grammar = g; listen = l;
	   }
	   public EnglishExam(int v, int g, int l, int m) {
		 vocab = v; grammar = g;  listen = l;
		 minutes = m;
	   }
	   public int score() {
		 return vocab + grammar + listen;
	   }
	 }

這個寫法有一個缺點就是 ::

	vocab = v; grammar = g; listen = l;

出現兩次。避免這些重複程式碼的方法是使用 this(v, g, l) 去呼叫那個三個參數的建構子： ::

.. code-block:: java

	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen;
	   public EnglishExam() {
		 vocab = 6; grammar = 6; listen = 6;
	   }
	   public EnglishExam(int v, int g, int l) {
		 vocab = v; grammar = g; listen = l;
	   }
	   public EnglishExam(int v, int g, int l, int m) {
		 this(v, g, l);
		 minutes = m;
	   } 
	   public int score() {
		 return vocab + grammar + listen;
	   }
	 }    

在建構子中使用 this(...) 指的是呼叫另一個，在相同的類別中，參數的個數與型態皆相同的建構子。要注意的是在建構子中使用 this(...)，一定要寫在建構子的第一行。

另一種可能是當 EnglishExam 與 ChineseExam 都需要呼叫一個參數的建構子將 minutes 初始化。一種不好的寫法是：

.. code-block:: java

	class EnglishExam extends Exam {
	  // ...
	  public EnglishExam(int m) {
	    minutes = m;
	  }
	  // ...
	}
	class ChineseExam extends Exam {
	  // ...
	  public ChineseExam(int m) {
	    minutes = m;
	  }
	  // ...
	}

這時的 ::

	minutes = m;

也是同樣的重複在兩個類別中。改良的寫法是使用 super(m) 去呼叫定義在 Exam 類別內的一個參數的建構子：

.. code-block:: java

	 class Exam {
	   public int getMinutes() {
		 return minutes;
	   }
	   public Exam() {
		 minutes = 75;
	   }
	   public Exam(int m) {
		 minutes = m;
	   }
	   private int minutes;
	 }
	 class EnglishExam extends Exam {
	   ...
	   public EnglishExam(int m) {
		 super(m);
	   }
	   ...
	 }
	 class ChineseExam extends Exam {
	   ...
	   public ChineseExam(int m) {
		 super(m);
	   }
	   ...
	 }

實例方法間的呼叫
--------------

如果你需要擴充 Exam、EnglishExam 與 ChineseExam，使它們能夠產出一份，
包括考試時間、分數的考試資料。例如： ::

	Chinese exam score: 88 Exam time: 75 minutes
	English exam score: 76 Exam time: 60 minutes

第一種完成這個程式的寫法是為 EnglishExam 與 ChineseExam 都提供一個 report 方法：

.. code-block:: java

	 class Exam {
	   public int minutes;
	   Exam(int m) {
		 minutes = m;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	 }
	 
	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen;
	   EnglishExam(int v, int g, int l) {
		 super(60);
		 vocab = v;
		 grammar = g;
		 listen = l;
	   } 
	   public int score() {
		 return vocab + grammar + listen;
	   }
	   public void report() {
		 System.out.println("English exam score: " + score() + 
					" Exam time: " + getMinutes() + " minutes"); 
	   }
	 }
	 
	 class ChineseExam extends Exam{
	   public int word, sentence, composition;
	   ChineseExam(int w, int s, int c) {
		 super(75);
		 word = w;
		 sentence = s;
		 composition = c;
	   }
	   public int score() {
		 return word + sentence + composition;
	   }
	   public void report() {
		 System.out.println("Chinese exam score: " + score() + 
					" Exam time: " + getMinutes() + " minutes"); 
	   }
	 }
	 
	 public class Demo {
	   public static void main(String argv[]) {
		 ChineseExam cc = new ChineseExam(35, 35, 18);    
		 cc.report();
		 EnglishExam ee = new EnglishExam(30, 20, 26);
		 ee.report();
	   }
	 }

你也可以使用 this 來呼叫方法，所上例中的 report 可以改寫如下:

.. code-block:: java

	 public void report() {
	   System.out.println("English exam score: " + this.score() + 
			  " Exam time: " + this.getMinutes() + " minutes"); 
	 }

由於 getMinutes 方法是 Exam 提供給它的子類別的方法。
所以也可以用 super 來呼叫這個方法：

.. code-block:: java

	 public void report() {
	   System.out.println("English exam score: " + this.score() + 
			  " Exam time: " + super.getMinutes() + " minutes"); 
	 }

super 與 this 這兩個保留字，
同時用在建構子中與方法的呼叫，但是意義完全不同。
用於建構子中的呼叫時，super 與 this 是用來呼叫其他的建構子；
用於方法的呼叫時，super 是指呼叫自己或祖先中同名且參數一致的方法；
而 this 甚至有可能呼叫到子孫類別中同名且參數一致的方法。
由於 this 是在方法呼叫時才傳入的隱藏性參數，
指的是實例本身，並不一定是指 this 這個字所在的類別，
所以要看 this 呼叫時的實例為何，才能知道是那個方法被呼叫。

另一個寫這個程式的方式是將 report 拆開並分別放在父類別與子類別中：

.. code-block:: java

	 class Exam {
	   public int minutes;
	   Exam(int m) {
		 minutes = m;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	   public void report() {
		 System.out.println(" Exam time: " + this.getMinutes() + " minutes"); 
	   }
	 }
	 
	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen;
	   EnglishExam(int v, int g, int l) {
		 super(60);
		 vocab = v;
		 grammar = g;
		 listen = l;
	   } 
	   public int score() {
		 return vocab + grammar + listen;
	   }
	   public void report() {
		 System.out.println("English exam score: " + this.score());
		 super.report(); 
	   }
	 }
	 
	 class ChineseExam extends Exam{
	   public int word, sentence, composition;
	   ChineseExam(int w, int s, int c) {
		 super(75);
		 word = w;
		 sentence = s;
		 composition = c;
	   }
	   public int score() {
		 return word + sentence + composition;
	   }
	   public void report() {
		 System.out.println("Chinese exam score: " + this.score());
		 super.report();
	   }
	 } 
	 
	 public class Demo {
	   public static void main(String argv[]) {
		 ChineseExam cc = new ChineseExam(35, 35, 18);    
		 cc.report();
		 EnglishExam ee = new EnglishExam(30, 20, 26);
		 ee.report();
	   }
	 }

當使用 super 呼叫一個方法（report）時，
Java 會忽略定義在目前類別（EnglishExam 或 ChineseExam）的同名的 report 方法，
而會從目前類別的父類別（Exam）開始往上搜尋，
找到後，便呼叫那個方法。以上例而言，就是定義在 Exam 中的 report 方法。

抽象類別
-------

還有一個寫這個程式的方式是使用抽象類別（abstract class）。
抽象類別的功用是為它的子類別們提供共用的變數與方法。
在抽象類別中可以宣告抽象方法（abstract method），
抽象方法沒有程式碼的具體定義，它只有方法的名稱及型態的宣告。
在一個抽象類別中宣告一個抽象方法，
便必需要在這個抽象類別的直接子類別（direct subclass）定義與這個抽象方法同名、
同型態的方法，要不然會發生編譯錯誤。

如果要在 Exam 的子類別強迫定義 score 方法，
並且只用 Exam 的 report 印出 score、time 及 examName 的資料。
那麼這個程式可以改寫成以下這個沒有重複程式碼的版本：

.. code-block:: java

	 abstract class Exam {
	   private int minutes;
	   private String examName;
	   Exam(String n, int m) {
		 examName = n;
		 minutes = m;
	   }
	   public int getMinutes() {
		 return minutes;
	   }
	   public String getExamName() {
		 return examName;
	   }
	   public void report() {
		 System.out.println(this.getExamName() + "score: " +
		 this.score() + " Exam time: " + this.getMinutes() + " minutes"); 
	   }
	   abstract int score();
	 }
	 
	 class EnglishExam extends Exam {
	   public int vocab, grammar, listen;
	   EnglishExam(int v, int g, int l, String n) {
		 super(n, 60);
		 vocab = v;
		 grammar = g;
		 listen = l;
	   } 
	   public int score() {
		 return vocab + grammar + listen;
	   }
	 } 
	 
	 class ChineseExam extends Exam {
	   public int word, sentence, composition;
	   ChineseExam(int w, int s, int c, String n) {
		 super(n, 75);
		 word = w;
		 sentence = s;
		 composition = c;
	   }
	   public int score() {
		 return word + sentence + composition;
	   }
	 } 
	 
	 public class Demo {
	   public static void main(String argv[]) {
		 Exam ex;
		 ex = new ChineseExam(35, 35, 18, "Chinese exam");    
		 ex.report();
		 ex = new EnglishExam(30, 20, 26, "English exam");
		 ex.report();
	   }
	 }

在 Exam 類別內的 report 方法所用到的 this 可以有兩種可能的實例與之對應：
ChineseExam 的實例與 EnglishExam 的實例。
而呼叫在 main 中的 ex.report() 會繼續呼叫到 this.score()，
這時實際上被呼叫的 score 方法有兩種可能：

1. 呼叫到定義在 ChineseExam 中的 score，如果 ex 的值是一個 ChineseExam 的實例。
2. 呼叫到定義在 EnglishExam 中的 score，如果 ex 的值是一個 EnglishExam 的實例。

因此 this 的意義不是指出現 this 這個字的類別（Exam），
而是指用於呼叫方法（score）的實例，
這個實例就是 this。
以上例而言是 ex，而 ex 的值可以是一個 ChineseExam 的實例，
也可以是一個 EnglishExam 的實例，
而 ChineseExam 與 EnglishExam 都是 Exam 的子類別，
所以 this.score() 實際上 **可能呼叫到自己的子孫所定義的方法** 。

一個抽象類別的主要功用是為它的子類別提供共用的變數與方法。
抽象類別內可以宣告抽象方法。
但是抽象類別不能產生實例，所以以下的程式碼會產生編譯錯誤：

.. code-block:: java

	Exam ex = new Exam();    

抽象類別的抽象方法強制其直接子類別必須定義同名、同型態的實體方法，
而 Java 的編譯器可以檢查這個規定是否被達成，
因此可以減輕程式設計師自行檢查某個類別是否符合設計需求的負擔。

雖然抽象類別不能產生實例，但是卻可以用於宣告實例變數的型態。例如：

.. code-block:: java

	 public class Demo {
	   public static void main(String argv[]) {
		 Exam ex;
		 ex = new ChineseExam(35, 35, 18, "Chinese exam");    
		 ex.report();
		 ex = new EnglishExam(30, 20, 26, "English exam");
		 ex.report();
	   }
	 }

ex 這個變數的型態是 Exam，因為 ChineseExam 與 EnglishExam 都是一種 Exam，
所以 ex 可以儲存 ChineseExam 的實例，
也可以儲存 EnglishExam 的實例，
因為 ChineseExam 與 EnglishExam 不但是 Exam 的子類別，
也是 Exam 的 **子型態（subtype）** 。
這便是 ChineseExam 與 Exam 有 **is-a** 的關係，
也就是一個 ChineseExam 是一個（is-a）Exam；
而一個 EnglishExam 也是一個 Exam。

但是型態被宣告為 Exam 的變數，只能用於呼叫宣告在 Exam 內的方法。
假設 ChineseExam 內有一個 getWord 的方法，
但是在 Exam 中沒有這個方法，
那麼 ex.getWord() 將會產生編譯錯誤，
因為 ex 實例的型態沒有這個方法。

如果確實有需要呼叫 getWord 方法，則可使用轉型的方式進行呼叫。例如：

.. code-block:: java

	 public class Demo {
	   public static void main(String argv[]) {
		 Exam ex;
		 ex = new ChineseExam(35, 35, 18, "Chinese exam");    
		 System.out.println("Word score: " + (ChineseExam)ex.getWord();
	   }
	 }

抽象類別有一個特性，它不可能是在一個類別繼承結構的最下層。
如果需要，程式設計師可以宣告一個最下層的類別為 final，
一個 final 的類別不能被其他類別繼承。

物件導向程式的設計原則
-------------------

如同前面的範例所展示的，一個問題可能有好幾種不同的解法。
到底哪一種方法比較好？在什麼狀況用哪種解法呢？
以下是設計物件導向程式的幾個參考原則：

1. 類別的結構與實際一致。
2. 高層次的類別歸納一般化的屬性（general properties），例如：Exam或生物；而低層次類別的屬性則比較特殊化（specialize），例如：EnglishExam或人類。
3. 沒有重複的程式碼。
4. 直接存取常用的資訊，避免反覆的透過計算得到。
5. 將其他類別不需要用的或不需要知道的變數與方法以 private 或 protected 隱藏起來。
6. is-a 與 has-a 的適當設計：
   以前例而言，ChineseExam 與 EnglishExam 都是一種（is-a）Exam。
   所以這時將它們設計成父類別與子類別的關係便很正確。
   但是，一個考生（a Student）的資料卻不能因為所有的 Exam 都有考生，
   而將 Student 設計成 EnglishExam 與 ChineseExam 的父類別。
   然而，將 Student 設計成一個單一的類別，
   並在 Exam 中宣告一個能夠存放考生實例的實例變數，卻很恰當。
   因為一份考卷 has-a 考生。
   這種在類別中宣告實例變數，以儲存其他類別所產生的實例，
   稱為（ **has-a** ）的關係。

圖形與動畫的範例
--------------

到目前為止，我們已經闡述了四種呼叫 Java 方法的方式，這四種方式是：

1. 呼叫類別方法
2. 以實例來呼叫實例方法
3. 以 this 來呼叫實例方法
4. 以 super 來呼叫實例方法

在這四種方式中最單純的是呼叫類別方法，
因為呼叫一個類別方法可以藉由看靜態（static）的程式碼即可確定是哪一個類別方法被呼叫到。

以 super 來呼叫實例方法也很單純，
其判斷的方式是以程式碼的繼承關係來決定。
例如在 C 類別中呼叫 super.m() 則可以從 C 的父類別開始依序向上（祖先們）搜尋，
而搜尋到的第一個 m 即為被呼叫的方法。

「以實例來呼叫實例方法」及「以 this 來呼叫實例方法」則不能單單的看靜態的程式碼，
而必須要依照程式在動態執行時所使用的實例是哪一個類別的實例才能決定。
為了能明確說明，Java 決定哪一個實例方法被執行的的機制
（這個機制稱為動態搜尋或 dynamic lookup），
在這一節我們使用了幾個能夠動態顯現的圖形與動畫，
並將實例以一層包含一層的方式及將類別以樹狀階層圖的方式對照，
來明確的解說程式執行時的實例或 this 到底是哪一個類別的實例，以決定是那個方法被執行。

如果一個程式有以下幾個類別： ::

	Class A{}
	Class B extends A{}
	Class C extends A{}
	Class D extends B{}
	Class E extends B{}

那麼它們之間的繼承與所產生的實例有以下的關係。
其中繼承是以樹狀階層圖表示，而實例則以對應的多層次的同心圓來表示，
同心圓的最內層對應最 super 的類別，而同心圓的最外層則對應這個實例所屬的類別：

Image:inheritance.jpg

以下是另一個圖形與動畫的範例。
這個範例說明了父類別之物件不可以使用子類別之方法，
但子類別之物件可以使用父類別之方法。程式碼如下：

.. code-block:: java

	 class Make_counter {
		 int count;
		 void add1() {
			 count = count + 1;
		 }
		 void add3() {
			 add1();
			 add1();
			 add1();
		 }
		 int getCount() {
			 return count;
		 }
	 }
	 
	 class Make_counter2 extends Make_counter {
		 void add2() {
			 add1();
			 add1();
		 }
	 }
	 
	 public class Ex6 {
		 public static void main(String argv[]) {
			 Make_counter2 c2 = new Make_counter2();
			 c2.add2();
			 c2.add3();
			 System.out.println("count:" + c2.getCount());
			 Make_counter c1 = new Make_counter();
			 // c1.add2(); => error
		 }
	 }

執行結果： ::

	count:5

Media:Ex6.swf|觀看執行動畫

Super, this, abstract class的動畫範例
------------------------------------

以下的這個範例使用有層次的實例與動畫，說明this, super的特性:

.. code-block:: java

	 class Father {
		 String a = "father";
	 }
	 class Son extends Father {
		 String a = "son";
		 String get_null() {
			 return a;
		 }
		 String get_this() {
			 return this.a;
		 }
		 String get_super() {
			 return super.a;
		 }
	 }
	 public class Ex7 {
		 public static void main(String argv[]) {
			 Son s = new Son();
			 System.out.println("a:" + s.get_null());
			 System.out.println("this.a:" + s.get_this());
			 System.out.println("super.a:" + s.get_super());
		 } 
	 }

執行結果: ::

	a:son
	this.a:son
	super.a:father

這個範例中的 s 是一個 Son 的實例，而 Son 的父類別是 Father，
因此 s 實例有兩層，外層是宣告於 Son 中的實例變數與方法，
而內層是宣告於 Father 的實例變數與方法。
get_this 方法中的 this 即是 s；
而 get_super 中的 super 指的是 s 的內層相對於 Father 的部分。

Media:Ex7.swf|觀看執行動畫

以下這個範例說明類別間有同名而且型態也相同的方法（overwrite）的特性:

.. code-block:: java

	 class GrandParent {
		 String eyes() {
			 return "blue";
		 }
	 }
	 class Parent extends GrandParent {
		 String eyes() {
			 return "green";
		 }
	 }
	 public class Ex8 {
		 public static void main(String args[]) {
			 GrandParent gail = new GrandParent();
			 Parent sue = new Parent();
			 System.out.println("當子類別擁有與父類別同方法名稱時稱為overwrite");
			 System.out.println("gail.eyes():" + gail.eyes());
			 System.out.println("sue.eyes():" + sue.eyes());
		 }
	 }

執行結果:

	當子類別擁有與父類別同方法名稱時稱為overwrite
	gail.eyes():blue
	sue.eyes():green

GrandParent 由於沒有父類別（除了 Object 以外），
所以 gail 的實例只有一層；然而，sue 的實例卻有兩層，
外層對應 Parent，內層對應 GrandParent。

Media:Ex8.swf|觀看執行動畫

以下這個範例將透過宣告在數個不同類別的實例方法的呼叫，
更深入的闡釋 super 與 this 的特性:

.. code-block:: java

	 class A {
		 String color() {
			 return "blue";
		 }
		 String getColor() {
			 return this.color();
		 }
	 }
	 class B extends A {
		 String color() {
			 return "green";
		 }
		 String getColor1() {
			 return this.color();
		 }
		 String getColor2() {
			 return super.color();
		 }
	 }
	 class C extends B {
		 String color() {
			 return "red";
		 }
		 String getColor3() {
			 return this.color();
		 }
		 String getColor4() {
			 return super.color();
		 }
	 }
	 public class Ex10 {
		 public static void main(String args[]) {
			 A a = new A();
			 B b = new B();
			 C c = new C();
			 System.out.println("a.color():" + a.color());
			 System.out.println("a.getColor():" + a.getColor());
			 System.out.println("b.color():" + b.color());
			 System.out.println("b.getColor1():" + b.getColor1());
			 System.out.println("b.getColor2():" + b.getColor2());
			 System.out.println("c.color():" + c.color());
			 System.out.println("c.getColor():" + c.getColor());
			 System.out.println("c.getColor1():" + c.getColor1());
			 System.out.println("c.getColor2():" + c.getColor2());
			 System.out.println("c.getColor3():" + c.getColor3());
			 System.out.println("c.getColor4():" + c.getColor4());
		 }
	 }

執行結果: ::

	a.color():blue
	a.getColor():blue
	b.color():green
	b.getColor1():green
	b.getColor2():blue
	c.color():red
	c.getColor():red
	c.getColor1():red
	c.getColor2():blue
	c.getColor3():red
	c.getColor4():green

這個程式最讓人訝異的是呼叫 c.getColor() 的結果是 red。
因為 c.getColor 會呼叫宣告在 A 之內的 getColor；
而 getColor 內的 this 指的是 c，不是 A；而 c 的 getColor 會傳回 red。

Media:Ex10.swf|觀看執行動畫

以下的範例將使用「寵物(Pet)」類別及「狗(Dog)」及「貓(Cat)」兩個子類別。
狗及貓都擁有「聲音(sound)」這個方法，
但狗跟貓的叫聲卻是不同的，此時我們可以利用抽象類別來實作這個例子。

.. code-block:: java

	 abstract class Pet {
		 abstract String sound();
	 }
	 class Dog extends Pet {
		 String sound() {
			 return "汪汪";
		 }
	 }
	 class Cat extends Pet {
		 String sound() {
			 return "喵喵";
		 }
	 }
	 public class Ex11 {
		 public static void main(String args[]) {
			 Dog d = new Dog();
			 Cat c = new Cat();
			 System.out.println("d.sound():" + d.sound());
			 System.out.println("c.sound():" + c.sound());
		 }
	 }

執行結果: ::

	d.sound():汪汪
	c.sound():喵喵

上例中 d 與 c 兩個變數若宣告成 Pet 型態，則答案仍然會一樣。

Media:Ex11.swf|觀看執行動畫

以下這個範例是一個整合了 abstract class, super, this, array 的應用。
這個範例的特色是宣告了 Area 這個 abstract class 及 getArea 這個抽象方法，
讓 Square 及 Triangle 來繼承，
而 whichBig 這個方法則可以比較任何兩個 Area 實例
（Square 及 Triangle 的實例都是 Area 的實例），
何者的面積較大。此外，在 main 中的 a 陣列，
也可以存放任何的 Area 的實例，
因此 a 可以存放 Square 的實例，
也可以存放 Triangle 的實例：

.. code-block:: java

	 abstract class Area {
		 int high, weight;
		 Area(int a, int b) {
			 high = a;
			 weight = b;
		 }
		 abstract int getArea();
		 boolean whichBig(Area p) {
			 return (this.getArea() > p.getArea());
		 }
	 }
	 class Square extends Area {
		 Square(int a, int b) {
			 super(a, b);
		 }
		 int getArea() {
			 return high * weight;
		 }
	 }
	 class Triangle extends Area {
		 Triangle(int a, int b) {
			 super(a, b);
		 }
		 int getArea() {
			 return (high * weight) / 2;
		 }
	 }
	 public class Ex12 {
		 public static void main(String args[]) {
			 int total = 0;
			 Area[] a = { new Square(6, 6), new Triangle(10, 10) };
			 System.out.println("Is a[0] bigger than a[1]?" + a[0].whichBig(a[1]));
			 for (int i = 0; i &lt; a.length; i++) {
				 total = total + a[i].getArea();
			 }
			 System.out.println("total:" + total);
		 }
	 }

執行結果: ::

	Is a[0] bigger than a[1]?false
	total:86

Media:Ex13new.swf|觀看執行動畫及詳細解說
