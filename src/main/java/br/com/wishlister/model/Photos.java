package br.com.wishlister.model;

import java.util.List;

/**
 * Created by wallace on 14/10/2017.
 */
public class Photos {

    private int count;
    private List<Groups> groups;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Groups> getGroups() {
        return groups;
    }

    public void setGroups(List<Groups> groups) {
        this.groups = groups;
    }
}
