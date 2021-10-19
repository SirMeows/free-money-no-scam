package com.example.freemoneynoscam;

public class Email {

    String input;

    Email(String input) {
        this.input = input;
    }

    public boolean isValidEmail() {
        var regex = "";
        if(this.input.contains(regex)) {
            return true;
        }
        return false;
    }

    public String getInput() {
        return input;
    }
}
