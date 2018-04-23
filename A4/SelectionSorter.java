public class SelectionSorter implements IntSorter {
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
    for(int i = 0; i < array.length-1; i++) {
      int smallest = i;

      for(int k = i+1; k < array.length; k++) {
        if(array[k] < array[smallest]) {
          smallest = k;
        }
    }
    int temp = array[smallest];
    array[smallest] = array[i];
    array[i]= temp;
    moves++;
    }
    endTime = System.nanoTime();
  }

  public long getSortTime() { //return ns taken to perform sorting
    return endTime - startTime;
  }

  public int getMoves() { //return number of moves taken
    return moves;
  }
}
