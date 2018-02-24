package project.webshop.controller;


import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {
    // msg
    private MessageSource messageSource;

    @GetMapping("/welcome-internationalized")
    public String msg(@RequestHeader(value = "Accept-Language",
            required = false) Locale locale) {
        return messageSource.getMessage("welcome.message", null,
                locale);
    }


}
