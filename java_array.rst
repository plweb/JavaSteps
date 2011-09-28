陣列
====

陣列（array）是一組有索引（index）的儲存值，這些儲存值稱為元素（element）。
一個陣列有一定的長度（length）以及一個型態（t）。陣列索引的範圍是從 0 到 length - 1。儲存在 array 中的值的型態必須是 t 或 t 的 subtype。subtype 的觀念與 subclass（子類別）有關，將在物件導向的單元中介紹。陣列內的儲存值可以是 primitive type 也可以是 reference type。在本節中我們只會以 primitive type 的儲存值當作範例。

例如： ::

    {| border="1" style="border-collapse;"
    !2.4
    !3.9
    !4.0
    !1.3
    |}

便是一個長度是 4，索引是 0 - 3 而型態是 double 的陣列。這個陣列可以由以下的程式碼得到： ::

     double[] aDoubleArray;  // 宣告 aDoubleArray 是一個 double array
     
     aDoubleArray = new double[4]; // 使用 new 挪出可以存放 4 個 double 的儲存區
     aDoubleArray[0] = 2.4;
     aDoubleArray[1] = 3.9;
     aDoubleArray[2] = 4.0;
     aDoubleArray[3] = 1.3;

以下是另一種寫法： ::

     double[] aDoubleArray = new double[4];
     
     aDoubleArray[0] = 2.4;
     aDoubleArray[1] = 3.9;
     aDoubleArray[2] = 4.0;
     aDoubleArray[3] = 1.3;

也可以直接初始化：

    double[] aDoubleArray = {2.4, 3.9, 4.0, 1.3};

而以下的程式碼可以印出其值：

.. code-block:: java

     for (int i = 0; i < aDoubleArray.length; i++)
         System.out.println(aDoubleArray[i]);

多維陣列
-------

多維陣列是一個陣列的元素本身也是陣列。例如以下這個二維陣列：

.. code-block:: java

    String[][] names = {{"Boy", "Girl", "Man"},
                     {"Woman", "Father", "Son"}};
    for (int i = 0; i < 2; i++)
     for (int j = 0; j < 3; j++)
         System.out.printf(names[i][j]);

的輸出結果是 ::

    Boy
    Girl
    Man
    Woman
    Father
    Son
