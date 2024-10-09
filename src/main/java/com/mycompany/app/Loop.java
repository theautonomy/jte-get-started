package com.mycompany.app;

import java.util.List;

public class Loop {

    private List<Entry> entries;

    public Loop(List<Entry> entries) {
        this.entries = entries;
    }

    public List<Entry> entries() {
        return entries;
    }

    public static record Entry(String title) {}
}
