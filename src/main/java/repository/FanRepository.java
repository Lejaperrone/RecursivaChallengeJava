package repository;

import model.Fan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class FanRepository {

    private static FanRepository instance;

    private List<Fan> fans = new ArrayList<>();

    public static FanRepository getInstance() {
        if (instance == null) {
            instance = new FanRepository();
        }
        return instance;
    }

    public int getNumberOfMembers() {
        return this.fans.size();
    }

    public void addMember(Fan fan) {
        this.fans.add(fan);
    }

    public List<Fan> getFans() {
        return fans;
    }

    public List<Fan> getFirst100MarriedFansWithUniversityStudies() {

        List<Fan> marriedAndStudents = fans.stream().filter((fan) -> fan.getStudies().equals("Universitario") && fan.getCivilStatus().equals("Casado")).collect(Collectors.toList());
        marriedAndStudents.sort((fan1, fan2) -> fan1.getAge() < fan2.getAge() ? -1 : fan1.getAge() == fan2.getAge() ? 0 : 1);

        return marriedAndStudents.subList(0, 100);
    }
}
