package GoIt;

public class MyHashMap<K ,V> {

    private Node[]node;

    public MyHashMap(){
        node = new Node[16];
    }

    public V get(K key) {
        Node temp=node[hash(key)];
        while(true){
            if(temp==null){
                return null;
            }
            else if(temp.key==key) return (V)temp.value;
            temp=temp.next;
        }
    }

    public void put(K key, V value) {
        if(key==null)
            return;
        int myKey = hash(key);

        if(node[myKey]==null){
            node[myKey]=new Node(key,value,null);
            return;
        }
        Node temp = node[myKey];
        while(true) {
            if (temp == null) {
                temp=new Node(key,value,null);
                return;
            }
            else if (temp.key==key){
                temp.value=value;
                return;
            }
            else {
                temp = temp.next;
            }
        }
    }

    public V remove(K key){

        Node temp1=node[hash(key)];
        if(temp1!=null && temp1.key.equals(key)){
            V removedValue=(V)temp1.value;
            node[hash(key)]=temp1.next;
            return removedValue;
        }
        if(temp1==null){
            return null;
        }
        Node temp2=temp1.next;
        while(temp2!=null){
            if(temp2.key.equals(key)){
                V removedValue=(V)temp2.value;
                temp1.next=temp2.next;
                return removedValue;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
    public void print(){
        for(int i=0;i<16;i++){
            Node temp=node[i];
            while(temp!=null){
                System.out.println(temp);
                temp=temp.next;
            }
        }
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            return Math.abs(key.hashCode() % 16);
        }
    }

    public class Node<K,V>{
        public K key;
        public V value;
        Node next;
        public Node(){}
        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}