class Light{
    public void on(){
        System.out.println("Light is ON");
    }
    public void off(){
        System.out.println("Light is OFF");
    }
}

class AC{
    public void on(){
        System.out.println("AC is ON");
    }
    public void off(){
        System.out.println("AC is OFF");
    }
}

interface Command {
    void execute();
    void undo();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class ACOnCommand implements Command {
    private AC ac;

    public ACOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off();
    }
}

class ACOffCommand implements Command {
    private AC ac;

    public ACOffCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.off();
    }

    @Override
    public void undo() {
        ac.on();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

// ========== Remote control class (Invoker) ==========

class RemoteControl {
    private Command[] buttons = new Command[4];  // Assigning 4 slots for commands
    private Stack<Command> commandHistory = new Stack<>();

    // Assign command to slot
    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
    }

    // Press the button to execute the command
    public void pressButton(int slot) {
        if (buttons[slot] != null) {
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
        } else {
            System.out.println("No command assigned to slot " + slot);
        }
    }

    // Undo the last action
    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
}

public class RemoteCntrolExample {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        AC bedroomAC = new AC();

        // Create command objects
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command acOn = new ACOnCommand(bedroomAC);
        Command acOff = new ACOffCommand(bedroomAC);

        // Assign commands to remote control buttons
        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);
        remote.setCommand(2, acOn);
        remote.setCommand(3, acOff);

        // Simulate button presses
        remote.pressButton(0);  // Turn on the light
        remote.pressButton(2);  // Turn on the AC
        remote.pressUndo();     // Undo last action (turn off AC)
        remote.pressButton(1);  // Turn off the light
    }
}
