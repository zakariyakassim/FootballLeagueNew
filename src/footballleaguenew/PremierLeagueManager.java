package footballleaguenew;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class PremierLeagueManager implements LeagueManager {

    String line = "____________________________________________________________________________________________________";
    String line2 = "----------------------------------------------------------------------------------------------------";
    String format = "%-5s%-30s%8s%8s%8s%8s%8s%8s%8s%8s";
    Scanner input = new Scanner(System.in);
    String newLine = System.getProperty("line.separator");
    ArrayList<FootballClub> teams = new ArrayList<>(); //arraylist of FootballClub.
    ArrayList results = new ArrayList();

    String teamName;
    String teamLocation;

    @Override
    public void initialise() {
        //adds the default teams.
        results.add("Results:" + newLine);
        teams.add(new FootballClub("MANUTD", "MANCHESTER"));
        teams.add(new FootballClub("CHELSEA", "lONDON"));
        teams.add(new FootballClub("ARSENAL", "LONDON"));
        teams.add(new FootballClub("LIVERPOOL", "LIVERPOOL"));
        teams.add(new FootballClub("TOTTENHAM", "LONDON"));

    }

    @Override
    public void addTeam() {

        System.out.println("Team name:");
        teamName = input.next().toUpperCase();

        System.out.println("Team location:");
        teamLocation = input.next().toUpperCase();

        teams.add(new FootballClub(teamName, teamLocation)); // adds the teamname and the location to the arraylist teams.

    }

    @Override
    public void display() {

        Collections.sort(teams, Collections.reverseOrder()); //sorts the points and the goal difference.
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println(line);
        System.out.printf(format, "POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "     " + "PTS" + newLine);
        System.out.println(line);
        for (int i = 0; i < teams.size(); i++) {
            //prints the table.
            System.out.printf(format, i + 1, teams.get(i).getTeamName(),
                    teams.get(i).getPlayed(),
                    teams.get(i).getWins(),
                    teams.get(i).getDrew(),
                    teams.get(i).getLost(),
                    teams.get(i).getGoalsScored(),
                    teams.get(i).getGoalsAgainst(),
                    teams.get(i).getGoalDifference(),
                    "       " + teams.get(i).getPoints() + newLine + line2 + newLine);

        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    @Override
    public void deleteClub() {
        System.out.println("Enter club name:");
        String deleteClub = input.next().toUpperCase();
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(deleteClub)) {
                //searches for the club name entered by the user and removes it.
                System.out.println(teams.get(i).getTeamName() + " has been deleted.");
                teams.remove(i);

            }
        }
    }

    @Override
    public void viewClubStatistics() {
        System.out.println("Enter club name:");
        String clubStatistics = input.next().toUpperCase();
        //searches for the club entered by the user and displays the statistics of that club.
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(clubStatistics)) {

                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println(line);
                System.out.printf(format, "POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "     " + "PTS" + newLine);
                System.out.println(line);

                System.out.printf(format, i + 1, teams.get(i).getTeamName(),
                        teams.get(i).getPlayed(),
                        teams.get(i).getWins(),
                        teams.get(i).getDrew(),
                        teams.get(i).getLost(),
                        teams.get(i).getGoalsScored(),
                        teams.get(i).getGoalsAgainst(),
                        teams.get(i).getGoalDifference(),
                        "       " + teams.get(i).getPoints() + newLine + line2 + newLine);

                System.out.println("");
                System.out.println("LOCATION: " + teams.get(i).getTeamLocation());
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;

            }
        }

    }

    @Override
    public void addScores() {

        System.out.println("Enter home team:");
        String homeTeam = input.next().toUpperCase();
        System.out.println("Score for " + homeTeam + ":");
        int homeTeamScore = input.nextInt();

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(homeTeam)) {
                break; //do nothing
            } else {
                if (i + 1 == teams.size()) {

                    System.out.println("Team location for " + homeTeam + ":");
                    teamLocation = input.next().toUpperCase();
                    teams.add(new FootballClub(homeTeam, teamLocation));
                    break;

                }
            }

        }

        System.out.println("Enter away team:");
        String awayTeam = input.next().toUpperCase();
        System.out.println("Score for " + awayTeam + ":");
        int awayTeamScore = input.nextInt();

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(awayTeam)) {
                break;
            } else {

                if (i + 1 == teams.size()) {

                    System.out.println("Team location for " + awayTeam + ":");
                    teamLocation = input.next().toUpperCase();
                    teams.add(new FootballClub(awayTeam, teamLocation));
                    break;
                }
            }

        }

        results.add(homeTeam + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam + newLine);

        if (homeTeamScore > awayTeamScore) {
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(homeTeam)) {

                    teams.get(i).setWinHome(homeTeamScore, awayTeamScore, 3);
                    teams.get(i).setPlayed();
                    teams.get(i).setGoalDifference();

                }
            }

            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(awayTeam)) {
                    teams.get(i).setWinAway(homeTeamScore, awayTeamScore, 0);
                    teams.get(i).setPlayed();
                    teams.get(i).setGoalDifference();

                }
            }
        } else if (homeTeamScore < awayTeamScore) {
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(awayTeam)) {

                    teams.get(i).setWinAway(homeTeamScore, awayTeamScore, 3);
                    teams.get(i).setPlayed();
                    teams.get(i).setGoalDifference();

                }

            }

            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(homeTeam)) {
                    teams.get(i).setLost(homeTeamScore, awayTeamScore, 0);
                    teams.get(i).setPlayed();
                    teams.get(i).setGoalDifference();

                }
            }
        } else if (homeTeamScore == awayTeamScore) {

            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(homeTeam)) {

                    teams.get(i).setDrew(homeTeamScore, awayTeamScore);
                    teams.get(i).setPlayed();
                    teams.get(i).setGoalDifference();
                }

            }

            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).getTeamName().equals(awayTeam)) {
                    teams.get(i).setDrew(homeTeamScore, awayTeamScore);
                    teams.get(i).setPlayed();
                }
            }

        }

    }

    @Override
    public void viewResults() {
        System.out.println("");
        System.out.println("");
        System.out.println("");

        String formatedResults = results.toString()
                .replace(",", "") //remove the commas
                .replace("[", "") //remove the right bracket
                .replace("]", "") //remove the left bracket
                .trim(); //remove trailing spaces from partially initialized arrays
        System.out.printf("%-10s", formatedResults + newLine);

        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void viewCalendar() throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);

        System.out.println("Enter date:  (DD/MM/YYYY)");
        String dateStr = input.next();
        Date date = formatter.parse(dateStr);
        Date dateNow = new Date();
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        int M = calendar.get(Calendar.MONTH) + 1; //adding to the month because the array months[0] is blank.
        int Y = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // int D = calendar.get(Calendar.DAY_OF_MONTH);
        int d = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        String[] months = {
            // leave empty so that months[1] = "January"
            "", "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };

        // days[i] = number of days in month i
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // check for leap year
        if (M == 2) {
            days[M] = 29;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");

        // print calendar header
        System.out.println("      " + months[M] + " " + Y);

        System.out.println("---------------------");
        System.out.println(" S  M Tu  W Th  F  S");
        System.out.println("_____________________");
        // print the calendar
        int prev = days[(M - 1)] - d + 1;
        for (int i = 0; i < d; i++) {
            // System.out.print("   ");
            System.out.print(prev + " ");
            prev++;
        }
        for (int i = 1; i <= days[M]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[M])) {
                System.out.println();
            }
        }
        System.out.println("---------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        int currentDay = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        int rHomeT = (int) Math.floor(Math.random() * 4);
        int rAwayT = (int) Math.floor(Math.random() * 4);

        int rHomeS = (int) Math.floor(Math.random() * 4);
        int rAwayS = (int) Math.floor(Math.random() * 4);

        Random random = new Random();
        String[] timeList = {"12:45", "19:00", "19:45", "20:00", "18:00", "17:00", "13:00", "14:00", "17:45"};
        int pos = new Random().nextInt(timeList.length);
        String randomTime = (timeList[pos]);

        if (dateNow.after(date)) {
            System.out.println("__________________________________________");
            System.out.print("RESULTS   ");
            System.out.println(dateStr);
            System.out.println("------------------------------------------");
            System.out.println("");
            System.out.println(randomTime);
            System.out.println(teams.get(rHomeT).getTeamName() + " " + rHomeS + " - " + rAwayS + " " + teams.get(rAwayT).getTeamName());
            System.out.println("__________________________________________");
        } else {
            System.out.println("__________________________________________");
            System.out.print("FIXTURES   ");
            System.out.println(dateStr);
            System.out.println("------------------------------------------");
            System.out.println("");
            System.out.println(teams.get(rHomeT).getTeamName() + " " + "|" + randomTime + "|" + " " + teams.get(rAwayT).getTeamName());
            System.out.println("__________________________________________");
        }

    }

   /* final JPanel panel = new JPanel();
    final JFrame frame = new JFrame("Main");
    JLabel table;

    public void frameGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setSize(1000, 1000);
        frame.setResizable(false);
        frame.add(panel);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {

        javax.swing.JButton btnSetScore = new javax.swing.JButton();

        final javax.swing.JComboBox ComboBoxHomeTeam = new javax.swing.JComboBox();
        final javax.swing.JComboBox ComboBoxAwayTeam = new javax.swing.JComboBox();
        final javax.swing.JComboBox scoreHome = new javax.swing.JComboBox();
        final javax.swing.JComboBox scoreAway = new javax.swing.JComboBox();
        javax.swing.JButton addTeam = new javax.swing.JButton("Add team");
        final javax.swing.JTextField txtAddTeam = new javax.swing.JTextField("Team name                  ");
        final javax.swing.JComboBox ComboBoxDeleteClub = new javax.swing.JComboBox();
        javax.swing.JButton btnDeleteClub = new javax.swing.JButton("Delete");

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        String[] teamNames = new String[teams.size()];

        tableGUI();

        for (int i = 0; i < teams.size(); i++) {
            teamNames[i] = teams.get(i).getTeamName();
        }

        String[] scores = new String[10];
        for (int i = 0; i < 10; i++) {
            scores[i] = Integer.toString(i);
        }

        ComboBoxDeleteClub.setModel(new javax.swing.DefaultComboBoxModel(teamNames));
        ComboBoxHomeTeam.setModel(new javax.swing.DefaultComboBoxModel(teamNames));
        panel.add(ComboBoxHomeTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        scoreHome.setModel(new javax.swing.DefaultComboBoxModel(scores));
        panel.add(scoreHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        scoreAway.setModel(new javax.swing.DefaultComboBoxModel(scores));
        panel.add(scoreAway, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        ComboBoxAwayTeam.setModel(new javax.swing.DefaultComboBoxModel(teamNames));
        panel.add(ComboBoxAwayTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        btnSetScore.setText("SET SCORE");

        panel.add(btnSetScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        panel.add(txtAddTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));
        panel.add(addTeam, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        panel.add(ComboBoxDeleteClub, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, -1, -1));
        panel.add(btnDeleteClub, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, -1, -1));

        btnDeleteClub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String deleteClub = ComboBoxDeleteClub.getSelectedItem().toString();
                for (int i = 0; i < teams.size(); i++) {
                    if (teams.get(i).getTeamName().equals(deleteClub)) {
                        teams.remove(i);

                    }
                }

                panel.removeAll();
                initComponents();
                panel.repaint();

            }
        });

        txtAddTeam.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                txtAddTeam.setText("");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (txtAddTeam.getText().equals("")) {
                    txtAddTeam.setText("Add Team");
                }
            }
        });

        addTeam.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ss = txtAddTeam.getText().toUpperCase();
                for (int i = 0; i < teams.size(); i++) {

                    if (ss.equals(teams.get(i).getTeamName())) {
                        JOptionPane.showMessageDialog(null, "CLUB ALREADY EXIST");

                    }
                }

                if (teams.size() != 10) {

                    teams.add(new FootballClub(txtAddTeam.getText().toUpperCase(), null));
                    panel.removeAll();

                    initComponents();
                } else {
                    JOptionPane.showMessageDialog(null, "TABLE CAN ONLY ALLOW 10 CLUBS");
                }

            }
        });
        btnSetScore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String homeTeam = ComboBoxHomeTeam.getSelectedItem().toString();
                String awayTeam = ComboBoxAwayTeam.getSelectedItem().toString();

                String a = scoreHome.getSelectedItem().toString();
                int homeTeamScore = Integer.parseInt(a);

                String s = scoreAway.getSelectedItem().toString();
                int awayTeamScore = Integer.parseInt(s);

                if (homeTeam.equals(awayTeam)) {
                    JOptionPane.showMessageDialog(null, "TEAM CANNOT BE THE SAME");
                } else {

                    if (homeTeamScore > awayTeamScore) {
                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(homeTeam)) {

                                teams.get(i).setWinHome(homeTeamScore, awayTeamScore, 3);
                                teams.get(i).setPlayed();
                                teams.get(i).setGoalDifference();

                            }
                        }

                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(awayTeam)) {
                                teams.get(i).setWinAway(homeTeamScore, awayTeamScore, 0);
                                teams.get(i).setPlayed();
                                teams.get(i).setGoalDifference();

                            }
                        }
                    } else if (homeTeamScore < awayTeamScore) {
                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(awayTeam)) {

                                teams.get(i).setWinAway(homeTeamScore, awayTeamScore, 3);
                                teams.get(i).setPlayed();
                                teams.get(i).setGoalDifference();

                            }

                        }

                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(homeTeam)) {
                                teams.get(i).setLost(homeTeamScore, awayTeamScore, 0);
                                teams.get(i).setPlayed();
                                teams.get(i).setGoalDifference();

                            }
                        }
                    } else if (homeTeamScore == awayTeamScore) {

                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(homeTeam)) {

                                teams.get(i).setDrew(homeTeamScore, awayTeamScore);
                                teams.get(i).setPlayed();
                                teams.get(i).setGoalDifference();

                            }

                        }

                        for (int i = 0; i < teams.size(); i++) {
                            if (teams.get(i).getTeamName().equals(awayTeam)) {
                                teams.get(i).setDrew(homeTeamScore, awayTeamScore);
                                teams.get(i).setPlayed();

                            }
                        }

                    }

                    panel.removeAll();

                    initComponents();
                 //   frame.dispose();

                    //   tableGUI();
                }

            }
        });

        frame.pack();
    }

    public void tableGUI() {

        int p = 20;
        Collections.sort(teams, Collections.reverseOrder());
        for (int i = 0; i < teams.size(); i++) {
            JLabel tableName = new JLabel();
            table = new JLabel();

            // String tableFormat = "%-5s%-15s%-8d%-3d";
            String tableFormat = "%-5s%-15s%7s%7s%7s%7s%7s%7s%7s%7s";
            table.setFont(new Font("monospaced", Font.PLAIN, 14));
            tableName.setFont(new Font("monospaced", Font.PLAIN, 14));
            tableName.setText(String.format(tableFormat, "POS", "CLUB", "P", "W", "D", "L", "GF", "GA", "GD", "PTS"));
            table.setText(String.format(tableFormat, i + 1, teams.get(i).getTeamName().trim(),
                    teams.get(i).getPlayed(),
                    teams.get(i).getWins(),
                    teams.get(i).getDrew(),
                    teams.get(i).getLost(),
                    teams.get(i).getGoalsScored(),
                    teams.get(i).getGoalsAgainst(),
                    teams.get(i).getGoalDifference(),
                    teams.get(i).getPoints()));

            panel.add(tableName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));
            panel.add(table, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, (10 + p), -1, -1));
            p = p + 20;
        }

    }

    public void addTeamGUI() {


        javax.swing.JButton add = new javax.swing.JButton();

        final javax.swing.JTextField tfTeamName = new javax.swing.JTextField();
        final javax.swing.JTextField tfTeamLocation = new javax.swing.JTextField();

        final JFrame frameAddTeam = new JFrame("Add Team");
        JPanel panel2 = new JPanel();
        frameAddTeam.pack();
        frameAddTeam.setLocationRelativeTo(null);
        frameAddTeam.setVisible(true);

        frameAddTeam.setSize(1000, 1000);
        frameAddTeam.setResizable(false);
        frameAddTeam.add(panel);

        frameAddTeam.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tfTeamName.setSize(20, 100);
        panel2.add(tfTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));
    } */

}
