package algobootcamp.arrays;

public class DynamicArray<String> {

    private Object[] data;
    private int size;
    private int initialCapacity;


    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }


    //O(n)
    public String get(int index) {
        return (String) data[index];
    }

    //O(n)
    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {
        //check size
        if (size == initialCapacity) {
            resize();
        }

        //copy up
        for (int j = size; j > index; j--) {
            data[j] = data[j - 1];
        }
        //do insert
        data[index] = value;
        size++;
    }


    public void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        initialCapacity = initialCapacity * 2;
    }


    public void delete(int index) throws Exception {
        if (index > initialCapacity) throw new Exception("Index out of range!");


        //!from book
        for (int i = index; i <size-1; i++) {
            data[i] = data[i + 1];
        }


     /*   for (int i = initialCapacity; i > index; i--) {
            data[i] = data[i - 1];
        }*/
        size--;
    }


    public boolean Contains(String value) {

        for (int i = 0; i < size - 1; i++) {
            if (data[i].equals(value)) return true;
        }
        return false;
    }


    public void add(String value) {
        if (size == initialCapacity) {
            resize();
        }

        data[size] = value;
        size++;
    }



    public void print(){
        for (int i = 0; i < size - 1; i++) {
           System.out.println("data[i] = " + data[i]);
        }

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }
}
