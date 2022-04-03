public class MyList<T>{
    private Object[] myArray;
    private int listSize;
    private int capacity;


    public MyList(){
        this.capacity = 10;
        this.myArray = generateArray(capacity);
    }

     public MyList(int capacity){
        this.capacity = capacity;
        this.myArray = generateArray(capacity);
    }

    public Integer size(){
        int size = 0;
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] != null){
                size++;
            }
        }
        this.listSize = size;
        return listSize;
    }

    public Integer getCapacity(){
        return capacity;
    }

    public void add(T data){
        int size = size();
        if(!(capacity > size)) {
            this.capacity = getCapacity() * 2;
            this.myArray = copyToNewArray();
        }
        myArray[size] = data;

    }

    Object[] generateArray(Integer capacity){
       Object array[] = new Object[capacity];  
       return array;
    }

    Object[] copyToNewArray(){
        Object newArray[] = generateArray(capacity);

        for(int i = 0; i<listSize ;i++){
            newArray[i] = myArray[i];
        }
        return newArray;
    }

    Object get(int index){
        return myArray[index];
    }

    public void remove(int index){
        int arraySize = size();
        
        if(indisGecersiz(index)) return;

        for(int i=index; i<arraySize-1; i++){
            myArray[i] = myArray[i+1];
        }
        myArray[arraySize-1]= null;
    }

    private boolean indisGecersiz(int index){
        if(index >= size()){
            return true;
        }
        return false;
    }

    public void set(int index, T data){
        if(indisGecersiz(index)) return;
        myArray[index] = data;

    }


    public String toString() {
        String sonuc = "[";
        for (int i = 0;i<size(); i++) {
            sonuc += myArray[i].toString() + ',';
        }
        return sonuc + ']';
    }

    public int indexOf(T data){
        for(int i = 0;i < size();i++){
            if(myArray[i] == data) return i;
        }

        return -1;
    }

    public int lastIndexOf(T data){
        for(int i = size()-1;i >= 0 ;i--){
            if(myArray[i] == data) return i;
        }

        return -1;
    }
        
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public T[] toArray() {
        T[] newArray = (T[]) myArray;
        return newArray;
    }
    
    public void clear() {
        this.myArray = generateArray(capacity);
    }
    
    
    MyList<T> subList(int start,int finish){
        Object[] newArr = new Object[capacity];
        int end = finish;
        if(finish >size()) end=size();
        int a = 0;

        MyList<T> newList = new MyList<>();
        for(int i = start; i<end ;i++){
            newList.add((T)myArray[i]);
        }

        return newList;
    } 

    boolean contains(T data){
        for(int i = 0;i < size();i++){
            if(myArray[i] == data) return true;
        }
        return false;
    }
    
}