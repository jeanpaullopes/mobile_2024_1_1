package br.edu.uniritter.aula224_1.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.edu.uniritter.aula224_1.models.User;
public class UserRepository {
    private Map<Integer, User> users;
    private static UserRepository instance;

    private UserRepository() {
        this.users = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        this.users.put(user.getId(), user);
    }
    public User getUser(int id) {
        return this.users.get(id);
    }
    public void removeUser(int id) {
        this.users.remove(id);
    }

    public boolean containsUser(int id) {
        return this.users.containsKey(id);
    }

    public ArrayList<User> getAllUsers() {
        return new ArrayList<User>(this.users.values());
    }

}
