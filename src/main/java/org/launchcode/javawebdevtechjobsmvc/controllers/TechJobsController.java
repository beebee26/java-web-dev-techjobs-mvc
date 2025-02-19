package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    static HashMap<String, String> columnChoices = new HashMap<>();
    static HashMap<String, String> actionChoices = new HashMap<>();
    static String home = "TechJobs";

    public TechJobsController () {
        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");

        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
    }


    @ModelAttribute("actions")
    public static String getActionChoices(Model model) {
        model.addAttribute("actions", actionChoices);
        return "actions";
    }

    @ModelAttribute("homeLink")
    public static String getHomeLink(Model model) {
        model.addAttribute("homeLink", home);
        return "homeLink";
    }
}
