import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayPiece extends HelperFunctions implements setupVars, ActionListener {
    int[] corners = {0, 10, 110, 120};
    int[] blackRookLoc = {3, 4, 5, 6, 7,
                          33, 44, 55, 66, 77,
                          43, 54, 65, 76, 87,
                          113, 114, 115, 116, 117,
                          16, 56, 64 ,104};
    int[] whiteRookLoc = {38,
                          48, 49, 50,
                          58, 59, 61, 62,
                          70, 71, 72,
                          82};
    public void display() {
        placePiece(60, King, "King");
        for (int loc : blackRookLoc) {
           placePiece(loc, blackRook, "Black Rook");
       }
       for (int loc : whiteRookLoc) {
           placePiece(loc, whiteRook, "White Rook");
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
                    System.out.println(pieceHeld);
                }
                else {
                    if (holdingPiece)
                        Move.empty(i);
                    else System.out.println("Pick up a piece bozo");
                    System.out.println(pieceHeld);
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
