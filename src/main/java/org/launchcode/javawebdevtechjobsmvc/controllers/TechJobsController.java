package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    static HashMap<String, String> actionChoices = new HashMap<>();

    public TechJobsController () {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
    }


    @ModelAttribute("actions")
    public static String getActionChoices(Model model) {
        model.addAttribute("search", "Search");
        model.addAttribute("list", "List");
        return "actions";
    }
}
