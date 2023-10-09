package auctionbn.compo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import auctionbn.compo.entity.Auction;
import auctionbn.compo.entity.AuctionDTO;
import auctionbn.compo.entity.Bid;
import auctionbn.compo.entity.BidDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    AuctionDTO getAuctionDto(Auction auction);

    List<AuctionDTO> getAuctionDto(List<Auction> auctions);

    BidDTO getBidDTO(Bid bid);

    List<BidDTO> getBidDTO(List<Bid> bids);

}
