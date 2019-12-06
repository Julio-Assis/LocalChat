package main.java.onlinechat;


public class Message {
    private String content;
    private String authorName;

    public Message(String content, String authorName) {
        this.content = content;
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String formatMessage() {
        return String
                .format("Author: %s\n Message: %s", authorName, content);
    }
}
