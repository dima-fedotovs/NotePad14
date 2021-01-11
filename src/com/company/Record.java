package com.company;

public abstract class Record {
    private static int counter = 0;
    private int id;

    public Record() {
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id: %d", id);
    }

    public abstract void askData();

    public boolean contains(String substr) {
        var strId = String.valueOf(id);
        return strId.contains(substr);
    }
}
