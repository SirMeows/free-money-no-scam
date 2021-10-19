package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.EmailDataBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmailRequestController {

    @GetMapping("/")
    public String emailRequest() {
        return "email-request-page";
    }

    @PostMapping("/user-email")
    public String userEmail(WebRequest wr) {
        var parameter = wr.getParameter("email");
        var edbs = new EmailDataBaseService();
        edbs.insertEmailIntoDB(parameter);
        return "email-request-page";
    }
}
