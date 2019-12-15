package com.example.auction.controller;

import com.example.auction.model.Auction;
import com.example.auction.model.User;
import com.example.auction.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping    //("/home")
public class HomeController {


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
//    @GetMapping("/find")
//    public String greeting(
//            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "search";
//    }

        @GetMapping  //("/home")
        public String greeting(
                @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "home";
        }
     // LAST DELETED THIS
//        @PostMapping("/new")
//        public String add(
//                @AuthenticationPrincipal User user,
//                @RequestParam String text,
//                @RequestParam String tag, Map<String, Object> model){
//            Auction auction = new Auction(text, tag, user);
//            searchRepository.save(auction);
//            List<Auction> auctions = searchRepository.findAll();
//            model.put("Auctions", auctions);
//            return "add";
//        }

        //Searching and filtering
//    @PostMapping("/filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        List<Message> messages;
//        if(filter != null && !filter.isEmpty()) {
//            messages = searchRepository.findByText(filter);
//        } else {
//            messages = searchRepository.findAll();
//        }
//        model.put("messages", messages);
//        return "search";
//    }
//
//    // Show all messages from DB in a searchlist without manually searching
//    @GetMapping("/filter")
//    public String getAllMessages(Model model){
//        List<Message> messages = searchRepository.findAll();
//        model.addAttribute("messages", messages);
//        return "search";
//    }
    }



