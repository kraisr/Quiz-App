import java.util.*;
import java.io.Serializable;

/**
 * Question.java
 * 
 * This is an object to hold questions and their information in.
 * The Question class includes several methods that allow users to
 * interact with question objects however they please. For instance,
 * it allows teachers to edit specific question attributes like point
 * value and to randomize answer choices if desired.
 *
 * @version April 11, 2022
 */

public class Question implements Serializable {
    // Four question fields: question prompt, arraylist of answer choices,
    // integer indicating whih choice is correct, and point value/weight
    private String prompt;
    private ArrayList<String> responses;
    private int answer;
    private int weight;

    // Single constructor to create question objects
    public Question(String prompt, ArrayList<String> responses, int answer, int weight) {
        this.prompt = prompt;
        this.responses = responses;
        this.answer = answer;
        this.weight = weight;
    }

    // allows user to access question prompt
    public String getPrompt() {
        return prompt;
    }

    // allows user to access arraylist of question answer choices
    public ArrayList<String> getResponses() {
        return responses;
    }

    // allows user to access answer index
    public int getAnswer() {
        return answer;
    }

    // allows user to access question weight/point value
    public int getWeight() {
        return weight;
    }

    // allows user to change question prompt
    public void setPrompt(String qPrompt) {
        prompt = qPrompt;
    }

    // allows user to change question responses
    public void setResponses(ArrayList<String> qResponses) {
        responses = qResponses;
    }

    // allows user to change question answer index
    public void setAnswer(int qAnswer) {
        answer = qAnswer;
    }

    // allows user to change question weight/point value
    public void setWeight(int qWeight) {
        weight = qWeight;
    }

    // randomizes order of answer choices and ensures answer index changes with it
    public void randomize() {
        String correctResponse = responses.get(answer);
        Collections.shuffle(responses);
        for (int i = 0; i < responses.size(); i++) {
            if (responses.get(i).equals(correctResponse)) {
                answer = i;
            }
        }
    }

    // equals method ensures correct objects can be removed from arraylist of questions
    public boolean equals(Object o) {
        boolean equal = false;
        if (o instanceof Question) {
            Question ques = (Question) o;
            if (this.prompt.equalsIgnoreCase(ques.prompt) && this.responses == ques.responses &&
                    this.answer == ques.answer && this.weight == ques.weight) {
                equal = true;
            }
        }
        return equal;
    }

    // toString allows question to be printed all at once if users want to view it
    public String toString() {
        String format = "Question{prompt = %s, responses = [";
        for (int i = 0; i < responses.size(); i++) {
            format += responses.get(i) + ", ";
        }
        format = format.substring(0, format.length() - 2) + "], answer = %s, weight = %d}";
        String answerString = responses.get(answer);
        return String.format(format, this.prompt, answerString, this.weight);
    }
}
