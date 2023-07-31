import javax.swing.*;
import java.awt.*;

public class DisplayMoves extends HelperFunctions{
    public static void move(int loc, JButton[] buttons) {
        for (int i = loc - 1; i >= 0; i--) {
            if (i / 11 != loc / 11 || pieceLoc.containsKey(i)) break;
            if (!pieceLoc.get(loc).equals("King") && i == 0 || i == 110) break;
            displayMoves(i, buttons, Color.black);
        }
        for (int i = loc + 1; i < 121; i++) {
            if (i / 11 != loc / 11 || pieceLoc.containsKey(i)) break;
            if (!pieceLoc.get(loc).equals("King") && i == 10 || i == 120) break;
            displayMoves(i, buttons, Color.black);
        }
        for (int i = loc - 11; i >= 0; i -= 11) {
            if (pieceLoc.containsKey(i)) break;
            if (!pieceLoc.get(loc).equals("King") && i == 0 || i == 110) break;
            displayMoves(i, buttons, Color.black);
        }
        for (int i = loc + 11; i < 121; i += 11) {
            if (pieceLoc.containsKey(i)) break;
            if (!pieceLoc.get(loc).equals("King") && i == 10 || i == 120) break;
            displayMoves(i, buttons, Color.black);
        }
    }
}