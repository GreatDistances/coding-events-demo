package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventCategoryController {

    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @GetMapping("eventCategories/index")
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("eventCategories/create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute("category", eventCategoryRepository.save(new EventCategory())); // TODO fix ??
        return "eventCategories/create";
    }

    @PostMapping("eventCategories/create")
    public String processCreateEventCategoryForm(@ModelAttribute EventCategory newEventCategory, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute("errorMsg", "Bad data!");
            return "eventCategories/create";
        } else {
            model.addAttribute("newCategory", eventCategoryRepository.save(newEventCategory));
        }
        return "redirect:";
    }


}
