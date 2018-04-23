public class StringArrayList {

  private String[] list;
  private int numberOfStrings;

  public int add(String s) {
    list[numberOfStrings] = s;
    numberOfStrings++;

    return numberOfStrings;
  }

  public String get(int i) {
    if (i < numberOfStrings) {
      return list[i];
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public boolean contains(String s) {
    boolean found = false;
    int index = 0;

    while (!found && (index < numberOfStrings)) {
      if (s.equals(list[index])) {
        found = true;
      }
      index++;
    }
    return found;
  }

  public int indexOf(String s) {
    for (int i = 0; i < numberOfStrings; i++) {
        if (list[i] == s) {
            return i;
        }
    }
    return -1;
  }

  public int size() {
    return numberOfStrings;
  }

  public int add(int index, String s) {
    for (int i = numberOfStrings; i > index; i--) {
      list[i] = list[i - 1];
    }
    list[index] = s;
    numberOfStrings++;

    return index;
  }

  public void clear() {
    numberOfStrings = 0;
  }


  public boolean isEmpty() {
    return numberOfStrings == 0;
  }

  public String remove(int i) {
    String result = null;
    if (!isEmpty() && (i >=0)) {
      result = list[i];
      list[i] = list[numberOfStrings - 1];

      list[numberOfStrings - 1] = null;
      numberOfStrings--;
    }
    return result;
  }

  public void set(int index, String s) {
    if (index < numberOfStrings) {
      list[index] = s;
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public String[] toArray() {
    @SuppressWarnings("Unchecked")
    String[] result = (String[]) new Object[numberOfStrings];

    for(int i = 0; i < numberOfStrings; i++) {
      result[i] = list[i+ 1];
    }

    return result;
  }
}
