import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PerformTest implements CollectionTest{
    
    public PerformTest(){
        
    }


    //variables
    private int collectionSize;
    private int sum;
    //private int searchedValue;
    private Person searchedValue;
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
    public void runTest(CollectionType type, TestType test, int iterations){

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

        for (int i = 0; i < iterations; i++){
            if (test == TestType.INDEX){
                if (type == CollectionType.ARRAY_LIST){
                    index(arrayList);
                } else if (type == CollectionType.LINKED_LIST){
                    index(linkedList);
                } else if (type == CollectionType.HASH_MAP){

                }
            } else if (test == TestType.SEARCH){
                if (type == CollectionType.ARRAY_LIST){
                    search(arrayList);
                } else if (type == CollectionType.LINKED_LIST){
                    search(linkedList);
                } else if (type == CollectionType.HASH_MAP){
                    searchHashMap(hashMap);
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

    public void searchHashMap(HashMap<Integer, Person>map){
        int ID = collectionSize/2;
        if (map.containsKey(ID)){
            Person p = map.get(ID);
        }
    }



    // //INDEX TEST TYPE
    // public Person index(CollectionType type, TestType test, int index){
    //     if (type == CollectionType.ARRAY_LIST){
    //         if (test == TestType.INDEX){
    //             for (int i = 0; i < collectionSize; i++){
    //                 searchedResult =  arrayList.get(index);
    //             }
    //         }
    //     } else if (type == CollectionType.LINKED_LIST){
    //         if (test == TestType.INDEX){
    //             for (int i = 0; i < collectionSize; i++){
    //                 searchedResult =  linkedList.get(index);
    //             }
    //         }
    //     } else if (type == CollectionType.HASH_MAP){

    //     }

    //     return searchedResult;
    // }


    //SEARCH TEST TYPE

}

