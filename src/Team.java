import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if(members.contains(player)) {
            System.out.println(player.getPlayerName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getPlayerName() + " successfully added to " + this.name + " team");
            return true;
        }
    }

    public int getTeamCount() {
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore < theirScore) {
            lost++;
            message = " lost to ";
        } else {
            tied++;
            message = " drew with ";
        }

        played++;

        if(opponent != null) {
            System.out.println(getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }

    }

    public int ranking() {
        return 2 * won + tied;
    }

    @Override
    public int compareTo(Team<T> opponent) {
        if(this.ranking() > opponent.ranking()) {
            return 1;
        } else if(this.ranking() < opponent.ranking()) {
            return -1;
        } else {
            return 0;
        }
    }
}




