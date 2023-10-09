package auctionbn.compo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import auctionbn.compo.entity.Auction;
import auctionbn.compo.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AuctionDaoDbImpl implements AuctionItemDao {
    final AuctionRepository auctionRepository;

    @Override
    public Integer getAuctionSize() {
        return Math.toIntExact(auctionRepository.count());
    }

    @Override
    public Page<Auction> getAuctions(Integer pageSize, Integer page) {
        return auctionRepository.findAll(PageRequest.of(page - 1, pageSize));

    }

    @Override
    public Auction getAuction(Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @Override
    public Auction save(Auction Auction) {
        return auctionRepository.save(Auction);
    }

    @Override
    public Page<Auction> getAuctions(String title, Pageable page) {
        try {
            return auctionRepository.findByDescriptionContainingIgnoreCaseOrWonBidAmountLessThan(title,
                    Long.parseLong(title), page);
        } catch (NumberFormatException ex) {
            return auctionRepository.findByDescriptionContainingIgnoreCase(title, page);
        }
    }

     @Override
    public Page<Auction> getAuctions(Double title, Pageable page) {
            return auctionRepository.findByWonBidLessThan(title, page);
    }


}
