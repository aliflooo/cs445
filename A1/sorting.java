private void swap(int[] array, int p1, int p2) {
  int temp = array[p1];
  array[p1] = array[p2];
  array[p2] = temp;
}

public void bubbleSort(int[] array) {
  boolean done = false;

  while(!done) {
    done = true;
    for(int i = 0; i < array.length-1; i++) {
      if(array[i] > array[i+1]) {
        done = false;
        swap(array, i, i+1);
      }
    }
  }
}

public void selectionSort(int[] array) {
  for(int i = 0; i < array.length-1; i++) { //logically, the last item will be in the right place
    int smallest = i; //using smallest as an index, not a value

    for(int k = i+1; k < array.length; k++) {
      if(array[k] < array[smallest]) { //known as a min function
        smallest = k;
      }
    }
    swap(array, i, smallest);
  }
}

public void insertionSort(int[] array) {
  for(int i = 1; i < array.length; i++) { //starts at 1 because we know subelement of first array is already sorted
    int k = i;

    while(k > 0 && array[k-1] > array[k]) {
      swap(array, k, k-1);
      k--;
    }
  }
}
