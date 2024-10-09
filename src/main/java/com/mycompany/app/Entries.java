package com.mycompany.app;

import java.util.List;

public class Entries {

    private List<Entry> entries;

    public Entries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> entries() {
        return entries;
    }

    public static record Entry(String title) {}
}
