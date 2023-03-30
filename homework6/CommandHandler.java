package homework6;

public interface CommandHandler {
    String commandName();
	void handleCommand(RobotMap map, String[] args) throws Exception;
}