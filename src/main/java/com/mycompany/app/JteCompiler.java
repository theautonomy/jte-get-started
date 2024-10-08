package com.mycompany.app;

import java.nio.file.Path;
import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

public class JteCompiler {

    public static void main1(String[] args) {
        // Define the template engine with the path to the templates

        CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src/main/jte")); // This is
                                                                                        // the
                                                                                        // directory
                                                                                        // where
                                                                                        // your .jte
                                                                                        // files are
                                                                                        // located.
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two
                                                                                               // choices:
                                                                                               // Plain
                                                                                               // or
                                                                                               // Html

        // Manually compile templates (usually you'd automate this through Maven or Gradle build
        // plugins)
        templateEngine.precompileAll();
    }
}
