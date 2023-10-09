package auctionbn.compo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import auctionbn.compo.entity.Auction;

public interface AuctionService {
    Integer getAuctionSize();

    Page<Auction> getAuctions(Integer pageSize, Integer page);

    Auction getAuction(Long id);

    Page<Auction> getAuctions(Double title, Pageable pageable);

    //Auction save(Auction auction);

    Page<Auction> getAuctions(String title, Pageable pageable);

}