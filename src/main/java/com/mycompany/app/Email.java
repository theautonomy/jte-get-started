package com.mycompany.app;

public class Email {

    public static class EmailModel {
        public final String name;
        public final String activationLink;

        public EmailModel(String name, String activationLink) {
            this.name = name;
            this.activationLink = activationLink;
        }
    }
}
