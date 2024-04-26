package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Pawn extends ChessPieceBase implements ChessPiece{

    public Pawn(Color player, Square location) {
        super(PieceType.PAWN, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns
        int direction = (color.equals(Color.WHITE)) ? -1 : 1;

        // Pawns can only move in their forward direction
        if ((color.equals(Color.WHITE) && destination.getY() >= location.getY()) ||
                (color.equals(Color.BLACK) && destination.getY() <= location.getY())) {
            System.out.println("Not in forward direction");
            return false;
        }

        // Pawns can move one square forward
        if (destination.getX() == location.getX() && destination.getY() == location.getY() + direction) {
            System.out.println("Moving one square forward");
            return true;
        }

        // Pawns can move two squares forward from starting position
        if ((color.equals(Color.WHITE) && location.getY() == 6 && destination.getY() == location.getY() + 2 * direction) ||
                (color.equals(Color.BLACK) && location.getY() == 1 && destination.getY() == location.getY() + 2 * direction)) {
            if (destination.getX() == location.getX()) {
                System.out.println("Moving two squares forward");
                return true;
            }
        }

        // Pawns can capture diagonally
        if (Math.abs(destination.getX() - location.getX()) == 1 && destination.getY() == location.getY() + direction) {
            System.out.println("Capturing diagonally");
            return true;
        }
        System.out.println("Cannot move");
        return false;
    }
}
