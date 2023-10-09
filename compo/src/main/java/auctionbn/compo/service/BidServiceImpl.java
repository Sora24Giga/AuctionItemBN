package auctionbn.compo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import auctionbn.compo.dao.BidDao;
import auctionbn.compo.entity.Bid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    final BidDao bidDao;

    @Override
    public Integer getBidSize() {
        return bidDao.getBidSize();
    }

    @Override
    public Page<Bid> getBids(Integer pageSize, Integer page) {
        return bidDao.getBids(pageSize, page);
    }

    @Override
    public Bid getBid(Long id) {
        return bidDao.getBid(id);
    }

    @Override
    public Bid save(Bid bid) {
        return bidDao.save(bid);
    }
}