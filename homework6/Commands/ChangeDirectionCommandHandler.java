package homework6.Commands;

import java.util.UUID;

import homework6.CommandHandler;
import homework6.RobotMap;

public class ChangeDirectionCommandHandler implements CommandHandler{

    @Override
    public String commandName() {
        return "change-direction";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) throws Exception {
        UUID robotId = UUID.fromString(args[0]);    
        RobotMap.Direction newDirection = RobotMap.Direction.valueOf(args[1]);

        RobotMap.Robot robotById = map.findRobotById(robotId);
        if (robotById != null) {
            robotById.changeDirection(newDirection);
            System.out.println(robotById.toString());
        } else {
            System.out.printf("Робот с идентификатором " + robotId + " не найден");
        }
        
    }
   
}
