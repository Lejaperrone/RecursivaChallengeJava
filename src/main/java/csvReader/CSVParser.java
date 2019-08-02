package csvReader;

import model.Fan;
import model.Team;
import repository.TeamRepository;

public class CSVParser {

    public void parse(String[] memberArray) {

        String name = memberArray[0];
        int age = Integer.parseInt(memberArray[1]);
        String studies = memberArray[3];
        String civilStatus = memberArray[4];

        TeamRepository teamRepository = TeamRepository.getInstance();

        Team team = teamRepository.getTeamByName(memberArray[2]);
        if(team == null) {
            team = new Team(memberArray[2]);
        }

        Fan fan = new Fan(name, age, team, studies, civilStatus);

        team.addMember(fan);

    }
}