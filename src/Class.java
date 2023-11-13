import java.util.ArrayList;

/**
 * Class.java
 * 
 * This program handles the all the courses created and adds them to the courses arraylist using mutator methods.
 * They can also be removed using mutators and other classes can use it using the getter.
 * 
 * @version April 11, 2022
 */
public class Class {
    private ArrayList<Course> courses = new ArrayList<>(); // All the course of a specific class

    /**
     * Constructs a course class using the parameters inputed
     *
     * @param courses - the ArrayList<Course> that the course field is set too
     */
    public Class(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Getter method that returns the courses field arraylist
     *
     * @return - the courses field arraylist
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the courses field to the ArrayList<Course> inputed
     *
     * @param courses - the ArrayList<Course> that the course field is set to
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * Adds the course passed in from the courses field
     *
     * @param course - the course that you want to add
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * Removes the course passed in from the courses field
     *
     * @param course -  the course that you want to remove
     */
    public void removeCourse(Course course) {
        courses.remove(course);
    }

    /**
     * Checks if the course already exists and returns a corresponding boolean
     *
     * @param course - the course that you are checking if it already exists
     * @return true if it is redundant and false if it isn't
     */
    public boolean checkRedundantCourse(Course course) {
        boolean redundant = false;
        for (int i = 0; i < courses.size(); i++) {
            redundant = course.getCourseName().equals(courses.get(i).getCourseName());
        }
        return redundant;
    }


}
