import java.io.Serializable;
import java.util.ArrayList;

/**
 * Course.java
 * 
 * This class is the course class. The course class handles information about the course such as the
 * String courseName, User owner, ArrayList<Quiz> quizzes. The Course class also has methods that mutate
 * and get the fields
 *
 * @version April 11, 2022
 */
public class Course implements Serializable {
    private String courseName; //Name of the Course
    private User owner; // Creator of the course
    private ArrayList<Quiz> quizzes; // The quiz object that are in the course


    /**
     * Constructs a Course object given the parameters
     *
     * @param courseName - the String that the courseName field is set to
     * @param quizzes    - the ArrayList<Quiz> that quizzes is set to
     */
    public Course(String courseName, ArrayList<Quiz> quizzes) {
        this.courseName = courseName;
        this.quizzes = quizzes;
    }

    /**
     * Getter that returns courseName field String
     *
     * @return - courseName field String
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter that sets the courseName to the String inputted
     *
     * @param courseName - the String that the courseName field is set to
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Getter that returns quizzes field
     *
     * @return - quizzes field Arraylist<Quiz>
     */
    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     * Setter that sets the courseName to the Arraylist<Quix inputted
     *
     * @param quizzes - the ArrayList<Quiz> that quizzes is set to
     */
    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    /**
     * Allow you to add a quiz object to the quizzes arraylist field
     *
     * @param quiz - the Quiz object you are adding to the quizzes field
     */
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    /**
     * Getter for the owner field
     *
     * @return - the owner field
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set the owner field to the user object passed in
     *
     * @param owner - the user object you are setting the owner field to
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * This  method allows you to remove a specific quiz object from a specific course object's quizzes arraylist
     * field
     *
     * @param course the Course object that you want to remove the quiz parameter from
     * @param quiz   - the Quiz object you are removing from the specific course
     */
    public void removeQuiz(Course course, Quiz quiz) {
        course.getQuizzes().remove(quiz);
    }
}
