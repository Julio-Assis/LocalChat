package main.java.onlinechat;


public abstract class FriendRequest {
    private User requester;
    private User requested;

    public FriendRequest(User requester, User requested) {
        this.requester = requester;
        this.requested = requested;
    }

    public User getRequester() {
        return requester;
    }

    public User getRequested() {
        return requested;
    }

    public abstract void accept();
    public abstract void reject();
}
