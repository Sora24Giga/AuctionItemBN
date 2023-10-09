package auctionbn.compo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import auctionbn.compo.entity.Bid;
import auctionbn.compo.repository.BidRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class BidDaoDbImpl implements BidDao {
    final BidRepository bidRepository;

    @Override
    public Integer getBidSize() {
        return Math.toIntExact(bidRepository.count());
    }

    @Override
    public Page<Bid> getBids(Integer pageSize, Integer page) {
        if (pageSize != null && page != null) {
            return bidRepository.findAll(PageRequest.of(page - 1, pageSize));
        }
        return bidRepository.findAll(PageRequest.of(0, getBidSize()));
    }

    @Override
    public Bid getBid(Long id) {
        return bidRepository.findById(id).orElse(null);
    }

    @Override
    public Bid save(Bid Bid) {
        return bidRepository.save(Bid);
    }

}
