package auctionbn.compo.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuctionDTO {

    Long id;
    String description;
    String type;
    List<BidDTO> allBid = new ArrayList<>();
    BidDTO wonBid;

}