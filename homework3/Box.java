package homework3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

 public class Box implements Iterable<Notebook>{

    public List<Notebook> list = new ArrayList<>();

    public Box(int  count) {
        AddRandomNotebooks(count);
    }

    public Box(List<Notebook> list) {
        this.list = list;
    }

    public void AddRandomNotebooks(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(new Notebook(random.nextInt(1000), random.nextInt(64)));
        }
    }

    // В порядке создания списка
    @Override
    public Iterator<Notebook> iterator() {
    return list.iterator();
    }
}
