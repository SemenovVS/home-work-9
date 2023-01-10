package GoIt;

public class MyQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public void add(int item) {
       if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }

        System.out.println("Create " + item);

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public int poll(){

        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        int x = arr[front];

        System.out.println("Removing " + x);

        front = (front + 1) % capacity;
        count--;

        return x;
    }

     MyQueue(int size){
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public int peek(){
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }


    public int size() {
        return count;
    }


    public boolean isEmpty() {
        return (size() == 0);
    }


    public boolean isFull() {
        return (size() == capacity);
    }
}
class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);

        q.add(88);
        q.add(45);
        q.add(6548);

        System.out.println("The FIFO element is " + q.peek());
        q.poll();
        System.out.println("The front element is " + q.peek());

        System.out.println("The queue size is " + q.size());

        q.poll();
        q.poll();
        System.out.println("The queue size is " + q.size());

    }
}
