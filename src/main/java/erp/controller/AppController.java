package erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AppController {

    @RequestMapping(value = "/")
    public String hello(Model model){
        model.addAttribute("hello", "HELLO");
        return "hello";
    }
}
