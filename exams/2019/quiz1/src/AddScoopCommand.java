public class AddScoopCommand extends Command{
    private Flavor flavor;
    AddScoopCommand(Flavor flavor){
        this.flavor = flavor;
    }
    public void execute(Icecream icecream){
        icecream.addScoop(flavor);
    }
}
