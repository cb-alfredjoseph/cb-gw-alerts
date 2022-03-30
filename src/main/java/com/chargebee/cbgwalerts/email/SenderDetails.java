package com.chargebee.cbgwalerts.email;

import com.sun.istack.NotNull;

public class SenderDetails {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String messageBody;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
