package auctionbn.compo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import auctionbn.compo.entity.Auction;
import auctionbn.compo.service.AuctionService;
import auctionbn.compo.util.LabMapper;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuctionController {
    final AuctionService auctionService;

    @GetMapping("auctions")
    public ResponseEntity<?> getAuctionLists(@RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Auction> pageOutput;
        if (title == null) {
            pageOutput = auctionService.getAuctions(perPage, page);
        // } else if(StringUtils.isNumeric(title)){
        //     pageOutput = auctionService.getAuctions(title, PageRequest.of(page - 1, perPage));
        } else {
            pageOutput = auctionService.getAuctions(title, PageRequest.of(page - 1, perPage));

        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionDto(pageOutput.getContent()), responseHeader,
                HttpStatus.OK);

    }

    @GetMapping("auctions/{id}")
    public ResponseEntity<?> getAuction(@PathVariable("id") Long id) {
        Auction output = auctionService.getAuction(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The givenid is not found");

        }
    }

    // @PostMapping("/auctions")
    // public ResponseEntity<?> addAuction(@RequestBody Auction Auction) {
    // Auction output = auctionService.save(Auction);
    // return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionDto(output));
    // }

}
