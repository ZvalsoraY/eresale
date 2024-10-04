package first.resale.service.implementation;

import first.resale.models.User;
import first.resale.repository.UserRepository;
import first.resale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public boolean  saveUser(User user) {
        User userFromDB = userRepository.findByUserName(user.getUserName());
        if (userFromDB != null) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("User not found with id: " + id));
        return user;
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        if (bCryptPasswordEncoder.matches(updatedUser.getPassword(),user.getPassword()) ||
                updatedUser.getPassword().equals(user.getPassword()) ||
                updatedUser.getPassword().isBlank() ||
                updatedUser.getPassword() == null) {
            updatedUser.setPassword(user.getPassword());
        } else {
            updatedUser.setPassword(bCryptPasswordEncoder.encode(updatedUser.getPassword()));
        }
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        if (getUserById(id) == null) {
            throw new NoSuchElementException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUserName(String username) {
        var user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
