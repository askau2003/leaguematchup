package com.leaguematchup.leaguematchup.Controller;

import com.leaguematchup.leaguematchup.Model.Matchups;
import com.leaguematchup.leaguematchup.Service.MatchupsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final MatchupsService matchupsService;

    @Autowired
    public HomeController(MatchupsService matchupsService) {
        this.matchupsService = matchupsService;
    }


    // Standard forside
    @GetMapping("/")
    public String homepage(Model model) {

        List<String> matchupList = matchupsService.championsWithMatchups();
        model.addAttribute("matchupList", matchupList);

        return "homepage";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/search")
    public String searchChampion(@RequestParam("championName") String championName, Model model) {

        // Sætter det første bogstav til at være UpperCase og resterende til at være LowerCase
        String formateretChampionName = championName.substring(0, 1).toUpperCase() + championName.substring(1).toLowerCase();

        List<Matchups> matchupsList = matchupsService.selectMatchup(championName);
        model.addAttribute("matchupsList", matchupsList);
        model.addAttribute("championName", formateretChampionName);
        return "championPage";
    }

    @GetMapping("/updateNote/{matchup_id}")
    public String updateNote(@PathVariable("matchup_id") int matchup_id,Model model) {
        model.addAttribute("matchup",matchupsService.findMatchupByID(matchup_id));
        return "updateNote";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Matchups matchups) {
        matchupsService.editNote(matchups);
        return "redirect:";
    }
}
