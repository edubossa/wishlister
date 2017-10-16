package br.com.wishlister.model;

import java.util.List;

/**
 * Created by wallace on 14/10/2017.
 */
public class Groups {

    private String type;
    private String name;
    private int count;
    private List<Items> items;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
