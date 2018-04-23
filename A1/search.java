//overloading binarySearch
public int binarySearch(int[] array, int toFind) {
  binarySearch(array, 0, array.length-1, toFind);
}

//recursive method for binary search
private int binarySearch(int[] array, int start, int end, int toFind) {
  int mid = (start+end)/2;
  if(array[mid] == toFind) {
    return mid;
  }
  else if(toFind > array[mid]) {
    return binarySearch(array, mid+1, end, toFind);
  }
  else {
    return binarySearch(array, start, mid-1, toFind);
  }
}

public void mergeSort(int[] array, int[] temp) {
  mergeSort(array, temp, 0, array.length);
}

private void mergeSort(int[] array, int[] temp, int start, int end) {
  int mid = (start+end)/2;
  mergeSort(array, temp, start, mid);
  mergeSort(array, temp, mid, end);
  merge(array, temp, start, mid, end);
}

private void merge(int[] array, int temp, int start, int mid, int end) {
  int b1 = start;
  int b2 = mid;
  int index = 0;

  while(b1 < mid && b2 < end) {
    if(array[b1] <= array[b2]) {
      temp[index] = array[b1];
      b1++;
    } else {
      temp[index] = array[b2];
      b2++;
    }
    index++;
  }

  /* Loop will terminate after completing these steps; but what if there are still more elements to sort?
  ** Need to determine which side still has elements and then move those elements into the temp array */

  if(b1 == mid){
    while(b2 < end) {
      temp[index] = array[b2];
      index++;
      b2++;
    }
  } else {
    while (b1 < mid) {
      temp[index] = array[b1];
      index++;
      b1++;
    }
  }
  // This if else is actually unneccessary because while loops check to see if they can run before they actually do run

  System.arraycopy(temp, 0, array, start, index);
  // index is the count of the values we put into the temp array (why we use index instead of end)
  // Will only use the full temporary array at the end because you're not filling in the whole thing until the very end
}
