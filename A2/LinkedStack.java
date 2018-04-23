public class LinkedStack<T> implements Stack<T> {
  private Node head;

  private class Node {
    private T data;
    private Node next;
    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public T pop() {
    T top = peek();
    head = head.next;
    return top;
  }

  public T peek()  {
    return head.data;
  }

  public void push(T thing) {
    head = new Node(thing, head);
  }

  public boolean isEmpty() {
    return head == null;
  }    
}
