package homework3;

import java.util.Comparator;

public class MyIntComparator implements Comparator<Notebook>{

    @Override
    public int compare(Notebook o1, Notebook o2) {
        // ramSize
        if (o1.ramSize < o2.ramSize) {
            return 1;
        } else if (o1.ramSize > o2.ramSize) {
            return -1;
        }

        // o1.ramSize == o2.ramSize
        // cost
        if (o1.cost < o2.cost) {
            return 1;
        } else if (o1.cost > o2.cost) {
            return -1;
        }

        return 0;
    }
    
}
