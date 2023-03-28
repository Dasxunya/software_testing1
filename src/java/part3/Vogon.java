package part3;

public class Vogon extends AbstractPerson {
    private final String name;
    private final String species;
    private final String location;

    private final ShoutSeries shoutSeries;
    private Smile smile;

    public Vogon(String name, ShoutSeries shoutSeries, Smile smile) {
        this.name = name;
        this.shoutSeries = shoutSeries;
        this.smile = smile;
        this.species = "Вожак";
        this.location = "Vogon";
    }

    @Override
    public String action() {
        return "пребывает у дома " + this.location;
    }

    @Override
    public String influence() {
        return "Статус: " + this.species;
    }

    public String getName() {
        return this.name;
    }

    public void setSmiling(Smile smile){
        this.smile = smile;
    }
    public String getState() {
        if (!shoutSeries.getRelax().contains("не") || !smile.getSpeed().contains("медленно") || !smile.getReason().contains("не мог")){
            return "расстроен";
        } else return "доволен";
    }

}
