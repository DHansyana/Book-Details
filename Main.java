package BookDetails;

public class Main {
    public static void main(String[] args){
        List l1 = new List(15);

        l1.InsertLast(new Book("B001","Data Structures        ","S.Tanenbaum     ",2018));
        l1.InsertLast(new Book("B002","Operating Systems      ","A.Silberschatz  ",2020));
        l1.InsertLast(new Book("B003","Computer Networks      ","A.S.Tanenbaum   ",2017));
        l1.InsertLast(new Book("B004","Java Programming       ","H.Schildt       ",2021));
        l1.InsertLast(new Book("B005","Python Crash Course    ","E.Matthes       ",2019));
        l1.InsertLast(new Book("B006","Database Management    ","R.Elmasri       ",2016));
        l1.InsertLast(new Book("B007","Discrete Mathematics   ","K.Rosen         ",2015));
        l1.InsertLast(new Book("B008","Artificial Intelligence","S.Russell       ",2022));
        l1.InsertLast(new Book("B009","Software Engineering   ","I.Sommerville   ",2018));
        l1.InsertLast(new Book("B010","Machine Learning       ","T.Mitchell      ",2021));

        System.out.println();
        System.out.println("-------------Book Details-------------");
        l1.TraversalList();

        System.out.println();
        l1.DeleteList(6);
        System.out.println("------------Final Table------------");
        l1.TraversalList();


        System.out.println();
        l1.ReplaceList(l1.SequentialSearch("B003"),new Book("B003","Computer Networks      ","A.S.Tanenbaum   ",2011));
        l1.ReplaceList(l1.SequentialSearch("B009"),new Book("B009","Software Engineering   ","I.Sommerville   ",2020));
        System.out.println("---------------Updated List---------------");
        Book b1 = l1.RetrieveList(2);
        System.out.println(b1.BookID + " | " + b1.Title + "  " + b1.Author + " | " + b1.Year);
        Book b2 = l1.RetrieveList(7);
        System.out.println(b2.BookID + " | " + b2.Title + "  " + b2.Author + " | " + b2.Year);

        System.out.println();
        l1.InsertionSort();
        System.out.println("------------Insertion Sort------------");
        l1.TraversalReverseList();

        System.out.println();
        l1.SelectionSort();
        System.out.println("------------Selection Sort------------");
        l1.TraversalReverseList();

        System.out.println();
        l1.BubbleSort();
        System.out.println("------------Bubble Sort------------");
        l1.TraversalReverseList();

        System.out.println();
        l1.HeapSort();
        System.out.println("------------Heap Sort------------");
        l1.TraversalReverseList();

        System.out.println();
        Book b3 = l1.SequentialSearch2("E.Matthes       ");
        System.out.println(b3.BookID + " | " + b3.Title + " | " + b3.Author + " | " + b3.Year);

        System.out.println();
        l1.BubbleSort2();
        System.out.println("---------Sorted List by Author---------");
        l1.TraversalList();

        System.out.println();
        Book b4 = l1.binarySearch2("I.Sommerville   ");
        System.out.println(b4.BookID + " | " + b4.Title + " | " + b4.Author + " | " + b4.Year);
    }
}
