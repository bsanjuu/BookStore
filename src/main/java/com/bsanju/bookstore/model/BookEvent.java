package com.bsanju.bookstore.model;

public class BookEvent {

    private String type; // NEW_BOOK or PURCHASE
    private String message;

    public BookEvent() {}

    public BookEvent(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
