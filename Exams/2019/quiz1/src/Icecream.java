import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Icecream {
    private List<Flavor> scoops;
    Icecream(){
        this.scoops = new ArrayList<>();
    }
    public void addScoop(Flavor flavor){
        scoops.add(flavor);
    }
    public int getScoopCount() {
        return scoops.size();
    }

    public Boolean contains(String name){
        for(Flavor flavor: scoops)
            if(flavor.getName().equals(name)) return true;
        return false;
    }

    public int getFlavorCount(){
        Set<Flavor> flavors = new HashSet<>(scoops);
        return flavors.size();
    }

    public void undo(){
        scoops.remove(scoops.size()-1);
    }
}
