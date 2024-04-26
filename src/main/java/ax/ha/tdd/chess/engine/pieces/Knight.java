package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Knight extends ChessPieceBase implements ChessPiece{

    public Knight(Color player, Square location) {
        super(PieceType.KNIGHT, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns
        int deltaX = Math.abs(destination.getX() - location.getX());
        int deltaY = Math.abs(destination.getY() - location.getY());

        // Knights move in an L-shape: 2 squares in one direction and 1 square perpendicular to that
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);

    }
}
