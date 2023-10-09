package auctionbn.compo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import auctionbn.compo.entity.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
