package GoIt;



public class MyLinkedList <E>{

    public static void main(String[] args) {
MyLinkedList list = new MyLinkedList();
        list.add("Vova");
        System.out.println(list.add("hi"));
        System.out.println(list.add(125));
        System.out.println(list.add("Vova"));
        System.out.println(list.size);
        System.out.println(list.get(2));
        list.clear();
        System.out.println(list.size);
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    E unlink(Node<E> x) {

        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        modCount++;
        return element;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;
    protected transient int modCount = 0;
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}