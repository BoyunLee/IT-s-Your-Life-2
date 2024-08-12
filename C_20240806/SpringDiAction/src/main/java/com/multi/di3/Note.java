package com.multi.di3;

public class Note {
    private String message;
    public Note() {}
    public Note(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Note{" +
                "message='" + message + '\'' +
                '}';
    }
}
