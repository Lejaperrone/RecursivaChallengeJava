package repository;

import model.Fan;
import model.Team;

import java.util.*;
import java.util.stream.Collectors;

public final class TeamRepository {

    private static TeamRepository instance;

    private List<Team> teams = new ArrayList<Team>();

    public static TeamRepository getInstance() {
        if (instance == null) {
            instance = new TeamRepository();
        }
        return instance;
    }

    public int getAgeAverageFrom(String teamName) {

        List<Fan> fans = getFansByTeam(teamName);

        int membersAgeSum = fans.stream().map(Fan::getAge).mapToInt(Integer::intValue).sum();
        int numberOfMembers = fans.size();

        return Math.floorDiv(membersAgeSum, numberOfMembers);
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Team getTeamByName(String name) {
        List<Team> teams = this.teams.stream().filter((team) -> team.getName().equals(name)).collect(Collectors.toList());
        if(!teams.isEmpty()) {
            return teams.get(0);
        }
        return null;
    }

    public List<String> getFiveMoreCommonNamesByTeam(String teamName) {

        List<String> teamFansName = getFansByTeam(teamName).stream().map(fan -> fan.getName()).collect(Collectors.toList());

        teamFansName.sort((fanName1, fanName2) -> Collections.frequency(teamFansName, fanName1) > Collections.frequency(teamFansName, fanName2) ? 0 : 1);

        Set<String> teamFansUniques = new LinkedHashSet<>(teamFansName);

        List<String> finalTeams = new ArrayList<>(teamFansUniques);

        return finalTeams.subList(0, 5);
    }

    public List<Fan> getFansByTeam(String teamName) {
        Team team = getTeamByName(teamName);
        return team.getFans();
    }

    public List<Team> getTeamsOrderByNumberOfFans() {

        List<Team> teamsAux = new ArrayList<>(teams);

        teamsAux.sort((team1, team2) -> team1.getNumberOfMembers() > team2.getNumberOfMembers() ? -1 : team1.getNumberOfMembers() == team2.getNumberOfMembers() ? 0 : 1);

        return teamsAux;
    }


    public int getMinAgeFrom(String teamName) {
        List<Fan> fans = getFansByTeam(teamName);

        return fans.stream().min((fan1, fan2) -> Integer.compare(fan1.getAge(), fan2.getAge())).get().getAge();
    }

    public int getMaxAgeFrom(String teamName) {
        List<Fan> fans = getFansByTeam(teamName);

        return fans.stream().max((fan1, fan2) -> Integer.compare(fan1.getAge(), fan2.getAge())).get().getAge();
    }
}
