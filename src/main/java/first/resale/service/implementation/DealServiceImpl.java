package first.resale.service.implementation;

import first.resale.models.Deal;
import first.resale.repository.DealRepository;
import first.resale.repository.ProductRepository;
import first.resale.repository.UserRepository;
import first.resale.service.DealService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DealServiceImpl implements DealService {
    private final DealRepository dealRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public DealServiceImpl(ProductRepository productRepository, UserRepository userRepository,
                           DealRepository dealRepository) {
        this.dealRepository = dealRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public List<Deal> getDeals() {
        List<Deal> result = new ArrayList<>();
        dealRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Deal> getDealsBySellerId(Long sellerId) {
        return dealRepository.findBySellerId(sellerId);
    }

    @Override
    public List<Deal> getDealsByBuyerId(Long buyerId) {
        return dealRepository.findByBuyerId(buyerId);
    }

    @Override
    public Deal getDealById(Long id) {
        var deal = dealRepository.findById(id);
        if (deal.isPresent()) {
            return deal.get();
        } else {
            throw new NoSuchElementException("Deal not found.");
        }
    }

    @Override
    public void updateDeal(Long id, Deal updatedDeal) {
        updatedDeal.setId(id);
        var deal = dealRepository.findById(id).get();
        updatedDeal.setSellerId(deal.getSellerId());
        updatedDeal.setBuyerId(deal.getBuyerId());
        updatedDeal.setProductId(deal.getProductId());
        updatedDeal.setDealDate(deal.getDealDate());
        updatedDeal.setDealPrice(deal.getDealPrice());
        updatedDeal.setCurrency(deal.getCurrency());
        dealRepository.save(updatedDeal);
    }

    @Override
    public void deleteDeal(Long id) {
        dealRepository.deleteById(id);
    }
}