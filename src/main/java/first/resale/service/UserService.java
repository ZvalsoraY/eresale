package first.resale.service;

import first.resale.models.User;

public interface UserService {
    void save(User user);
    void login(String username, String password);
    User findById(long id);
}
