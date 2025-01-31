package first.resale.controller;

import first.resale.models.controller.AuthenticationController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {
    private static final String GET_RESULT_EXPECTED = "/authentication/login";

    @InjectMocks
    private AuthenticationController authenticationController;
    @Mock
    private Model model;

    @Test
    void getTest() {
        assertEquals(GET_RESULT_EXPECTED, authenticationController.get(model));
        verify(model).addAttribute("title", "Форма входа");
    }

}
