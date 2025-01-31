package first.resale.controller;

import first.resale.models.User;
import first.resale.models.controller.UserController;
import first.resale.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private static final String INDEX_EXPECTED = "/user/users";
    private static final String NEW_USER_EXPECTED = "/user/new";
    private static final String CREATE_USER_EXPECTED = "redirect:/users";
    private static final String EDIT_USER_EXPECTED = "user/edit";
    private static final String UPDATE_USER_EXPECTED = "redirect:/users";
    private static final String DELETE_USER_EXPECTED = "redirect:/users";

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    @Mock
    private Model model;

    @Test
    public void indexTest() {
        String result = userController.index(model);

        assertEquals(INDEX_EXPECTED, result);
    }

    @Test
    public void newUserTest() {
        String result = userController.newUser(model);

        assertEquals(NEW_USER_EXPECTED, result);
    }

    @Test
    public void createTest() {
        String result = userController.create(new User());

        assertEquals(CREATE_USER_EXPECTED, result);
    }

    @Test
    public void editTest() {
        String result = userController.edit(model, 1L);

        assertEquals(EDIT_USER_EXPECTED, result);
    }

    @Test
    public void updateTest() {
        String result = userController.update(new User(), 1L);

        assertEquals(UPDATE_USER_EXPECTED, result);
    }

    @Test
    public void deleteUserTest() {
        String result = userController.deleteUser(1L);

        assertEquals(DELETE_USER_EXPECTED, result);
    }
}
