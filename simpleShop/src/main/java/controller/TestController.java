package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Олег on 07.03.2016.
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String Hello(){
        return "Hello, Spring";
    }

}
