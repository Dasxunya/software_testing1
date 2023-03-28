package part3;

public class MuscleMovement {
    private final String type;
    private final String bodyPart;

    public MuscleMovement(String type, String bodyPart) {
        this.type = type;
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "(правильная последовательность: " + this.type + " " + this.bodyPart + ")";
    }
}
