package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Queen extends ChessPieceBase implements ChessPiece{

    public Queen(Color player, Square location) {
        super(PieceType.QUEEN, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns
        int deltaX = Math.abs(destination.getX() - location.getX());
        int deltaY = Math.abs(destination.getY() - location.getY());

        // Queen moves diagonally, horizontally, or vertically, so either deltaX or deltaY must be 0
        if (!((deltaX == 0 && deltaY != 0) || (deltaX != 0 && deltaY == 0) || (deltaX == deltaY))) {
            return false;
        }

        // Check if there is any piece blocking its way
        if (deltaX == 0 && deltaY != 0) { // Moving vertically
            return checkVerticalMove(chessboard, destination);
        } else if (deltaX != 0 && deltaY == 0) { // Moving horizontally
            return checkHorizontalMove(chessboard, destination);
        } else { // Moving diagonally
            return checkDiagonalMove(chessboard, destination);
        }

    }
}
