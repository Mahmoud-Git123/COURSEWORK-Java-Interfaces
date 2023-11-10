/**
 * This class runs the tests add, index and search for the 3 collection type through implementing CollectionTest class
 * @author Mahmoud Abdelfattah
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PerformTest implements CollectionTest{

    //variables
    private int collectionSize;
    private String personSearched;

    private ArrayList <Person> actualArray;
    private LinkedList <Person> actualLinked;
    private HashMap <Integer, Person> actualHash;

    //constructor with no parameters
    /**
     * This is the constructor made with no parameters as speicified but sets the 3 collection types
     */
    public PerformTest(){
        actualArray = new ArrayList<>();
        actualLinked = new LinkedList<>();
        actualHash = new HashMap<>();
    }

    /**
     * This is the size setter method where the collectionSize variable made is now equal to size
     */
    //setSize method
    public void setSize(int size){
        collectionSize = size;
    }

    /**
     * runTest method:
     * Has a loop for iterations.
     * Depending on the type and test, the correct method is called to carry out the relevant test
     * @param type this is the collection type(array list, linked list or hashmap)
     * @param test this is the test type (add, search or index)
     * @param iterations this is the number of times the tests are iterated through
     */

     //runTest method
    public void runTest(CollectionType type, TestType test, int iterations){

        for (int i = 0; i < iterations; i++){

            //if test type is add
            if (test == TestType.ADD){
                if (type == CollectionType.ARRAY_LIST){
                    actualArray = addArray(collectionSize);
                } else if (type == CollectionType.LINKED_LIST){
                    actualLinked = addLinked(collectionSize);
                } else if (type == CollectionType.HASH_MAP){
                    actualHash = addHash(collectionSize);
                } 
            //if test type is index
            }else if (test == TestType.INDEX){
                if (type == CollectionType.ARRAY_LIST){
                    index(actualArray);
                } else if (type == CollectionType.LINKED_LIST){
                    index(actualLinked);
                } else if (type == CollectionType.HASH_MAP){
                    indexHashMap(actualHash);
                }
            //if test type is search
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

    /**
     * addArray method:
     * Creates the array list (as required).
     * Populates the arraylist through use of for loop, by adding a new person instance (unique) to the list
     * @param collectionSize this is to set the limit for the collection size, where it is used in the for loop
     * @return arrayList - returns the array list to be used in other methods
     */
    private ArrayList<Person> addArray(int collectionSize){
        //creates an array list
        ArrayList<Person> arrayList = new ArrayList<Person>();
        //loops through array
        for (int i = 0; i < collectionSize; i++){
            //creates new person instance
            Person p = new Person("person" + i, i);
            //adds person
            arrayList.add(p);
        }
        return arrayList;
    }

    /**
     * addLinked method:
     * Creates the linked list (as required).
     * Populates the linked list through use of for loop, by adding a new person instance (unique) to the list
     * @param collectionSize this is to set the limit for the collection size, where it is used in the for loop
     * @return linkedList - returns the linked list to be used in other methods
     */
    private LinkedList<Person> addLinked(int collectionSize){
        //creates a linked list
        LinkedList<Person> linkedList = new LinkedList<Person>();
        //loops through list
        for (int i = 0; i < collectionSize; i++){
            //create unique instance of person
            Person p = new Person("person" + i, i);
            //add to list
            linkedList.add(p);
        }
        return linkedList;
    }

    /**
     * addHash method:
     * Creates the hash map (as required).
     * Populates the hashmap through use of for loop, by adding a new person instance (unique) to the map.
     * Uses the hashcode from the person class
     * @param collectionSize this is to set the limit for the collection size, where it is used in the for loop
     * @return hashMap - returns hashMap to be used in other methods
     */
    private HashMap<Integer, Person> addHash(int collectionSize){
        //create new hashmap
        HashMap<Integer, Person> hashMap = new HashMap<Integer, Person>();
        //loop through the map
        for (int i = 0; i < collectionSize; i++){
            //create unique instance of person
            Person p = new Person("person" + i, i);
            //add to map using Integer hashcode
            hashMap.put(p.hashCode(), p);
        }
        return hashMap;
    }
    
    /**
     * index method:
     * index method for both array and linked lists.
     * divides collection size by 2 to get index roughly half way through.
     * loops through list and gets the index.
     * @param list this is the list where it can be an array or a linked list
     */

    public void index(List<Person> list){
        //gets index halfway
        int index = collectionSize/2;
        //loops through list
        for (int i = 0; i < collectionSize; i++){
            //gets the person at index
            list.get(index);
        }
    }

    /**
     * indexHashMap method:
     * index method for hashmaps only.
     * Creates ID variable which is collectionsize/2 to be halfway.
     * Loops through hashmap using "entrySet".
     * Gets the key at each entry and compares to the keyset array at ID (halfway).
     * Gets the value
     * @param map this is the map
     */
    public void indexHashMap(HashMap<Integer, Person>map){
        //halfway through
        int ID = collectionSize/2;
        
        //loops through hashmap
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            //compares key to the keyset at ID (halfway)
            if (entry.getKey() == map.keySet().toArray()[ID]) {
                //gets the value at that key
                entry.getValue();
                break;
            }
        }
    }

    /**
     * search method:
     * search method for both array and linked lists.
     * uses personSearched string to find the person at roughly halfway through.
     * loops through list.
     * compares the name of personsearched to name in the list.
     * @param list this is the list where it can be an array or a linked list
     */
    public void search(List<Person> list){
        //the person that is searched for (halfway through)
        personSearched = ("person" + collectionSize/2);
        //loop through list
        for (int i = 0; i < collectionSize; i++){
            //get the person
            Person p = list.get(i);
            //compare the name wanted to the name gotten
            if (p.getName() == (personSearched)){
                break;
            }
        }
        
    }

    /**
     * searchHashMap method:
     * search method for hash maps.
     * creates ID variable as collectionSize/2 to be roughly halfway.
     * looks for that key in the map.
     * gets the person.
     * @param map this is the hash map
     */
    public void searchHashMap(HashMap<Integer, Person>map){
        //divide collectionsize by 2 to be halfway through
        int ID = collectionSize/2;    
        //check if map contains this ID
        if (map.containsKey(ID)){
            //get the person
            Person p = map.get(ID);
        }
    }


}
