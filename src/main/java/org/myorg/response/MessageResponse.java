package org.myorg.response;

import org.myorg.model.Message;

public class MessageResponse {
    String author, message;

    public MessageResponse() {
    }

    public MessageResponse(Message message) {
        this.author = message.getAuthor();
        this.message = message.getMessage();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
