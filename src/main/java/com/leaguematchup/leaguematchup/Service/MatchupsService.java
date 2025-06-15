package com.leaguematchup.leaguematchup.Service;

import com.leaguematchup.leaguematchup.Model.Matchups;
import com.leaguematchup.leaguematchup.Repository.MatchupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchupsService {
    @Autowired
    MatchupsRepository matchupsRepository;

    public List<Matchups> selectMatchup(String championName) {
        return matchupsRepository.selectMatchup(championName);
    }

    public List<String> championsWithMatchups() {
        return matchupsRepository.championsWithMatchups();
    }

    public void editNote(Matchups matchups) {
        matchupsRepository.editNote(matchups);
    }

    public Matchups findMatchupByID(int matchup_id) {
        return matchupsRepository.findMatchupByID(matchup_id);
    }
}
