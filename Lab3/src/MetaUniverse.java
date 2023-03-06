import java.util.Arrays;

public class MetaUniverse {
    private int count = 0;
    public Universe[] universes;
    MetaUniverse(int n){
        this.universes = new Universe[n];
    }
    public void addUniverse(Universe uni){
        this.universes[count] = uni;
        count++;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.count; i++){
            result.append(this.universes[i].getLength()).append("\t").append(this.universes[i].getName()).append("\n");
        }
        return result.toString();
    }

    public void sort (){
        Arrays.sort(this.universes);
    }
}
