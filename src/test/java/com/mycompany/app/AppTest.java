package com.mycompany.app;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.mycompany.app.EmailService.WelcomeEmailModel;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

class AppTest {
    private static TemplateEngine templateEngine;

    @BeforeAll
     static void setup() {
         templateEngine = TemplateEngine.createPrecompiled(ContentType.Plain);
    }

    @Test
    void test1() {
        StringOutput output = new StringOutput();
        templateEngine.render("email.jte", new WelcomeEmailModel("Mark Smith", "https://signup.com"), output);
        String result = output.toString();
        System.out.println(result);
    }

    @Test
    void testConditional() {
        StringOutput output = new StringOutput();
        Conditional model = new Conditional(Arrays.asList("hello", "world"));
        templateEngine.render("conditional.jte", model, output); 
        System.out.println(output.toString());
    }

    @Test
    void testLoop() {
        StringOutput output = new StringOutput();
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
        templateEngine.render("loop.jte", model, output); 
        System.out.println(output.toString());
    }
}
