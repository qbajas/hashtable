package main.behavior;

import main.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Qba
 * Date: 18.12.12
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
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
