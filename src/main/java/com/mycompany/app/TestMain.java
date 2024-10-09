package com.mycompany.app;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

public class TestMain {

    private final TemplateEngine templateEngine;

    public TestMain() {
        // CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src/main/jte")); // This is the directory where your .jte files are located.
        // this.templateEngine = TemplateEngine.create(codeResolver, ContentType.Plain); // Two choices: Plain or Html
        this.templateEngine = TemplateEngine.createPrecompiled(ContentType.Plain);
    }

    public String renderWelcomeEmail(String name, String activationLink) {
        StringOutput output = new StringOutput();
        templateEngine.render("email.jte", new Email.EmailModel(name, activationLink), output);
        return output.toString();
    }

    public static void main(String[] args) {
        TestMain main = new TestMain();
        String emailContent = main.renderWelcomeEmail(
                        "John Doe", "http://example.com/activate?token=abc123");
        System.out.println(emailContent);
    }

}
