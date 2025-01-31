package first.resale.controller;

import first.resale.models.Role;
import first.resale.models.User;
import first.resale.models.controller.RegistrationController;
import first.resale.service.DealService;
import first.resale.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {
    private static final String REGISTRATION_EXPECTED = "/authentication/registration";

    @InjectMocks
    private RegistrationController registrationController;
    @Mock
    private UserService userService;
    @Mock
    private Model model;
    @Mock
    private BindingResult bindingResult;

    @Test
    void registrationTest() {
        String result = registrationController.registration(model);

        assertEquals(REGISTRATION_EXPECTED, result);
    }

    @Test
    public void addUserTest() {
        Mockito.when(bindingResult.hasErrors()).thenReturn(true);

        String result = registrationController.addUser(new User(), bindingResult, model);

        assertEquals("registration", result);
    }
}
