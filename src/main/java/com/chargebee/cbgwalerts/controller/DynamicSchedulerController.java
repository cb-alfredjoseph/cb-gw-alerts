package com.chargebee.cbgwalerts.controller;


import com.chargebee.cbgwalerts.configuration.DynamicSchedulerConfiguration;
import com.chargebee.cbgwalerts.entity.DynamicScheduler;
import com.chargebee.cbgwalerts.service.DynamicSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DynamicSchedulerController {


    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;

    @Autowired
    private DynamicSchedulerConfiguration dynamicSchedulerConfiguration;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listSchedulers", dynamicSchedulerService.getAllSchedulers());
        return "index";
    }

    /*@GetMapping("/newSchedulerForm")
    public String newSchedulerForm(Model model){
        //creating model attribute to bind form data
        DynamicScheduler dynamicScheduler = new DynamicScheduler();
        model.addAttribute("dynamicScheduler" , dynamicScheduler);
        return "new-scheduler";
    }

    @PostMapping("/saveScheduler")
    public String saveScheduler(@ModelAttribute("dynamicScheduler") DynamicScheduler dynamicScheduler){
        // save scheduler to database
        dynamicSchedulerService.saveScheduler(dynamicScheduler);
        //dynamicSchedulerConfiguration.fixedDelay();
        return "redirect:/";
    }*/

    @GetMapping("/newSchedulerForm")
    public String getForm(Model model){
        DynamicScheduler dynamicScheduler=new DynamicScheduler();
        model.addAttribute("dynamicScheduler",dynamicScheduler);
        return "new-scheduler";
    }
    @PostMapping("/register")
    public String postForm(@ModelAttribute("dynamicScheduler")DynamicScheduler dynamicScheduler){

        dynamicScheduler=dynamicSchedulerService.configureDelayTime(dynamicScheduler);
        dynamicSchedulerService.saveScheduler(dynamicScheduler);


        return "redirect:/";
    }

}
