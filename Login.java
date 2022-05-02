import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Login extends JComponent implements Runnable {
    Login login;

    // Top level panel
    JPanel panel;

    // Login GUI ------------------------------------------------------

    // JPanel for welcome panel
    JPanel welcomePanel;
    JLabel welcomeLabel;
    JButton loginButton;
    JButton createButton;

    // JMenu for logging out and returning to main menu
    JMenu topMenu;
    JMenuBar menuBar;
    JMenuItem logoutItem;
    JMenuItem mainItem;

    // JPanel for login panel
    JPanel loginPanel;
    JLabel userLabel;
    JTextField userText;
    JLabel passLabel;
    JPasswordField passText;
    String[] userOptions;
    JComboBox<String> userBox;
    JButton loginSubmitButton;

    // JPanel for teacher version of main menu
    JPanel mainTeacherPanel;
    JButton teacherSettingsButton;
    JButton createEditButton;

    // JPanel for student version of main menu
    JPanel mainStudentPanel;
    JButton studentSettingsButton;
    JButton takeButton;
    JButton viewButton;

    // JPanel for account settings menu
    JPanel settingsPanel;
    JButton editButton;
    JButton deleteButton;

    // JPanel for account editing options
    JPanel editAccountPanel;
    JButton editUserButton;
    JButton editPassButton;

    // JPanel for editing username
    JPanel editUserPanel;
    JLabel newUsernameLabel;
    JTextField newUsernameText;
    JButton newUsernameButton;

    // JPanel for editing password
    JPanel editPassPanel;
    JLabel newPasswordLabel;
    JPasswordField newPasswordText;
    JButton newPasswordButton;

    // JPanel for creating new account
    JPanel createPanel;
    JLabel createUserLabel;
    JTextField createUserText;
    JLabel createPassLabel;
    JPasswordField createPassText;
    JComboBox<String> newTeacherBox;
    JButton newSubmitButton;

    // Edit Quiz GUI ------------------------------------------------------

    //JPanel and JButtons for the Create and Edit Panel
    JPanel createAndEditPanel;
    JButton changeQuizzes;
    JButton createACourse;
    JButton deleteACourse;
    JButton viewStudentSubmissions;

    //JPanel and JButtons for Change Quizzes Panel
    JPanel changeQuizzesPanel;
    JButton editQuizzes;
    JButton createAQuiz;
    JButton deleteQuiz;

    //JPanel and JButtons for Create a Quiz Panel
    JPanel createAQuizPanel;
    JButton createAQuizManual;
    JButton uploadAQuiz;

    // JPanel for selecting a course to edit
    JPanel selectCoursePanel;
    JLabel courseLabel;
    JComboBox<String> courseBox;
    JButton courseSubmitButton;

    // JPanel for selecting quiz to edit
    JPanel selectQuizPanel;
    JLabel quizLabel;
    JComboBox<String> quizBox;
    JButton quizSubmitButton;

    // JPanel for quiz editing menu
    JPanel editQuizPanel;
    JButton editQuizName;
    JButton addNewQuestionButton;
    JButton removeQuestionButton;
    JButton editQuestion;
    JButton editWeight;
    JButton editResponse;
    JButton editAnswerIndex;
    JButton randomize;

    // JPanel for changing name of quiz
    JPanel newQuizNamePanel;
    JLabel newQuizNameLabel;
    JTextField newQuizNameField;
    JButton newQuizNameButton;

    // JPanel for adding question to quiz
    JPanel addQuestionPanel;
    JLabel questionPromptLabel;
    JTextField questionPromptField;
    JLabel questionWeightLabel;
    JTextField questionWeightField;
    JButton addQuestionButton;

    // JPanel for adding response to question
    JPanel addResponsePanel;
    JLabel addResponseLabel;
    JTextField addResponseField;
    JButton newResponseButton;
    JButton lastResponseButton;

    // JPanel for selecting correct answer out of added responses
    JPanel addAnswerPanel;
    JLabel addAnswerLabel;
    JComboBox<String> addAnswerBox;
    JCheckBox randomCheck;
    JButton addAnswerButton;
    JButton newQuestionButton;

    // JPanel for removing question from quiz
    JPanel removeQuestionPanel;
    JLabel removeQuestionLabel;
    JComboBox<String> removeQuestionBox;
    JButton removeQuestionSubmitButton;

    // JPanel for editing question prompt
    JPanel editPromptPanel;
    JLabel editPromptLabel;
    JComboBox<String> editPromptBox;
    JButton editPromptButton;

    // JPanel for adding prompt to question
    JPanel newPromptPanel;
    JLabel newPromptLabel;
    JTextField newPromptField;
    JButton newPromptButton;

    // JPanel for editing question weight
    JPanel editWeightPanel;
    JLabel editWeightLabel;
    JComboBox<String> editWeightBox;
    JButton editWeightButton;

    // JPanel for adding weight to question
    JPanel newWeightPanel;
    JLabel newWeightLabel;
    JTextField newWeightField;
    JButton newWeightButton;

    // JPanel for editing individual question response
    JPanel editResponsePanel;
    JLabel editResponseLabel;
    JComboBox<String> editResponseBox;
    JButton editResponseButton;

    // JPanel for selecting which response to edit
    JPanel newResponsePanel;
    JComboBox<String> newResponseBox;
    JButton newResponseSubmitButton;

    // JPanel for adding new response to question
    JPanel enterResponsePanel;
    JLabel enterResponseLabel;
    JTextField enterResponseField;
    JButton enterResponseButton;

    // JPanel for editing question answer
    JPanel editAnswerPanel;
    JLabel editAnswerLabel;
    JComboBox<String> editAnswerBox;
    JButton editAnswerButton;

    // JPanel for adding new answer to panel
    JPanel responseSelectionPanel;
    JComboBox<String> responseSelection;
    JButton getResponseSelection;

    // Delete/Create Quiz GUI ------------------------------------------------------

    // JPanel for deleting quiz from course
    JPanel deleteQuizPanel;
    JLabel deleteQuizLabel;
    JComboBox<String> deleteQuizBox;
    JButton deleteQuizButton;

    // JPanel for creating new quiz from file
    JPanel quizFilePanel;
    JLabel quizFileLabel;
    JTextField quizFileField;
    JButton quizFileButton;

    // JPanel for creating new quiz manually
    JPanel quizNamePanel;
    JLabel quizNameLabel;
    JTextField quizNameField;
    JButton quizNameButton;

    // Delete/Create Course GUI ------------------------------------------------------

    // JPanel for deleting course
    JPanel deleteCoursePanel;
    JLabel deleteCourseLabel;
    JComboBox<String> deleteCourseBox;
    JButton deleteCourseButton;

    // JPanel for creating new course
    JPanel newCoursePanel;
    JLabel newCourseLabel;
    JTextField newCourseField;
    JButton newCourseButton;

    // Take Quiz GUI ------------------------------------------------------

    // Take Quiz Menu
    JPanel takeChooseCoursePanel;
    JComboBox<String> courseChoice;
    JLabel pickCourseLabel;
    JButton courseChoiceSubmit;
    ArrayList<String> courses;
    // formerly quizzes
    ArrayList<String> quizList;

    JPanel takeChooseQuizPanel;
    JComboBox<String> quizChoice;
    JLabel pickQuizLabel;
    JButton quizChoiceSubmit;
    String cSelection;
    String qSelection;
    int courseSelection;
    int quizSelection;

    JPanel takeQuiz;
    JComboBox<String>[] answerChoices;
    JLabel[] questionPrompt;
    JButton takeQuizSubmit;

    JPanel submitPanel;
    JButton submitYesButton;
    JButton submitNoButton;
    JLabel submitPrompt;

    JPanel submitPanelNo;
    JComboBox<Integer> questionNumbers;
    JButton submitPanelNoButton;
    JLabel submitPanelNoPrompt;

    JPanel changeAnswer;
    JLabel changeAnswerPrompt;
    JButton changeAnswerSubmit;
    int questionNumber;

    // formerly responses
    ArrayList<String> responseList;

    // Submissions GUI ------------------------------------------------------

    JPanel viewChooseCoursePanel;
    JComboBox<String> courseChoiceView;
    JButton viewChooseCourseButton;

    JPanel viewChooseQuizPanel;
    JComboBox<String> quizChoiceView;
    JButton viewChooseQuizButton;

    JPanel viewSubmission;
    JTextArea submissionsDetails;
    JButton mainMenuButton;

    // Other Fields ------------------------------------------------------

    static ArrayList<User> userList;
    User user;

    Course course;
    String courseName;
    ArrayList<Quiz> quizzes;
    int courseIndex;

    Quiz quiz;
    String quizName;
    ArrayList<Question> questions;
    int quizIndex;

    Question question;
    String prompt;
    int weight;
    int index;
    String response;
    ArrayList<String> responses = new ArrayList<>();
    int questionIndex;

    Class currentClass;

    static Socket socket;

    public Login() {
        userList = LoggingIn.readUserInfo(); // server
        user = null;
    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logoutItem) {
                // returns user to login screen
                // Login GUI
                loginPanel.setVisible(false);
                mainTeacherPanel.setVisible(false);
                mainStudentPanel.setVisible(false);
                settingsPanel.setVisible(false);
                editAccountPanel.setVisible(false);
                editUserPanel.setVisible(false);
                editPassPanel.setVisible(false);
                createPanel.setVisible(false);
                // Teacher GUI
                selectCoursePanel.setVisible(false);
                selectQuizPanel.setVisible(false);
                editQuizPanel.setVisible(false);
                newQuizNamePanel.setVisible(false);
                addQuestionPanel.setVisible(false);
                addResponsePanel.setVisible(false);
                addAnswerPanel.setVisible(false);
                removeQuestionPanel.setVisible(false);
                editPromptPanel.setVisible(false);
                newPromptPanel.setVisible(false);
                editWeightPanel.setVisible(false);
                newWeightPanel.setVisible(false);
                editResponsePanel.setVisible(false);
                newResponsePanel.setVisible(false);
                enterResponsePanel.setVisible(false);
                editAnswerPanel.setVisible(false);
                responseSelectionPanel.setVisible(false);
                deleteQuizPanel.setVisible(false);
                quizFilePanel.setVisible(false);
                quizNamePanel.setVisible(false);
                deleteCoursePanel.setVisible(false);
                newCoursePanel.setVisible(false);
                createAndEditPanel.setVisible(false);
                changeQuizzesPanel.setVisible(false);
                createAQuizPanel.setVisible(false);
                // Student GUI
                takeChooseCoursePanel.setVisible(false);
                takeChooseQuizPanel.setVisible(false);
                takeQuiz.setVisible(false);
                submitPanel.setVisible(false);
                submitPanelNo.setVisible(false);
                changeAnswer.setVisible(false);
                viewChooseCoursePanel.setVisible(false);
                viewChooseQuizPanel.setVisible(false);
                viewSubmission.setVisible(false);
                // Return to welcome page
                welcomePanel.setVisible(true);
                mainItem.setVisible(false);
                user = null;
            }
            if (e.getSource() == mainItem) {
                // returns user to main menu
                // Teacher GUI
                settingsPanel.setVisible(false);
                editAccountPanel.setVisible(false);
                editUserPanel.setVisible(false);
                editPassPanel.setVisible(false);
                selectCoursePanel.setVisible(false);
                selectQuizPanel.setVisible(false);
                editQuizPanel.setVisible(false);
                newQuizNamePanel.setVisible(false);
                addQuestionPanel.setVisible(false);
                addResponsePanel.setVisible(false);
                addAnswerPanel.setVisible(false);
                removeQuestionPanel.setVisible(false);
                editPromptPanel.setVisible(false);
                newPromptPanel.setVisible(false);
                editWeightPanel.setVisible(false);
                newWeightPanel.setVisible(false);
                editResponsePanel.setVisible(false);
                newResponsePanel.setVisible(false);
                enterResponsePanel.setVisible(false);
                editAnswerPanel.setVisible(false);
                responseSelectionPanel.setVisible(false);
                deleteQuizPanel.setVisible(false);
                newCoursePanel.setVisible(false);
                quizFilePanel.setVisible(false);
                quizNamePanel.setVisible(false);
                deleteCoursePanel.setVisible(false);
                createAndEditPanel.setVisible(false);
                changeQuizzesPanel.setVisible(false);
                createAQuizPanel.setVisible(false);
                // Student GUI
                takeChooseCoursePanel.setVisible(false);
                takeChooseQuizPanel.setVisible(false);
                takeQuiz.setVisible(false);
                submitPanel.setVisible(false);
                submitPanelNo.setVisible(false);
                changeAnswer.setVisible(false);
                viewChooseCoursePanel.setVisible(false);
                viewChooseQuizPanel.setVisible(false);
                viewSubmission.setVisible(false);
                // Return to main menu
                if (user.isTeacher()) {
                    mainTeacherPanel.setVisible(true);
                } else {
                    mainStudentPanel.setVisible(true);
                }
            }

            // Login GUI ------------------------------------------------------

            // Show login panel when login button is pressed
            if (e.getSource() == loginButton) {
                welcomePanel.setVisible(false);
                loginPanel.setVisible(true);
            }
            // show create account panel when create account button is pressed
            if (e.getSource() == createButton) {
                welcomePanel.setVisible(false);
                createPanel.setVisible(true);
            }
            // check if login information is correct when submit button is pressed
            if (e.getSource() == loginSubmitButton) {
                // checks if account information is correct and creates user object
                String username = userText.getText();
                char[] input = passText.getPassword();
                StringBuilder password = new StringBuilder();
                for (char c : input) {
                    password.append(c);
                }
                String loginBoxInput = (String) userBox.getSelectedItem();
                boolean teacherInput = true;
                assert loginBoxInput != null;
                if (loginBoxInput.equals(userOptions[1])) {
                    teacherInput = false;
                }
                User userAttempt = new User(username, password.toString(), teacherInput);
                boolean checkUser = LoggingIn.checkUser(userAttempt); // server
                if (checkUser) {
                    user = userAttempt;
                    loginPanel.setVisible(false);
                    if (teacherInput) {
                        mainTeacherPanel.setVisible(true);
                    } else {
                        mainStudentPanel.setVisible(true);
                    }
                    mainItem.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login information is incorrect!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                userText.setText("");
                passText.setText("");
            }
            // show account settings panel when pressed
            if (e.getSource() == teacherSettingsButton || e.getSource() == studentSettingsButton) {
                mainTeacherPanel.setVisible(false);
                mainStudentPanel.setVisible(false);
                settingsPanel.setVisible(true);
            }
            // show create and edit menu when pressed
            if (e.getSource() == createEditButton) {
                mainTeacherPanel.setVisible(false);
                createAndEditPanel.setVisible(true);
            }

            // shows course selection menu for students when pressed
            if (e.getSource() == takeButton) {
                mainStudentPanel.setVisible(false);

                courses = new ArrayList<>();
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);

                int courseCounter = 0;
                for (int f = 0; f < currentClass.getCourses().size(); f++) {
                    courses.add(currentClass.getCourses().get(courseCounter).getCourseName());
                    courseCounter++;
                }
                takeChooseCoursePanel.remove(courseChoice);
                takeChooseCoursePanel.remove(pickCourseLabel);
                courseChoice = new JComboBox(courses.toArray());
                pickCourseLabel = new JLabel("Pick a course: ");
                takeChooseCoursePanel.add(pickCourseLabel, 0);
                takeChooseCoursePanel.add(courseChoice, 1);
                takeChooseCoursePanel.setVisible(true);
            }

            if (e.getSource() == viewButton) {
                mainStudentPanel.setVisible(false);
            }
            // shows account editing menu when pressed
            if (e.getSource() == editButton) {
                settingsPanel.setVisible(false);
                editAccountPanel.setVisible(true);
            }
            // deletes account when pressed
            if (e.getSource() == deleteButton) {
                // deletes user account
                int confirmDelete = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this account?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirmDelete == JOptionPane.YES_OPTION) {
                    boolean worked = LoggingIn.deleteAccount(user); // server
                    if (worked) {
                        settingsPanel.setVisible(false);
                        welcomePanel.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Could not delete account!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            // shows username editing panel when pressed
            if (e.getSource() == editUserButton) {
                editAccountPanel.setVisible(false);
                editUserPanel.setVisible(true);
            }
            // shows password editing panel when pressed
            if (e.getSource() == editPassButton) {
                editAccountPanel.setVisible(false);
                editPassPanel.setVisible(true);
            }
            // changes the user's username to entered one when pressed
            if (e.getSource() == newUsernameButton) {
                // changes user's username
                if (newUsernameText.getText() != null) {
                    String newUsername = newUsernameText.getText();
                    // calls editUsername method
                    boolean userSuccess = LoggingIn.editUsername(user, newUsername); // server
                    if (userSuccess) {
                        user.setUsername(newUsername);
                        editUserPanel.setVisible(false);
                        if (user.isTeacher()) {
                            mainTeacherPanel.setVisible(true);
                        } else {
                            mainStudentPanel.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Could not edit username!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    newUsernameText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a new username!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // changes user's password to entered one when pressed
            if (e.getSource() == newPasswordButton) {
                // changes user's password
                if (newPasswordText.getPassword() != null) {
                    StringBuilder newPassword = new StringBuilder();
                    char[] newPassInput = newPasswordText.getPassword();
                    for (char c : newPassInput) {
                        newPassword.append(c);
                    }
                    // calls editPassword method
                    boolean passSuccess = LoggingIn.editPassword(user, user.getPassword(), newPassword.toString()); // server
                    if (passSuccess) {
                        user.setPassword(newPassword.toString());
                        editPassPanel.setVisible(false);
                        if (user.isTeacher()) {
                            mainTeacherPanel.setVisible(true);
                        } else {
                            mainStudentPanel.setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! Could not edit password!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    newPasswordText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a new password!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // creates new account when pressed
            if (e.getSource() == newSubmitButton) {
                // creates new user account
                if (createUserText.getText() != null && createPassText.getPassword() != null) {
                    // accepts all entered information and creates new user object
                    String createUsername = createUserText.getText();
                    char[] createPassInput = createPassText.getPassword();
                    StringBuilder createPassword = new StringBuilder();
                    for (char c : createPassInput) {
                        createPassword.append(c);
                    }
                    String createBoxInput = (String) newTeacherBox.getSelectedItem();
                    boolean createTeacher = true;
                    assert createBoxInput != null;
                    if (createBoxInput.equals(userOptions[1])) {
                        createTeacher = false;
                    }
                    user = new User(createUsername, createPassword.toString(), createTeacher);
                    // creates new user account or outputs error message
                    boolean success = LoggingIn.createUser(user); // server
                    if (success) {
                        createPanel.setVisible(false);
                        if (createTeacher) {
                            mainTeacherPanel.setVisible(true);
                        } else {
                            mainStudentPanel.setVisible(true);
                        }
                        mainItem.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error! New account could not be created!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    createUserText.setText("");
                    createPassText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a new username and password!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Edit Quiz GUI ------------------------------------------------------

            // shows course selection menu when pressed
            if (e.getSource() == changeQuizzes) {
                createAndEditPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] courses = new String[currentClass.getCourses().size()];
                for (int i = 0; i < currentClass.getCourses().size(); i++) {
                    courses[i] = currentClass.getCourses().get(i).getCourseName();
                }
                selectCoursePanel.remove(courseBox);
                selectCoursePanel.remove(courseSubmitButton);
                courseBox = new JComboBox<>(courses);
                selectCoursePanel.add(courseBox);
                selectCoursePanel.add(courseSubmitButton);
                selectCoursePanel.setVisible(true);
            }

            // shows course creation panel when pressed
            if (e.getSource() == createACourse) {
                createAndEditPanel.setVisible(false);
                newCoursePanel.setVisible(true);
            }
            // shows course deletion panel when pressed
            if (e.getSource() == deleteACourse) {
                createAndEditPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] deleteCourses = new String[currentClass.getCourses().size()];
                for (int i = 0; i < currentClass.getCourses().size(); i++) {
                    deleteCourses[i] = currentClass.getCourses().get(i).getCourseName();
                }
                deleteCoursePanel.remove(deleteCourseBox);
                deleteCoursePanel.remove(deleteCourseButton);
                deleteCourseBox = new JComboBox<>(deleteCourses);
                deleteCoursePanel.add(deleteCourseBox);
                deleteCoursePanel.add(deleteCourseButton);
                deleteCoursePanel.setVisible(true);
            }
            if (e.getSource() == viewStudentSubmissions) {
                createAndEditPanel.setVisible(false);
            }
            // shows quiz selection panel when pressed
            if (e.getSource() == editQuizzes) {
                changeQuizzesPanel.setVisible(false);
                selectQuizPanel.setVisible(true);
            }
            // shows quiz creation menu when pressed
            if (e.getSource() == createAQuiz) {
                changeQuizzesPanel.setVisible(false);
                createAQuizPanel.setVisible(true);
            }
            // shows quiz deletion panel when pressed
            if (e.getSource() == deleteQuiz) {
                changeQuizzesPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] deleteQuizzes = new String[currentClass.getCourses().get(courseIndex).getQuizzes().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex).getQuizzes().size(); i++) {
                    deleteQuizzes[i] = currentClass.getCourses().get(courseIndex).getQuizzes().get(i).getName();
                }
                deleteQuizPanel.remove(deleteQuizBox);
                deleteQuizPanel.remove(deleteQuizButton);
                deleteQuizBox = new JComboBox<>(deleteQuizzes);
                deleteQuizPanel.add(deleteQuizBox);
                deleteQuizPanel.add(deleteQuizButton);
                deleteQuizPanel.setVisible(true);
            }
            // prompts user for new quiz name when pressed
            if (e.getSource() == createAQuizManual) {
                createAQuizPanel.setVisible(false);
                quizNamePanel.setVisible(true);
            }
            // prompts user for quiz file name when pressed
            if (e.getSource() == uploadAQuiz) {
                createAQuizPanel.setVisible(false);
                quizFilePanel.setVisible(true);
            }

            // sets course and shows quiz menu when pressed
            if (e.getSource() == courseSubmitButton) {
                selectCoursePanel.setVisible(false);
                try {
                    String courseName = (String) courseBox.getSelectedItem();
                    serverCommunicator(socket, "Get ArrayList");
                    readArrayList(socket);
                    for (int i = 0; i < currentClass.getCourses().size(); i++) {
                        assert courseName != null;
                        if (courseName.equals(currentClass.getCourses().get(i).getCourseName())) {
                            courseIndex = i;
                        }
                    }
                    String[] quizzes = new String[currentClass.getCourses().get(courseIndex).getQuizzes().size()];
                    for (int i = 0; i < currentClass.getCourses().get(courseIndex).getQuizzes().size(); i++) {
                        quizzes[i] = currentClass.getCourses().get(courseIndex).getQuizzes().get(i).getName();
                    }
                    selectQuizPanel.remove(quizBox);
                    selectQuizPanel.remove(quizSubmitButton);
                    quizBox = new JComboBox<>(quizzes);
                    selectQuizPanel.add(quizBox);
                    selectQuizPanel.add(quizSubmitButton);
                    changeQuizzesPanel.setVisible(true);
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(null, "Error! This course has no quizzes!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    mainTeacherPanel.setVisible(true);
                }
            }
            // sets quiz and shows quiz editing menu when pressed
            if (e.getSource() == quizSubmitButton) {
                selectQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String quizName = (String) quizBox.getSelectedItem();
                for (int i = 0; i < currentClass.getCourses().get(courseIndex).getQuizzes().size(); i++) {
                    assert quizName != null;
                    if (quizName.equals(currentClass.getCourses().get(courseIndex).getQuizzes().get(i).getName())) {
                        quizIndex = i;
                    }
                }
                editQuizPanel.setVisible(true);
            }

            // shows quiz name editing panel when pressed
            if (e.getSource() == editQuizName) {
                editQuizPanel.setVisible(false);
                newQuizNamePanel.setVisible(true);
            }
            // shows question creation panel when pressed
            if (e.getSource() == addNewQuestionButton) {
                editQuizPanel.setVisible(false);
                addQuestionPanel.setVisible(true);
            }
            // shows question removal panel when pressed
            if (e.getSource() == removeQuestionButton) {
                editQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] removePrompts = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    removePrompts[i] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt();
                }
                removeQuestionPanel.remove(removeQuestionBox);
                removeQuestionPanel.remove(removeQuestionSubmitButton);
                removeQuestionBox = new JComboBox<>(removePrompts);
                removeQuestionPanel.add(removeQuestionBox);
                removeQuestionPanel.add(removeQuestionSubmitButton);
                removeQuestionPanel.setVisible(true);
            }
            // shows question prompt editing panel when pressed
            if (e.getSource() == editQuestion) {
                editQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] editingPrompts = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    editingPrompts[i] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt();
                }
                editPromptPanel.remove(editPromptBox);
                editPromptPanel.remove(editPromptButton);
                editPromptBox = new JComboBox<>(editingPrompts);
                editPromptPanel.add(editPromptBox);
                editPromptPanel.add(editPromptButton);
                editPromptPanel.setVisible(true);
            }
            // shows question weight editing panel when pressed
            if (e.getSource() == editWeight) {
                editQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] editingWeights = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    editingWeights[i] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt();
                }
                editWeightPanel.remove(editWeightBox);
                editWeightPanel.remove(editWeightButton);
                editWeightBox = new JComboBox<>(editingWeights);
                editWeightPanel.add(editWeightBox);
                editWeightPanel.add(editWeightButton);
                editWeightPanel.setVisible(true);
            }
            // shows question response editing panel when pressed
            if (e.getSource() == editResponse) {
                editQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] editingResponses = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    editingResponses[i] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt();
                }
                editResponsePanel.remove(editResponseBox);
                editResponsePanel.remove(editResponseButton);
                editResponseBox = new JComboBox<>(editingResponses);
                editResponsePanel.add(editResponseBox);
                editResponsePanel.add(editResponseButton);
                editResponsePanel.setVisible(true);
            }
            // shows question answer editing panel when pressed
            if (e.getSource() == editAnswerIndex) {
                editQuizPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                String[] editingAnswers = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size()];
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    editingAnswers[i] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt();
                }
                editAnswerPanel.remove(editAnswerBox);
                editAnswerPanel.remove(editAnswerButton);
                editAnswerBox = new JComboBox<>(editingAnswers);
                editAnswerPanel.add(editAnswerBox);
                editAnswerPanel.add(editAnswerButton);
                editAnswerPanel.setVisible(true);
            }

            // randomizes order of questions in quiz when pressed
            if (e.getSource() == randomize) {
                serverCommunicator(socket, "Update Arraylist");
                readArrayList(socket);
                currentClass.getCourses().get(courseIndex).getQuizzes().get(quizIndex).randomize();
                writeArrayList(socket, currentClass.getCourses());
                JOptionPane.showMessageDialog(null, "Quiz has been successfully randomized!",
                        "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
            }


            // prompts user for new quiz name when pressed
            if (e.getSource() == newQuizNameButton) {
                if (newQuizNameField.getText() != null) {
                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).setName(newQuizNameField.getText());
                    writeArrayList(socket, currentClass.getCourses());
                    newQuizNameField.setText("");
                    newQuizNamePanel.setVisible(false);
                    editQuizPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a new quiz name!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // prompts user for new question weight and prompt when pressed
            if (e.getSource() == addQuestionButton) {
                try {
                    weight = Integer.parseInt(questionWeightField.getText());
                    prompt = questionPromptField.getText();
                    responses = new ArrayList<>();
                    addQuestionPanel.setVisible(false);
                    addResponsePanel.setVisible(true);
                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "Error! Please enter an integer!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                questionWeightField.setText("");
                questionPromptField.setText("");
            }
            // adds response to question then allows user to create another response
            if (e.getSource() == newResponseButton) {
                if (addResponseField.getText() != null) {
                    response = addResponseField.getText();
                    responses.add(response);
                    addResponseField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a response!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // adds response to question then sends user to answer selection panel
            if (e.getSource() == lastResponseButton) {
                if (addResponseField.getText() != null) {
                    response = addResponseField.getText();
                    responses.add(response);
                    String[] responseArray = new String[responses.size()];
                    for (int i = 0; i < responses.size(); i++) {
                        responseArray[i] = responses.get(i);
                    }
                    addResponseField.setText("");
                    addResponsePanel.setVisible(false);
                    addAnswerPanel.remove(addAnswerBox);
                    addAnswerPanel.remove(randomCheck);
                    addAnswerPanel.remove(addAnswerButton);
                    addAnswerPanel.remove(newQuestionButton);
                    addAnswerBox = new JComboBox<>(responseArray);
                    addAnswerPanel.add(addAnswerBox);
                    addAnswerPanel.add(randomCheck);
                    addAnswerPanel.add(addAnswerButton);
                    addAnswerPanel.add(newQuestionButton);
                    addAnswerPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a response!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // allows user to select which response is correct then returns to main menu
            if (e.getSource() == addAnswerButton) {
                String correct = (String) addAnswerBox.getSelectedItem();
                for (int i = 0; i < responses.size(); i++) {
                    assert correct != null;
                    if (correct.equals(responses.get(i))) {
                        index = i;
                    }
                }
                question = new Question(prompt, responses, index, weight);

                if (randomCheck.isSelected()) {
                    question.randomize();
                }

                serverCommunicator(socket, "Get Arraylist");
                readArrayList(socket);

                serverCommunicator(socket, "Update Arraylist");
                readArrayList(socket);
                currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).addQuestion(question, -1);
                writeArrayList(socket, currentClass.getCourses());

                addAnswerPanel.setVisible(false);
                mainTeacherPanel.setVisible(true);
            }
            // allows user to select which response is correct then create another question
            if (e.getSource() == newQuestionButton) {
                String correct = (String) addAnswerBox.getSelectedItem();
                for (int i = 0; i < responses.size(); i++) {
                    assert correct != null;
                    if (correct.equals(responses.get(i))) {
                        index = i;
                    }
                }
                question = new Question(prompt, responses, index, weight);

                if (randomCheck.isSelected()) {
                    question.randomize();
                }

                serverCommunicator(socket, "Get Arraylist");
                readArrayList(socket);

                serverCommunicator(socket, "Update Arraylist");
                readArrayList(socket);
                currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).addQuestion(question, -1);
                writeArrayList(socket, currentClass.getCourses());

                addAnswerPanel.setVisible(false);
                addQuestionPanel.setVisible(true);
            }

            // removes question from quiz when pressed
            if (e.getSource() == removeQuestionSubmitButton) {
                removeQuestionPanel.setVisible(false);

                serverCommunicator(socket, "Update Arraylist");
                readArrayList(socket);
                String removedPrompt = (String) removeQuestionBox.getSelectedItem();
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    assert removedPrompt != null;
                    if (removedPrompt.equals(currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt())) {
                        currentClass.getCourses().get(courseIndex)
                                .getQuizzes().get(quizIndex).removeQuestion(currentClass.getCourses().get(courseIndex)
                                        .getQuizzes().get(quizIndex).getQuestions().get(i));
                    }
                }
                writeArrayList(socket, currentClass.getCourses());

                mainTeacherPanel.setVisible(true);
            }

            // allows user to enter new question prompt when pressed
            if (e.getSource() == editPromptButton) {
                editPromptPanel.setVisible(false);
                prompt = (String) editPromptBox.getSelectedItem();
                newPromptPanel.setVisible(true);
            }
            // changes existing question prompt when pressed
            if (e.getSource() == newPromptButton) {
                if (newPromptField.getText() != null) {

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    String newPrompt = newPromptField.getText();
                    for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                        assert prompt != null;
                        if (prompt.equals(currentClass.getCourses().get(courseIndex)
                                .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt())) {
                            currentClass.getCourses().get(courseIndex)
                                    .getQuizzes().get(quizIndex).getQuestions().get(i).setPrompt(newPrompt);
                        }
                    }
                    writeArrayList(socket, currentClass.getCourses());

                    newPromptField.setText("");
                    newPromptPanel.setVisible(false);
                    editQuizPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a prompt!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // allows user to enter new question weight when pressed
            if (e.getSource() == editWeightButton) {
                editWeightPanel.setVisible(false);
                prompt = (String) editWeightBox.getSelectedItem();
                newWeightPanel.setVisible(true);
            }
            // changes existing question weight when pressed
            if (e.getSource() == newWeightButton) {
                if (newWeightField.getText() != null) {
                    try {
                        String weightString = newWeightField.getText();
                        weight = Integer.parseInt(weightString);

                        serverCommunicator(socket, "Update Arraylist");
                        readArrayList(socket);
                        for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                                .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                            assert prompt != null;
                            if (prompt.equals(currentClass.getCourses().get(courseIndex)
                                    .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt())) {
                                currentClass.getCourses().get(courseIndex)
                                        .getQuizzes().get(quizIndex).getQuestions().get(i).setWeight(weight);
                            }
                        }
                        writeArrayList(socket, currentClass.getCourses());

                        newWeightPanel.setVisible(false);
                        editQuizPanel.setVisible(true);
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(null, "Error! Please enter an integer!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    newWeightField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a weight!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // allows user to select which question response to edit when pressed
            if (e.getSource() == editResponseButton) {
                editResponsePanel.setVisible(false);
                prompt = (String) editResponseBox.getSelectedItem();
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    if (prompt.equals(currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt())) {
                        questionIndex = i;
                    }
                }
                String[] questionResponses = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().get(questionIndex).getResponses().size()];
                for (int x = 0; x < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions()
                        .get(questionIndex).getResponses().size(); x++) {
                    questionResponses[x] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions()
                            .get(questionIndex).getResponses().get(x);
                }
                newResponsePanel.remove(newResponseBox);
                newResponseBox = new JComboBox<>(questionResponses);
                newResponsePanel.add(newResponseBox, BorderLayout.WEST);
                newResponsePanel.setVisible(true);
            }
            // allows user to enter new question response when pressed
            if (e.getSource() == newResponseSubmitButton) {
                newResponsePanel.setVisible(false);
                response = (String) newResponseBox.getSelectedItem();
                enterResponsePanel.setVisible(true);
            }
            // changes existing question response when pressed
            if (e.getSource() == enterResponseButton) {
                if (enterResponseField.getText() != null) {
                    String enteredResponse = enterResponseField.getText();

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions()
                            .get(questionIndex).getResponses().size(); i++) {
                        if (response.equals(currentClass.getCourses().get(courseIndex)
                                .getQuizzes().get(quizIndex).getQuestions()
                                .get(questionIndex).getResponses().get(i))) {
                            currentClass.getCourses().get(courseIndex)
                                    .getQuizzes().get(quizIndex).getQuestions()
                                    .get(questionIndex).getResponses().set(i, enteredResponse);
                        }
                    }
                    writeArrayList(socket, currentClass.getCourses());

                    enterResponseField.setText("");
                    enterResponsePanel.setVisible(false);
                    editQuizPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a new response!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // allows user to select new question answer from existing response list when pressed
            if (e.getSource() == editAnswerButton) {
                editAnswerPanel.setVisible(false);
                prompt = (String) editAnswerBox.getSelectedItem();
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions().size(); i++) {
                    if (prompt.equals(currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions().get(i).getPrompt())) {
                        questionIndex = i;
                    }
                }
                String[] questionResponses = new String[currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions()
                        .get(questionIndex).getResponses().size()];
                for (int x = 0; x < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions()
                        .get(questionIndex).getResponses().size(); x++) {
                    questionResponses[x] = currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions()
                            .get(questionIndex).getResponses().get(x);
                }
                responseSelectionPanel.remove(responseSelection);
                responseSelection = new JComboBox<>(questionResponses);
                responseSelectionPanel.add(responseSelection, BorderLayout.WEST);
                responseSelectionPanel.setVisible(true);
            }
            // changes existing question answer when pressed
            if (e.getSource() == getResponseSelection) {
                responseSelectionPanel.setVisible(false);
                response = (String) responseSelection.getSelectedItem();
                int responseNumber = 0;

                serverCommunicator(socket, "Update Arraylist");
                readArrayList(socket);
                for (int i = 0; i < currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions()
                        .get(questionIndex).getResponses().size(); i++) { //use question index
                    assert response != null;
                    if (response.equals(currentClass.getCourses().get(courseIndex)
                            .getQuizzes().get(quizIndex).getQuestions()
                            .get(questionIndex).getResponses().get(i))) { // use question index
                        responseNumber = i;
                    }
                }
                currentClass.getCourses().get(courseIndex)
                        .getQuizzes().get(quizIndex).getQuestions()
                        .get(questionIndex).setAnswer(responseNumber);
                writeArrayList(socket, currentClass.getCourses());

                editQuizPanel.setVisible(true);
            }

            // Delete/Create Quiz GUI ------------------------------------------------------

            // deletes quiz from course when pressed
            if (e.getSource() == deleteQuizButton) {
                int confirmDelete = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this quiz?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirmDelete == JOptionPane.YES_OPTION) {
                    deleteQuizPanel.setVisible(false);
                    String deleteQuizName = (String) deleteQuizBox.getSelectedItem();

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    for (int i = 0; i < currentClass.getCourses().get(courseIndex).getQuizzes().size(); i++) {
                        assert deleteQuizName != null;
                        if (deleteQuizName.equals(currentClass.getCourses().get(courseIndex)
                                .getQuizzes().get(i).getName())) {
                            currentClass.getCourses().get(courseIndex).getQuizzes().remove(i);
                        }
                    }
                    writeArrayList(socket, currentClass.getCourses());

                    mainTeacherPanel.setVisible(true);
                }
            }

            // allows user to enter quiz file name and creates quiz when pressed
            if (e.getSource() == quizFileButton) {
                if (quizFileField.getText() != null) {
                    String filename = quizFileField.getText();
                    quiz = new Quiz(filename);

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    currentClass.getCourses().get(courseIndex).getQuizzes().add(quiz);
                    writeArrayList(socket, currentClass.getCourses());

                    quizIndex = currentClass.getCourses().get(courseIndex).getQuizzes().size() - 1;
                    quizFileField.setText("");
                    quizFilePanel.setVisible(false);
                    mainTeacherPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a file name!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // allows user to enter new quiz name and begin question creation when pressed
            if (e.getSource() == quizNameButton) {
                if (quizNameField.getText() != null) {
                    quizName = quizNameField.getText();
                    questions = new ArrayList<>();
                    quiz = new Quiz(quizName, questions);

                    /*for (int i = 0; i < currentClass.getCourses().size(); i++) {
                        System.out.println(currentClass.getCourses().get(i).getCourseName());
                    }*/

                    serverCommunicator(socket, "Get Arraylist");
                    readArrayList(socket);

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);

                    /*for (int i = 0; i < currentClass.getCourses().size(); i++) {
                        System.out.println(currentClass.getCourses().get(i).getCourseName());
                    }

                    System.out.println(courseIndex);
                    System.out.println(currentClass.getCourses().size());*/
                    currentClass.getCourses().get(courseIndex).getQuizzes().add(quiz);
                    //serverCommunicator(socket, "Sending Arraylist");
                    writeArrayList(socket, currentClass.getCourses());

                    quizIndex = currentClass.getCourses().get(courseIndex).getQuizzes().size() - 1;
                    quizNameField.setText("");
                    quizNamePanel.setVisible(false);
                    addQuestionPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a quiz name!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Delete/Create Course GUI ------------------------------------------------------

            // allows user to delete entire course when pressed
            if (e.getSource() == deleteCourseButton) {
                int confirmDelete = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this course?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirmDelete == JOptionPane.YES_OPTION) {
                    deleteCoursePanel.setVisible(false);
                    String deleteCourseName = (String) deleteCourseBox.getSelectedItem();

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    for (int i = 0; i < currentClass.getCourses().size(); i++) {
                        assert deleteCourseName != null;
                        if (deleteCourseName.equals(currentClass.getCourses().get(i).getCourseName())) {
                            currentClass.getCourses().remove(i);
                        }
                    }
                    writeArrayList(socket, currentClass.getCourses());

                    mainTeacherPanel.setVisible(true);
                }
            }

            // allows user to enter course name and begin quiz creation when pressed
            if (e.getSource() == newCourseButton) {
                if (newCourseField.getText() != null) {
                    courseName = newCourseField.getText();
                    quizzes = new ArrayList<>();
                    course = new Course(courseName, quizzes);

                    serverCommunicator(socket, "Update Arraylist");
                    readArrayList(socket);
                    currentClass.getCourses().add(course);
                    writeArrayList(socket, currentClass.getCourses());

                    courseIndex = currentClass.getCourses().size() - 1;
                    System.out.println(courseIndex);
                    newCourseField.setText("");
                    newCoursePanel.setVisible(false);
                    createAQuizPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error! Please enter a course name!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Take Quiz GUI ------------------------------------------------------

            if (e.getSource() == courseChoiceSubmit) {
                takeChooseCoursePanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                quizList = new ArrayList<>();
                cSelection = (String) courseChoice.getSelectedItem();
                courseSelection = 0;

                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).equals(cSelection)) {
                        courseSelection = i;
                    }
                }

                courseSelection++;
                int quizCounter = 0;
                for (int f = 0; f < currentClass.getCourses().get(courseSelection - 1).getQuizzes().size(); f++) {
                    quizList.add(currentClass.getCourses().get(courseSelection - 1)
                            .getQuizzes().get(quizCounter).getName());
                    quizCounter++;
                }
                takeChooseQuizPanel.remove(pickQuizLabel);
                takeChooseQuizPanel.remove(quizChoice);
                quizChoice = new JComboBox(quizList.toArray());
                pickQuizLabel = new JLabel("Pick a quiz: ");
                takeChooseQuizPanel.add(pickQuizLabel, 0);
                takeChooseQuizPanel.add(quizChoice, 1);
                takeChooseQuizPanel.setVisible(true);
            }
            if (e.getSource() == quizChoiceSubmit) {
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                takeChooseQuizPanel.setVisible(false);
                qSelection = (String) quizChoice.getSelectedItem();
                quizSelection = 0;
                for (int i = 0; i < quizList.size(); i++) {
                    if (quizList.get(i).equals(qSelection)) {
                        quizSelection = i;
                    }
                }
                quizSelection++;
                int num = currentClass.getCourses().get(courseSelection - 1)
                        .getQuizzes().get(quizSelection - 1).getQuestions().size();
                questionPrompt = new JLabel[num];
                answerChoices = new JComboBox[num];
                for (int i = 0; i < num; i++) {
                    questionPrompt[i] = new JLabel(currentClass.getCourses().get(courseSelection - 1)
                            .getQuizzes().get(quizSelection - 1).getQuestions().get(i).getPrompt());
                    answerChoices[i] = new JComboBox(currentClass.getCourses().get(courseSelection - 1)
                            .getQuizzes().get(quizSelection - 1).getQuestions().get(i).getResponses().toArray());
                    takeQuiz.add(questionPrompt[i]);
                    takeQuiz.add(answerChoices[i]);
                }
                takeQuiz.add(takeQuizSubmit);
                takeQuiz.setVisible(true);
            }
            if (e.getSource() == takeQuizSubmit) {
                takeQuiz.setVisible(false);
                responseList = new ArrayList<>();
                int num = currentClass.getCourses().get(courseSelection - 1)
                        .getQuizzes().get(quizSelection - 1).getQuestions().size();
                for (int i = 0; i < num; i++) {
                    responseList.add((String) answerChoices[i].getSelectedItem());
                }
                submitPanel.setVisible(true);
            }
            if (e.getSource() == submitYesButton) {
                submitPanel.setVisible(false);
                Date date = new Date();
                long time = date.getTime();
                Timestamp timestamp = new Timestamp(time);
                Submission submission = new Submission(user,
                        currentClass.getCourses().get(courseSelection - 1).getQuizzes()
                                .get(quizSelection - 1), currentClass.getCourses().get(courseSelection - 1),
                        responseList, timestamp.toString(), false, new ArrayList<>());
                submission.addSubmission(submission, true);
                mainStudentPanel.setVisible(true);
            }
            if (e.getSource() == submitNoButton) {
                submitPanel.setVisible(false);
                int num = currentClass.getCourses().get(courseSelection - 1)
                        .getQuizzes().get(quizSelection - 1).getQuestions().size();
                Integer[] qNum = new Integer[num];
                for (int i = 0; i < num; i++) {
                    qNum[i] = i + 1;
                }
                questionNumbers = new JComboBox(qNum);

                submitPanelNo.add(questionNumbers, 1);

                submitPanelNo.setVisible(true);
            }
            if (e.getSource() == submitPanelNoButton) {
                submitPanelNo.setVisible(false);
                questionNumber = questionNumbers.getSelectedIndex();
                String question = currentClass.getCourses()
                        .get(courseSelection - 1).getQuizzes().get(quizSelection - 1).
                        getQuestions().get(questionNumber).getPrompt();
                changeAnswerPrompt = new JLabel(question);
                changeAnswer.add(changeAnswerPrompt);
                changeAnswer.add(answerChoices[questionNumber]);

                changeAnswer.setVisible(true);
            }
            if (e.getSource() == changeAnswerSubmit) {
                changeAnswer.setVisible(false);
                Date date = new Date();
                long time = date.getTime();
                Timestamp timestamp = new Timestamp(time);
                responseList.set(questionNumbers.getSelectedIndex(),
                        (String) answerChoices[questionNumber].getSelectedItem());
                Submission submission = new Submission(user,
                        currentClass.getCourses().get(courseSelection - 1).getQuizzes()
                                .get(quizSelection - 1), currentClass.getCourses().get(courseSelection - 1),
                        responseList, timestamp.toString(), false, new ArrayList<>());
                mainStudentPanel.setVisible(true);
            }

            // Submissions GUI ------------------------------------------------------

            if (e.getSource() == viewButton) {
                mainStudentPanel.setVisible(false);
                serverCommunicator(socket, "Get ArrayList");
                readArrayList(socket);
                courses = new ArrayList<>();

                int courseCounter = 0;
                for (int f = 0; f < currentClass.getCourses().size(); f++) {
                    courses.add(currentClass.getCourses().get(courseCounter).getCourseName());
                    courseCounter++;
                }
                viewChooseCoursePanel.remove(pickCourseLabel);
                viewChooseCoursePanel.remove(courseChoiceView);
                courseChoiceView = new JComboBox(courses.toArray());
                pickCourseLabel = new JLabel("Pick a course: ");
                viewChooseCoursePanel.add(pickCourseLabel, 0);
                viewChooseCoursePanel.add(courseChoiceView, 1);
                viewChooseCoursePanel.setVisible(true);
            }
            if (e.getSource() == viewChooseCourseButton) {
                viewChooseCoursePanel.setVisible(false);
                quizList = new ArrayList<>();
                cSelection = (String) courseChoiceView.getSelectedItem();
                courseSelection = 0;

                for (int i = 0; i < courses.size(); i++) {
                    if (courses.get(i).equals(cSelection)) {
                        courseSelection = i;
                    }
                }

                courseSelection++;
                int quizCounter = 0;
                for (int f = 0; f < currentClass.getCourses().get(courseSelection - 1).getQuizzes().size(); f++) {
                    quizList.add(currentClass.getCourses().get(courseSelection - 1)
                            .getQuizzes().get(quizCounter).getName());
                    quizCounter++;
                }

                viewChooseQuizPanel.remove(pickQuizLabel);
                viewChooseQuizPanel.remove(quizChoiceView);
                quizChoiceView = new JComboBox(quizList.toArray());
                pickQuizLabel = new JLabel("Pick a quiz: ");
                viewChooseQuizPanel.add(pickQuizLabel, 0);
                viewChooseQuizPanel.add(quizChoiceView, 1);
                viewChooseQuizPanel.setVisible(true);
            }
            if (e.getSource() == viewChooseQuizButton) {
                viewChooseQuizPanel.setVisible(false);

                String results = "";
                courseSelection = courseChoiceView.getSelectedIndex() + 1;
                quizSelection = quizChoiceView.getSelectedIndex();
                ArrayList<Submission> submissions = QuizMenu.readSubmissions(currentClass);
                //assert submissions != null;
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                if (submissions != null) {
                    int counter = 0;
                    for (Submission s : submissions) {
                        if (s.getStudent().getUsername().equals(user.getUsername())
                                && s.getCourseOfQuiz().getCourseName()
                                .equals(currentClass.getCourses().get(courseSelection - 1).getCourseName())
                                && s.getQuizBeingTaken().getName()
                                .equals(currentClass.getCourses().get(courseSelection - 1)
                                        .getQuizzes().get(quizSelection).getName())
                                && !s.isGraded()) {
                            results += String.format("Quiz Name: %s\n", s.getQuizBeingTaken().getName());
                            for (int i = 0; i < s.getResponses().size(); i++) {
                                results += String.format("Question: %s\n", s.getQuizBeingTaken().getQuestions().get(i));
                                results += String.format("Your Answer: %s\n", s.getResponses().get(i));
                                results += String.format("Your Grade: Not Graded\n");
                            }
                            results += String.format("Submission Timestamp: %s\n", s.getTime());
                        } else if (s.getStudent().getUsername().equals(user.getUsername())
                                && s.getCourseOfQuiz().getCourseName()
                                .equals(currentClass.getCourses().get(courseSelection - 1).getCourseName())
                                && s.getQuizBeingTaken().getName()
                                .equals(currentClass.getCourses().get(courseSelection - 1)
                                        .getQuizzes().get(quizSelection).getName())
                                && s.isGraded()) {
                            results += String.format("Quiz Name: %s\n", s.getQuizBeingTaken().getName());
                            for (int i = 0; i < s.getResponses().size(); i++) {
                                results += String.format("Question: %s\n", s.getQuizBeingTaken().getQuestions().get(i));
                                results += String.format("Your Answer: %s\n", s.getResponses().get(i));
                                results += String.format("Your Grade: %s\n", s.getGrades().get(i));
                            }
                            results += String.format("Submission Timestamp: %s\n", s.getTime());
                        } else if (!(s.getStudent().getUsername().equals(user.getUsername())
                                && s.getCourseOfQuiz().getCourseName()
                                .equals(currentClass.getCourses().get(courseSelection - 1).getCourseName())
                                && s.getQuizBeingTaken().getName()
                                .equals(currentClass.getCourses().get(courseSelection - 1)
                                        .getQuizzes().get(quizSelection).getName())) && (results.equals(""))) {
                            results = String.format("Quiz Name: %s\nNo Submissions to view",
                                    currentClass.getCourses().get(courseSelection - 1)
                                            .getQuizzes().get(quizSelection).getName());
                        }
                    }
                    counter++;
                } else {
                    results = "No Submissions to view\n";
                }
                viewSubmission.remove(submissionsDetails);
                submissionsDetails = new JTextArea(results);
                viewSubmission.add(submissionsDetails, 0);
                viewSubmission.setVisible(true);
            }
            if (e.getSource() == mainMenuButton) {
                viewSubmission.setVisible(false);
                mainStudentPanel.setVisible(true);
            }
        }
    };

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 3005);
        } catch (IOException i) {
            JOptionPane.showMessageDialog(null, "Error! Failed connection!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        SwingUtilities.invokeLater(new Login());
    }

    public void run() {
        JFrame frame = new JFrame("Quiz Application");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        login = new Login();
        container.add(login, BorderLayout.CENTER);

        serverCommunicator(socket, "Get ArrayList");
        ArrayList<Course> firstCourses = new ArrayList<>();
        currentClass = new Class(firstCourses);
        readArrayList(socket);

        frame.setSize(1200, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        // creates menu bar
        menuBar = new JMenuBar();
        topMenu = new JMenu("Options");
        topMenu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(topMenu);
        logoutItem = new JMenuItem("Log Out", KeyEvent.VK_T);
        logoutItem.addActionListener(actionListener);
        mainItem = new JMenuItem("Main Menu", KeyEvent.VK_T);
        mainItem.addActionListener(actionListener);
        topMenu.add(logoutItem);
        topMenu.add(mainItem);
        mainItem.setVisible(false);
        frame.setJMenuBar(menuBar);

        // creates top-level panel containing all others
        panel = new JPanel();
        container.add(panel, BorderLayout.CENTER);

        // Login GUI ------------------------------------------------------

        // creates welcome panel
        welcomeLabel = new JLabel("Welcome to the quiz application! Log in or create a new user account:");
        loginButton = new JButton("Log In");
        loginButton.addActionListener(actionListener);
        createButton = new JButton("Create New Account");
        createButton.addActionListener(actionListener);

        welcomePanel = new JPanel();
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(loginButton);
        welcomePanel.add(createButton);
        panel.add(welcomePanel, BorderLayout.CENTER);
        welcomePanel.setVisible(true);

        // creates login panel
        userLabel = new JLabel("Username:");
        userText = new JTextField(20);
        passLabel = new JLabel("Password:");
        passText = new JPasswordField(20);
        userOptions = new String[2];
        userOptions[0] = "Teacher";
        userOptions[1] = "Student";
        userBox = new JComboBox<>(userOptions);
        loginSubmitButton = new JButton("Submit");
        loginSubmitButton.addActionListener(actionListener);

        loginPanel = new JPanel();
        loginPanel.add(userLabel);
        loginPanel.add(userText);
        loginPanel.add(passLabel);
        loginPanel.add(passText);
        loginPanel.add(userBox);
        loginPanel.add(loginSubmitButton);
        panel.add(loginPanel, BorderLayout.CENTER);
        loginPanel.setVisible(false);

        // creates main menu panel for teachers
        teacherSettingsButton = new JButton("Account Settings");
        teacherSettingsButton.addActionListener(actionListener);
        createEditButton = new JButton("Create and Edit");
        createEditButton.addActionListener(actionListener);

        mainTeacherPanel = new JPanel();
        mainTeacherPanel.add(teacherSettingsButton);
        mainTeacherPanel.add(createEditButton);
        panel.add(mainTeacherPanel, BorderLayout.CENTER);
        mainTeacherPanel.setVisible(false);

        // creates main menu panel for students
        studentSettingsButton = new JButton("Account Settings");
        studentSettingsButton.addActionListener(actionListener);
        takeButton = new JButton("Take Quiz");
        takeButton.addActionListener(actionListener);
        viewButton = new JButton("View Quiz Results");
        viewButton.addActionListener(actionListener);

        mainStudentPanel = new JPanel();
        mainStudentPanel.add(studentSettingsButton);
        mainStudentPanel.add(takeButton);
        mainStudentPanel.add(viewButton);
        panel.add(mainStudentPanel, BorderLayout.CENTER);
        mainStudentPanel.setVisible(false);

        // creates account settings panel
        editButton = new JButton("Edit Account");
        editButton.addActionListener(actionListener);
        deleteButton = new JButton("Delete Account");
        deleteButton.addActionListener(actionListener);

        settingsPanel = new JPanel();
        settingsPanel.add(editButton);
        settingsPanel.add(deleteButton);
        panel.add(settingsPanel, BorderLayout.CENTER);
        settingsPanel.setVisible(false);

        // creates account editing panel
        editUserButton = new JButton("Edit Username");
        editUserButton.addActionListener(actionListener);
        editPassButton = new JButton("Edit Password");
        editPassButton.addActionListener(actionListener);

        editAccountPanel = new JPanel();
        editAccountPanel.add(editUserButton);
        editAccountPanel.add(editPassButton);
        panel.add(editAccountPanel, BorderLayout.CENTER);
        editAccountPanel.setVisible(false);

        // creates username editing panel
        newUsernameLabel = new JLabel("What is your new username?");
        newUsernameText = new JTextField(20);
        newUsernameButton = new JButton("Submit");
        newUsernameButton.addActionListener(actionListener);

        editUserPanel = new JPanel();
        editUserPanel.add(newUsernameLabel);
        editUserPanel.add(newUsernameText);
        editUserPanel.add(newUsernameButton);
        panel.add(editUserPanel, BorderLayout.CENTER);
        editUserPanel.setVisible(false);

        // creates password editing panel
        newPasswordLabel = new JLabel("What is your new password?");
        newPasswordText = new JPasswordField(20);
        newPasswordButton = new JButton("Submit");
        newPasswordButton.addActionListener(actionListener);

        editPassPanel = new JPanel();
        editPassPanel.add(newPasswordLabel);
        editPassPanel.add(newPasswordText);
        editPassPanel.add(newPasswordButton);
        panel.add(editPassPanel, BorderLayout.CENTER);
        editPassPanel.setVisible(false);

        // creates account creation panel
        createUserLabel = new JLabel("Username");
        createUserText = new JTextField(20);
        createPassLabel = new JLabel("Password:");
        createPassText = new JPasswordField(20);
        newTeacherBox = new JComboBox<>(userOptions);
        newSubmitButton = new JButton("Submit");
        newSubmitButton.addActionListener(actionListener);

        createPanel = new JPanel();
        createPanel.add(createUserLabel);
        createPanel.add(createUserText);
        createPanel.add(createPassLabel);
        createPanel.add(createPassText);
        createPanel.add(newTeacherBox);
        createPanel.add(newSubmitButton);
        panel.add(createPanel, BorderLayout.CENTER);
        createPanel.setVisible(false);

        // Edit Quiz GUI ------------------------------------------------------

        // creates "create and edit" panel
        //CREATE AND EDIT MENU - Creates the Change Quizzes Button
        changeQuizzes = new JButton("Change Quizzes");
        Dimension accountSettingsSize = changeQuizzes.getPreferredSize();
        changeQuizzes.setBounds(75, 80, 150, accountSettingsSize.height);
        changeQuizzes.addActionListener(actionListener);

        //CREATE AND EDIT MENU - creates the Create A Course Button
        createACourse = new JButton("Create a Course");
        Dimension createAndEditSiz = createACourse.getPreferredSize();
        createACourse.setBounds(75, 130, 150, createAndEditSiz.height);
        createACourse.addActionListener(actionListener);

        //CREATE AND EDIT MENU - creates the Delete A Course Button
        deleteACourse = new JButton("Delete A Course");
        deleteACourse.addActionListener(actionListener);

        //CREATE AND EDIT MENU - Creates the view Student Submissions Button
        viewStudentSubmissions = new JButton("Grade Quizzes");
        Dimension viewStudentSubmissionsSiz = viewStudentSubmissions.getPreferredSize();
        viewStudentSubmissions.setBounds(75, 180, 150, viewStudentSubmissionsSiz.height);
        viewStudentSubmissions.addActionListener(actionListener);

        // CREATE AND EDIT MENU - creates the Menu
        createAndEditPanel = new JPanel();
        panel.add(createAndEditPanel, BorderLayout.CENTER);
        createAndEditPanel.add(changeQuizzes);
        createAndEditPanel.add(createACourse);
        createAndEditPanel.add(deleteACourse);
        createAndEditPanel.add(viewStudentSubmissions);
        createAndEditPanel.setVisible(false);

        // creates change quizzes panel
        //CHANGE QUIZZES MENU - creates the Edit Quizzes Button
        editQuizzes = new JButton("Edit Quiz");
        Dimension editQuizzesSize = editQuizzes.getPreferredSize();
        editQuizzes.setBounds(75, 80, 150, editQuizzesSize.height);
        editQuizzes.addActionListener(actionListener);

        //CHANGE QUIZZES MENU - creates the Create A Quiz Button
        createAQuiz = new JButton("Create a Quiz");
        Dimension createAQuizSiz = createAQuiz.getPreferredSize();
        createAQuiz.setBounds(75, 130, 150, createAQuizSiz.height);
        createAQuiz.addActionListener(actionListener);

        //CHANGE QUIZZES MENU - creates the "Delete Quiz" Button
        deleteQuiz = new JButton("Delete Quiz");
        Dimension deleteQuizPreferredSize = deleteQuiz.getPreferredSize();
        deleteQuiz.setBounds(75, 180, 150, deleteQuizPreferredSize.height);
        deleteQuiz.addActionListener(actionListener);

        //CHANGE QUIZZES MENU - creates JPanel
        changeQuizzesPanel = new JPanel();
        panel.add(changeQuizzesPanel, BorderLayout.CENTER);
        changeQuizzesPanel.add(editQuizzes);
        changeQuizzesPanel.add(createAQuiz);
        changeQuizzesPanel.add(deleteQuiz);
        changeQuizzesPanel.setVisible(false);

        // creates quiz creation panel
        //CREATE A QUIZ MENU - adds the "Create a Quiz Manually" Button
        createAQuizManual = new JButton("Create a Quiz");
        createAQuizManual.addActionListener(actionListener);

        //CREATE A QUIZ MENU - adds the Upload a Quiz File Button
        uploadAQuiz = new JButton("Upload A Quiz File");
        uploadAQuiz.addActionListener(actionListener);

        //CREATE A QUIZ MENU - creates the JPanel
        createAQuizPanel = new JPanel();
        panel.add(createAQuizPanel, BorderLayout.SOUTH);
        createAQuizPanel.add(createAQuizManual);
        createAQuizPanel.add(uploadAQuiz);
        createAQuizPanel.setVisible(false);

        // creates course selection panel
        courseLabel = new JLabel("Please select a course from the list:");
        courseBox = new JComboBox<>();
        courseSubmitButton = new JButton("Submit");
        courseSubmitButton.addActionListener(actionListener);

        selectCoursePanel = new JPanel();
        selectCoursePanel.add(courseLabel);
        selectCoursePanel.add(courseBox);
        selectCoursePanel.add(courseSubmitButton);
        panel.add(selectCoursePanel, BorderLayout.CENTER);
        selectCoursePanel.setVisible(false);

        // creates quiz selection panel
        quizLabel = new JLabel("Please select a quiz from the list");
        quizBox = new JComboBox<>();
        quizSubmitButton = new JButton("Submit");
        quizSubmitButton.addActionListener(actionListener);

        selectQuizPanel = new JPanel();
        selectQuizPanel.add(quizLabel);
        selectQuizPanel.add(quizBox);
        selectQuizPanel.add(quizSubmitButton);
        panel.add(selectQuizPanel, BorderLayout.CENTER);
        selectQuizPanel.setVisible(false);

        // creates editing menu panel
        editQuizName = new JButton("Edit Quiz Name");
        editQuizName.addActionListener(actionListener);
        addNewQuestionButton = new JButton("Add Question");
        addNewQuestionButton.addActionListener(actionListener);
        removeQuestionButton = new JButton("Remove Question");
        removeQuestionButton.addActionListener(actionListener);
        editQuestion = new JButton("Edit Question");
        editQuestion.addActionListener(actionListener);
        editWeight = new JButton("Edit Weight");
        editWeight.addActionListener(actionListener);
        editResponse = new JButton("Edit Question Answer");
        editResponse.addActionListener(actionListener);
        editAnswerIndex = new JButton("Change Correct Answer");
        editAnswerIndex.addActionListener(actionListener);
        randomize = new JButton("Randomize Quiz");
        randomize.addActionListener(actionListener);

        editQuizPanel = new JPanel();
        editQuizPanel.add(editQuizName);
        editQuizPanel.add(addNewQuestionButton);
        editQuizPanel.add(removeQuestionButton);
        editQuizPanel.add(editQuestion);
        editQuizPanel.add(editWeight);
        editQuizPanel.add(editResponse);
        editQuizPanel.add(editAnswerIndex);
        editQuizPanel.add(randomize);
        panel.add(editQuizPanel, BorderLayout.CENTER);
        editQuizPanel.setVisible(false);

        // creates quiz name changing panel
        newQuizNameLabel = new JLabel("Enter the new quiz name: ");
        newQuizNameField = new JTextField(20);
        newQuizNameButton = new JButton("Submit");
        newQuizNameButton.addActionListener(actionListener);

        newQuizNamePanel = new JPanel();
        newQuizNamePanel.add(newQuizNameLabel);
        newQuizNamePanel.add(newQuizNameField);
        newQuizNamePanel.add(newQuizNameButton);
        panel.add(newQuizNamePanel, BorderLayout.CENTER);
        newQuizNamePanel.setVisible(false);

        // creates question adding panel
        questionPromptLabel = new JLabel("New Question Prompt: ");
        questionPromptField = new JTextField(20);
        questionWeightLabel = new JLabel("Question Weight: ");
        questionWeightField = new JTextField(10);
        addQuestionButton = new JButton("Submit");
        addQuestionButton.addActionListener(actionListener);

        addQuestionPanel = new JPanel();
        addQuestionPanel.add(questionPromptLabel);
        addQuestionPanel.add(questionPromptField);
        addQuestionPanel.add(questionWeightLabel);
        addQuestionPanel.add(questionWeightField);
        addQuestionPanel.add(addQuestionButton);
        panel.add(addQuestionPanel, BorderLayout.CENTER);
        addQuestionPanel.setVisible(false);

        // creates response adding panel
        addResponseLabel = new JLabel("New Answer Choice: ");
        addResponseField = new JTextField(20);
        newResponseButton = new JButton("Add Another Answer Choice");
        newResponseButton.addActionListener(actionListener);
        lastResponseButton = new JButton("Submit Answer Choice");
        lastResponseButton.addActionListener(actionListener);

        addResponsePanel = new JPanel();
        addResponsePanel.add(addResponseLabel);
        addResponsePanel.add(addResponseField);
        addResponsePanel.add(lastResponseButton);
        addResponsePanel.add(newResponseButton);
        panel.add(addResponsePanel, BorderLayout.CENTER);
        addResponsePanel.setVisible(false);

        // creates answer choosing panel
        addAnswerLabel = new JLabel("Select which answer choice is correct: ");
        addAnswerBox = new JComboBox<>();
        randomCheck = new JCheckBox("Randomize question");
        addAnswerButton = new JButton("Submit Question");
        addAnswerButton.addActionListener(actionListener);
        newQuestionButton = new JButton("Add Another Question");
        newQuestionButton.addActionListener(actionListener);

        addAnswerPanel = new JPanel();
        addAnswerPanel.add(addAnswerLabel);
        addAnswerPanel.add(addAnswerBox);
        addAnswerPanel.add(randomCheck);
        addAnswerPanel.add(addAnswerButton);
        addAnswerPanel.add(newQuestionButton);
        panel.add(addAnswerPanel, BorderLayout.CENTER);
        addAnswerPanel.setVisible(false);

        // creates question removing panel
        removeQuestionLabel = new JLabel("Select a question to remove: ");
        removeQuestionBox = new JComboBox<>();
        removeQuestionSubmitButton = new JButton("Remove");
        removeQuestionSubmitButton.addActionListener(actionListener);

        removeQuestionPanel = new JPanel();
        removeQuestionPanel.add(removeQuestionLabel);
        removeQuestionPanel.add(removeQuestionBox);
        removeQuestionPanel.add(removeQuestionSubmitButton);
        panel.add(removeQuestionPanel, BorderLayout.CENTER);
        removeQuestionPanel.setVisible(false);

        // creates prompt editing panel
        editPromptLabel = new JLabel("Select question you would like to edit: ");
        editPromptBox = new JComboBox<>();
        editPromptButton = new JButton("Submit");
        editPromptButton.addActionListener(actionListener);

        editPromptPanel = new JPanel();
        editPromptPanel.add(editPromptLabel);
        editPromptPanel.add(editPromptBox);
        editPromptPanel.add(editPromptButton);
        panel.add(editPromptPanel, BorderLayout.CENTER);
        editPromptPanel.setVisible(false);

        // creates panel for entering new prompt
        newPromptLabel = new JLabel("Enter new prompt: ");
        newPromptField = new JTextField(20);
        newPromptButton = new JButton("Submit");
        newPromptButton.addActionListener(actionListener);

        newPromptPanel = new JPanel();
        newPromptPanel.add(newPromptLabel);
        newPromptPanel.add(newPromptField);
        newPromptPanel.add(newPromptButton);
        panel.add(newPromptPanel, BorderLayout.CENTER);
        newPromptPanel.setVisible(false);

        // creates weight editing panel
        editWeightLabel = new JLabel("Select question you would like to edit: ");
        editWeightBox = new JComboBox<>();
        editWeightButton = new JButton("Submit");
        editWeightButton.addActionListener(actionListener);

        editWeightPanel = new JPanel();
        editWeightPanel.add(editWeightLabel);
        editWeightPanel.add(editWeightBox);
        editWeightPanel.add(editWeightButton);
        panel.add(editWeightPanel, BorderLayout.CENTER);
        editWeightPanel.setVisible(false);

        // creates panel for entering new weight
        newWeightLabel = new JLabel("Enter new weight: ");
        newWeightField = new JTextField(10);
        newWeightButton = new JButton("Submit");
        newWeightButton.addActionListener(actionListener);

        newWeightPanel = new JPanel();
        newWeightPanel.add(newWeightLabel);
        newWeightPanel.add(newWeightField);
        newWeightPanel.add(newWeightButton);
        panel.add(newWeightPanel, BorderLayout.CENTER);
        newWeightPanel.setVisible(false);

        // creates panel for editing response
        editResponseLabel = new JLabel("Select which question you would like to edit: ");
        editResponseBox = new JComboBox<>();
        editResponseButton = new JButton("Submit");
        editResponseButton.addActionListener(actionListener);

        editResponsePanel = new JPanel();
        editResponsePanel.add(editResponseLabel);
        editResponsePanel.add(editResponseBox);
        editResponsePanel.add(editResponseButton);
        panel.add(editResponsePanel, BorderLayout.CENTER);
        editResponsePanel.setVisible(false);

        // creates panel for selecting response to edit
        newResponseBox = new JComboBox<>();
        newResponseSubmitButton = new JButton("Select Response to Edit");
        newResponseSubmitButton.addActionListener(actionListener);

        newResponsePanel = new JPanel();
        newResponsePanel.add(newResponseBox);
        newResponsePanel.add(newResponseSubmitButton);
        panel.add(newResponsePanel);
        newResponsePanel.setVisible(false);

        // creates panel for entering new response
        enterResponseLabel = new JLabel("Enter the new response: ");
        enterResponseField = new JTextField(20);
        enterResponseButton = new JButton("Submit");
        enterResponseButton.addActionListener(actionListener);

        enterResponsePanel = new JPanel();
        enterResponsePanel.add(enterResponseLabel);
        enterResponsePanel.add(enterResponseField);
        enterResponsePanel.add(enterResponseButton);
        panel.add(enterResponsePanel, BorderLayout.CENTER);
        enterResponsePanel.setVisible(false);

        // creates panel for changing answer index
        editAnswerLabel = new JLabel("Select which question you would like to edit: ");
        editAnswerBox = new JComboBox<>();
        editAnswerButton = new JButton("Submit");
        editAnswerButton.addActionListener(actionListener);

        editAnswerPanel = new JPanel();
        editAnswerPanel.add(editAnswerLabel);
        editAnswerPanel.add(editAnswerBox);
        editAnswerPanel.add(editAnswerButton);
        panel.add(editAnswerPanel, BorderLayout.CENTER);
        editAnswerPanel.setVisible(false);

        // creates panel for selecting new answer
        responseSelection = new JComboBox<>();
        getResponseSelection = new JButton("Select New Correct Answer");
        getResponseSelection.addActionListener(actionListener);

        responseSelectionPanel = new JPanel();
        responseSelectionPanel.add(responseSelection);
        responseSelectionPanel.add(getResponseSelection);
        panel.add(responseSelectionPanel, BorderLayout.CENTER);
        responseSelectionPanel.setVisible(false);

        // Delete/Create Quiz GUI ------------------------------------------------------

        // creates delete quiz panel
        deleteQuizLabel = new JLabel("Select a quiz to delete from this course: ");
        deleteQuizBox = new JComboBox<>();
        deleteQuizButton = new JButton("Delete");
        deleteQuizButton.addActionListener(actionListener);

        deleteQuizPanel = new JPanel();
        deleteQuizPanel.add(deleteQuizLabel);
        deleteQuizPanel.add(deleteQuizBox);
        deleteQuizPanel.add(deleteQuizButton);
        panel.add(deleteQuizPanel, BorderLayout.CENTER);
        deleteQuizPanel.setVisible(false);

        // creates quiz file entry panel
        quizFileLabel = new JLabel("Enter a quiz file name: ");
        quizFileField = new JTextField(20);
        quizFileButton = new JButton("Submit");
        quizFileButton.addActionListener(actionListener);

        quizFilePanel = new JPanel();
        quizFilePanel.add(quizFileLabel);
        quizFilePanel.add(quizFileField);
        quizFilePanel.add(quizFileButton);
        panel.add(quizFilePanel);
        quizFilePanel.setVisible(false);

        // creates quiz name entry panel
        quizNameLabel = new JLabel("Enter the name of the new quiz: ");
        quizNameField = new JTextField(20);
        quizNameButton = new JButton("Submit & Add Questions");
        quizNameButton.addActionListener(actionListener);

        quizNamePanel = new JPanel();
        quizNamePanel.add(quizNameLabel);
        quizNamePanel.add(quizNameField);
        quizNamePanel.add(quizNameButton);
        panel.add(quizNamePanel, BorderLayout.CENTER);
        quizNamePanel.setVisible(false);

        // Delete/Create Course GUI ------------------------------------------------------

        // creates delete course panel
        deleteCourseLabel = new JLabel("Select a course to delete: ");
        deleteCourseBox = new JComboBox<>();
        deleteCourseButton = new JButton("Delete");
        deleteCourseButton.addActionListener(actionListener);

        deleteCoursePanel = new JPanel();
        deleteCoursePanel.add(deleteCourseLabel);
        deleteCoursePanel.add(deleteCourseBox);
        deleteCoursePanel.add(deleteCourseButton);
        panel.add(deleteCoursePanel, BorderLayout.CENTER);
        deleteCoursePanel.setVisible(false);

        // creates new course panel
        newCourseLabel = new JLabel("Enter the name of the new course: ");
        newCourseField = new JTextField(20);
        newCourseButton = new JButton("Add Quiz");
        newCourseButton.addActionListener(actionListener);

        newCoursePanel = new JPanel();
        newCoursePanel.add(newCourseLabel);
        newCoursePanel.add(newCourseField);
        newCoursePanel.add(newCourseButton);
        panel.add(newCoursePanel, BorderLayout.CENTER);
        newCoursePanel.setVisible(false);

        // Take Quiz GUI ------------------------------------------------------

        // Choosing the course
        takeChooseCoursePanel = new JPanel();
        courseChoiceSubmit = new JButton("Submit");
        courseChoiceSubmit.addActionListener(actionListener);
        courseChoice = new JComboBox<>();
        pickCourseLabel = new JLabel();

        takeChooseCoursePanel.add(courseChoiceSubmit);

        panel.add(takeChooseCoursePanel, BorderLayout.CENTER);
        takeChooseCoursePanel.setVisible(false);

        // Choosing the quiz
        takeChooseQuizPanel = new JPanel();
        quizChoiceSubmit = new JButton("Submit");
        quizChoice = new JComboBox<>();
        pickQuizLabel = new JLabel();

        quizChoiceSubmit.addActionListener(actionListener);

        takeChooseQuizPanel.add(quizChoiceSubmit);

        panel.add(takeChooseQuizPanel, BorderLayout.CENTER);
        takeChooseQuizPanel.setVisible(false);

        // Taking the quiz
        takeQuiz = new JPanel();
        takeQuizSubmit = new JButton("Submit");
        takeQuizSubmit.addActionListener(actionListener);

        panel.add(takeQuiz, BorderLayout.CENTER);
        takeQuiz.setVisible(false);

        // Submit panel
        submitPanel = new JPanel();
        submitPrompt = new JLabel("Do you want to submit?");
        submitYesButton = new JButton("Yes");
        submitYesButton.addActionListener(actionListener);
        submitNoButton = new JButton("No");
        submitNoButton.addActionListener(actionListener);

        submitPanel.add(submitPrompt);
        submitPanel.add(submitYesButton);
        submitPanel.add(submitNoButton);

        panel.add(submitPanel, BorderLayout.CENTER);
        submitPanel.setVisible(false);

        // Submit panel No option
        submitPanelNo = new JPanel();
        submitPanelNoPrompt = new JLabel("Which Question Number do you want to change?");
        submitPanelNoButton = new JButton("Submit");
        submitPanelNoButton.addActionListener(actionListener);

        submitPanelNo.add(submitPanelNoPrompt);
        submitPanelNo.add(submitPanelNoButton);

        panel.add(submitPanelNo, BorderLayout.CENTER);
        submitPanelNo.setVisible(false);

        // Re-asking the question
        changeAnswer = new JPanel();
        changeAnswerSubmit = new JButton("Submit");
        changeAnswerSubmit.addActionListener(actionListener);

        changeAnswer.add(changeAnswerSubmit);

        panel.add(changeAnswer, BorderLayout.CENTER);
        changeAnswer.setVisible(false);

        // Submissions GUI ------------------------------------------------------

        // Choosing a course
        viewChooseCoursePanel = new JPanel();
        viewChooseCourseButton = new JButton("Submit");
        pickCourseLabel = new JLabel();
        courseChoiceView = new JComboBox<>();
        viewChooseCourseButton.addActionListener(actionListener);

        viewChooseCoursePanel.add(viewChooseCourseButton);

        panel.add(viewChooseCoursePanel, BorderLayout.CENTER);
        viewChooseCoursePanel.setVisible(false);

        // Choosing quiz
        viewChooseQuizPanel = new JPanel();
        viewChooseQuizButton = new JButton("Submit");
        pickQuizLabel = new JLabel();
        quizChoiceView = new JComboBox<>();
        viewChooseQuizButton.addActionListener(actionListener);

        viewChooseQuizPanel.add(viewChooseQuizButton);

        panel.add(viewChooseQuizPanel);
        viewChooseQuizPanel.setVisible(false);

        // Viewing results
        viewSubmission = new JPanel();
        mainMenuButton = new JButton("Main Menu");
        submissionsDetails = new JTextArea();
        mainMenuButton.addActionListener(actionListener);

        viewSubmission.add(mainMenuButton);

        panel.add(viewSubmission, BorderLayout.CENTER);
        viewSubmission.setVisible(false);
    }

    /**
     * This method is used to take to the server and in conjunction with the readCommunication() can be used
     * to talk with a server to get necessary information
     *
     * @param socket  -  The socket the that the server communication is started on
     * @param message - The String message that you want to write to the server
     */
    public static void serverCommunicator(Socket socket, String message) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.write(message);
            writer.println();
            writer.flush();


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * This method is to be used after you use the serverCommunicator() to get any message that the server
     * sends back
     *
     * @param socket -  The socket that the server communication is started on
     * @return - The string that the server writes back
     */
    public static String readCommunication(Socket socket) {
        String s1 = "";

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();

            do {
                if (s1.equals("")) {
                    s1 += line;
                } else {
                    s1 += "\n" + line;
                }
                line = reader.readLine();
                if (line.equals("end")) {
                    return s1;
                }
            } while (true);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return s1;
    }

    /**
     * Handles receiving an arraylist from the server so the client can get the most up to
     * date arraylist of course
     *
     * @param socket - The socket that the arraylist is received on
     */
    public void readArrayList(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());

            Object object = objectInput.readObject();
            currentClass.setCourses((ArrayList<Course>) object);
            /*for (Course c : (ArrayList<Course>) object) {
                System.out.println(c.getCourseName());
            }*/
            System.out.println();

        } catch (ClassNotFoundException e) {
            System.out.println("The title list has not come from the server");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles sending arraylist from the client to the server so the server can get the most up to
     * date arraylist of course
     *
     * @param socket  - The socket that the arraylist is sent on
     * @param courses - The arraylist that is being sent to the server
     */
    public void writeArrayList(Socket socket, ArrayList<Course> courses) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(courses);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    
    public ArrayList<User> readUserArrayList(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());

            Object object = objectInput.readObject();
            return (ArrayList<User>) object;

        } catch (ClassNotFoundException e) {
            System.out.println("The title list has not come from the server");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void writeUserArrayList(Socket socket, ArrayList<User> users) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(users);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public ArrayList<Submission> readSubmissionsArrayList(Socket socket) {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());

            Object object = objectInput.readObject();
            return (ArrayList<Submission>) object;

        } catch (ClassNotFoundException e) {
            System.out.println("The title list has not come from the server");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public void writeSubmissionsArrayList(Socket socket, ArrayList<Submission> submissions) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(submissions);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    

}
