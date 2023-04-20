package org.myorg.service;

import org.myorg.model.Message;
import org.myorg.model.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class MessageService {
    private Set<Message> messages;

    public MessageService() {
        messages = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    }

    public List<Message> list() {
        List<Message> res = new ArrayList<>();
        List<Message> msg = messages.stream().toList();
        for (int index = messages.size() > 10 ? messages.size() - 10 : 0; index < messages.size(); index++) {
            res.add(msg.get(index));
        }

        return res;
    }

    public List<Message> add(Message newMessage) {
        messages.add(newMessage);

        return list();
    }
}
