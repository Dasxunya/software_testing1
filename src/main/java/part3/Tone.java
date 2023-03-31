package part3;

public enum Tone {
    HIGH("высокий"),
    LOW("низкий"),

    MIDDLE("средний"),
    OVER_HIGH("наивысший"),
    OVER_LOW("очень низкий");
    private final String description;

    Tone(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
