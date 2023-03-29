package part3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vogon extends AbstractPerson {
    private final String name;
    private final String species;
    private final String location;

    private final ShoutSeries shoutSeries;
    private Smile smile;

    private final Set<MuscleMovement> muscleMovements = new HashSet<>();

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

    public void setSmiling(Smile smile) {
        this.smile = smile;
    }

    public String getState() {
        if (!shoutSeries.getRelax().contains("не") || !smile.getSpeed().contains("медленно") || !smile.getReason().contains("не мог")) {
            return "расстроен";
        } else return "доволен";
    }

    public void addMovement(MuscleMovement muscleMovement) {
        if (muscleMovement == null) {
            throw new UnsupportedOperationException("Не обнаружено движений мышц");
        } else muscleMovements.add(muscleMovement);
    }

    public Set<MuscleMovement> getMovements(){
        return muscleMovements;
    }

}
