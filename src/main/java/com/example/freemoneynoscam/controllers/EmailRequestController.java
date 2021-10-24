package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.EmailDataBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmailRequestController {
    EmailDataBaseService edbs = new EmailDataBaseService();

    @GetMapping("/get-email")
    public String emailRequest() {
        return "email-request-page";
    }

    @PostMapping("/get-email")
    public String userEmail(WebRequest wr) {
        var parameter = wr.getParameter("email");
        edbs.insertEmailIntoDB(parameter);
        return "success-page"; // supposed to redirect to avoid double submission
    }

    @GetMapping("display-emails")
    public Object listOfEmails(Model model) {
        model.addAttribute("emailList", edbs.getAllEmails());
        return "email-list-page";
    }
}
