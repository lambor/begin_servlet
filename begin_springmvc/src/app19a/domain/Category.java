package app19a.domain;

import java.io.Serializable;

/**
 * Created by lambor on 17-5-18.
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
