實例的產生與封裝
==============

在前面的章節中，我們曾經使用 new 來產生一個 EnglishExam 的實例，
然後個別的將這個實例的實例變數初始化。例如：

.. code-block:: java

	EnglishExam ee = new EnglishExam();
	ee.vocab = 3;
	ee.grammar = 4;
	ee.listen = 5;

另一個達到同樣目的的方式是在類別內直接的初始化實例變數的值。例如：

.. code-block:: java

	class EnglishExam {
	  public int vocab = 6,
	    grammar = 7,
	    listen = 8;
	  public int score() {
	    return vocab + grammar + listen;
	  }
	}

如果一個實例變數沒有初始化，那麼它的值是便會根據它的型態，
而設定成該型態的 default value。

Java 也支援使用一個類別的 **constructor（建構子）** 將實例變數的值初始化。
建構子與 class 同名，並且不需要定義 return type。
呼叫建構子之後會製造一個物件並將那個物件回傳。例如：

.. code-block:: java

	class EnglishExam {
	  public int vocab, grammar, listen;
	  EnglishExam() {
	    vocab = 6;
	    grammar = 7;
	    listen = 8;
	  }
	  public int score() {
	    return vocab + grammar + listen;
	  }
	}
	
	public class Exem {
	  public static void main(String args[]) {
	    EnglishExam ee = new EnglishExam();
	    System.out.println("The score of the exam is: " + ee.score());
	  }
	}

執行結果: ::

	The score of the exam is: 21

建構子也可以使用傳入的參數，將實例變數的值初始化。例如：

.. code-block:: java

	class EnglishExam {
	  public int vocab, grammar, listen;
	  EnglishExam() {
	    vocab = 6; grammar = 7; listen = 8;
	  }
	  EnglishExam(int v, int g, int l) {
	    vocab = v; grammar = g; listen = l;
	  }
	  public int score() {
	    return vocab + grammar + listen;
	  }
	}
	
	public class Exam {
	  public static void main(String args[]) {
	    EnglishExam ee = new EnglishExam();
	    System.out.println("The score of the first exam is: " + ee.score());
	    ee = new EnglishExam(7, 8, 9);
	    System.out.println("The score of the second exam is: " + ee.score());
	  }
	}

這時的執行結果是:

The score of the first exam is: 21
The score of the second exam is: 24

以上的程式有一個沒有參數的建構子，及一個三個參數的建構子。
如果一個類別內沒有定義建構子，那麼 Java 會自動提供一個沒有參數的建構子給這個類別。

Media:Ex9.swf|觀看一個建構子範例的執行與解說

Getter, Setter 及 Data Abstraction
----------------------------------

假設有一個 Exam 類別，
而這個類別有一個 minute 的實例變數，
而 e 則是一個 Exam 的實例。
那麼使用 e.minute 便可以直接的取用它的值，
然而 minute 卻必須宣告成 public。
另一個存取實例變數的方式是使用 getter 及 setter 方法，
這時程式設計師可以將 minute 宣告成 private，
並選擇性的將 getter 及 setter 設定成所需要的存取權限。
例如：

.. code-block:: java

	public class Exam {
	  private int minutes;
	  public Exam() {
	    minutes = 80;
	  }
	  public int getMinutes() {
	    return minutes;
	  }
	}

這時在其他的類別中若有一個 Exam 的實例 e，
便可以使用 getMinutes 取出 e.minutes 的值： ::

	e.getMinutes()

使用 getter 方法的好處之一是，
能夠很容易的在取用實例變數的值時，
增加協助偵錯的程式碼：

.. code-block:: java

	public class Exam {
	  private int minutes;
	  public Exam() {
	    minutes = 80;
	  }
	  public int getMinutes() {
	    System.out.println("Accessing minutes...");
	    return minutes;
	  }
	}

setter 方法的作用也類似：

.. code-block:: java

	public class Exam {
	  private int minutes;
	    public Exam() {
	    minutes = 80;
	  }
	  public int getMinutes() {
	    return minutes;
	  }
	  public void setMinutes(int m) {
	    System.out.println("Setting minutes...");
	    minutes = m;
	  }
	}

然而 setter 方法不需要傳回值。因此 setMinutes 的傳回值的型態是void。

getter 與 setter 方法的另一個功用是，模擬不必真實的存在，
但是卻可以透過運算而得到的實例變數。例如：

.. code-block:: java

	public class Exam {
	  private int minutes;
	  public Exam() {
	    minutes = 80;
	  }
	  public int getMinutes() {
	    return minutes;
	  }
	  public void setMinutes(int m) {
	    minutes = m;
	  }
	  public int getHours() {
	    return minutes/ 60.0
	  }
	  public void setHours(double h) {
	    minutes = (int)(h * 60);
	  }
	}

使用以上的 getHours 及 setHours 使得 Exam 好像多了 hours 
這個其實並不存在的實例變數一般。

使用 getter 及 setter 方法，
可以在改變實例內資料的儲存方式後，
不用修改其他使用此資料的程式碼，
讓程式易於維護。
例如：hours 比 minutes 更常用時，
便可以將上面的範例，
更改成以 hours 來儲存，
以增加程式的效率：

.. code-block:: java

	public class Exam {
	  private double hours;
	  public Exam() {
	    hours = 1.5;
	  }
	  public int getMinutes() {
	    return (int)(hours * 60);
	  }
	  public void setMinutes(int m) {
	    hours = m / 60.0;
	  }
	  public double getHours() {
	    return hours;
	  }
	  public void setHours(double h) {
	    hours = h;
	  }
	}

這時程式碼雖然做了更改，但是並不影響程式的其他部份。
如果沒有使用 getter 與 setter，類似的更動，
便需要將程式碼中所有存取 minutes 的地方全部做修改。例如： ::

	x.minutes           需要更改成     (int)(x.hours * 60)
	(x.minutes / 60.0)  則需要更改成   x.hours

使用 getter 及 setter 方法，
間接的存取實例變數的程式設計方式稱為「資料抽象化」(data abstraction)。
應用資料抽象化的方式寫程式，有以下的好處：

1. 程式碼容易再利用
2. 程式碼容易瞭解
3. 易於增加類別的功能
4. 易於改進資料的儲存方式
