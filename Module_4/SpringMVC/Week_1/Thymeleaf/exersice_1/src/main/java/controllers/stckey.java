package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class stckey {
    @ResponseBody
    @RequestMapping("/stckey")
    public  String giverkeybad(){
        return ("hey man sugger dady !");
    }

}
