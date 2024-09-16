package first.resale.service;

import first.resale.models.User;

import java.util.List;

public interface UserService {
    boolean  saveUser(User user);

    List<User> getUsers();

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void deleteUserById(Long id);

    User getUserByUserName(String username);
}
