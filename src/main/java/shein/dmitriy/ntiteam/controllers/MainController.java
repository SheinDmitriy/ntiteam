package shein.dmitriy.ntiteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shein.dmitriy.ntiteam.entitys.Governor;
import shein.dmitriy.ntiteam.entitys.Planet;
import shein.dmitriy.ntiteam.services.GovernorService;
import shein.dmitriy.ntiteam.services.PlanetService;

@Controller
@RequestMapping(value = "/")
public class MainController {
    private GovernorService governorService;
    private PlanetService planetService;

    @Autowired
    public MainController(GovernorService governorService, PlanetService planetService) {
        this.governorService = governorService;
        this.planetService = planetService;
    }

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("governors", governorService.findAll());
        model.addAttribute("planets", planetService.findAll());
        model.addAttribute("governor", new Governor());
        model.addAttribute("planet", new Planet());
        return "main";
    }

    @PostMapping("/addGover")
    public String addGovernor(Governor governor){
        governorService.save(governor);
        return "redirect:/";
    }

    @PostMapping("/addPlanet")
    public String addPlanet(Planet planet){
        planetService.save(planet);
        return "redirect:/";
    }

    @PostMapping("/chooseGover")
    public String chooseGovernor(Governor governor, Planet planet){
        planetService.choose(governor, planet);
        return "redirect:/";
    }
}
