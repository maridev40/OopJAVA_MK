package homework4;

public abstract class Fruit {
    int weight;

    int getWeight() {
        return weight;
    };

    @Override
    public String toString() {
        return "{class=" + this.getClass().getName() + ", weight=" + weight + "}";
    }    
}
