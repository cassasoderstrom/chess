package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Bishop extends ChessPieceBase implements ChessPiece{

    public Bishop(Color player, Square location) {
        super(PieceType.BISHOP, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns
        int deltaX = Math.abs(destination.getX() - location.getX());
        int deltaY = Math.abs(destination.getY() - location.getY());

        // Bishop moves diagonally, so deltaX must be equal to deltaY
        if (deltaX != deltaY) {
            return false;
        }

        return checkDiagonalMove(chessboard, destination);
    }
}

