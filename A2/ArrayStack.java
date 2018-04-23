import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
  private T[] stack;
  private int topIndex;
  private static final int DEF_CAP = 100;

  public ArrayStack() {
    this(DEF_CAP);
  }

  @SuppressWarnings("unchecked")
  public ArrayStack(int capacity) {
    stack = (T[]) new Object[capacity];
    topIndex = -1;
  }

  public T pop() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    T result = stack[topIndex];
    stack[topIndex] = null;
    topIndex--;
    return result;
  }

  public T peek() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack[topIndex];
  }

  public void push(T thing) {
    if (stack.length == topIndex + 1) {
	    stack = java.util.Arrays.copyOf(stack, stack.length * 2);
	   }
     topIndex++;
     stack[topIndex] = thing;
  }

  public boolean isEmpty() {
    return (topIndex == -1);
  }
}
