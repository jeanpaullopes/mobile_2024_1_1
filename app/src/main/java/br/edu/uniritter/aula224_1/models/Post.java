package br.edu.uniritter.aula224_1.models;

public class Post {
    private User user;
    private int id;
    private String title;
    private String body;

    public Post(User user, int id, String title, String body) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
