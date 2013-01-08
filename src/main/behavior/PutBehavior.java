package main.behavior;

import main.Item;
import main.IterateBehavior;

public class PutBehavior implements IterateBehavior {

    private Item returnValue;

    @Override
    public boolean perform(int index, Item item, Item[] array) {
        if (array[index] == null || array[index].getKey() == item.getKey()) {
            array[index] = item;
            returnValue = item;
            return true;
        }
        return false;
    }

    @Override
    public Item getReturnValue() {
        return returnValue;
    }
}
