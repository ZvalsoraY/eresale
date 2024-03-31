package first.resale.service;

import first.resale.models.Deal;

import java.util.List;

public interface DealService {
    Deal saveDeal(Deal deal);

    List<Deal> getDeals();

    List<Deal> getDealsBySellerId(Long sellerId);

    List<Deal> getDealsByBuyerId(Long buyerId);

    Deal getDealById(Long id);

    void updateDeal(Long id, Deal deal);

    void deleteDeal(Long id);
}
