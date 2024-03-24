package first.resale.service;

import first.resale.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
    User getUserById(Long id);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserByUserName(String username);
}
