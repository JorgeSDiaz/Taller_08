package org.myorg.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.myorg.model.Message;
import org.myorg.response.MessageResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.*;

import static com.mongodb.client.model.Indexes.descending;

@ApplicationScoped
public class MessageService {
    @Inject
    MongoClient mongoClient;

    public List<MessageResponse> list() {
        List<MessageResponse> messages = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().sort(descending("created_at")).limit(10).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                MessageResponse message = new MessageResponse();

                message.setAuthor(document.getString("author"));
                message.setMessage(document.getString("message"));

                messages.add(message);
            }
        } finally {
            cursor.close();
        }

        return messages;
    }

    public List<MessageResponse> add(Message newMessage) {
        Message message = new Message(newMessage.getAuthor(), newMessage.getMessage());

        Document document = new Document()
                .append("author", message.getAuthor())
                .append("message", message.getMessage())
                .append("created_at", message.getCreated_at());

        getCollection().insertOne(document);

        return list();
    }

    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("messages").getCollection("messages");
    }
}
