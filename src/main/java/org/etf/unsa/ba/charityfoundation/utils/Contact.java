package org.etf.unsa.ba.charityfoundation.utils;

import java.io.Serializable;

public class Contact implements Serializable{
    private String message;
    private String to;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "message='" + message + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
