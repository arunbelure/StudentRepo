package com.student.Payload;

import java.util.Date;


public class ErrorDetails {

    private Date date;

    private String message;

    private String Description;

    public ErrorDetails(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        Description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return Description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
