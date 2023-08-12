import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {

    private Object[] myArray;
    private static final int INITITAL_CAPACITY = 10;
    private int size;


    public MyArrayList() {
        myArray = new Object[INITITAL_CAPACITY];
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
            throw new IndexOutOfBoundsException("Index out of bound exception");
        }
        return (E) myArray[index];
    }

    public void remove(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bound exception");
        }

        for (int i = index; i < size - 1; i++) {
            myArray[i] = myArray[i + 1];
        }
        size--;
        myArray[size] = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }
    public String toString() {
        StringBuilder elem = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            elem.append(myArray[i]);
            if(i==size-1)
                break;
            elem.append(", ");
        }
        elem.append("]");
        return elem.toString();

   }

    public boolean contains(E e){

      for(int i=0;i<size;i++){
         if(Objects.equals(myArray[i],e))
             return true;
      }
      return false;
    }

    public int index(E e){

        for(int i=0;i< size;i++){
            if(Objects.equals(myArray[i],e)){
                return i;
            }
        }
        return -1;
    }



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
      list.add("Jyothi");
      list.add("Manikandan");
      list.add("Amma");
      list.add("Sherlyn");
      list.add("Surian");
      list.add("KP");

      System.out.println(list);
      System.out.println(list.size());
      list.remove(0);
      System.out.println(list.get(9));
      System.out.println(list);
      System.out.println(list.size());
      System.out.println("Is list Empty? " + list.isEmpty());
      list.remove(9);
      System.out.println(list);
      System.out.println(list.contains("Amma"));
      System.out.println(list.contains("Achan"));
      System.out.println(list.contains(null));
      System.out.println(list.index("Sambhu"));
      System.out.println(list.index("Achan"));
      System.out.println(list.index("Amma"));
    }


}