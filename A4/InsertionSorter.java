public class InsertionSorter implements IntSorter {
  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;

  public void init(int[] a) { //initialize your class
    this.array = a;
    moves = 0;
  }

  public void sort() { //sort the values from init
    startTime = System.nanoTime();

    for(int i = 1; i < array.length; i++) {
      int k = i;

      while (k > 0 && array[k-1] > array[k]) {
        swap(array, k, k-1);
        k--;
      }
    }
    endTime = System.nanoTime();
  }

  private void swap(int[] values, int p1, int p2) {
    int temp = values[p1];
    values[p1] = values[p2];
    values[p2] = temp;
    moves++;
  }

  public long getSortTime() { //return ns taken to perform sorting
    return endTime - startTime;
  }

  public int getMoves() { //return number of moves taken
    return moves;
  }
}
