package homework4;


/* 
Есть классы: GoldenApple -> Apple -> Fruit
Orange -> Fruit
Есть класс Box. Нужно:
1. Организовать его так, чтобы он мог хранить только фрукты какого-то типа
2. Реализовать методы добавления фрукта, пересыпания в другую коробку, получение сумарного веса
Ограничения:
В коробку с апельсинами нельзя добавить яблоки
В коробку с золотыми яблоками нельзя добавить апельсины и яблоки
Пересыпать из коробки с золотыми яблоками в коробку с яблоками можно!
3.* Реализовать итерируемость по коробке
*/

public class Main {

    public static void main(String[] args) {

        // Box<String> stringBox = new Box<>(); // не работает
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<GoldenApple> goldenAppleBox = new Box<>();

        appleBox.add(() -> new Apple(1));
        // appleBox.add(() -> new Orange(1)); // не работает
        appleBox.add(() -> new GoldenApple(4));
        System.out.println(appleBox.getWeight()); // 5

        // goldenAppleBox.add(() -> new Apple(2)); // не работает
        goldenAppleBox.add(() -> new GoldenApple(2));
        System.out.println(goldenAppleBox.getWeight()); // 2

        goldenAppleBox.moveTo(appleBox);
        System.out.println(goldenAppleBox.getWeight()); // 0
        System.out.println(appleBox.getWeight()); // 7

        for(Fruit item: appleBox) {
            System.out.println(item);
        }
    }
    
}
