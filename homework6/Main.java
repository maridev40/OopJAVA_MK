package homework6;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import homework6.Commands.ChangeDirectionCommandHandler;
import homework6.Commands.CreateRobotCommandHandler;
import homework6.Commands.MoveRobotCommandHandler;

public class Main {

    // Client <-> API <-> Model
    // Client_2

    public static void main(String[] args) {
        // 1.
        // Карта с каким-то размером n x m.
        // На ней можно создать робов, указывая начальное положение.
        // Если начальное положение некорректное ИЛИ эта позиция занята другим робом, то
        // кидаем исключение.
        // Робот имеет направление (вверх, вправо, вниз, влево). У роботов можно менять
        // направление и передвигать их на 1 шаг вперед
        // 2.
        // Написать контроллер к этому коду, который будет выступать посредником между
        // консолью (пользователем) и этой игрой.
        // (0,0) ------------------ (0, m)
        // ...
        // (n, 0) ----------------------- (n, m)

        // Robot, Map, Point

        // Домашнее задание:
        // Реализовать чтение команд с консоли и выполнить их в main методе
        // Список команд:
        // create-map 3 5
        // create-robot 2 7
        // move-robot id
        // change-direction id LEFT

        // Реализовать обработчики команд CommandHandler по заданному списку команд

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = null;
        boolean next = true;
        while (next) {
            String command = sc.nextLine();
            if (command.equals("exit")) {
                next = false;
            } else if (command.startsWith("create-map")) {
                String[] split = command.split(" "); // [create-map 3 5]
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); // [3 5]

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    System.out.println("Введите команду для создания робота:");
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                    " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }

        List<CommandHandler> handlers = List.of(
                new ChangeDirectionCommandHandler(),
                new CreateRobotCommandHandler(),
                new MoveRobotCommandHandler());

        CommandManager commandManager = new CommandManager(map, handlers);
           
        while (next) {
            String command = sc.nextLine();
            if (command.equals("exit")) {
                next = false;
            } else {
                try {
                    commandManager.handleCommand(command);
                    System.out.println(
                        "Далее вводите команды для движения робота или смены его движения, а также создания нового робота:");    
                } catch (Exception e) {
                    System.out.println("Не удалось обработать команду: " + e);
                }
            }
        }

        sc.close();

    }

}
