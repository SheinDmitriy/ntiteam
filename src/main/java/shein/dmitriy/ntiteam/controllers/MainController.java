package shein.dmitriy.ntiteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.ntiteam.entitys.SystemGover;
import shein.dmitriy.ntiteam.services.GovernorService;

@Controller
@RequestMapping(value = "/")
public class MainController {
    private GovernorService governorService;

    @Autowired
    public MainController(GovernorService governorService) {
        this.governorService = governorService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("governors", governorService.findAll());
        model.addAttribute("systemGover", new SystemGover());
        return "main";
    }

    @PostMapping("/addGover")
    public String addGovernor(SystemGover systemGover){
        governorService.save(systemGover);
        return "redirect:/";
    }
}
