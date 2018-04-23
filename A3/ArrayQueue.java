import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {

  private T[] queue;
  private int head;
  private int tail;
  private static final int DEF_CAP = 100;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayQueue() {
    head = 0;
    tail = 0;
    size = 0;
    queue = (T[]) new Object[DEF_CAP];
  }

  @SuppressWarnings("unchecked")
  public ArrayQueue(int initialCapacity) {
    head = 0;
    tail = 0;
    size = 0;
    queue = (T[]) new Object[initialCapacity];
  }

  public T remove() {
    if(isEmpty()) {
      throw new NullPointerException();
    } else {
      T front = queue[head];
      queue[head] = null;
      head = (head+1) % queue.length;
      size--;
      return front;
    }
  }

  public T peek() {
    if(isEmpty()) {
      throw new NullPointerException();
    } else {
      return queue[head];
    }
  }

  public void add(T thing) {
    if (size == queue.length) {
      resizeArray();
    }
      queue[tail] = thing;
      tail = (tail + 1) % queue.length;
      size++;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  public void resizeArray() {
    T[] newQueue = Arrays.copyOf(queue, queue.length*2);
    tail = queue.length;
    head = 0;
    queue = newQueue;
  }
}
