import javax.swing.*;
import java.awt.*;

public class HelperFunctions implements setupVars {
    public static int location = 0;
    boolean gameOver = false;
    public static boolean holdingPiece = false;
    public static String pieceHeld = "";
    public static ImageIcon icon = null;
    public static void swapPiece(int oldLoc, int newLoc, ImageIcon currentIcon, String name) {
        pieceLoc.remove(oldLoc, name);
        pieceLoc.put(newLoc, name);
        buttons[oldLoc].setIcon(null);
        buttons[newLoc].setIcon(currentIcon);
        holdingPiece = false;
    }
    public static void pickUpPiece(int loc, String pieceName) {
        pieceLoc.remove(loc, pieceName);
        holdingPiece = true;
    }
    public static void placePiece(int loc, ImageIcon newIcon, String pieceName) {
        pieceLoc.put(loc, pieceName);
        buttons[loc].setIcon(newIcon);
    }
    public static void grabPiece(int loc, ImageIcon newIcon) {
        pieceHeld = pieceLoc.get(loc);
        location = loc;
        icon = newIcon;
    }
    public static void displayMoves(int loc, JButton[] buttons, Color color, String curPieceColor) {
        String[] whitePieces = {"White Rook", "King"};
        String currentColor = "";
        for (String pColor : whitePieces) {
            if (pColor.equals(curPieceColor)) {
                currentColor = "White";
            } else {
                currentColor = "Black";
            }
        }
        if (!currentColor.equals(curPieceColor)) {
            buttons[loc].setText("a");
            buttons[loc].setForeground(color);
        }
    }
}
