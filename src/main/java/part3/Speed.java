package part3;

public enum Speed {
    INFANTILE("инфантильно", 0),
    SO_SLOW("очень медленно", 20),
    SLOWLY("медленно", 40),
    FAST("быстро", 60),
    VIGOROUSLY("энергично", 80),
    FASTEST("быстрее пули", 100);

    private final String description;

    private final int equal;

    Speed(String description, int equal) {
        this.description = description;
        this.equal = equal;
    }

    public String getDescription() {
        return description;
    }

    public int getEqual() {
        return equal;
    }
}
