package first.resale.service.implementation;

import first.resale.models.User;
import first.resale.repository.UserRepository;
import first.resale.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public User getUserById(Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchElementException("User not found.");
        }
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        updatedUser.setId(id);
        var user = userRepository.findById(id).get();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setName(user.getName());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUserName(String username) {
        var user = userRepository.findByUserName(username);
        if (user != null) {
            return user.get();
        } else {
            throw new NoSuchElementException("User not found.");
        }
    }
}
