package auctionbn.compo.config;

import java.util.ArrayList;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.w3c.dom.events.Event;

import auctionbn.compo.entity.Auction;
import auctionbn.compo.entity.Bid;
import auctionbn.compo.repository.AuctionRepository;
import auctionbn.compo.repository.BidRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class init implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionRepository auctionRepository;
    final BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Auction auc1, auc2, auc3, auc4, auc5;
        auc1 = auctionRepository.save(Auction.builder()
                .description("TOP G").type("white").build());
        auc2 = auctionRepository.save(Auction.builder()
                .description("CAMT").type("black").build());
        auc3 = auctionRepository.save(Auction.builder()
                .description("Tate").type("green").build());
        auc4 = auctionRepository.save(Auction.builder()
                .description("Adison poomung").type("blue").build());
        auc5 = auctionRepository.save(Auction.builder()
                .description("Chad").type("rainbow").build());
        // 1
        Bid tempBid;
        tempBid = bidRepository.save(Bid.builder()
                .amount(1000L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc1);
        auc1.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(800L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc1);
        auc1.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(1200L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc1);
        auc1.getAllBid().add(tempBid);
        auc1.setWonBid(tempBid);
        // 2
        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc2);
        auc2.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc2);
        auc2.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(5000L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc2);
        auc2.getAllBid().add(tempBid);
        auc2.setWonBid(tempBid);
        // 3
        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc3);
        auc3.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc3);
        auc3.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(1500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc3);
        auc3.getAllBid().add(tempBid);
        auc3.setWonBid(tempBid);
        // 4
        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc4);
        auc4.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc4);
        auc4.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(1500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc4);
        auc4.getAllBid().add(tempBid);
        auc4.setWonBid(tempBid);
         // 5
        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc5);
        auc5.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc5);
        auc5.getAllBid().add(tempBid);

        tempBid = bidRepository.save(Bid.builder()
                .amount(1500L)
                .datetime("2/10")
                .build());
        tempBid.setItem(auc5);
        auc5.getAllBid().add(tempBid);
        auc5.setWonBid(tempBid);

    }
}
