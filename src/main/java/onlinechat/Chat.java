package main.java.onlinechat;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public abstract class Chat {

    private Map<String, User> users;
    private List<Message> messages;

    public Chat() {
        users = new HashMap<>();
        messages = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.put(user.getEmail(), user);
    }

    public void addMessage(Message m) {
        this.messages.add(m);
    }

    public int usersCount() {
        return users.size();
    }

    public void displayMessages() {
        for (Message m : messages) {
            System.out.println(m.formatMessage());
        }
    }
}
