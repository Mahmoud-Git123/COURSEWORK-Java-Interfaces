import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PerformTest implements CollectionTest{
    //variables
    private int collectionSize;

    private ArrayList <Person> actualArray;
    private LinkedList <Person> actualLinked;
    private HashMap <Integer, Person> actualHash;

    //constructor with no parameters
    public PerformTest(){
        actualArray = new ArrayList<>();
        actualLinked = new LinkedList<>();
        actualHash = new HashMap<>();
    }
    
    //setSize method
    public void setSize(int size){
        collectionSize = size;
    }

    //ADD TEST TYPE
    public void runTest(CollectionType type, TestType test, int iterations){

        for (int i = 0; i < iterations; i++){

            if (test == TestType.ADD){
                if (type == CollectionType.ARRAY_LIST){
                    actualArray = addArray(collectionSize);
                } else if (type == CollectionType.LINKED_LIST){
                    actualLinked = addLinked(collectionSize);
                } else if (type == CollectionType.HASH_MAP){
                    actualHash = addHash(collectionSize);
                } 
            }else if (test == TestType.INDEX){
                if (type == CollectionType.ARRAY_LIST){
                    index(actualArray);
                } else if (type == CollectionType.LINKED_LIST){
                    index(actualLinked);
                } else if (type == CollectionType.HASH_MAP){
                    indexHashMap(actualHash);
                }

            } else if (test == TestType.SEARCH){
                if (type == CollectionType.ARRAY_LIST){
                    search(actualArray);
                } else if (type == CollectionType.LINKED_LIST){
                    search(actualLinked);
                } else if (type == CollectionType.HASH_MAP){
                    searchHashMap(actualHash);
                }
            }
        }
    }

    private ArrayList<Person> addArray(int collectionSize){
        ArrayList<Person> arrayList = new ArrayList<Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, i);
            arrayList.add(p);
        }
        return arrayList;
    }

    private LinkedList<Person> addLinked(int collectionSize){
        LinkedList<Person> linkedList = new LinkedList<Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, i);
            linkedList.add(p);
        }
        return linkedList;
    }

    private HashMap<Integer, Person> addHash(int collectionSize){
        HashMap<Integer, Person> hashMap = new HashMap<Integer, Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, i);
            hashMap.put(p.hashCode(), p);
        }
        return hashMap;
    }
    
    public void index(List<Person> list){
        int index = collectionSize/2;
        for (int i = 0; i < collectionSize; i++){
            list.get(index);
        }
    }

    public void indexHashMap(HashMap<Integer, Person>map){

    }

    public void search(List<Person> list){
        String personSearched = ("person" + collectionSize/2);
        for (int i = 0; i < collectionSize; i++){
            Person p = list.get(i);
            if (p.getName() == (personSearched)){
                break;
            }
        }
        
    }

    public void searchHashMap(HashMap<Integer, Person>map){

    }


}
