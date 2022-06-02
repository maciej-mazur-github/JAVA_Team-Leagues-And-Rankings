public class Main {
    public static void main(String[] args) {
        BaseballPlayer joe = new BaseballPlayer("Joe");
        FootballPlayer beckham = new FootballPlayer("Beckham");
        BasketballPlayer jordan = new BasketballPlayer("Jordan");
        BaseballPlayer joe2 = new BaseballPlayer("Joe");

        Team<BaseballPlayer> crows = new Team<>("Crows");
        crows.addPlayer(joe);

        Team<FootballPlayer> manchester = new Team<>("Manchester");
        manchester.addPlayer(beckham);

        Team<FootballPlayer> barcelona = new Team<>("Barcelona");
        FootballPlayer ronaldo = new FootballPlayer("Ronaldo");
        manchester.addPlayer(ronaldo);

        Team<FootballPlayer> united = new Team<>("United");
        FootballPlayer lewandowski = new FootballPlayer("Lewandowski");
        manchester.addPlayer(lewandowski);

        manchester.matchResult(barcelona, 4, 2);
        manchester.matchResult(united, 2, 5);

        barcelona.matchResult(united, 1, 4);
        barcelona.matchResult(manchester, 5, 4);
        //barcelona.matchResult(crows, 3, 6);

        /*Team<String> brokenTeam = new Team<>("Broken Team");
        brokenTeam.addPlayer("no-one");*/

        //crows.addPlayer(jordan);

        //System.out.println(crows.getTeamCount());

        System.out.println("\n\nRankings:");
        System.out.println(manchester.getName() + " " + manchester.ranking());
        System.out.println(united.getName() + " " + united.ranking());
        System.out.println(barcelona.getName() + " " + barcelona.ranking());

        League<FootballPlayer, Team<FootballPlayer>> league = new League<>("Super League");
        league.add(manchester);
        league.add(barcelona);
        league.add(united);
        //league.add(crows);
        league.showLeagueTable();

    }
}
