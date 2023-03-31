package part3;

import java.util.Objects;

public class ShoutSeries {
    private final int volume;
    private final Tone tone;
    private Boolean isReady;
    private final Smile smile;

    public ShoutSeries(int volume, Tone tone, Smile smile) {
        this.volume = volume;
        this.tone = tone;
        this.smile = smile;
        this.isReady = false;
    }

    public String getRelax(){
        if (!smile.getIsForEffect() && this.volume > 50 && (Objects.equals(this.tone, Tone.HIGH) || Objects.equals(this.tone, Tone.OVER_HIGH))){
            this.isReady = true;
        }
        if(isReady){
            return "теперь чувствовал себя отдохнувшим и готовым к небольшой гнусности";
        } else return "не чувствовал себя отдохнувшим и готовым к небольшой гнусности";
    }

    public int getVolume(){
        return this.volume;
    }

}
