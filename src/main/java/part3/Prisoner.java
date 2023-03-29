package part3;

public class Prisoner extends AbstractPerson{
    private int quantity;
    private String condition;
    private String location;
    private Integer mood = 100;
    // и другие свойства

    public Prisoner(int quantity, String condition, String location) {
        this.quantity = quantity;
        this.condition = condition;
        this.location = location;
    }

    @Override
    public String action() {
        this.mood = this.mood - 10;
        return "находится в плену";
    }

    @Override
    public String influence() {
        return "Статус обнулен";
    }

    public int getMood(){
        return this.mood;
    }

}
