package jp.command.command;

import java.util.Stack;

public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        // TODO Auto-generated method stub
       commands.forEach(command -> command.execute());
    }
    
    public void appand(Command cmd) {
        // 自身を追加するとexecuteで無限ループするため
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    public void undo() {
        if (!commands.empty()) {
            commands.pop();
        }
    }
    public void clear() {
        commands.clear();
    }
}