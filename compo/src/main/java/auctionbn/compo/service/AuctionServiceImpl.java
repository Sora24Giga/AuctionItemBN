package auctionbn.compo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import auctionbn.compo.dao.AuctionItemDao;
import auctionbn.compo.entity.Auction;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {
    final AuctionItemDao auctionDao;

    @Override
    public Integer getAuctionSize() {
        return auctionDao.getAuctionSize();
    }

    @Override
    public Page<Auction> getAuctions(Integer pageSize, Integer page) {
        return auctionDao.getAuctions(pageSize, page);
    }

    @Override
    public Auction getAuction(Long id) {
        return auctionDao.getAuction(id);
    }

    // @Override
    // @Transactional
    // public Auction save(Auction auction) {
    //     Bid organizer = organizerDao.getOrganizer(auction.getOrganizer().getId());
    //     auction.setOrganizer(organizer);
    //     organizer.getOwnAuctions().add(auction);

    //     return auctionDao.save(auction);
    // }

    @Override
    public Page<Auction> getAuctions(String title, Pageable pageable) {
        return auctionDao.getAuctions(title, pageable);
    }

    @Override
    public Page<Auction> getAuctions(Double title, Pageable pageable) {
        return auctionDao.getAuctions(title, pageable);
    }

}
