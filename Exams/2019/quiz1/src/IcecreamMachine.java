public class IcecreamMachine {
    private Icecream icecream;
    IcecreamMachine(Icecream icecream){
        this.icecream = icecream;
    }
    public void executeCommand(Command command){
        command.execute(icecream);
    }

    public void undoLastCommand() {
        icecream.undo();
    }
}
