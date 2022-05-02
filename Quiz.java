import javax.swing.*;
import java.io.*;
import java.util.*;
import java.sql.Timestamp;

public class Quiz implements Serializable{
    // Three Quiz fields, name of quiz, arraylist of questions, and arraylist of submissions
    private String name;
    private ArrayList<Question> questions;
    private ArrayList<String> submissions;

    // first constructor creates quiz object from existing name and arraylist
    public Quiz(String name, ArrayList<Question> questions) {
        this.name = name;
        this.questions = questions;
        this.submissions = new ArrayList<>();
    }

    public Quiz(String fileName) {
        String name = null;
        ArrayList<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String readName = br.readLine();
            name = readName.substring(readName.indexOf(' ') + 1);
            String line = br.readLine();
            while (line != null) {
                while (line != null && line.contains("Question: ")) {
                    int weight = 0;
                    int answer = 0;
                    ArrayList<String> responses = new ArrayList<>();
                    String prompt = line.substring(line.indexOf(' ') + 1);
                    line = br.readLine();
                    if (line != null && line.contains("Weight: ")) {
                        weight = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
                        line = br.readLine();
                        while(line != null && line.contains("Answer: ")) {
                            if (line.contains("Correct_Answer: ")) {
                                answer = responses.size() - 1;
                            }
                            responses.add(line.substring(line.indexOf(' ') + 1));
                            line = br.readLine();
                        }
                    }
                    questions.add(new Question(prompt, responses, answer, weight));
                }
            }
        } catch (IOException i) {
            JOptionPane.showMessageDialog(null, "Error! Please enter a correct filename!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! Could not create quiz!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.name = name;
        this.questions = questions;
        this.submissions = new ArrayList<String>();
    }


    // accessors and mutators
    public String getName() {
        return name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public ArrayList<String> getAllSubmissions() {
        return submissions;
    }

    public void setName(String quizName) {
        name = quizName;
    }

    public void setQuestions(ArrayList<Question> quizQuestions) {
        questions = quizQuestions;
    }

    public void setSubmissions(ArrayList<String> quizSubmissions) {
        submissions = quizSubmissions;
    }


    public void addQuestion(Question question, int index) {
        if (index >= 0) {
            questions.add(index, question);
        } else {
            questions.add(question);
        }
    }

    // remove method calls question equals method to remove specific question objects from list
    public void removeQuestion(Question question) {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).equals(question)) {
                questions.remove(i);
            }
        }
    }

    // calculates max score of quiz
    public int calcMaxScore() {
        int maxScore = 0;
        int inScore;
        for (int m = 0; m < questions.size(); m++) {
            inScore = questions.get(m).getWeight();
            maxScore += inScore;
        }
        return maxScore;
    }

    // creates submission trace string that includes all results of quiz taken
    public void addSubmission(String userName, ArrayList<Question> correctAnswers) {
        String format = "Submission{User = %s";
        ArrayList<Question> results = new ArrayList<>();
        int pointsEarned = 0;
        int score = 0;
        String quesNum;
        String points;
        String prompt;
        String correct;
        for (int q = 0; q < questions.size(); q++) {
            for (int c = 0; c < correctAnswers.size(); c++) {
                if (questions.get(q) == correctAnswers.get(c)) {
                    pointsEarned = questions.get(q).getWeight();
                } else {
                    pointsEarned = 0;
                }
            }
            quesNum = Integer.toString(q + 1);
            prompt = questions.get(q).getPrompt();
            correct = questions.get(q).getResponses().get(questions.get(q).getAnswer());
            points = Integer.toString(pointsEarned);
            format += ", Question " + quesNum + "{prompt = " + prompt;
            format += ", correct answer = " + correct + ", points earned = " + points + "}";
            score += pointsEarned;
        }
        format += ", Score = %d, Maximum Score = %d, Time = %s}";
        int maxScore = calcMaxScore();
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        submissions.add(String.format(format, userName, score, maxScore, ts));
    }

    // retrieves submissions pertaining to specific student's username
    public ArrayList<String> getStudentSubmissions(String userName) {
        ArrayList<String> userSubs = new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++) {
            String user = "User = " + userName;
            if (submissions.get(i).contains(user)) {
                userSubs.add(submissions.get(i));
            }
        }
        return userSubs;
    }

    // shuffles order of quiz questions
    public void randomize() {
        Collections.shuffle(questions);
    }

    // substitute for deleteQuiz method
    // equals method allows course class to simply delete quiz from arraylist of quiz objects
    public boolean equals(Object o) {
        boolean equal = false;
        if (o instanceof Quiz) {
            Quiz quiz = (Quiz) o;
            if (this.name.equalsIgnoreCase(quiz.name) && this.questions == quiz.questions &&
                    this.submissions == quiz.submissions) {
                equal = true;
            }
        }
        return equal;
    }

    // toString allows quiz to be printed all at once if anyone wants to see it
    public String toString() {
        String format = "Quiz{name = %s,";
        for (int i = 0; i < questions.size(); i++) {
            format = format + "question " + Integer.toString(i + 1) + " = " + questions.get(i).toString() + ", ";
        }
        format = format.substring(0, format.length() - 2) + "}";
        return String.format(format, this.name);
    }

}
