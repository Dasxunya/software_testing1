import java.util.Objects;

public class Smile {
    private String speed;
    private String reason;
    private final Boolean isForEffect;

    public Smile(Boolean ifForEffect, String speed, String reason) {
        this.isForEffect = ifForEffect;
        this.speed = speed;
        this.reason = reason;

    }

    public Smile(Boolean ifForEffect) {
        this.isForEffect = ifForEffect;
        if (!ifForEffect) {
            this.speed = "очень медленно";
            this.reason = "не мог вспомнить правильную последовательность движения мышц";
        }
    }

    public String getSpeed() {
        if (!isForEffect) {
            return "улыбнулся" + this.speed;
        } else {
            return "стал серьезен" + this.speed;
        }
    }

    public Boolean getIsForEffect() {
        return this.isForEffect;
    }

    public String getReason() {
        return this.reason;
    }

    @Override
    public String toString() {
        if (!this.isForEffect) {
            return "Он сделал так не ради эффекта";
        } else {
            return "Он сделал так ради эффекта";
        }
    }
}
