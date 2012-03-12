**************
例外狀態的處理
**************

一個程式在執行時，可能會有許多不正常或例外的狀態需要處理。
例如：網路突然斷線、插入了錯誤的光碟、使用 0 為除數或陣列的 index 值超出了範圍等等。
為了讓處理這些例外狀況的程式碼與主程式不混在一起，
Java 使用 了try、catch 將主程式與處理例外狀況的程式碼分開。

.. code-block:: java

	try { 
	  // ... 程式的主要邏輯在此，
	  // ... 執行時可能會產生IO Exception
	} catch (IOException e) { 
	  // 處理IO Exception的程式碼，例如：  
	  e.printStackTrace(); 
	  System.out.println(e);
	  // ...
	} 

為了能區分不同種類的 Exception，
Java 也將 Exception 以繼承的方式分類。
例如以下的三個 Exception 類別： ::

	Exception
	   |
	   V
	IOException
	   |
	   V
	FileNotFoundException

其中 Exception 涵蓋所有的 Exception，
而 FileNotFoundException 則指定 file not found 這種狀況。

try 之後，可以 catch 許多的例外。例如：

.. code-block:: java

	try {
	  // ... 
	  // ...
	} catch (FileNotFoundException e) {
	  System.out.println("檔案不存在");
	} catch (IOException e) {
	  System.out.println("發生輸出入錯誤");
	}

然而，catch 的出現的次序必須與各個 exception 類別的繼承次序配合。
繼承層次低的類別要先出現，繼承層次高的後出現。
例如：以下這個錯誤的寫法：

.. code-block:: java

	try {
	  // ...
	  // ...
	} catch (IOException e) {
	  System.out.println("發生輸出入錯誤");
	} catch (FileNotFoundException e) {
	  System.out.println("檔案不存在");
	}
	
	System.out.println("檔案不存在") 便不可能被執行到，因為 FileNotFoundException 也是 IOException 的一種。所以會先被IOException 抓到。

以下是一個讀取輸入資料檔的範例：

.. code-block:: java

	import java.io.*; 
	import java.util.*; 
	
	public class ReadFile {
	  public static void main(String args[]) {
		try {
		  FileInputStream stream = new FileInputStream("xx.part");
		  InputStreamReader reader = new InputStreamReader(stream);
		  BufferedReader breader = new BufferedReader(reader);
		  String record;
		  String nameString;
		  int grade;
		  while ((record = breader.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(record);
			nameString = tokens.nextToken();
			grade = Integer.parseInt(tokens.nextToken());
			System.out.println(nameString + "  " + grade);
		  }
		  stream.close();
		}
		catch (FileNotFoundException e) {
		  System.out.println(e);
		} catch (IOException e) {
		  System.out.println(e);
		}
	  }
	}

由以上的範例可以看出，\
``try`` 與 ``catch`` 之間是程式的正常邏輯。\
當在讀取檔案時發生例外時，\
程式的執行則自動的跳到 catch 中執行。\
至於是跳到那個 catch，\
則要看是 FileNotFoundException 還是其他的 IOException 而定。

以下則是一個將 while 放在 try、catch 之外，\
並且利用一個 tryAgain 的變數讓一個程式可以不斷的請使用者放入磁片，\
直到放正確才繼續處理的程式。

	import java.io.*;
	import java.util.*;
	
	public class ReadData {
	  public static void readFile(String fileName) {
	    boolean tryAgain = true;
	    while (tryAgain) {
	      try {
	        tryAgain = false;
	        //
	        // 讀檔成功之後的程式碼
	        //
	      }
	      catch (FileNotFoundException e) {
	        tryAgain = true;
	      }
	      catch (IOException e) { 
	        System.out.println(e); 
	      } 
	    } 
	  } 
	}

其他常見的 Exception 類別還有：\
ArrayIndexOutOfBoundsException, ArithmeticException 等。\
當 Exception 發生時，也可以使用 System.exit(0) 結束程式的執行。\
例如：

.. code-block:: java

	catch (IOException e) { 
	  System.exit(0); 
	}

除了 try, catch 外，finaly 子句是用來寫在例外或沒有例外發生時都需要執行的程式碼。\
其語法如下：

.. code-block:: java

	try {
	  // ...
	}
	catch (exception-class name e) {
	  // ...                      
	}
	finally {
	  // ...
	}

除了使用 Java 內建的數個 Exception 類別。\
程式設計師也可以依據程式的需要，\
自行定義 Exception 的子類別：

.. code-block:: java

	public class StrangeDataException extends Exception { 
	}

以上的 StrangeDataException 是一個 Exception 的子類別。\
定義好之後，便可以在 try 子句內使用 new 與 throw 來產生一個 exception:

.. code-block:: java

	try {
	  // ...
	  if (...) { // someting-wrong 
		throw (new StrangeDataException()) ;
	  } else {
		...  // 正常處理
	  }
	} 
	catch (StrangeDataException e) {  
	  // e 是一個 StrangeDataException 的物件
	  //
	  // 處理 StrangeDataException 發生時的程式碼
	  //
	}

以下這個範例則是在產生 StrangeDataException 物件時，\
透過有參數的 constructor 將例外處理時所需要的資料傳入的範例：

.. code-block:: java

	// ...
	public class StrangeDataException extends Exception {
	  // 某個類別 obj;
	  StrangeDataException(某個類別 o, ...) {
	    obj = o;
	  }
	  handleStrangeData（...）{
	    // ...
	  }
	}
	
	// ...
	
	try {
	  // ...
	  if (...) { // someting-wrong 
	    throw (new StrangeDataException(objx, ...)) ;
	  } else {
	    // ... 正常處理
	  }
	} 
	catch (StrangeDataException e) {  
	  // e 是一個StrangeDataException的物件
	  // ...
	  // 呼叫發生 StrangeDataException 的處理方法
	  e.handleStrangeData（...） 
	  // ...
	}
