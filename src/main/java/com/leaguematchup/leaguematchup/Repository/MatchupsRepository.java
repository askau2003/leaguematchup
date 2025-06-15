package com.leaguematchup.leaguematchup.Repository;

import com.leaguematchup.leaguematchup.Model.Matchups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchupsRepository {
    @Autowired
    JdbcTemplate template;

    public List<Matchups> selectMatchup(String championName) {
        String sql = "SELECT * FROM matchups WHERE champion = ?";
        RowMapper<Matchups> rowMapper = new BeanPropertyRowMapper<>(Matchups.class);
        return template.query(sql,rowMapper, championName);
    }


    // Used to get a list of champions with existing matchups
    public List<String> championsWithMatchups() {
        String sql = "SELECT champion FROM matchups GROUP BY champion";
        return template.queryForList(sql, String.class);
    }

    public void editNote(Matchups matchups) {
        String sql = "UPDATE matchups SET notes = ? WHERE matchup_id = ?";
        template.update(sql, matchups.getNotes(), matchups.getMatchup_id());
    }

    public Matchups findMatchupByID(int matchup_id) {
        String sql = "SELECT * FROM matchups WHERE matchup_id = ?";
        RowMapper<Matchups> rowMapper = new BeanPropertyRowMapper<>(Matchups.class);
        return template.queryForObject(sql,rowMapper,matchup_id);
    }
}
