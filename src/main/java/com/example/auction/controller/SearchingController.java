package com.example.auction.controller;

import com.example.auction.module.Message;
import com.example.auction.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.auction.repository.SearchRepository;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchingController {

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
    @GetMapping("/find")
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
    @PostMapping("/find")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        List<Message> messages;
        if(filter != null && !filter.isEmpty()) {
            messages = searchRepository.findByText(filter);
        } else {
         messages = searchRepository.findAll();
        }
        model.put("messages", messages);
    return "search";
    }

    // Show all messages from DB in a searchlist without manually searching
    @GetMapping("/filter")
    public String getAllMessages(Model model){
        List<Message> messages = searchRepository.findAll();
        model.addAttribute("messages", messages);
        return "search";
    }
}
