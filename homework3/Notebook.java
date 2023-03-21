package homework3;

public class Notebook implements Comparable<Notebook>{
    private static int guid = 0;
    int id;
    int cost;
    int ramSize;

    public Notebook(int cost, int ramSize) {
        this.cost = cost;
        this.ramSize = ramSize;
        this.id = ++guid;
    }

    @Override
    public String toString() {
        return String.format("{id=%d cost=%d RAM=%d}", this.id, this.cost, this.ramSize);
    }

    @Override
    public int compareTo(Notebook o) {
        return cost - o.cost;
    }   
}
