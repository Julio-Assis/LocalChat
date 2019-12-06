package main.java.onlinechat;


import java.util.List;
import java.util.ArrayList;


public class GroupChat {

    private List<User> users;
    private List<Message> messages;

    public GroupChat() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addMessage(Message m) {
        this.messages.add(m);
    }

    public void displayMessages() {
        for (Message m : messages) {
            System.out.println(m.formatMessage());
        }
    }
}