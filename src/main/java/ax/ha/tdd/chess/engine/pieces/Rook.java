package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Rook extends ChessPieceBase implements ChessPiece{

    public Rook(Color player, Square location) {
        super(PieceType.ROOK, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns

        int deltaX = Math.abs(destination.getX() - location.getX());
        int deltaY = Math.abs(destination.getY() - location.getY());

        // Rook moves horizontally or vertically, so either deltaX or deltaY must be 0
        if (!(deltaX == 0 && deltaY != 0) && !(deltaX != 0 && deltaY == 0)) {
            return false;
        }

        if (deltaX == 0 && deltaY != 0) { // Moving vertically
            return checkVerticalMove(chessboard, destination);
        } else { // Moving horizontally
            return checkHorizontalMove(chessboard, destination);
        }
    }
}
