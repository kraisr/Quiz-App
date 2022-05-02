import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/*
public class Testing {

    //testing for right modifiers
    //if necessary
//     @Test(timeout = 1000)
//     public void simpleTest() {
//         Class<?> quizClazz = Quiz.class;
//         Class<?> questionClazz = Question.class;
//         Class<?> quizMenuClazz = QuizMenu.class;
//         Class<?> courseClazz = Course.class;
//         Class<?> courseInfoHandlerClazz = CourseInfoHandler.class;
//         Class<?> userClazz = User.class;
//         Class<?> loginClazz = LoggingIn.class;


//         if (quizClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (questionClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (quizMenuClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (courseClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (courseInfoHandlerClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (userClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }
//         if (loginClazz.getModifiers() != Modifier.PUBLIC) {
//             Assert.fail("Was not the right modifiers!");
//             return;
//         }


//     }

    public static void main(String[] args) {

        //for User class
        String username = "";
        String password = "";
        boolean teacher = true;
        User user = new User(username, password, teacher);

        user.setUsername("Teacher");
        user.getUsername();
        user.setPassword("1122");
        user.getPassword();
        user.setTeacher(true);
        user.isTeacher();

        if (!user.getUsername().equals("Teacher")) {
            System.out.println("Not the expected output");
        }
        if (!user.getPassword().equals("1122")) {
            System.out.println("Not the expected output");
        }
        if (!user.isTeacher() == true) {
            System.out.println("Not the expected output");
        }

        //for LoggingIn
        boolean allGood = true;
        User teacherLoggingIn = new User("James", "jPassword", true);
        User studentLoggingIn = new User("John", "JohnsPassword", false);
        User notRegisteredTeacher = new User("Ronnie", "1234", true);
        User notRegisteredStudent = new User("lucy", "xyz", false);

        //Testing createUser method
        LoggingIn.createUser(teacherLoggingIn);
        LoggingIn.createUser(studentLoggingIn);
        if (!LoggingIn.checkUser(teacherLoggingIn)) {
            System.out.println("[checkUser] Not the expected output teacher");
            allGood = false;
        }
        if (!LoggingIn.checkUser(studentLoggingIn)) {
            System.out.println("[checkUser] Not the expected output student");
            allGood = false;
        }
        //Checking login class for users that are not registered
        if (LoggingIn.checkUser(notRegisteredTeacher)) {
            System.out.println("[checkUser] Not the expected output teacher");
            allGood = false;
        }
        if (LoggingIn.checkUser(notRegisteredStudent)) {
            System.out.println("[checkUser] Not the expected output for student");
            allGood = false;
        }
        //Testing editPassword
        LoggingIn.editPassword(teacherLoggingIn, "jPassword", "newPassword");
        LoggingIn.editPassword(studentLoggingIn, "JohnsPassword", "newPassword2");
        if (!teacherLoggingIn.getPassword().equals("newPassword")) {
            System.out.println("[editPassword] Not the expected output");
            allGood = false;
        }
        if (!studentLoggingIn.getPassword().equals("newPassword2")) {
            System.out.println("[editPassword] Not the expected output");
            allGood = false;
        }

        //Testing editUsername
        LoggingIn.editUsername(teacherLoggingIn, "Kasper");
        LoggingIn.editUsername(studentLoggingIn, "Jasper");
        if (!teacherLoggingIn.getUsername().equals("Kasper")) {
            System.out.println("[editUsername] Not the expected output");
            allGood = false;
        }
        if (!studentLoggingIn.getUsername().equals("Jasper")) {
            System.out.println("[editUsername] Not the expected output");
            allGood = false;
        }

        //Testing checkRedundant
        if (!LoggingIn.checkRedundant("Kasper")) {
            System.out.println("[checkRedundant] Not the expected output");
            allGood = false;
        }
        if (!LoggingIn.checkRedundant("Jasper")) {
            System.out.println("[checkRedundant] Not the expected output");
            allGood = false;
        }

        //Testing getUser
        if (!LoggingIn.getUser("Kasper").equals(teacherLoggingIn)) {
            System.out.println("[getUser] Not the expected output");
            allGood = false;
        }
        if (!LoggingIn.getUser("Jasper").equals(studentLoggingIn)) {
            System.out.println("[getUser] Not the expected output");
            allGood = false;
        }

        if (allGood) {
            System.out.println("All test cases passed!");
        }
        
        
        //for Submission class
        User student = null;
        ArrayList<String> responses = new ArrayList<>();
        ArrayList<Quiz> quizzes = new ArrayList<>();
        ArrayList<Question> questions = new ArrayList<>();
        String time = "";
        boolean graded = true;
        Quiz quizBeingTaken = new Quiz("Quiz 1", questions);
        Course courseOfQuiz = new Course("Bio" , quizzes);
        ArrayList<String> grades = new ArrayList<>();


        Submission submission = new Submission(student, quizBeingTaken, courseOfQuiz, responses, time, graded, grades);

        grades.add("30");
        grades.add("40");
        grades.add("50");
        responses.add("answer1");

        grades.set(0, "100");
        submission.setGrades(grades);
        submission.getGrades();
        System.out.println(submission.getGrades());

        submission.setCourseOfQuiz(new Course("Math", quizzes));
        submission.getCourseOfQuiz();
        System.out.println(submission.getCourseOfQuiz());

        submission.setQuizBeingTaken(new Quiz("Quiz 2", questions));
        submission.getQuizBeingTaken();
        System.out.println(quizBeingTaken.getName());

        submission.setStudent(new User("Teacher", "1122", true));
        submission.getStudent();
        System.out.println(submission.getStudent());

        responses.set(0, "answers");
        submission.setResponses(responses);
        submission.getResponses();
        System.out.println(submission.getResponses());

        submission.setTime("10");
        submission.getTime();
        System.out.println(submission.getTime());

        submission.setGraded(false);
        submission.isGraded();
        System.out.println(submission.isGraded());


         //Course class
        String courseName = "";
        String Quiz = "";
        User owner = new User("Teacher 1", "1122", true) ;
        ArrayList<Quiz> quiz = new ArrayList<>();
        ArrayList<Question> question = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        quiz.add(0, new Quiz("Quiz 2", question));


        Course course = new Course(courseName, quiz);

        course.setCourseName("Math");
        System.out.println(course.getCourseName());

        quiz.set(0, new Quiz("Quiz 1", question));
        course.setQuizzes(quiz);
        System.out.println(course.getQuizzes().get(0).getName());

        course.setOwner(owner);
        System.out.println(course.getOwner());

        course.addQuiz(new Quiz("Quiz 1", question));
        System.out.println(courses);

        course.removeQuiz(course, course.getQuizzes().get(0));
        System.out.println(courses);
        
         //---------------------------------
        // Tests methods in question class
        String prompt = "question prompt";
        ArrayList<String> responses = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            responses.add("response " + i);
        }
        int answer = 1;
        int weight = 10;

        // Creates question object for testing
        Question question = new Question(prompt, responses, answer, weight);

        // Tests accessor methods
        String accessedPrompt = question.getPrompt();
        ArrayList<String> accessedResponses = question.getResponses();
        int accessedAnswer = question.getAnswer();
        int accessedWeight = question.getWeight();

        if (!(prompt.equals(accessedPrompt))) {
            System.out.println("Error! getPrompt() method output incorrect!");
        }
        if (responses != accessedResponses) {
            System.out.println("Error! getResponses() method output incorrect!");
        }
        if (answer != accessedAnswer) {
            System.out.println("Error! getAnswer() method output incorrect!");
        }
        if (weight != accessedWeight) {
            System.out.println("Error! getWeight() method output incorrect!");
        }

        // Tests mutator methods
        String newPrompt = "new prompt";
        ArrayList<String> newResponses = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            newResponses.add("new response " + i);
        }
        int newAnswer = 2;
        int newWeight = 20;

        question.setPrompt(newPrompt);
        question.setResponses(newResponses);
        question.setAnswer(newAnswer);
        question.setWeight(newWeight);

        accessedPrompt = question.getPrompt();
        accessedResponses = question.getResponses();
        accessedAnswer = question.getAnswer();
        accessedWeight = question.getWeight();

        if (!(newPrompt.equals(accessedPrompt))) {
            System.out.println("Error! setPrompt() method output incorrect!");
        }
        if (newResponses != accessedResponses) {
            System.out.println("Error! setResponses() method output incorrect!");
        }
        if (newAnswer != accessedAnswer) {
            System.out.println("Error! setAnswer() method output incorrect!");
        }
        if (newWeight != accessedWeight) {
            System.out.println("Error! setWeight() method output incorrect!");
        }

        // Creates new question objects to test equals method
        // First object should be equal while third should not
        Question questionA = new Question(question.getPrompt(), question.getResponses(), question.getAnswer(), question.getWeight());
        boolean equal = question.equals(questionA);
        if (!equal) {
            System.out.println("Error! equals() method output incorrect!");
        }

        // Tests toString method
        question.setPrompt(prompt);
        question.setResponses(responses);
        question.setAnswer(answer);
        question.setWeight(weight);
        String expected = "Question{prompt = question prompt, responses = [response 1, response 2, " +
                "response 3, response 4], answer = response 2, weight = 10}";
        String result = question.toString();
        if (!(expected.equals(result))) {
            System.out.println("Error! toString() method output incorrect!");
        }



        // ------------------------------------------
        // Tests methods in Quiz class as well
        String name = "Quiz name";
        ArrayList<Question> questions = new ArrayList<>();

        // formats question object and adds to quiz
        String prompt1 = "question prompt";
        ArrayList<String> responses1 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            responses1.add("response " + i);
        }
        int answer1 = 1;
        int weight1 = 10;
        Question question1 = new Question(prompt1, responses1, answer1, weight1);

        questions.add(question1);
        questions.add(new Question(newPrompt, newResponses, newAnswer, newWeight));

        // Creates quiz object for testing
        Quiz quiz = new Quiz(name, questions);
        String userName = "username";

        // Uses addSubmission method, assumes user got all questions correct by passing in complete questions list
        // Tests method in conjuncture with getAllSubmissions() method
        quiz.addSubmission(userName, questions);

        // Tests accessor methods and getStudentSubmission(userName) method
        String accessedName = quiz.getName();
        ArrayList<Question> accessedQuestions = quiz.getQuestions();
        ArrayList<String> accessedSubmissions = quiz.getAllSubmissions();
        ArrayList<String> studentSubmissions = quiz.getStudentSubmissions(userName);

        if (!(name.equals(accessedName))) {
            System.out.println("Error! getName() method output incorrect!");
        }
        if (questions != accessedQuestions) {
            System.out.println("Error! getQuestions() method output incorrect!");
        }
        if (accessedSubmissions.size() != 1) {
            System.out.println("Error! getAllSubmission() & addSubmissions() methods output incorrect!");
        }
        if (studentSubmissions.size() != 1) {
            System.out.println("Error! getStudentSubmissions() method output incorrect!");
        }

        // Creates new question object
        String prompt2 = "prompt2";
        ArrayList<String> responses2 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            responses2.add("response " + i);
        }
        int answer2 = 1;
        int weight2 = 10;
        Question question2 = new Question(prompt2, responses2, answer2, weight2);

        // Tests addQuestion method
        quiz.addQuestion(question2, -1);
        if (quiz.getQuestions().size() != 3) {
            System.out.println("Error! addQuestion() method output incorrect!");
        }
    }
}
*/