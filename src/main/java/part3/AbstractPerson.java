package part3;

import java.util.Objects;

public abstract class AbstractPerson implements Capability {
    private String race;

    protected AbstractPerson() {
    }

    public void setRace(String zone) {
        if (Objects.equals(zone, "Vogon")) this.race = "соплеменник Вогона";
        else this.race = "чужак Вогона";
    }

    public String getRace() {
        return race;
    }
}
