import javax.swing.*;
import java.awt.*;

public class displayMoves extends HelperFunctions{
    public static void move(int loc, JButton[] buttons, String color) {
        for (int i = loc - 1; i >= 0; i--) {
            if (i / 11 != loc / 11 || pieceLoc.containsKey(i)) break;
            displayMoves(i, buttons, Color.black, color);
        }
        for (int i = loc + 1; i < 121; i++) {
            if (i / 11 != loc / 11 || pieceLoc.containsKey(i)) break;
            displayMoves(i, buttons, Color.black, color);
        }
        for (int i = loc - 11; i >= 0; i -= 11) {
            if (pieceLoc.containsKey(i)) break;
            displayMoves(i, buttons, Color.black, color);
        }
        for (int i = loc + 11; i < 121; i += 11) {
            if (pieceLoc.containsKey(i)) break;
            displayMoves(i, buttons, Color.black, color);
        }
    }
}
