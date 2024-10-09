package com.mycompany.app;

import java.util.List;

public class Condition {

    private List<String> entries;

    public List<String> entries() {
        return entries;
    }

    public Condition(List<String> entries) {
        this.entries = entries;
    }
}
