package main.java.onlinechat;


import java.util.List;

public class PrivateChat extends Chat {
    @Override
    public void addUser(User user) {
        if (usersCount() < 2) {
            super.addUser(user);
        }
    }
}