public class Vogon extends AbstractPerson {
    private final String name;
    private final String species;
    private final String location;

    private final ShoutSeries shoutSeries;
    private final Smile smile;

    public Vogon(String name, ShoutSeries shoutSeries, Smile smile) {
        this.name = name;
        this.shoutSeries = shoutSeries;
        this.smile = smile;
        this.species = "Вожак";
        this.location = "Vogon";
    }

    @Override
    public String action() {
        return "пребывает на планете" + this.location;
    }

    @Override
    public String influence() {
        return "Статус: " + this.species;
    }

    public String getName() {
        return this.name;
    }

    public String state() {
        if (!shoutSeries.getRelax().contains("не") && smile.getSpeed().contains("медленно") && smile.getReason().contains("не мог")){
            return "расстроен";
        } else return "доволен";
    }

}
