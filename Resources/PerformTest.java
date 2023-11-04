import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class PerformTest implements CollectionTest{
    
    //variables
    private int collectionSize;
    private int sum;
    private int searchedValue;
    private Person searchedResult;
    
    //Creating an array list
    private ArrayList<Person> arrayList = new ArrayList<Person>(collectionSize);

    //Creating a linked list
    private LinkedList<Person> linkedList = new LinkedList<Person>();

    //Creating a hashmap
    private HashMap<Integer,Person> hashMap = new HashMap<Integer,Person>();    
    
    
    //setSize method
    public void setSize(int size){
        collectionSize = size;
    }

    //ADD TEST TYPE
    public void add(CollectionType type, TestType test, int index){

        //Array List ADD
        if (type == CollectionType.ARRAY_LIST){
            if (test == TestType.ADD){
                for (int i = 0; i < collectionSize; i++){
                    Person p = new Person("person" + i, 19);
                    arrayList.add(p);
                }
            }
        //Linked list ADD
        } else if (type == CollectionType.LINKED_LIST){
            if (test == TestType.ADD){
                for (int i = 0; i < collectionSize; i++){
                    Person p = new Person("person"+i,19);
                    linkedList.add(p);
                }
            }
        //Hash map ADD
        } else if (type == CollectionType.HASH_MAP){
            if (test == TestType.ADD){
                for (int i = 0; i < collectionSize; i++){
                    Person p = new Person("person"+i,19);
                    hashMap.put(p.hashCode(), p);
                }
            } 
        }
    }


    //INDEX TEST TYPE
    public Person index(CollectionType type, TestType test, int index){
        if (type == CollectionType.ARRAY_LIST){
            if (test == TestType.INDEX){
                for (int i = 0; i < collectionSize; i++){
                    searchedResult =  arrayList.get(index);
                }
            }
        } else if (type == CollectionType.LINKED_LIST){
            if (test == TestType.INDEX){
                for (int i = 0; i < collectionSize; i++){
                    searchedResult =  linkedList.get(index);
                }
            }
        } else if (type == CollectionType.HASH_MAP){

        }

        return searchedResult;
    }

}
