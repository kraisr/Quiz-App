import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditMenu extends JComponent implements Runnable {
    EditMenu editmenu;

    JPanel panel;

    JPanel editPanel;
    JButton editQuizName;
    JButton editQuestion;
    JButton editResponse;
    JButton editAnswerIndex;
    JButton goBack;

    public EditMenu() {

    }

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == editQuizName) {
                editPanel.setVisible(false);
            }
            if (e.getSource() == editQuestion) {
                editPanel.setVisible(false);
            }
            if (e.getSource() == editResponse) {
                editPanel.setVisible(false);
            }
            if (e.getSource() == editAnswerIndex) {
                editPanel.setVisible(false);
            }
            if (e.getSource() == goBack) {
                editPanel.setVisible(false);
            }
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new EditMenu());
    }

    public void run() {
        JFrame frame = new JFrame("Quiz Application");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        editmenu = new EditMenu();
        container.add(editmenu, BorderLayout.CENTER);

        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        // creates top-level panel
        panel = new JPanel();
        container.add(panel, BorderLayout.CENTER);

        // creates editing menu panel
        editQuizName = new JButton("Edit Quiz Name");
        editQuizName.addActionListener(actionListener);
        editQuestion = new JButton("Edit Question");
        editQuestion.addActionListener(actionListener);
        editResponse = new JButton("Edit Question Answer");
        editResponse.addActionListener(actionListener);
        editAnswerIndex = new JButton("Change Which Answer is Correct");
        editAnswerIndex.addActionListener(actionListener);
        goBack = new JButton("Go Back");
        goBack.addActionListener(actionListener);

        editPanel = new JPanel();
        editPanel.add(editQuizName);
        editPanel.add(editQuestion);
        editPanel.add(editResponse);
        editPanel.add(editAnswerIndex);
        editPanel.add(goBack);
        panel.add(editPanel, BorderLayout.CENTER);
    }
}