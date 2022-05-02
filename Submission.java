import java.io.*;
import java.util.*;

/**
 * Project 4 - Submission.java Class
 * <p>
 * This class handles the submission to of a certain quiz object using
 *
 * @author Corey Tuinstra
 * @version March 29, 2022
 */
public class Submission {
    private User student;
    private ArrayList<String> responses;
    private String time;
    private boolean graded;
    private Quiz quizBeingTaken;
    Course courseOfQuiz;
    ArrayList<String> grades;

    public Submission(User student, Quiz quizBeingTaken, Course courseOfQuiz,
                      ArrayList<String> responses, String time, boolean graded, ArrayList<String> grades) {
        this.student = student;
        this.responses = responses;
        this.time = time;
        this.graded = graded;
        this.quizBeingTaken = quizBeingTaken;
        this.courseOfQuiz = courseOfQuiz;
        this.grades = grades;
    }


    public ArrayList<String> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<String> grades) {
        this.grades = grades;
    }

    public void addCertainGrade(String grade) {
        grades.add(grade);
    }

    public Course getCourseOfQuiz() {
        return courseOfQuiz;
    }

    public void setCourseOfQuiz(Course courseOfQuiz) {
        this.courseOfQuiz = courseOfQuiz;
    }

    public Quiz getQuizBeingTaken() {
        return quizBeingTaken;
    }

    public void setQuizBeingTaken(Quiz quizBeingTaken) {
        this.quizBeingTaken = quizBeingTaken;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public ArrayList<String> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<String> responses) {
        this.responses = responses;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public static void writeSubmissions(ArrayList<Submission> submissions) {
        int index = 0;

        try {
            FileWriter fileWriter = new FileWriter("SubmissionDetails.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder submissionList = new StringBuilder();
            for (int c = 0; c < submissions.size(); c++) {
                String readableResponses = "";
                String readableGrades = "";
                for (int i = 0; i < submissions.get(c).getResponses().size(); i++) {
                    readableResponses += submissions.get(c).getResponses().get(i) + ",";
                }
                for (int i = 0; i < submissions.get(c).getGrades().size(); i++) {
                    readableGrades += submissions.get(c).getGrades().get(i) + ",";
                }

                if (index == 0) {
                    String submissionDetail = String.format("Student: %s\nResponses: %s\nCourse: %s\nQuiz: %s\n" +
                                    "Time: %s\nGraded: %s\nGrades: %s\n",
                            submissions.get(c).getStudent().getUsername(), readableResponses,
                            submissions.get(c).getCourseOfQuiz().getCourseName(),
                            submissions.get(c).getQuizBeingTaken().getName(),
                            submissions.get(c).getTime(), submissions.get(c).isGraded(), readableGrades);
                    submissionList.append(submissionDetail);
                    index++;
                } else {
                    String submissionDetail = String.format("\nStudent: %s\nResponses: %s\nCourse: %s\nQuiz: %s\n" +
                                    "Time: %s\nGraded: %s\nGrades: %s\n",
                            submissions.get(c).getStudent().getUsername(), readableResponses,
                            submissions.get(c).getCourseOfQuiz().getCourseName(),
                            submissions.get(c).getQuizBeingTaken().getName(),
                            submissions.get(c).getTime(), submissions.get(c).isGraded(), readableGrades);
                    submissionList.append(submissionDetail);
                }
            }
            bufferedWriter.write(String.valueOf(submissionList));
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void addSubmission(Submission submission, boolean edit) {

        try {
            FileWriter fileWriter = new FileWriter("SubmissionDetails.txt", edit);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String readableResponses = "";
            String readableGrades = "";
            for (int i = 0; i < getResponses().size(); i++) {
                readableResponses += submission.getResponses().get(i) + ",";
            }
            for (int i = 0; i < getGrades().size(); i++) {
                readableGrades += submission.getGrades().get(i) + ",";
            }
            String submissionDetail = String.format("Student: %s\nResponses: %s\nCourse: %s\nQuiz: %s\n"+
                            "Time: %s\nGraded: %s\nGrades: %s\n",
                    submission.getStudent().getUsername(), readableResponses,
                    submission.getCourseOfQuiz().getCourseName(),
                    submission.getQuizBeingTaken().getName(),
                    submission.getTime(), submission.isGraded(), readableGrades);
            bufferedWriter.write(submissionDetail);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static ArrayList<Submission> readSubmissions(Class currentClass) {
        BufferedReader reader;
        try {
            FileReader filereader = new FileReader("SubmissionDetails.txt");
            reader = new BufferedReader(filereader);
            String line = reader.readLine();
            ArrayList<User> users = LoggingIn.readUserInfo();


            String studentName = "";
            String courseName = "";
            Course courseUsed = null;
            Quiz currentQuiz = null;
            User student = null;
            ArrayList<String> responses;
            ArrayList<String> grades = null;
            String time = "";
            String quizBeingTaken = "";
            boolean graded = false;
            double grade = 0;
            String currentQuestion = null;
            Question theQuestion = null;
            Submission newSubmission = null;
            ArrayList<Submission> submissions = new ArrayList<>();
            while (line != null) {
                if (line.contains("Student: ")) {
                    responses = new ArrayList<String>();
                    studentName = line.substring(line.indexOf(' ') + 1);
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUsername().equals(studentName)) {
                            student = users.get(i);
                        }
                    }
                    line = reader.readLine();

                    if (line.contains("Responses: ")) {
                        String[] responsesArray = line.substring(line.indexOf(' ') + 1).split(",");
                        responses = new ArrayList<String>(Arrays.asList(responsesArray));
                        line = reader.readLine();
                        if (line.contains("Course: ")) {
                            courseName = line.substring(line.indexOf(' ') + 1);
                            for (int i = 0; i < currentClass.getCourses().size(); i++) {
                                if (currentClass.getCourses().get(i).getCourseName().equals(courseName)) {
                                    courseUsed = currentClass.getCourses().get(i);
                                }
                            }
                            line = reader.readLine();

                            if (line.contains("Quiz: ")) {
                                quizBeingTaken = line.substring(line.indexOf(' ') + 1);
                                for (int i = 0; i < courseUsed.getQuizzes().size(); i++) {
                                    if (courseUsed.getQuizzes().get(i).getName().equals(quizBeingTaken)) {
                                        currentQuiz = courseUsed.getQuizzes().get(i);
                                    }
                                }
                                line = reader.readLine();

                                if (line.contains("Time: ")) {
                                    time = line.substring(line.indexOf(' ') + 1);
                                    line = reader.readLine();
                                    if (line.contains("Graded: ")) {
                                        graded = Boolean.parseBoolean(line.substring(line.indexOf(' ') + 1));
                                        line = reader.readLine();

                                        if (line.contains("Grades:")) {
                                            if (line.contains(",")) {
                                                String gradeSplit = line.substring(line.indexOf(' ') + 1);
                                                String[] gradesArray = gradeSplit.split(",");
                                                grades = new ArrayList<String>(Arrays.asList(responsesArray));
                                            } else {
                                                grades = new ArrayList<>();
                                            }

                                            line = reader.readLine();
                                        }

                                    }
                                }


                            }
                        }
                    }
                    newSubmission = new Submission(student, currentQuiz, courseUsed,
                            responses, time, graded, grades);
                    submissions.add(newSubmission);
                    //line = reader.readLine();
                }

            }
            reader.close();
            return submissions;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
