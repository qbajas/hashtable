package main;

import exception.FullException;
import main.behavior.GetBehavior;
import main.behavior.PutBehavior;

/**
 * Hash table implementation using open addressing
 * - holds objects of Item class
 * - has a constant capacity set at creation and throws exception if capacity is exceeded
 * - uses open addressing and sequential probing to resolve collisions
 * - implements strategy design pattern by using behaviors
 */
public class HashTable {

    private Item[] array;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        array = new Item[capacity];
    }

    public void put(Item item) {
        IterateBehavior behavior = new PutBehavior();
        Item returnedItem = iterate(item, behavior);
        if (returnedItem == null) {
            throw new FullException("HashTable is full!");
        }
    }

    public Item get(int key) {
        IterateBehavior behavior = new GetBehavior();
        Item item = new Item(key);
        return iterate(item, behavior);
    }

    private Item iterate(Item item, IterateBehavior behavior) {
        int localKey = myHashCode(item.getKey());
        for (int i = localKey; i < localKey + capacity; i++) {
            int index = i % capacity;
            boolean returnValueFromBehavior = behavior.perform(index, item, array);
            if (returnValueFromBehavior) {
                return behavior.getReturnValue();
            }
        }
        return null;
    }

    private int myHashCode(int value) {
        return value % capacity;
    }


}
