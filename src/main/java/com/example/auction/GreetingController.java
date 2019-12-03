package com.example.auction;

import domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repository.MessageRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepository  messageRepository;

    @GetMapping
    public String home(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("Messages", messages);
        return "home";
    }

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("Messages", messages);
        return "home";
    }
}
