package auctionbn.compo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import auctionbn.compo.entity.Auction;

public interface AuctionItemDao {
    Integer getAuctionSize();

    Page<Auction> getAuctions(Integer pageSize, Integer page);
    Page<Auction> getAuctions(String name, Pageable page);
    Page<Auction> getAuctions(Double name, Pageable page);

    Auction getAuction(Long id);

    Auction save(Auction event);
}
