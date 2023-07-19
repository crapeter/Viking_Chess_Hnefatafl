public class Move extends HelperFunctions implements setupVars{
    private static String colorHeld = "";
    private static String colorCollaborate = "";
    private static String colorTaking = "";
    private static final String white1 = "White Rook";
    private static final String white2 = "King";
    public static void grab(int loc) {
        if (pieceLoc.get(loc).equals("Black Rook")) {
            grabPiece(loc, blackRook);
            displayMoves.move(location, buttons, "black");
            pickUpPiece(loc, pieceHeld);
        }
        else if (pieceLoc.get(loc).equals("White Rook")) {
            grabPiece(loc, whiteRook);
            displayMoves.move(location, buttons, "white");
            pickUpPiece(loc, pieceHeld);
        }
        else if (pieceLoc.get(loc).equals("King")) {
            grabPiece(loc, King);
            displayMoves.move(location, buttons, "white");
            pickUpPiece(loc, pieceHeld);
        }
    }
    public static void empty(int loc) {
        if (!buttons[loc].getText().equals("a")) {
            swapPiece(location, location, icon, pieceHeld);
        }
        else {
            swapPiece(location, loc, icon, pieceHeld);
            takesPiece(loc);
        }
    }
    private static void takesPiece(int loc) {
        if (loc != 2 && loc != 9 && loc != 22 && loc != 32 && loc != 88 && loc != 98 && loc != 112 && loc != 118) {
            if (pieceLoc.containsKey(loc - 11) && pieceLoc.containsKey(loc - 22) && !pieceLoc.get(loc).equals("King")) {
                if (loc - 22 >= 0) {
                    assignColors(loc, loc - 11, loc - 22, false);
                }
                takePiece(loc - 11);
            }
            if (pieceLoc.containsKey(loc - 1) && pieceLoc.containsKey(loc - 2) &&
                    (loc - 2) / 8 == loc / 8 && !pieceLoc.get(loc).equals("King")) {
                if (loc - 2 >= 0) {
                    assignColors(loc, loc - 1, loc - 2, false);
                }
                takePiece(loc - 1);
            }
            if (pieceLoc.containsKey(loc + 1) && pieceLoc.containsKey(loc + 2) &&
                    (loc + 2) / 8 == loc / 8 && !pieceLoc.get(loc).equals("King")) {
                if (loc + 2 < 121) {
                    assignColors(loc, loc + 1, loc + 2, false);
                }
                takePiece(loc + 1);
            }
            if (pieceLoc.containsKey(loc + 11) && pieceLoc.containsKey(loc + 22) && !pieceLoc.get(loc).equals("King")) {
                if (loc + 22 < 121) {
                    assignColors(loc, loc + 11, loc + 22, false);
                }
                takePiece(loc + 11);
            }
        }
        else if (!pieceLoc.get(loc).equals("King")){
            switch (loc) {
                case 2, 112 -> {
                    if (pieceLoc.containsKey(loc -1)) {
                        assignColors(loc, loc - 1, 0, true);
                        takePiece(loc - 1);
                    }
                }
                case 9, 118 -> {
                    if (pieceLoc.containsKey(loc + 1)) {
                        assignColors(loc, loc + 1, 0, true);
                        takePiece(loc + 1);
                    }
                }
                case 22, 32 -> {
                    if (pieceLoc.containsKey(loc - 11)) {
                        assignColors(loc, loc - 11, 0, true);
                        takePiece(loc - 11);
                    }
                }
                case 88, 98 -> {
                    if (pieceLoc.containsKey(loc + 11)) {
                        assignColors(loc, loc + 11, 0, true);
                        takePiece(loc + 11);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + loc);
            }
        }
    }
    private static void assignColors(int loc1, int loc2, int loc3, boolean specialCase) {
        if (white1.equals(pieceLoc.get(loc1)) || white2.equals(pieceLoc.get(loc1))) {
            colorHeld = "White";
        } else {
            colorHeld = "Black";
        }
        if (white1.equals(pieceLoc.get(loc2)) || white2.equals(pieceLoc.get(loc2))) {
            colorTaking = "White";
        } else {
            colorTaking = "Black";
        }
        if (white1.equals(pieceLoc.get(loc3)) || white2.equals(pieceLoc.get(loc3)) && !specialCase) {
            colorCollaborate = "White";
        } else {
            colorCollaborate = "Black";
        }
    }
    private static void takePiece(int loc) {
        if (colorHeld.equals(colorCollaborate) && !colorHeld.equals(colorTaking)) {
            pieceLoc.remove(loc, pieceLoc.get(loc));
            buttons[loc].setIcon(null);
        }
    }
}
