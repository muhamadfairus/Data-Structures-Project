public class Stack<T> {
  Node<T> top;

  public Stack() {
    this.top = null;
  }

  public void push(T data) {
    Node<T> newNode = new Node<>(data);
    newNode.setNext(top);
    top = newNode;
  }

  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    T data = top.getData();
    top = top.getNext();
    return data;
  }

  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty");
    }
    return top.getData();
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void display() {
    Node<T> current = top;
    while (current != null) {
      System.out.print(current.getData() + " ");
      current = current.getNext();
    }
    System.out.println();
  }
}