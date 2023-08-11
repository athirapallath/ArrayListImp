import com.sun.tools.javac.Main;

import java.util.Arrays;

public class MyArrayList<E> {

    private Object[] myArray;
    private static final int INTITAL_CAPACITY = 10;
    private int size;


    public MyArrayList() {
        myArray = new Object[INTITAL_CAPACITY];
    }

    public void add(E e) {
        if (size == myArray.length) {
            ensureCapacity();
        }
        myArray[size++] = e;
    }

    private void ensureCapacity() {
        int oldCapacity = myArray.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        myArray = Arrays.copyOf(myArray, newCapacity);
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Index out of bound exception");
        }
        return (E) myArray[index];
    }

    public void remove(int index) {

        if (index >= size || index < 0) {
            throw new RuntimeException("Index out of bound exception");
        }

        for (int i = index; i < size - 1; i++) {
            myArray[i] = myArray[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }
    public String toString() {
       String elem = "[";
        for (int i = 0; i < size; i++) {
            elem += myArray[i];
            if(i==size-1)
                break;
            elem+= ", ";
        }
     return elem + "]";

    }

//    public boolean contains(E e){
//
//      for(Object i: myArray){
//          if(i==e){
//
//                }
//      }
//    }


}

class testArrayList{

  public static void main(String args[]){

      MyArrayList<String> list = new MyArrayList<>();
      System.out.println("Is list Empty? "+ list.isEmpty());
      list.add("Athira");
      list.add("Sambhu");
      list.add("Anju");
      list.add("Ishaan");
      list.add("Rithu");

      System.out.println(list);
      list.add("Varsha");
      list.add("Sountharya");
      list.add("Jephin");
      list.add("Sherlyn");
      list.add("Surian");
      list.add("KP");

      System.out.println(list);
      System.out.println(list.size());
      list.remove(5);
      System.out.println(list);
      System.out.println(list.size());
      System.out.println("Is list Empty? " + list.isEmpty());
      list.remove(8);
      System.out.println(list);
    }


}