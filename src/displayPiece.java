import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayPiece extends HelperFunctions implements setupVars, ActionListener {
    int[] corners = {0, 10, 110, 120};
    public void display() {
       for (int i = 3; i <= 7; i++) {
            placePiece(i, blackRook, "Black Rook");
        }
       for (int i = 33; i <= 77; i += 11) {
           placePiece(i, blackRook, "Black Rook");
       }
       for (int i = 43; i <= 87; i += 11) {
           placePiece(i, blackRook, "Black Rook");
       }
       for (int i = 113; i <= 117; i++) {
           placePiece(i, blackRook, "Black Rook");
       }
       placePiece(16, blackRook, "Black Rook");
       placePiece(104, blackRook, "Black Rook");
       placePiece(56, blackRook, "Black Rook");
       placePiece(64, blackRook, "Black Rook");
       for (int i = 58; i <= 62; i++) {
           if (i == 59 || i == 61) {
               placePiece(i - 11, whiteRook, "White Rook");
               placePiece(i, whiteRook, "White Rook");
               placePiece(i + 11, whiteRook, "White Rook");
           }
           else if (i == 60) {
               placePiece(i - 22, whiteRook, "White Rook");
               placePiece(i - 11, whiteRook, "White Rook");
               placePiece(i, King, "King");
               placePiece(i + 11, whiteRook, "White Rook");
               placePiece(i + 22, whiteRook, "White Rook");
           }
           else {
               placePiece(i, whiteRook, "White Rook");
           }
       }
       for (int i = 0; i < 121; i++)
           buttons[i].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 121; i++) {
            if (e.getSource() == buttons[i]) {
                if (pieceLoc.containsKey(i)) {
                    if (!holdingPiece) {
                        Move.grab(i);
                        break;
                    }
                    else System.out.println("Pick up a piece bozo");
                }
                else {
                    if (holdingPiece)
                        Move.empty(i);
                    else System.out.println("Pick up a piece bozo");
                    System.out.println(i);
                }
                for (int j = 0; j < 121; j++) {
                    if (!buttons[j].getText().equals(""))
                        buttons[j].setText("");
                }
                for (int corner : corners) {
                    if (pieceLoc.containsKey(corner) && pieceLoc.get(corner).equals("King")) {
                        gameOver = true;
                        for (int j = 0; j < 121; j++)
                            buttons[j].removeActionListener(this);
                        textField.setText("White wins");
                    }
                }
                if (!pieceLoc.containsValue("King")) {
                    gameOver = true;
                    for (int j = 0; j < 121; j++)
                        buttons[j].removeActionListener(this);
                    textField.setText("Black wins");
                }
                System.out.println(pieceHeld + " " + i);
            }
        }
    }
}