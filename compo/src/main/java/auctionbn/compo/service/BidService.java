package auctionbn.compo.service;

import org.springframework.data.domain.Page;

import auctionbn.compo.entity.Bid;


public interface BidService {
    Integer getBidSize();

    Page<Bid> getBids(Integer pageSize, Integer page);

    Bid getBid(Long id);

    Bid save(Bid bid);
}