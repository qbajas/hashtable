package main.behavior;

import main.Item;

/**
 * This class encapsulates behavior
 */
public interface IterateBehavior {

    /**
     * Defines operations which should be executed during iteration of inner structure of hash table
     * @return tells us if the function which called this behavior should return returnValue
     */
    boolean perform(int index, Item item, Item[] array);

    public Item getReturnValue();
}
