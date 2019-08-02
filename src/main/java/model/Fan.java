package model;

import repository.FanRepository;

import java.util.Comparator;

public class Fan {

    public Fan(String name, int age, Team team, String civilStatus, String studies) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.studies = studies;
        this.civilStatus = civilStatus;
        this.fanRepository = FanRepository.getInstance();
        fanRepository.addMember(this);
    }

    private String name;

    private int age;

    private Team team;

    private String studies;

    private String civilStatus;

    private FanRepository fanRepository;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public static Comparator<Fan> ageComparator = new Comparator<Fan>() {
        public int compare(Fan fan1, Fan fan2) {
            return fan1.getAge() - fan2.getAge();
        }
    };
}
