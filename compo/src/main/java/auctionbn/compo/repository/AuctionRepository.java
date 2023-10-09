package auctionbn.compo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import auctionbn.compo.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findAll();

    Page<Auction> findByDescriptionContainingIgnoreCaseOrWonBidAmountLessThan(String description, Long amount,
            Pageable page);

    Page<Auction> findByDescriptionContainingIgnoreCase(String description,
            Pageable page);

      Page<Auction> findByWonBidLessThan(Double description,
            Pageable page);       
}
