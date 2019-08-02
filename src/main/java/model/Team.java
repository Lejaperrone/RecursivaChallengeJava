package model;

import repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class Team {

    public Team(String name) {
        this.name = name;
        this.teamRepository = TeamRepository.getInstance();
        teamRepository.addTeam(this);
    }

    private String name;

    private List<Fan> fans = new ArrayList<>();

    private TeamRepository teamRepository;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fan> getFans() {
        return fans;
    }

    public void setFans(List<Fan> fans) {
        this.fans = fans;
    }

    public void addMember(Fan fan) {
        this.fans.add(fan);
    }

    public int getNumberOfMembers() {
        return this.fans.size();
    }

}
