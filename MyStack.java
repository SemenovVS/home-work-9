package GoIt;

public class MyStack {
    private int arr[];
    private int top;
    private int capacity;

    MyStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
        System.out.println("Create " + x);
        arr[++top] = x;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        System.out.println("Removing " + peek());
        return arr[top--];
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
        return -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void clear() {
        for (int i = 0; i <arr.length; i++) {
            int i1 = arr[top--];
            i1 = arr[i];
        }
    }

}


class Main1 {
    public static void main(String[] args) {
        MyStack stack = new MyStack(3);

        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        stack.push(3);

        System.out.println("The top element is " + stack.peek());


        stack.push(1);
        stack.push(2);
        System.out.println("The stack size is " + stack.size());
        stack.clear();
        System.out.println(stack.size());

    }
}