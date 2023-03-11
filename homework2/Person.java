package homework2;

public class Person implements HasHealthPoint, Tiredness {

    private final int maxHealthPoint;
    private int currentHealthPoint;
    private final int maxEnergy;
    private int currentEnergy;

    public Person(int maxHealthPoint, int currentHealthPoint, int maxEnergy, int currentEnergy) {
        this.maxHealthPoint = maxHealthPoint;
        this.currentHealthPoint = currentHealthPoint;
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;  
    }

    @Override
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    @Override
    public int getCurrentHealthPoint() {
        return currentHealthPoint;
    }  
    
    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public int getCurrentEnergy() {
        return currentEnergy;
    }
}
