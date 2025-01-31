package first.resale.controller;

import first.resale.models.controller.DealController;
import first.resale.service.DealService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DealControllerTest {
    private static final String GET_DEALS_RESULT_EXPECTED = "/deal/deals";
    private static final String DELETE_DEAL_RESULT_EXPECTED = "redirect:/deals";

    @InjectMocks
    private DealController dealController;
    @Mock
    private DealService dealService;
    @Mock
    private Model model;

    @Test
    public void getDealsTest() {
        String result = dealController.getDeals(model);

        assertEquals(GET_DEALS_RESULT_EXPECTED, result);
        verify(model).addAttribute("deals", dealService.getDeals());
    }

    @Test
    public void deleteDealTest() {
        String result = dealController.deleteDeal(1L);

        assertEquals(DELETE_DEAL_RESULT_EXPECTED, result);
        verify(dealService).deleteDealById(1L);
    }
}


