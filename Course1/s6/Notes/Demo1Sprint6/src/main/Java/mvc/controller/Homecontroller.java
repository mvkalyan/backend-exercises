package mvc.controller;


import org.springframework.web.bind.annotation.RequestMapping;

public class Homecontroller {

    @RequestMapping("/")
    public String getNewsHomePage()
    {
        System.out.println("Taking to home Page");
        return "index";
    }

    @RequestMapping("/greet")
    public String getDisaplayPage(){
        return "welcome";
    }
}