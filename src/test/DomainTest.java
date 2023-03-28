import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainTest {
    static Vogon vogon;
    static Smile smile;
    static ShoutSeries shoutSeries;
    static Prisoner prisoner;
    static MuscleMovement muscleMovement;


    static Smile smileWithParam;
    static Smile unsmile;
    static ShoutSeries lowVolume;
    static ShoutSeries lowTone;


    @BeforeAll
    public static void createAll() {
        prisoner = new Prisoner(5, "пленник", "Земля");
        muscleMovement = new MuscleMovement("энергично", "спина");

        smile = new Smile(false, null, "есть");
        smileWithParam = new Smile(true, "быстрее пули", "просто без причины");
        unsmile = new Smile(true, null, null);

        shoutSeries = new ShoutSeries(60, "высокий", smile);
        lowVolume = new ShoutSeries(20, "высокий", smile);
        lowTone = new ShoutSeries(70, "низкий", smile);

        vogon = new Vogon("Джельц", shoutSeries, smile);
    }

    @Test
    public void toStringTesting() {
        assertEquals("(правильная последовательность: энергично спина)", muscleMovement.toString());
        assertEquals("Он сделал так не ради эффекта", smile.toString());
    }

    @Test
    public void smileTesting() {
        assertEquals("улыбнулся очень медленно", smile.getSpeed());
        assertEquals("не мог вспомнить правильную последовательность движения мышц", smile.getReason());

        assertEquals("стал серьезен быстрее пули", smileWithParam.getSpeed());
        assertEquals("просто без причины", smileWithParam.getReason());

        assertEquals("беспричинно", unsmile.getReason());
        assertEquals("стал серьезен ", unsmile.getSpeed());

        smile.setIsForEffect(true);
        assertEquals("стал серьезен очень медленно", smile.getSpeed());
        assertEquals("не мог вспомнить правильную последовательность движения мышц", smile.getReason());

        smileWithParam.setIsForEffect(false);
        assertEquals("улыбнулся быстрее пули", smileWithParam.getSpeed());
        assertEquals("просто без причины", smileWithParam.getReason());

        unsmile.setIsForEffect(false);
        assertEquals("улыбнулся ", unsmile.getSpeed());
        assertEquals("беспричинно", unsmile.getReason());

    }

    @Test
    public void shoutSeriesTesting() {
        smile.setIsForEffect(false);
        assertEquals(60, shoutSeries.getVolume());
        assertEquals("теперь чувствовал себя отдохнувшим и готовым к небольшой гнусности", shoutSeries.getRelax());

        assertEquals("не чувствовал себя отдохнувшим и готовым к небольшой гнусности", lowTone.getRelax());
        assertEquals("не чувствовал себя отдохнувшим и готовым к небольшой гнусности", lowVolume.getRelax());

    }


    @Test
    public void vogonTesting() {
        assertEquals("Джельц", vogon.getName());
        assertEquals("пребывает у дома Vogon", vogon.action());

        assertNull(vogon.getRace());

        vogon.setRace("Kukunya");
        assertEquals("чужак Вогона", vogon.getRace());
        vogon.setRace("Vogon");
        assertEquals("соплеменник Вогона", vogon.getRace());

        assertEquals("Статус: Вожак", vogon.influence());
    }

    @Test
    public void prisonerTesting() {
        assertEquals("находится в плену", prisoner.action());
        assertEquals("Статус обнулен", prisoner.influence());

        assertNull(prisoner.getRace());

        prisoner.setRace("Umpa-Lumpa");
        assertEquals("чужак Вогона", prisoner.getRace());
    }

    @Test
    public void vogonStateTesting() {
        assertEquals("доволен", vogon.getState());

        vogon.setSmiling(unsmile);
        assertEquals("расстроен", vogon.getState());
        vogon.setSmiling(smileWithParam);
        assertEquals("расстроен", vogon.getState());
        vogon.setSmiling(smile);
        assertEquals("доволен", vogon.getState());
    }
}