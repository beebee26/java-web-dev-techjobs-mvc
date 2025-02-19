package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @RequestMapping(value="results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm, @RequestParam String searchType){
        ArrayList<Job> jobs;

        model.addAttribute("columns", columnChoices);

        if (searchTerm.equals("")){
            jobs=JobData.findAll();
        }
        else{
            jobs=(JobData.findByColumnAndValue(searchType,searchTerm));
        }
        model.addAttribute("jobs",jobs);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchTerm", searchTerm);

        return "search";
    }
}
