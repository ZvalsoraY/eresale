package first.resale.models.controller;

import first.resale.service.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("deals")
public class DealController {
    private final DealService dealService;

    public DealController( DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public String getDeals(Model model) {
        model.addAttribute("deals", dealService.getDeals());

        return "/deal/deals";
    }

    @DeleteMapping("/{id}")
    public String deleteDeal(@PathVariable Long id) {
        dealService.deleteDealById(id);
        return "redirect:/deals";
    }
}