public class Prisoner extends AbstractPerson{
    private int quantity;
    private String condition;
    private String location;
    // и другие свойства

    public Prisoner(int quantity, String condition, String location) {
        this.quantity = quantity;
        this.condition = condition;
        this.location = location;
    }

    @Override
    public String action() {
        return "находится в плену";
    }

    @Override
    public String influence() {
        return "Статус обнулен";
    }

}
