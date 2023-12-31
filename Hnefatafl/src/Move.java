public class Move extends HelperFunctions implements setupVars{
    private static String colorHeld = "";
    private static String colorCollaborate = "";
    private static String colorTaking = "";
    private static final String white1 = "White Rook";
    private static final String white2 = "King";
    public static void grab(int loc) {
        if (pieceLoc.get(loc).equals("Black Rook")) {
            grabPiece(loc, blackRook);
            DisplayMoves.move(location, buttons);
            pickUpPiece(loc, pieceHeld);
        }
        else if (pieceLoc.get(loc).equals("White Rook")) {
            grabPiece(loc, whiteRook);
            DisplayMoves.move(location, buttons);
            pickUpPiece(loc, pieceHeld);
        }
        else if (pieceLoc.get(loc).equals("King")) {
            grabPiece(loc, King);
            DisplayMoves.move(location, buttons);
            pickUpPiece(loc, pieceHeld);
        }
    }
    public static void empty(int loc) {
        if (!buttons[loc].getText().equals("a")) {
            swapPiece(location, location, icon, pieceHeld);
            System.out.println("Choose a valid spot bozo");
        }
        else {
            swapPiece(location, loc, icon, pieceHeld);
            takesPiece(loc);
        }
    }
    private static void takesPiece(int loc) {
        if (!pieceLoc.get(loc).equals("King")){
            switch (loc) {
                case 2, 112 -> {
                    if (pieceLoc.containsKey(loc - 1)) {
                        assignColors(loc, loc - 1, loc);
                        takePiece(loc - 1);
                    }
                }
                case 8, 118 -> {
                    if (pieceLoc.containsKey(loc + 1)) {
                        assignColors(loc, loc + 1, loc);
                        takePiece(loc + 1);
                    }
                }
                case 22, 32 -> {
                    if (pieceLoc.containsKey(loc - 11)) {
                        assignColors(loc, loc - 11, loc);
                        takePiece(loc - 11);
                    }
                }
                case 88, 98 -> {
                    if (pieceLoc.containsKey(loc + 11)) {
                        assignColors(loc, loc + 11, loc);
                        takePiece(loc + 11);
                    }
                }
                default -> {
                    if (pieceLoc.containsKey(loc - 11) && pieceLoc.containsKey(loc - 22) && loc - 22 >= 0) {
                        assignColors(loc, loc - 11, loc - 22);
                        takePiece(loc - 11);
                    }
                    if (pieceLoc.containsKey(loc - 1) && pieceLoc.containsKey(loc - 2) &&
                            (loc - 2) / 11 == loc / 11 && loc - 2 >= 0) {
                            assignColors(loc, loc - 1, loc - 2);
                            takePiece(loc - 1);
                    }
                    if (pieceLoc.containsKey(loc + 1) && pieceLoc.containsKey(loc + 2) &&
                            (loc + 2) / 11 == loc / 11 && loc + 2 < 121) {
                            assignColors(loc, loc + 1, loc + 2);
                            takePiece(loc + 1);
                    }
                    if (pieceLoc.containsKey(loc + 11) && pieceLoc.containsKey(loc + 22) && loc + 22 < 121) {
                        assignColors(loc, loc + 11, loc + 22);
                        takePiece(loc + 11);
                    }
                }
            }
        }
    }
    private static void assignColors(int loc1, int loc2, int loc3) {
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
        if (white1.equals(pieceLoc.get(loc3)) || white2.equals(pieceLoc.get(loc3))) {
            colorCollaborate = "White";
        } else {
            colorCollaborate = "Black";
        }
        System.out.println(colorHeld + " " + colorTaking + " " + colorCollaborate);
    }
    private static void takePiece(int loc) {
        if (colorHeld.equals(colorCollaborate) && !colorHeld.equals(colorTaking)) {
            pieceLoc.remove(loc, pieceLoc.get(loc));
            buttons[loc].setIcon(null);
        }
    }
}