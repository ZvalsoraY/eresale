package first.resale.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {
    private static final String AUTHENTICATION_CONTROLLER_RESULT = "/authentication/login";

    @InjectMocks
    private AuthenticationController authenticationController;
    @Mock
    private Model model;

    @Test
    void getTest() {
        assertEquals(AUTHENTICATION_CONTROLLER_RESULT, authenticationController.get(model));
    }

}
