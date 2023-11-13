import java.io.*;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * LoggingIn.java
 * 
 * The LoggingIn class handles method for the login process such as checking if the user the is trying to
 * sign in is a user in the system and checking if a user already exists when creating a new user.
 * This class has one field that is an Arraylist<User> which stores all the users. There are also methods
 * that handle writing and reading the user information to a text file.
 * 
 * @version April 11, 2022
 */
public class LoggingIn {

    static ArrayList<User> userList = new ArrayList<>();

    public static boolean checkUser(User user) {
        try {
            boolean hasCorrectInfo = false;

            //read the file and put it in an Array list
            BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"));
            ArrayList<String> userDetailFile = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                userDetailFile.add(line);
                line = reader.readLine();
            }

            //go through the userDetailFile and check for the line with the username that you want to edit
            for (int i = 0; i < userDetailFile.size(); i++) {
                int indexUser = userDetailFile.get(i).indexOf(" ");
                String subUser = userDetailFile.get(i).substring(indexUser + 1);
                if (subUser.equals(user.getUsername())) {
                    int indexPass = userDetailFile.get(i + 1).indexOf(" ");
                    String subPass = userDetailFile.get(i + 1).substring(indexPass + 1);
                    if (subPass.equals(user.getPassword())) {
                        if (userDetailFile.get(i + 2).contains(String.valueOf(user.isTeacher()))) {
                            hasCorrectInfo = true;
                        }
                    }
                }
            }
            return hasCorrectInfo;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean editPassword(User user, String oldPassword, String newPassword) {
        try {
            boolean worked = false;

            //read the file and put it in an Array list
            BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"));
            ArrayList<String> userDetailFile = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                userDetailFile.add(line);
                line = reader.readLine();
            }

            //go through the userDetailFile and check for the line with the username that you want to edit
            for (int i = 0; i < userDetailFile.size(); i++) {
                if (userDetailFile.get(i).contains(user.getUsername())) {
                    String[] editUser = userDetailFile.get(i + 1).split(" ");
                    for (int f = 0; f < editUser.length; f++) {
                        if (editUser[f].contains(oldPassword)) {
                            String checkPassword = editUser[f];
                            if (checkPassword.equals(oldPassword)) {
                                editUser[f] = " " + newPassword;
                                StringBuilder formatEditUser = new StringBuilder();
                                for (int a = 0; a < editUser.length; a++) {
                                    formatEditUser.append(editUser[a]);
                                }
                                userDetailFile.set(i + 1, formatEditUser.toString());
                                worked = true;
                            }
                        }
                    }
                }
            }
            FileWriter writer = new FileWriter("UserDetails.txt");
            for (int i = 0; i < userDetailFile.size(); i++) {
                writer.write(userDetailFile.get(i) + "\n");
            }

            //Add by Rishab
            for (int i = 0; i < userList.size(); i++) {
                if (user.equals(userList.get(i))) {
                    userList.get(i).setPassword(newPassword);
                }
            }

            writer.close();
            return worked;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean editUsername(User user, String newUsername) {
        try {
            boolean worked = false;

            //read the file and put it in an Array list
            BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"));
            ArrayList<String> userDetailFile = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                userDetailFile.add(line);
                line = reader.readLine();
            }

            //go through the userDetailFile and check for the line with the username that you want to edit
            for (int i = 0; i < userDetailFile.size(); i++) {
                if (userDetailFile.get(i).contains(user.getUsername())) {
                    String[] editUser = userDetailFile.get(i).split(" ");
                    for (int f = 0; f < editUser.length; f++) {
                        if (editUser[f].contains(user.getUsername())) {
                            editUser[f] = " " + newUsername;
                        }
                    }
                    StringBuilder formatEditUser = new StringBuilder();
                    for (int a = 0; a < editUser.length; a++) {
                        formatEditUser.append(editUser[a]);
                    }
                    userDetailFile.set(i, formatEditUser.toString());
                    worked = true;
                }
            }

            FileWriter writer = new FileWriter("UserDetails.txt");
            for (int i = 0; i < userDetailFile.size(); i++) {
                writer.write(userDetailFile.get(i) + "\n");
            }

            //Add by Rishab
            for (int i = 0; i < userList.size(); i++) {
                if (user.equals(userList.get(i))) {
                    userList.get(i).setUsername(newUsername);
                }
            }

            writer.close();
            return worked;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createUser(User user) {
        try {
            //establish FileWriter to the UserDetails.txt text file
            FileWriter writer = new FileWriter("UserDetails.txt", true);
            boolean contains = checkRedundant(user.getUsername());
            System.out.println(contains);

            if (contains) {
                return false;
            } else {
                String userDetails = String.format("Username: %s\nPassword: %s\nTeacher: %s\n",
                        user.getUsername(), user.getPassword(), user.isTeacher());

                //Add by Rishab
                userList.add(user);

                writer.write(userDetails);
                writer.close();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteAccount(User user) {
        try {
            boolean worked = false;

            //read the file and put it in an Array list
            BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"));
            ArrayList<String> userDetailFile = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                userDetailFile.add(line);
                line = reader.readLine();
            }

            //go through the userDetailFile and check for the line with the username that you want to edit
            for (int i = 0; i < userDetailFile.size(); i++) {
                if (userDetailFile.get(i).contains(user.getUsername())) {
                    if (userDetailFile.get(i + 1).contains(user.getPassword())) {
                        userDetailFile.set(i, "12823120123");
                        userDetailFile.set(i + 1, "12823120123");
                        userDetailFile.set(i + 2, "12823120123");
                        worked = true;
                    }
                }
            }
            for (int i = 0; i < userDetailFile.size(); i++) {
                if (userDetailFile.get(i).contains("12823120123")) {
                    userDetailFile.remove(i);
                }
            }
            for (int i = 0; i < userDetailFile.size(); i++) {
                if (userDetailFile.get(i).contains("12823120123")) {
                    userDetailFile.remove(i);
                }
            }
            FileWriter writer = new FileWriter("UserDetails.txt");
            for (int i = 0; i < userDetailFile.size(); i++) {
                writer.write(userDetailFile.get(i) + "\n");
            }

            //Add By Rishab
            userList.removeIf(user::equals);

            writer.close();
            return worked;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkRedundant(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"));
            String line = reader.readLine();
            boolean contains = false;
            while (line != null) {
                if (line.contains(username)) {
                    contains = true;
                }
                line = reader.readLine();
            }

            return contains;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String username) {
        for (User u : userList) {
            if (username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }

    public static void removeUser(String username) {
        for (User u : userList) {
            if (username.equals(u.getUsername())) {
                userList.remove(u);
            }
        }
    }

    public static ArrayList<User> readUserInfo() {

        String username;
        String password;
        boolean teacher;
        String line;

        ArrayList<User> users = new ArrayList<>();

        try {

            File courseInfoFile = new File("UserDetails.txt");
            FileReader fileReader = new FileReader(courseInfoFile);
            BufferedReader bfr = new BufferedReader(fileReader);

            line = bfr.readLine();
            username = "";
            password = "";


            while (line != null) {
                username = line.substring(line.indexOf(' ') + 1);
                line = bfr.readLine();
                password = line.substring(line.indexOf(' ') + 1);
                line = bfr.readLine();
                if (line.substring(line.indexOf(' ') + 1).equals("true")) {
                    teacher = true;
                } else {
                    teacher = false;
                }
                users.add(new User(username, password, teacher));
                line = bfr.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    public static void writeUserInfo(ArrayList<User> userList) {

        String userDetails;
        int index;

        try {
            index = 0;
            FileWriter writer = new FileWriter("UserDetails.txt");
            PrintWriter printWriter = new PrintWriter(writer);
            for (User u : userList) {
                userDetails = "";
                if (index == 0) {
                    userDetails += "Username: " + u.getUsername();
                    index++;
                } else {
                    userDetails += "\nUsername: " + u.getUsername();
                }
                userDetails += "\nPassword: " + u.getPassword();
                printWriter.println(userDetails);
                printWriter.flush();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}

