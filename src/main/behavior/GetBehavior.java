package main.behavior;

import main.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Qba
 * Date: 18.12.12
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */
public class GetBehavior implements IterateBehavior {

    private Item returnValue;

    @Override
    public boolean perform(int index, Item item, Item[] array) {
        if (array[index] == null) {
            returnValue = null;
            return true;
        }
        if (array[index].getKey() == item.getKey()) {
            returnValue = array[index];
            return true;
        }
        return false;
    }

    @Override
    public Item getReturnValue() {
        return returnValue;
    }
}
