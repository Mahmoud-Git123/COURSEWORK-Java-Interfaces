import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PerformTest implements CollectionTest{
    
    public PerformTest(){
        
    }


    //variables
    private int collectionSize;

    private ArrayList <Person> actualArray;
    private LinkedList <Person> actualLinked;
    private HashMap <Integer, Person> actualHash;
    

    //Creating and population of Array List
    private ArrayList<Person> addArray(int collectionSize){
        ArrayList<Person> arrayList = new ArrayList<Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, 19);
            arrayList.add(p);
        }
        return arrayList;
    }

    //Creating and population of Linked List
    private LinkedList<Person> addLinked(int collectionSize){
        LinkedList<Person> linkedList = new LinkedList<Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, 19);
            linkedList.add(p);
        }
        return linkedList;
    }

    //Creating and population of Hash Map
    private HashMap<Integer, Person> addHash(int collectionSize){
        HashMap<Integer, Person> hashMap = new HashMap<Integer, Person>();
        for (int i = 0; i < collectionSize; i++){
            Person p = new Person("person" + i, 19);
            hashMap.put(p.hashCode(), p);
        }
        return hashMap;
    }
    
    
    //setSize method
    public void setSize(int size){
        collectionSize = size;
    }

    //ADD TEST TYPE
    public void runTest(CollectionType type, TestType test, int iterations){

        //Array List ADD
        if (type == CollectionType.ARRAY_LIST){
            if (test == TestType.ADD){
                actualArray = addArray(collectionSize);
            }
        //Linked list ADD
        } else if (type == CollectionType.LINKED_LIST){
            if (test == TestType.ADD){
                actualLinked = addLinked(collectionSize);
            }

        //Hash map ADD
        } else if (type == CollectionType.HASH_MAP){
            if (test == TestType.ADD){
                actualHash = addHash(collectionSize);
            } 
        }

        for (int i = 0; i < iterations; i++){
            if (test == TestType.INDEX){
                if (type == CollectionType.ARRAY_LIST){
                    index(actualArray);
                } else if (type == CollectionType.LINKED_LIST){
                    index(actualLinked);
                } else if (type == CollectionType.HASH_MAP){

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

    //index method
    public void index(List<Person> list){
        int index = collectionSize/2;
        while (index >= 0 && index < collectionSize){
            Person p = list.get(index);
        }
    }

    //search method
    public void search(List<Person> list){
        String personSearched = ("person" + collectionSize/2);
        for (int i = 0; i < collectionSize; i++){
            Person p = list.get(i);
            if (p.getName().equals(personSearched)){
                break;
            }
        }
    }

    //search method for hashmap
    public void searchHashMap(HashMap<Integer, Person>map){
        int ID = collectionSize/2;
        if (map.containsKey(ID)){
            Person p = map.get(ID);
        }
    }


}

