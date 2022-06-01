import java.util.ArrayList;

public class Team {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(Player player) {
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

    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if(ourScore > theirScore) {
            won++;
        } else if(ourScore < theirScore) {
            lost++;
        } else {
            tied++;
        }

        played++;
        opponent.matchResult(null, theirScore, ourScore);
    }

    public int ranking() {
        return 2 * won + tied;
    }
}




