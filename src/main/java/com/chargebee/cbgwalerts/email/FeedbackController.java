package com.chargebee.cbgwalerts.email;

import com.chargebee.cbgwalerts.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private EmailCfg emailCfg;

    @Autowired
    TransactionsRepository transactionsRepository;



    @PostMapping("/send")
    public void sendEmail(@RequestBody SenderDetails request) {
        Map<String, List<User>> model = new HashMap<>();

//        List<User>getList= transactionsRepository.findAll();
////        model.put("Name", request.getName());
////        model.put("location", "Bangalore,India");
//        model.put("user",getList);
//        feedbackService.sendFeedback(request, model);

    }

//    @PostMapping ("/send/{id}")
//    public void findUser(@RequestBody SenderDetails senderDetails,@PathVariable int id)
//    {
//         Optional<List<User>> user=userService.findUser(id);
//         if(user!=null) {
//             Map<String, Optional<List<User>>> model= new HashMap<>();
//             model.put("data",user);
//             feedbackService.sendFeedback(senderDetails,model);
//         }
//
//
//    }

    @GetMapping("/value")
    public void giveValue()
    {
        String host=emailCfg.getHost();
        int port=emailCfg.getPort();
        String username=emailCfg.getUsername();
        String password=emailCfg.getPassword();

        System.out.println(host);
        System.out.println(port);
        System.out.println(username);
        System.out.println(password);

    }
}
