package first.resale.controller;

import first.resale.models.Role;
import first.resale.models.User;
import first.resale.repository.RoleRepository;
import first.resale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class AuthenticationController {
    private final UserService userService;
    private final RoleRepository roleRepository;
    public AuthenticationController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    /**
     * Method to display the login page
     *
     * @return Login page
     */
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    /**
     * Method to display the registration page
     *
     * @param model Model for passing data to a page
     * @return      Registration page
     */
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());

        return "/authentication/register";
    }

    /**
     * Method for registering a new user
     *
     * @param user   User registration request
     * @return       Redirect to user page or registration error page
     */
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user) {
        return "redirect:/authentication/registration-error";
//        if (user != null) {
//            userService.saveUser(user);
//            roleRepository.save(new Role(roleRepository.findAll().stream().count() + 1,);
//            return "redirect:;
//        } else {
//            return "redirect:/authentication/registration-error";
//        }
    }
}
