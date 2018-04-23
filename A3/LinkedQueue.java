public class LinkedQueue<T> implements Queue<T> {
  private Node head;
  private Node tail;
  private int size;

  private class Node {
    private T data;
    private Node next;
  }

  public LinkedQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  public T remove() {
    T item = head.data;
    head = head.next;
    size--;

    if (isEmpty()) {
      tail = null;
    }
    return item;
  }

  public T peek() {
    /*if (isEmpty())
      throw new NullPointerException();*/
    return head.data;
  }

  public void add(T thing) {
    Node oldTail = tail;
    tail = new Node();
    tail.data = thing;
    tail.next = null;

    if(isEmpty()) {
      head = tail;
    } else {
      oldTail.next = tail;
    }
    size++;
  }

  public boolean isEmpty() {
    return head == null;
  }
}
