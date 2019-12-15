package com.example.auction.controller;

import com.example.auction.model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.auction.repository.SearchRepository;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchRepository searchRepository;

    //Not needed in search
//    @GetMapping
//    public String home(Map<String, Object> model) {
//        List<Message> messages = searchRepository.findAll();
//        model.put("Messages", messages);
//        return "search";
//    }

    //Adding a new text and tag
    @GetMapping("/find")   //"/find"
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "search";
    }

//    @PostMapping("/find")
//    public String add(
//                      @AuthenticationPrincipal User user,
//                      @RequestParam String text,
//                      @RequestParam String tag, Map<String, Object> model){
//        Message message = new Message(text, tag, user);
//        searchRepository.save(message);
//        List<Message> messages = searchRepository.findAll();
//        model.put("Messages", messages);
//        return "search";
//    }

    //Searching and filtering
    @PostMapping("/find") //"/find"
    public String filter(@RequestParam String filter, Map<String, Object> model){
        List<Auction> auctions;
        if(filter != null && !filter.isEmpty()) {
            auctions = searchRepository.findByName(filter);
        } else {
            auctions = searchRepository.findAll();
        }
        model.put("auctions", auctions);
    return "search";
    }

    // Show all messages from DB in a searchlist without manually searching
    @GetMapping("/filter")
    public String getAllAuctions(Model model){
        List<Auction> auctions = searchRepository.findAll();
        model.addAttribute("auctions", auctions);
        return "search";
    }

    @GetMapping("/{id}")
    public String auctionEditForm(@PathVariable("id") Integer auctionId, Model model) {
        Auction auction = searchRepository.findAuctionById(auctionId);
        model.addAttribute("auction", auction);
        return "auction";
    }

    @GetMapping("/category/{category}")
    public String auctionCategorySearch(@PathVariable("category") String category, Model model) {
        List<Auction> auctions = searchRepository.findAuctionByCategory(category);
        model.addAttribute("auction", auctions);
//        model.addAttribute("roles", Role.values());
        return "category";
    }


}
