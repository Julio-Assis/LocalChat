package main.java.onlinechat;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class User {
    private String name;
    private String email;
    private String phone;
    private List<User> friends;
    private Map<String, FriendRequest> friendRequests;
    private Map<String, FriendRequest> incomingFriendRequest; 



    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.friends = new ArrayList<>();
        this.friendRequests = new HashMap<>();
        this.incomingFriendRequest = new HashMap<>();
    }

    public void createFriendRequest(User user) {
        User me = this;
        FriendRequest fr = new FriendRequest(me, user){
        
            @Override
            public void reject() {
                me.removeFriendRequest(user.getEmail());
                user.removeIncomingFriendRequest(me.getEmail());
            }
        
            @Override
            public void accept() {
                me.addFriend(user);
                user.addFriend(me);

                me.removeFriendRequest(user.getEmail());
                user.removeIncomingFriendRequest(me.getEmail());
            }
        };

        me.addFriendRequest(user, fr);
        user.addIncomingFriendRequest(me, fr);
    }

    private void addFriend(User user) {
        this.friends.add(user);
    }

    private void addFriendRequest(User user, FriendRequest fr) {
        this.friendRequests.put(user.getEmail(), fr);
    }
    
    private void removeFriendRequest(String requestId) {
        if (this.friendRequests.containsKey(requestId)) {
            this.friendRequests.remove(requestId);
        }
    }

    public void approveFriendRequest(FriendRequest fr) {
        fr.accept();
    }

    public void rejectFriendRequest(FriendRequest fr) {
        fr.reject();
    }

    private void addIncomingFriendRequest(User user, FriendRequest fr) {
        this.incomingFriendRequest.put(user.getEmail(), fr);
    }

    private void removeIncomingFriendRequest(String requestId) {
        if (this.incomingFriendRequest.containsKey(requestId)) {
            this.incomingFriendRequest.remove(requestId);
        }
    }

    public void removeFriend(User user) {
        this.friends.remove(user);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}