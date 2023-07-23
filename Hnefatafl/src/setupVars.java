import javax.swing.*;
import java.util.HashMap;

public interface setupVars {
    HashMap<Integer, String> pieceLoc = new HashMap<>();
    JFrame frame = new JFrame();
    JLabel textField = new JLabel();
    JPanel titlePanel = new JPanel();
    JButton[] buttons = new JButton[121];
    JPanel panel = new JPanel();
    ImageIcon blackRook = new ImageIcon("C:/Users/craig/IdeaProjects/intellij_Chess/src/Images/Black Rook.png");
    ImageIcon whiteRook = new ImageIcon("C:/Users/craig/IdeaProjects/intellij_Chess/src/Images/White Rook.png");
    ImageIcon King = new ImageIcon("C:/Users/craig/IdeaProjects/intellij_Chess/src/Images/White King.png");
}
