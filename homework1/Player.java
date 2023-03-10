package homework1;

public class Player {

    private static long guid = 0;
    private long id;

    private String name;
    private double damage = 10;
    private double healthPoint = 100;

    public Player (String name, double damage, double healthPoint) {
        this.name = name;
        this.damage = damage;
        this.healthPoint = healthPoint;
        this.id = ++guid;
    }

    public void Attack (Player player) {
        if (healthPoint - damage > 0) {
            healthPoint -= damage;
        } else {
            healthPoint = 0;
        }
    }

    public boolean isAlive () {
        return healthPoint > 0;
    }
    
    @Override
    public String toString() {
        return name + "{id=" + this.id + ", damage=" + damage + ", healthPoint=" + healthPoint + "}";
    }

}