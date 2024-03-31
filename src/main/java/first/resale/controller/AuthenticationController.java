package first.resale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String get(Model model) {
        model.addAttribute("title", "Форма входа");
        return "/authentication/login";
    }
//    @GetMapping("/api/eresale/user")
//    public String user(){
//        return "User";
//    }
//    @GetMapping("/api/eresale/admin")
//    public String admin(){
//        return "Admin";
//    }
//    private final UserService userService;
//    private final RoleRepository roleRepository;
//    public AuthenticationController(UserService userService, RoleRepository roleRepository) {
//        this.userService = userService;
//        this.roleRepository = roleRepository;
//    }
//    @GetMapping("/user")
//    public String user() {
//        return "User";
//    }
//    @GetMapping("/admin")
//    public String admin() {
//        return "Admin";
//    }
//    /**
//     * Method to display the login page
//     *
//     * @return Login page
//     */
//    @GetMapping("/login")
//    public String showLogin() {
//        return "/authentication/login";
//    }
//
//    /**
//     * Method to display the registration page
//     *
//     * @param model Model for passing data to a page
//     * @return      Registration page
//     */
//    @GetMapping("/registration")
//    public String showRegister(Model model) {
//        model.addAttribute("user", new User());
//
//        return "/authentication/registration";
//    }
//
//    /**
//     * Method for registering a new user
//     *
//     * @param user   User registration request
//     * @return       Redirect to user page or registration error page
//     */
//    @PostMapping("/registration")
//    public String registerUser(@ModelAttribute User user) {
//        return "redirect:/authentication/registration-error";
////        if (user != null) {
////            userService.saveUser(user);
////            roleRepository.save(new Role(roleRepository.findAll().stream().count() + 1,);
////            return "redirect:;
////        } else {
////            return "redirect:/authentication/registration-error";
////        }
//    }
}
