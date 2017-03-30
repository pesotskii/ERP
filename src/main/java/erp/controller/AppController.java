package erp.controller;

import erp.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppController {

    @RequestMapping(value = "/")
    public String hello(Model model){
        model.addAttribute("hello", "HELLO");
        return "hello";
    }
}
