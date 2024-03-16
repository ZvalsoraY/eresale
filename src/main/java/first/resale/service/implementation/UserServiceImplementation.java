package first.resale.service.implementation;

import first.resale.models.User;
import first.resale.repository.UserRepository;
import first.resale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }
}
