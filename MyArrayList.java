package GoIt;

public class MyArrayList  {
     String [] array = new String[10];


    public void  add (String value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                array[i] = value;
                break;
            }
        }
    }
    public void remove (int index) {
        for (int i = 0; i < array.length; i++) {
            if (index == i) {
                array[i] = null;
                int count = i;
                for (int j = 0; j < array.length - 1; j++) {
                    if (count + 1 < array.length) {
                        array[count] = array[count + 1];
                        count++;
                    }
                }
            }
        }
    }

    public void clear(){
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public int size(){
        return array.length;
    }

    public String get(int index){
        for (int i = 0; i < array.length; i++) {
            if (index == i){
                return array[i];
            }
        }
        return "Object not found!!!";
    }

    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Three");
        myArrayList.add("Four");
        myArrayList.add("Five");
        myArrayList.add("Six");

        myArrayList.remove(3);

        System.out.println("myArrayList.get(4) = " + myArrayList.get(4));

    }

}
