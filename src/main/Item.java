package main;

/**
 * Created with IntelliJ IDEA.
 * User: Qba
 * Date: 18.12.12
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    private int key;
    private String value;

    public Item(int key, String value) {
        this.value = value;
        this.key = key;
    }

    public Item(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
