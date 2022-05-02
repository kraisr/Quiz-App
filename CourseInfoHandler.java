import java.io.*;
import java.util.ArrayList;

/**
 * This program handles the data and makes use that data persisted between different runnings of the program.
 * It does this by storing the data about courses and it's quizzes in a text file called CourseDetails.txt using the
 * writeCourseInfo() method. The data persists from one session to another through the use of the readCourseInfo()
 * method which reads the data in CourseDetails.txt and creates and instantiates all the course, quiz, and question
 * objects.
 * <p>
 * <p>
 * Purdue University -- CS18000 -- Spring 2022 -- Project 4 -- Course Info Handler
 *
 * @author Rishab Koka CS180-L24
 * @version April 11th, 2022
 */

public class CourseInfoHandler {

    /**
     * Write the give Class object's course and their quizs'to the CourseDetail.txt text file in a way that
     * readCourseInfo can read it
     *
     * @param totalClass - Is the class you are writing to the text file
     */
    public static void writeCourseInfo(Class totalClass) {

        String courseDetails;
        int index = 0;

        try {
            File courseInfoFile = new File("CourseDetails.txt");
            FileWriter fileWriter = new FileWriter(courseInfoFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (int in = 0; in < totalClass.getCourses().size(); in++) {
                courseDetails = "";
                Course c = totalClass.getCourses().get(in);
                if (index == 0) {
                    courseDetails += "Course: " + c.getCourseName();
                    index++;
                } else {
                    courseDetails += "\nCourse: " + c.getCourseName();
                }
                for (Quiz q : c.getQuizzes()) {
                    courseDetails += "\nQuiz_Name: " + q.getName();
                    for (Question question : q.getQuestions()) {
                        courseDetails += "\nQuestion: " + question.getPrompt();
                        courseDetails += "\nWeight: " + question.getWeight();
                        for (int i = 0; i < question.getResponses().size(); i++) {
                            if (i == question.getAnswer()) {
                                courseDetails += "\nCorrect_Answer: " + question.getResponses().get(i);
                            } else {
                                courseDetails += "\nAnswer: " + question.getResponses().get(i);
                            }
                        }
                    }


                }

                printWriter.print(courseDetails);
                printWriter.flush();

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    /**
     * This method reads in the data from the CourseDetails.txt file and creates and instantiates all the course, quiz,
     * and question objects.
     *
     * @return ArrayList<Course> - This is an array of the state of the course arraylist before the program was turn
     * off based on data from CourseDetails.txt
     */
    public static ArrayList<Course> readCourseInfo() {
        ArrayList<Course> courses = new ArrayList<>();
        String line;
        String courseName;
        //String owner;
        String quizName;
        String prompt;
        int weight;
        int answer;
        ArrayList<Question> questionList;
        ArrayList<String> answerChoices;
        ArrayList<Quiz> quizList;


        try {
            File courseInfoFile = new File("CourseDetails.txt");
            FileReader fileReader = new FileReader(courseInfoFile);
            BufferedReader bfr = new BufferedReader(fileReader);

            weight = 0;
            answer = 0;
            line = bfr.readLine();

            while (line != null) {

                if (line.contains("Course: ")) {
                    quizList = new ArrayList<Quiz>();
                    courseName = line.substring(line.indexOf(' ') + 1);

                    line = bfr.readLine();
                    if (line == null) {
                        break;
                    }
                    while (line.contains("Quiz_Name: ")) {
                        questionList = new ArrayList<Question>();
                        quizName = line.substring(line.indexOf(' ') + 1);
                        line = bfr.readLine();
                        if (line == null) {
                            break;
                        }
                        while (line.contains("Question: ")) {
                            answerChoices = new ArrayList<String>();
                            prompt = line.substring(line.indexOf(' ') + 1);
                            line = bfr.readLine();
                            if (line.contains("Weight: ")) {
                                weight = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
                            }
                            line = bfr.readLine();

                            if (line == null) {
                                break;
                            }

                            while (line.contains("Answer: ")) {
                                if (line.contains("Correct_Answer: ")) {
                                    answerChoices.add(line.substring(line.indexOf(' ') + 1));
                                    answer = answerChoices.size() - 1;
                                } else {
                                    answerChoices.add(line.substring(line.indexOf(' ') + 1));
                                }
                                line = bfr.readLine();
                                if (line == null) {
                                    break;
                                }
                            }
                            questionList.add(new Question(prompt, answerChoices, answer, weight));
                            if (line == null) {
                                break;
                            }
                        }
                        quizList.add(new Quiz(quizName, questionList));
                        if (line == null) {
                            break;
                        }
                    }
                    courses.add(new Course(courseName, quizList));
                    if (line == null) {
                        break;
                    }
                }
                if (line.isEmpty()) {
                    line = bfr.readLine();
                }

            }

            bfr.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return courses;
    }

}
