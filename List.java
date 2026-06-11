package BookDetails;

public class List {
    private int maxSize;
    private int position;
    private Book[] ListEntry;

    List(int size) {
        maxSize = size;
        ListEntry = new Book[maxSize];
        position = -1;
    }

    boolean IsListEmpty() {
        return (position == -1);
    }

    boolean IsListFull() {
        return (position == maxSize - 1);
    }

    int ListSize() {
        return (position + 1);
    }

    void InsertLast(Book element) {
        if (IsListFull()) {
            System.out.println("Attempt to insert at the end of a full list.");
        } else {
            ListEntry[++position] = element;
        }
    }

    void InsertList(int p, Book element) {
        if (IsListFull()) {
            System.out.println("Attempt to insert an element into a full list.");
        } else if (p < 0 || p > ListSize()) {
            System.out.println("Attempt to insert a position not in the list.");
        } else {
            for (int i = ListSize(); i > p; i--) {
                ListEntry[i] = ListEntry[i - 1];
            }
            ListEntry[p] = element;
            position++;
        }
    }

    Book RetrieveList(int p) {
        Book element;
        if (IsListEmpty()) {
            System.out.println("Attempt to retrieve an element from an empty list.");
        } else if (p < 0 || p >= ListSize()) {
            System.out.println("Attempt to retrieve a position not in the list.");
        } else {
            element = ListEntry[p];
            return element;
        }
        return null;
    }

    Book DeleteList(int p) {
        Book element;
        if (IsListEmpty()) {
            System.out.println("Attempt to delete an entry from an empty list.");
        } else if (p < 0 || p >= ListSize()) {
            System.out.println("Attempt to delete a position not in the list.");
        } else {
            element = ListEntry[p];
            for (int i = p; i < ListSize() - 1; i++) {
                ListEntry[i] = ListEntry[i + 1];
            }
            position--;
            return element;
        }
        return null;
    }

    void TraversalList() {
        for (int i = 0; i < position + 1; i++) {
            System.out.println(ListEntry[i].BookID + " | " + ListEntry[i].Title + "  " + ListEntry[i].Author + " | " + ListEntry[i].Year);
        }
    }

    void ReplaceList(int p, Book element) {
        if (IsListEmpty()) {
            System.out.println("Attempt to replace an entry from an empty list.");
        } else if (p < 0 || p >= ListSize()) {
            System.out.println("Attempt to replace a position not in the list.");
        } else {
            ListEntry[p] = element;
        }
    }



    int SequentialSearch(String key) {
        for (int i = 0; i < ListSize(); i++) {
            if (ListEntry[i].BookID.equals(key))
                return i;
        }
        return -1;
    }

    void InsertionSort() {
        for (int i = 1; i < ListSize(); i++) {
            Book key = ListEntry[i];
            int j = i - 1;

            while (j >= 0 && ListEntry[j].Year > key.Year) {
                ListEntry[j + 1] = ListEntry[j];
                j--;
            }
            ListEntry[j + 1] = key;
        }
    }

    void SelectionSort(){
        for(int i = ListSize()-1 ; i >= 0 ; i--){
            int maxIndex = getMaxIndex(i);
            Book temp = ListEntry[maxIndex];
            ListEntry[maxIndex] = ListEntry[i];
            ListEntry[i] = temp;
        }
    }
    int getMaxIndex(int maxIndex){
        int Index = maxIndex;
        for(int i = maxIndex-1 ; i >= 0 ; i--){
            if(ListEntry[Index].Year < ListEntry[i].Year)
                Index = i;
        }
        return Index;
    }

    void BubbleSort(){
        int n = ListSize();
        Book temp = null;
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < n-i ; j++){
                if(ListEntry[j-1].Year > ListEntry[j].Year){
                    temp = ListEntry[j-1];
                    ListEntry[j-1] = ListEntry[j];
                    ListEntry[j] = temp;
                }
            }
        }
    }

    void HeapSort(){
        int n = ListSize();
        for(int i = n/2 -1 ; i >= 0 ; i--){
            InsertHeap(n,i);
        }
        for(int i = n-1 ; i >= 0 ; i--){
            Book temp = ListEntry[0];
            ListEntry[0] = ListEntry[i];
            ListEntry[i] = temp;
            InsertHeap(i,0);
        }
    }
    void InsertHeap(int n,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && ListEntry[left].Year > ListEntry[largest].Year)
            largest = left;
        if(right < n && ListEntry[right].Year > ListEntry[largest].Year)
            largest = right;
        if(largest != i){
            Book temp = ListEntry[i];
            ListEntry[i] = ListEntry[largest];
            ListEntry[largest] = temp;
            InsertHeap(n,largest);
        }
    }

    Book SequentialSearch2(String key) {
        for (int i = 0; i < ListSize(); i++) {
            if (ListEntry[i].Author.equals(key))
                return ListEntry[i];
        }
        return null;
    }

    int binarySearch(int key){
        int low = 0;
        int high = ListSize()-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(ListEntry[mid].Year < key){
                low = mid + 1;
            } else if(ListEntry[mid].Year > key){
                high = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    void BubbleSort2(){
        int n = ListSize();
        Book temp = null;
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < n-i ; j++){
                if(ListEntry[j-1].Author.compareTo((ListEntry[j].Author)) > 0){
                    temp = ListEntry[j-1];
                    ListEntry[j-1] = ListEntry[j];
                    ListEntry[j] = temp;
                }
            }
        }
    }

    Book binarySearch2(String key){
        int low = 0;
        int high = ListSize()-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(ListEntry[mid].Author.compareTo(key) > 0){
                low = mid + 1;
            } else if(ListEntry[mid].Author.compareTo(key) > 0){
                high = mid -1;
            } else {
                return ListEntry[mid];
            }
        }
        return null;
    }

    void TraversalReverseList(){
        for (int i = position ; i >= 0 ; i--) {
            System.out.println(ListEntry[i].BookID + " | " + ListEntry[i].Title + "  " + ListEntry[i].Author + " | " + ListEntry[i].Year);
        }
    }
}
