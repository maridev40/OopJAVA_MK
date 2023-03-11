package homework2;

public class Building implements HasHealthPoint {

    private final int maxHasHealthPoint;
    private int currentHasHealthPoint;

    public Building(int maxHasHealthPoint, int currentHasHealthPoint) {
        this.maxHasHealthPoint = maxHasHealthPoint;
        this.currentHasHealthPoint = currentHasHealthPoint;
    }

    @Override
    public int getMaxHealthPoint() {
        return maxHasHealthPoint;
    }

    @Override
    public int getCurrentHealthPoint() {
        return currentHasHealthPoint;
    }
    
}
