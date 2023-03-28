import java.util.Objects;

public class ShoutSeries {
    private final int volume;
    private final String tone;
    private Boolean isReady;
    private Smile smile;

    public ShoutSeries(int volume, String tone) {
        this.volume = volume;
        this.tone = tone;
        this.isReady = false;
    }

    public String getRelax(){
        if ( !smile.getIsForEffect() && this.volume > 50 && Objects.equals(this.tone, "высокий")){
            this.isReady = true;
        }
        if(isReady){
            return "теперь чувствовал себя отдохнувшим и готовым к небольшой гнусности";
        } else return "не чувствовал себя отдохнувшим и готовым к небольшой гнусности";
    }

}
