package footballleaguenew;
//this is the abstract class
public abstract class SportsClub {
    
    //setting very to 0.
    public int wins = 0;
    public int lost = 0;
    public int drew = 0;
    public int played = 0;
    public int points = 0;
    public int goalsScored = 0;
    public int goalsAgainst = 0;
    public int homePoints = 0;
    public int awayPoints = 0;
    public int goalDifference = 0;

    public String nameOfTeam;
    public String teamLocation;

    public abstract void played();


    public abstract void setWinHome(int homeTeamScoreRef, int awayTeamScoreRef, int homePointsRef);

    public abstract void setWinAway(int homeTeamScoreRef, int awayTeamScoreRef, int awayPointsRef);

    public abstract void setLost(int homeTeamScoreRef, int awayTeamScoreRef, int pointsRef);

    public abstract void setTeamLocation(String locationRef);

    public abstract void setDrew(int homeTeamScoreRef, int awayTeamScoreRef);

    public abstract void setPlayed();

    public abstract void setGoalDifference();

    public abstract String getTeamName();

    public abstract int getWins();

    public abstract int getLost();

    public abstract int getDrew();

    public abstract int getPlayed();

    public abstract int getPoints();

    public abstract int getGoalsScored();

    public abstract int getGoalsAgainst();

    public abstract int getGoalDifference();

    public abstract String getTeamLocation();

    public abstract int compareTo(FootballClub ss);
    

}
