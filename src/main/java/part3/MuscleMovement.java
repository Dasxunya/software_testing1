package part3;

public class MuscleMovement {
    private final Speed type;
    private final String bodyPart;

    public MuscleMovement(Speed type, String bodyPart) {
        this.type = type;
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "(правильная последовательность: " + this.type.getDescription() + " " + this.bodyPart + ")";
    }
}
