package com.leaguematchup.leaguematchup.Model;

public class Matchups {

    private int matchup_id;
    private String champion;
    private String icon;
    private String enemy;
    private String notes;

    public Matchups(String champion, String icon, String enemy, String notes) {
        this.champion = champion;
        this.icon = icon;
        this.enemy = enemy;
        this.notes = notes;
    }

    public Matchups() {
    }

    public int getMatchup_id() {
        return matchup_id;
    }

    public void setMatchup_id(int matchup_id) {
        this.matchup_id = matchup_id;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
