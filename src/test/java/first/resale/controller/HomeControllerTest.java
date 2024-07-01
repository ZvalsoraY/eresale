package first.resale.controller;

import first.resale.models.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {
    private static final String HOME_PAGE_RESULT = "/home";

    @InjectMocks
    private HomeController controller;

    @Test
    void getHomePageTest() {
        assertEquals(HOME_PAGE_RESULT, controller.getHomePage());
    }
}
