public class MergeSorter implements IntSorter { // double check if moves is in the right place???
  private int[] array = null;
  private int[] temp = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;
  private int length;

  public void init(int[] a) { //initialize your class
    this.array = a;
    this.length = a.length;
    this.temp = new int[length];
    moves = 0;
  }

  public void sort() { //sort the values from init
    startTime = System.nanoTime();
    mergeSort(0, length-1);
    endTime = System.nanoTime();
  }

  private void mergeSort(int start, int end) {
    if (start < end) {
      int mid = start + (end - start)/2;
      mergeSort(start, mid);
      mergeSort(mid+1, end);
      merge(start, mid, end);
    }
  }

  private void merge(int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      temp[i] = array[i];
    }
    int a = start;
    int b = mid+1;
    int c = start;

    while (a <= mid && b <= end) {
      if(temp[a] <= temp[b]) {
        array[c] = temp[a];
        a++;
        moves++;
      } else {
        array[c] = temp[b];
        b++;
        moves++;
      }
      c++;
    }

    while (a <= mid) {
      array[c] = temp[a];
      c++;
      a++;
      moves++;
    }
  }

  public long getSortTime() { //return ns taken to perform sorting
    return endTime - startTime;
  }

  public int getMoves() { //return number of moves taken
    return moves;
  }
}
