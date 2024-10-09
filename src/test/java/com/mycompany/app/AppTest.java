package com.mycompany.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    @Test
    void testLoopWithMap() {
        StringOutput output = new StringOutput();
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
        // Loop model1 = new Loop(Arrays.asList(new Loop.Entry("Mark")));
        Loop model1 = new Loop(Collections.<Loop.Entry>emptyList());  
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("model1", model1);
        templateEngine.render("loop1.jte", params, output); 
        System.out.println(output.toString());

    }

    @Test
    void testTemplateCall() {
        StringOutput output = new StringOutput();
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
        templateEngine.render("use-sub-loop.jte", model, output); 
        System.out.println(output.toString());
    }

    @Test
    void testTemplateCallWithDefaultParameter() {
        StringOutput output = new StringOutput();
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
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
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
        EmailService.WelcomeEmailModel model1 = new WelcomeEmailModel("Mark Smith", "https://signup.com");
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("email", model1);
        templateEngine.render("layout.jte", params, output); 
        System.out.println(output.toString());
    }

    @Test
    void testVariable() {
        StringOutput output = new StringOutput();
        Loop model = new Loop(Arrays.asList(new Loop.Entry("Mark"), new Loop.Entry("Smith")));
        templateEngine.render("variable.jte", model, output); 
        System.out.println(output.toString());
    }


}
