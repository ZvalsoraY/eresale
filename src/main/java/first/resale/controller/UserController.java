package first.resale.controller;

import first.resale.models.User;
import first.resale.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "/user/users";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable Long id,
                          HttpServletResponse response) {

        var user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/user/profile";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/user";
    }

    @GetMapping("/managerPanel")
    public String showManagerPanel() {
        return "/user/managerPanel";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("user", new User());
        return "/user/create";
    }

    @GetMapping("/{id}/update")
    public String showUpdatePage(Model model, @PathVariable Long id) {
        var user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "/user/update";
    }
}
