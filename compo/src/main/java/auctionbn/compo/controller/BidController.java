package auctionbn.compo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import auctionbn.compo.entity.Bid;
import auctionbn.compo.service.BidService;
import auctionbn.compo.util.LabMapper;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BidController {
    final BidService bidService;

    @GetMapping("bids")
    public ResponseEntity<?> getBidLists(
            @RequestParam(value = "_limit", required = false) Integer pageSize,
            @RequestParam(value = "_page", required = false) Integer page) {
        HttpHeaders responseHeader = new HttpHeaders();
        Page<Bid> pageOut = bidService.getBids(pageSize, page);
        responseHeader.set("x-total-count", String.valueOf(pageOut.getTotalElements()));
        if (pageOut.getContent().isEmpty()) {
            return new ResponseEntity<>(LabMapper.INSTANCE.getBidDTO(pageOut.getContent()), responseHeader,
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(LabMapper.INSTANCE.getBidDTO(pageOut.getContent()), responseHeader,
                HttpStatus.OK);
    }

    @GetMapping("bids/{id}")
    public ResponseEntity<?> getBid(@PathVariable("id") Long id) {
        Bid output = bidService.getBid(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getBidDTO(output));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bid not found.");
        }
    }

    @PostMapping("/bids")
    public ResponseEntity<?> addBid(@RequestBody Bid bid) {
        Bid output = bidService.save(bid);
        return ResponseEntity.ok(LabMapper.INSTANCE.getBidDTO(output));
    }

}