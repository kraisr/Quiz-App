import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Project 5 - ClientHandler.java
 * <p>
 * This Class is a thread that is explicitly made to run client-requested tasks by the server.
 *
 * @author Hyungchul Kim, Rishab Koka
 * @version May 2, 2022
 */
public class ClientHandler implements Runnable { //a thread

    private static Class info;
    private static Object concur;
    private Socket clientSocket;
    private BufferedReader in = null;
    private static ArrayList<Submission> submissions;

    //a ClientHandler constructor used in the server.java to start threads
    public ClientHandler(Socket client) {

        this.clientSocket = client;
    }

    //run method
    @Override
    public void run() {
        info = new Class(CourseInfoHandler.readCourseInfo());
        //submissions = readSubmissions(info);
        concur = new Object();
        try {

            while (true) {



                ObjectOutputStream objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
                objectOutput.writeObject(getInfoCourseArray());


                while (true) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                    String message = null;
                    while (message == null) {
                        message = reader.readLine();
                    }

                    if (message.equalsIgnoreCase("Get ArrayList")) {
                        sendArrayList(clientSocket);
                    } else if (message.equalsIgnoreCase("Sending Arraylist")) {
                        receiveArrayList(clientSocket);
                        System.out.printf(info.getCourses().get(0).getCourseName());
                    } else if (message.equalsIgnoreCase("Update Arraylist")) {
                        synchronized (concur) {
                            sendArrayList(clientSocket);
                            receiveArrayList(clientSocket);
                        }
                    } else if (message.equalsIgnoreCase("Get Submissions Arraylist")) {
                        sendSubmissions(clientSocket);
                    } else if (message.equalsIgnoreCase("Update Submissions Arraylist")) {
                        synchronized (concur) {
                            sendSubmissions(clientSocket);
                            receiveSubmissions(clientSocket);
                        }
                    } else if (message.equalsIgnoreCase("Get User Arraylist")) {
                        sendArrayList(clientSocket);
                    } else if (message.equalsIgnoreCase("Update User Arraylist")) {
                        synchronized (concur) {
                            sendUserInfo(clientSocket);
                            receiveArrayList(clientSocket);
                        }
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sendArrayList(Socket socket) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(getInfoCourseArray());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void receiveArrayList(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            Object object = objectInput.readObject();
            setInfoCourseArray((ArrayList<Course>) object);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Course> getInfoCourseArray() {
        return info.getCourses();
    }

    public static void setInfoCourseArray(ArrayList<Course> courses) {
        info.setCourses(courses);
        CourseInfoHandler.writeCourseInfo(info);
    }
    
    public static void sendUserInfo(Socket socket){
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(getUserInfo());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public static ArrayList<User> getUserInfo() {
        return LoggingIn.readUserInfo();
    }
    
    public static void receiveUserInfo(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            Object object = objectInput.readObject();
            LoggingIn.writeUserInfo((ArrayList<User>) object);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void sendSubmissions(Socket socket) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(Submission.readSubmissions(info));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void receiveSubmissions(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            Object object = objectInput.readObject();
            Submission.writeSubmissions((ArrayList<Submission>) object);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}



