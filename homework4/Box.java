package homework4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class Box<T extends Fruit> implements Iterable<T>{
    private List<T> list;

    public Box() {
        List<T> list = new ArrayList<>();
        this.list = list;
    }

    public void add(Supplier<T> supplier) {
        T t = (T) supplier.get();
        list.add(t);
    }

    public int getWeight() {
        int sum = 0;
        for(T item: this.list){
            sum += item.getWeight();
        }
        return sum;
    }

    public void moveTo(Box<? super T> box){
        for (T item: this.list) {
            ((Box<? super T>) box).add(() -> item);
        }
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
