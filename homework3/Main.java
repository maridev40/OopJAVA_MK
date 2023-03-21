package homework3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/*
Создать класс Notebook с полями:
1. Стоимость (int)
2. Оперативная память (int)
Нагенерить объектов этого класса, создать список и отсортировать его в трех вариантах:
1. По возрастанию цены
2. По убыванию цены
3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
4.+ придумать свои параметры и отсортировать по ним
 */

 public class Main {
    public static void main(String[] args) {

        Box box = new Box(100);

        // В порядке создания списка
        System.out.println("В порядке создания списка - FOREACH BOX ITERABLE ITERATOR: ");
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке создания списка
        System.out.println("В порядке создания списка - WHILE BOX ITERABLE ITERATOR: ");
        Iterator<Notebook> it = box.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        // В порядке возрастания стоимости
        System.out.println("В порядке возрастания стоимости - SORT + Notebook COMPARABLE  COMPARETO: ");
        Collections.sort(box.list);
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке убывания id
        System.out.println("В порядке убывания id - LAMBDA: ");
        Comparator<Notebook> intComparator1 = (o1, o2) -> -1 * (o1.id - o2.id);
        Collections.sort(box.list, intComparator1);
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке возрастания объема памяти
        System.out.println("В порядке возрастания объема памяти - SORT + COMPARINGINT + LAMBDA: ");
        Comparator<Notebook> intComparator2 = Comparator.comparingInt(o -> o.ramSize);
        Collections.sort(box.list, intComparator2);
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке возрастания объема памяти
        System.out.println("В порядке возрастания объема памяти - SORT + COMPARINGINT + applyAsInt: ");
        Comparator<Notebook> intComparator3 = Comparator.comparingInt(new ToIntFunction<Notebook>() {
            @Override
            public int applyAsInt(Notebook value) {
                return value.ramSize;
            }
        });
        Collections.sort(box.list, intComparator3);
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке убывания памяти и убывания стоимости
        System.out.println("В порядке убывания памяти и убывания стоимости - MYINTCOMPARATOR: ");
        MyIntComparator intComparator4 = new MyIntComparator();
        Collections.sort(box.list, intComparator4);
        for (Notebook item : box) {
            System.out.println(item.toString());
        }

        // В порядке убывания памяти и убывания стоимости
        System.out.println("В порядке убывания памяти и убывания стоимости - STREAM SORTED MYINTCOMPARATOR: ");
        MyIntComparator intComparator5 = new MyIntComparator();
        List<Notebook> myList = box.list.stream().sorted(intComparator5).collect(Collectors.toList());
        for (Notebook item : myList) {
            System.out.println(item.toString());
        }
            
    }
 }
