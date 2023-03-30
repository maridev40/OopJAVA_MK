package homework6.Commands;

import java.util.UUID;

import homework6.CommandHandler;
import homework6.RobotMap;

public class MoveRobotCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "move-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) throws Exception {
        UUID robotId = UUID.fromString(args[0]);

        RobotMap.Robot robotById = map.findRobotById(robotId);
        if (robotById != null) {
            robotById.move();
            System.out.println(robotById.toString());
        } else {
            System.out.println("Робот с идентификатором " + robotId + " не найден");
        }

    }
    
}
