package com.baizhi.entity;

public class Guru {
    private String id;

    private String name;

    private String head;

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

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                '}';
    }

    public Guru(String id, String name, String head) {
        this.id = id;
        this.name = name;
        this.head = head;
    }

    public Guru() {
        super();
    }

}