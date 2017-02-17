package controller;

import model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by isado on 16.02.2017.
 */

@Controller
public class AppController {
    @Autowired
    HelloWorld helloWorld;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", helloWorld.hello());
        return "hello";
    }
}
