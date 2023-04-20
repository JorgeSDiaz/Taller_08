package org.myorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private String author, message;
    private LocalDateTime created_at;

    public Message() {
    }

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
        this.created_at = LocalDateTime.now();
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

    @JsonIgnore
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }

        Message other = (Message) obj;

        return Objects.equals(other.getAuthor(), this.author) && Objects.equals(other.getMessage(), this.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.author);
    }

}
