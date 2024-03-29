//package first.resale.service.implementation;
//
//import first.resale.models.User;
//import first.resale.repository.ProductRepository;
//import first.resale.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    public UserDetailsServiceImpl(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUserName(userName);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("User not found.");
//        }
//        return new UserDetailsImpl(user.get());
//    }
//}
