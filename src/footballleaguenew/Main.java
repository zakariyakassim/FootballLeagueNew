package footballleaguenew;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        //this is the PremierLeagueManager class.
        PremierLeagueManager plm = new PremierLeagueManager();

        plm.initialise(); //initialises the league, adding default teams.
        plm.display(); //displays the table after.
       // plm.frameGUI();
                   // plm.initComponents();
        String newLine = System.getProperty("line.separator");
        String line = "------------------------------------------";
        System.out.println(line);
        System.out.println("ENTER:"
                + newLine + ""
                + newLine + "A - to add a football club."
                + newLine + "V - to display the table."
                + newLine + "D - to delete a football club."
                + newLine + "R - to add results."
                + newLine + "S - to view statistics of a club."
                + newLine + "C - to view calender and results/fixtures"
                + newLine + "X - to Stop program."
                + newLine + "");
        System.out.println(line);

        boolean ss = true;
        do {

            System.out.println("What action do you want to perform?");
            String performAction = input.next().toUpperCase();
            //this is the switch case, the user selects an option.
            switch (performAction) {
                case "A":
                    plm.addTeam();
                    break;
                case "V":
                    plm.display();
                    break;
                case "D":
                    plm.deleteClub();
                    break;
                case "S":
                    plm.viewClubStatistics();
                    break;
                case "R":
                    plm.addScores();
                    plm.viewResults();
                    break;
                case "C":
                    plm.viewCalendar();
                    break;
                case "W":
                   // plm.openWindow();
                   // plm.frameGUI();
                  //  plm.initComponents();
                    
                    break;
                case "X":
                    ss = false;
                    break;
            }

            System.out.println(newLine);
            System.out.println("ENTER:"
                    + newLine + ""
                + newLine + "A - to add a football club."
                + newLine + "V - to display the table."
                + newLine + "D - to delete a football club."
                + newLine + "R - to add results."
                + newLine + "S - to view statistics of a club."
                + newLine + "C - to view calender and results/fixtures"
                + newLine + "X - to Stop program."
                    + newLine + "");
            System.out.println(newLine);

        } while (ss);


    }

}
