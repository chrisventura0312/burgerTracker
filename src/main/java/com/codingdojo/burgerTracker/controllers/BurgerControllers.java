package com.codingdojo.burgerTracker.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





import com.codingdojo.burgerTracker.models.Burger;
import com.codingdojo.burgerTracker.services.BurgerService;

@Controller
public class BurgerControllers {
    @Autowired
    BurgerService burgerService;

    public BurgerControllers(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        model.addAttribute("burger", new Burger());
        return "index.jsp";
    }

    @PostMapping("/create")
    public String create(
        @Valid @ModelAttribute("burger") Burger burger,
        BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            List<Burger> burgers = burgerService.allBurgers(); // Retrieve all burgers from the database
            model.addAttribute("burgers", burgers); // Add the burgers to the model
            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
            return "redirect:/";
        }
        
    }

    @GetMapping("/burgers/edit/{id}")
    public String editBurger(@PathVariable("id") Long id, @ModelAttribute("burger") Burger burger, Model model) {
        model.addAttribute("burger", burgerService.findBurger(id));
        return "edit.jsp";
    }

    @PutMapping("/burgers/edit/{id}")
    public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, 
    @PathVariable("id") Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("burger", burger);
            return "edit.jsp";
        } else {
            burger.setId(id);
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }
}
