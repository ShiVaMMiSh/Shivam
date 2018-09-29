package com.example.shivam.project2.Sql;

import java.io.Serializable;

public class Dbholder2 implements Serializable {
    String id;
    String name;
    String percentage;

    public Dbholder2(String id, String name, String percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }

    public Dbholder2() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
