package homework6.Commands;

import homework6.Point;
import homework6.CommandHandler;
import homework6.RobotMap;
import homework6.RobotMap.Robot;

public class CreateRobotCommandHandler implements CommandHandler {
    
    @Override
    public String commandName() {
        return "create-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) throws Exception {

        Robot robot = map.createRobot(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
        System.out.println(robot.toString());

    }    
    
}
