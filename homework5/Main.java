package homework5;

import java.util.Arrays;
import java.util.Scanner;
import homework5.RobotMap.Direction;

public class Main {

    // Client <-> API <-> Model
    // Client_2

    public static void main(String[] args) {
        // 1.
        // Карта с каким-то размером n x m.
        // На ней можно создать робов, указывая начальное положение.
        // Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то кидаем исключение.
        // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять направление и передвигать их на 1 шаг вперед
        // 2.
        // Написать контроллер к этому коду, который будет выступать посредником между консолью (пользователем) и этой игрой.
        // (0,0)      ------------------            (0, m)
        // ...
        // (n, 0)    -----------------------        (n, m)

        // Robot, Map, Point

        // Домашнее задание:
        // Реализовать чтение команд с консоли и выполнить их в main методе
        // Список команд:
        // create-map 3 5 -- РЕАЛИЗОВАНО!
        // create-robot 2 7
        // move-robot id
        // change-direction id LEFT

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = null;
        while (true) {
            String command = sc.nextLine();
            if (command.equals("exit")) {
                break;
            } else if (command.startsWith("create-map")) {
                String[] split = command.split(" "); // [create-map 3 5]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    System.out.println("Введите команду для создания робота:");
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else if (command.startsWith("create-robot")) {
                String[] split = command.split(" "); // [create-robot 2 7]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [2 7]

                try {
                    RobotMap.Robot robot = map.createRobot(new Point(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1])));
                    System.out.println(robot.toString());
                    System.out.println("Вводите команды для движения робота или смены направления его движения, а также создания нового робота:");
                } catch (NullPointerException e) {
                    System.out.println("Cоздайте карту: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                } catch (PositionException e) {
                    System.out.println("При создании робота возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else if (command.startsWith("move-robot")) {
                String[] split = command.split(" "); // [move-robot id]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [id]

                try {
                    for (RobotMap.Robot robot: map){
                        if (robot.getId().toString().startsWith(arguments[0])) {
                            robot.move();
                            System.out.println(robot.toString());
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Cоздайте карту: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                } catch (PositionException e) {
                    System.out.println("При перемещении робота возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else if (command.startsWith("change-direction")) {
                String[] split = command.split(" "); // [change-direction id LEFT]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [id LEFT]

                try {
                    for (RobotMap.Robot robot: map){
                        if (robot.getId().toString().startsWith(arguments[0])) {
                            robot.changeDirection(Direction.valueOf(arguments[1]));
                            System.out.println(robot.toString());
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Cоздайте карту: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                } catch (IllegalArgumentException e) {
                    System.out.println("При смене направления движения робота возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }
        
        sc.close();

    }

}
