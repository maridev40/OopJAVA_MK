package homework6;

import java.util.Arrays;
import java.util.List;

import homework6.Executions.CommandExecutionException;

public class CommandManager {

    private RobotMap map;
    private List<CommandHandler> handlers;

    public CommandManager(RobotMap map, List<CommandHandler> handlers) {
        this.map = map;
        this.handlers = handlers;
    }

    public void handleCommand(String command) throws Exception {
        String[] split = command.split(" ");
        String commandName = split[0];
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        for (CommandHandler handler : handlers) {
            if (commandName.equals(handler.commandName())) {
                handler.handleCommand(map, arguments);
                return;
            }
        }
        throw new CommandExecutionException("Команда '" + command + "' не найдена. Попробуйте еще раз");
    }

}
