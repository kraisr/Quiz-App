import java.util.ArrayList;

/**
 * CourseInfoHandlerTester.java
 * 
 * This is a tester class for the CourseInfoHandler class. This class creates a Class class and write it to txt file
 * called CourseDetails.txt using the writeCourseInfo() method in the CourseInfoHandler class and then reads using the
 * readCourseInfo() method in the CourseInfoHandler class which reads from CourseDetails.txt and returns an arraylist
 * of Courses and then using if statements and for loops it checks if the original course arraylist to the one after
 * writing and reading to see if it's the same if successfully it should output:
 * "Course 1 Test Passed\n Course 2 Test Passed\n" and then finish
 * 
 * @version April 11th, 2022
 */

public class CourseInfoHandlerTester {

    public static void main(String[] args) {

        //Setting up all the object for the tester
        User teacherUser = new User("test", "test password", true);
        User studentUser = new User("test 2", "test password", false);
        ArrayList<String> responses = new ArrayList<>();
        responses.add("Test 1");
        responses.add("Test 2");
        responses.add("Test 3");
        Question question = new Question("Test Question 1", responses, 0, 5);
        Question question1 = new Question("Test Question 2", responses, 0, 5);
        Question question2 = new Question("Test Question 3", responses, 0, 5);
        Question question3 = new Question("Test Question 4", responses, 0, 5);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        Quiz quiz1 = new Quiz("Test Quiz", questions);
        Quiz quiz2 = new Quiz("Test Quiz 2", questions);
        Quiz quiz3 = new Quiz("Test Quiz 3", questions);
        ArrayList<Quiz> quizzes = new ArrayList<>();
        quizzes.add(quiz1);
        quizzes.add(quiz2);
        quizzes.add(quiz3);
        Course course = new Course("Test Course", quizzes);
        Course course1 = new Course("Test Course 2", quizzes);
        Class allCourse = new Class(new ArrayList<Course>());

        allCourse.addCourse(course);
        allCourse.addCourse(course1);


        //The Arraylist that are being compared one is before the reading and writing and one is after
        ArrayList<Course> original = allCourse.getCourses();

        CourseInfoHandler.writeCourseInfo(allCourse);
        ArrayList<Course> afterReadAndWriting = CourseInfoHandler.readCourseInfo();
        boolean allQuizzesEqual = false;

        //Testing to see if the Arraylist contain the object with the same value
        //Goes through all course
        for (int i = 0; i < afterReadAndWriting.size(); i++) {
            //Read in Course
            Course courseR = afterReadAndWriting.get(i);
            //Original Course
            Course courseO = original.get(i);


            if (courseR.getCourseName().equals(courseO.getCourseName())) {

                //Goes through all quizzes
                for (int index = 0; index < courseO.getQuizzes().size(); index++) {
                    //Read in Quiz
                    Quiz quizR = courseR.getQuizzes().get(index);
                    //Original Quiz
                    Quiz quizO = courseO.getQuizzes().get(index);

                    if (quizO.getName().equals(quizR.getName())) {

                        for (int qNum = 0; qNum < quizR.getQuestions().size(); qNum++) {
                            //Read in question
                            Question questionR = quizR.getQuestions().get(qNum);
                            //Original question
                            Question questionO = quizO.getQuestions().get(qNum);

                            if (questionR.getPrompt().equals(questionO.getPrompt()) && questionO.getWeight() ==
                                    questionR.getWeight() && questionO.getAnswer() == questionR.getAnswer()) {

                                for (int choices = 0; choices < questionR.getResponses().size(); choices++) {
                                    if (questionR.getResponses().get(choices).equals(questionO.getResponses().
                                            get(choices))) {
                                        allQuizzesEqual = true;
                                    } else {
                                        allQuizzesEqual = false;
                                        break;
                                    }
                                }

                            } else {
                                allQuizzesEqual = false;
                                break;
                            }
                        }

                    } else {
                        allQuizzesEqual = false;
                        break;
                    }

                }

                if (allQuizzesEqual) {
                    System.out.printf("Course %d Test Passed\n", i + 1);
                }

            } else {
                System.out.printf("Course %d Test Failed\n", i + 1);
            }


        }

    }
}
