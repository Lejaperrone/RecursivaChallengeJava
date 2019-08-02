import csvReader.CSVReader;
import model.Fan;
import model.Team;
import repository.FanRepository;
import repository.TeamRepository;

import java.util.List;

public class RecursivaChallenge {

    public static void main(String[] args) {

        CSVReader reader = new CSVReader();

        String csvFileLocation = "socios.csv";

        reader.readDataFrom(csvFileLocation);

        FanRepository fanRepository = FanRepository.getInstance();
        TeamRepository teamRepository = TeamRepository.getInstance();

        System.out.println("Cantidad total de personas registradas");
        System.out.println(fanRepository.getNumberOfMembers());

        System.out.println("Promedio de edad de los socios de Racing");
        System.out.println(teamRepository.getAgeAverageFrom("Racing"));

        System.out.println("Listado con las 100 primeras personas casadas y con estudios universitarios");
        List<Fan> fans = fanRepository.getFirst100MarriedFansWithUniversityStudies();
        fans.forEach((fan) -> System.out.println("Nombre: " + fan.getName() + " Edad: " + fan.getAge() + " Equipo: " + fan.getTeam().getName()));

        System.out.println("Listado con los 5 nombres mas comunes entre los hinchas de River");
        List<String> fans2 = teamRepository.getFiveMoreCommonNamesByTeam("River");
        fans2.forEach((fanName) -> System.out.println("Nombre: " + fanName));

        System.out.println("Listado ordenado de mayor a menor segun cantidad de socios (Equipo - Promedio Edad - Edad Minima - Edad Maxima)");
        List<Team> teams = teamRepository.getTeamsOrderByNumberOfFans();
        teams.forEach((team) -> System.out.println("Equipo: " + team.getName() + " Promedio Edad: " + teamRepository.getAgeAverageFrom(team.getName()) + " Edad Minima: " + teamRepository.getMinAgeFrom("River") + " Edad Maxima " + teamRepository.getMaxAgeFrom("River")));

    }
}