package footballleaguenew;
//this is the FootballClub that extends the SportsClub
//i had to implement all the abstract methods in SportsClub otherwise there will be an error.
public final class FootballClub extends SportsClub implements Comparable<FootballClub> {
    //setting the teamName and the location of each team.
    //also implements the comparable footballclub so it compares the points and the goal difference.
    FootballClub(String teamName, String locationRef) { 
        nameOfTeam = teamName;
        teamLocation = locationRef;
        played();

    }

    //if they loose, win or draw, they still played so it adds 1 to played.
    @Override
    public void played() {
        played = wins + drew + lost;
    }

    //if home team wins, it calculates the points by adding 3 to it and also calculates the goal scored and against.
    @Override                       //3                  //1
    public void setWinHome(int homeTeamScoreRef, int awayTeamScoreRef, int homePointsRef) {

        points = points + homePointsRef;

        goalsScored = goalsScored + homeTeamScoreRef;
        goalsAgainst = goalsAgainst + awayTeamScoreRef;
        wins++;

    }
    //if away team wins, it calculates the points by adding 3 to it and also calculates the goal scored and against.
    @Override
    public void setWinAway(int homeTeamScoreRef, int awayTeamScoreRef, int awayPointsRef) {

        points = points + awayPointsRef;

        goalsScored = goalsScored + awayTeamScoreRef;
        goalsAgainst = goalsAgainst + homeTeamScoreRef;
        wins++; // adds 1 to wins.

    }
    //if home or away team wins, it calculates the points by adding 3 to it and also calculates the goal scored and against.
    @Override
    public void setLost(int homeTeamScoreRef, int awayTeamScoreRef, int pointsRef) {

        points += pointsRef;
        goalsScored = goalsScored + homeTeamScoreRef;
        goalsAgainst = goalsAgainst + awayTeamScoreRef;
        lost++; //adds 1 to lost.
    }

    @Override
    public void setTeamLocation(String locationRef) {

        teamLocation = locationRef; //setting the team location.
    }

    @Override
    public void setDrew(int homeTeamScoreRef, int awayTeamScoreRef) {

        drew++; //adds 1 to the draw;
        points++;
        goalsScored = goalsScored + homeTeamScoreRef;
        goalsAgainst = goalsAgainst + awayTeamScoreRef;

    }

    @Override
    public void setPlayed() {

        played++;

    }

    @Override
    public void setGoalDifference() {
        goalDifference = goalsScored - goalsAgainst; 
//calculates the goal difference 
//by substracting goal against from goals scored. 
    }

  
// these are returning and teamnames and statistics.
    @Override
    public String getTeamName() {
        return nameOfTeam;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public int getLost() {
        return lost;
    }

    @Override
    public int getDrew() {
        return drew;
    }

    @Override
    public int getPlayed() {
        return played;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public int getGoalsScored() {
        return goalsScored;
    }

    @Override
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    @Override
    public int getGoalDifference() {

        return goalDifference;
    }

    @Override
    public String getTeamLocation() {
        return teamLocation;
    }

    @Override
    public int compareTo(FootballClub ss) {
        //comparing the goal difference and the points.
        int compare = ((FootballClub) ss).getPoints(); 

        if (getPoints() == ss.getPoints()) {
            int comparediff = ((FootballClub) ss).getGoalDifference(); 

            return this.getGoalDifference() - comparediff;
        } else {
            return this.points - compare;

        }

    }

}
