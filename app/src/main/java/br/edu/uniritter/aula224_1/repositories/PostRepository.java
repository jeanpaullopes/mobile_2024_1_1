package br.edu.uniritter.aula224_1.repositories;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.aula224_1.models.Post;

public class PostRepository implements RepostoryInterface{
    private static PostRepository instance;
    private PostRepository() {
        this.posts = new ArrayList<>();
    }
    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }

     private List<Post> posts;
    @Override
    public Object get(int id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void add(Object obj) {
        posts.add((Post) obj);

    }

    @Override
    public void remove(int id) {
        posts.removeIf(p -> p.getId() == id);
    }

    @Override
    public boolean contains(int id) {
        return posts.stream().anyMatch(p -> p.getId() == id);
    }

    @Override
    public List getAll() {
        return posts;
    }
}
