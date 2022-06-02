import java.util.ArrayList;
import java.util.Collections;

public class League<U extends Player, T extends Team<U>> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team) {
        if(league.contains(team)) {
            return false;
        }

        league.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.reverse(league);
        System.out.println(name + " table:");
        for(T t : league) {
            System.out.println("\t" + t.getName() + " " + t.ranking());
        }
    }
}
