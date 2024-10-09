package com.mycompany.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.EmailService.EmailModel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        templateEngine.render(
                "email.jte", new EmailModel("Mark Smith", "https://signup.com"), output);
        String result = output.toString();
        System.out.println(result);
    }

    @Test
    void testConditional() {
        StringOutput output = new StringOutput();
        Condition model = new Condition(Arrays.asList("hello", "world"));
        templateEngine.render("conditional.jte", model, output);
        System.out.println(output.toString());
    }

    @Test
    void testLoop() {
        StringOutput output = new StringOutput();
        Entries model = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        templateEngine.render("loop.jte", model, output);
        System.out.println(output.toString());
    }

    @Test
    void testLoopWithMap() {
        StringOutput output = new StringOutput();
        Entries model = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        Entries model1 = new Entries(Collections.<Entries.Entry>emptyList());
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("model1", model1);
        templateEngine.render("loop1.jte", params, output);
        System.out.println(output.toString());
    }

    @Test
    void testTemplateCall() {
        StringOutput output = new StringOutput();
        Entries model = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        templateEngine.render("use-sub-loop.jte", model, output);
        System.out.println(output.toString());
    }

    @Test
    void testTemplateCallWithDefaultParameter() {
        StringOutput output = new StringOutput();
        Entries model = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("name", "Mark");
        templateEngine.render("use-sub-loop1.jte", params, output);
        System.out.println(output.toString());
    }

    @Test
    void testTemplateWithVarargs() {
        StringOutput output = new StringOutput();
        templateEngine.render("varargs.jte", null, output);
        System.out.println(output.toString());
    }

    @Test
    void testContent() {
        StringOutput output = new StringOutput();
        Entries entries = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        EmailService.EmailModel emailModel = new EmailModel("Mark Smith", "https://signup.com");
        Map<String, Object> params = new HashMap<>();
        params.put("email", emailModel);
        params.put("entries", entries);
        templateEngine.render("layout.jte", params, output);
        System.out.println(output.toString());
    }

    @Test
    void testVariable() {
        StringOutput output = new StringOutput();
        Entries model = new Entries(Arrays.asList(new Entries.Entry("Mark"), new Entries.Entry("Smith")));
        templateEngine.render("variable.jte", model, output);
        System.out.println(output.toString());
    }
}
