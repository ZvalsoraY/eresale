package first.resale.service;

import first.resale.models.Deal;


import java.util.List;

public interface DealService {
    Deal saveDeal(Deal deal);
    List<Deal> getDeals();
    List<Deal> getDealsByUserId(Long userId);
    Deal getDealById(Long id);
    void updateDeal(Long id, Deal deal);
    void deleteDeal(Long id);
}
