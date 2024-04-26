package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class King extends ChessPieceBase implements ChessPiece{

    public King(Color player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        //TODO here goes move logic for pawns
        int deltaX = Math.abs(destination.getX() - location.getX());
        int deltaY = Math.abs(destination.getY() - location.getY());

        return deltaX <= 1 && deltaY <= 1;
    }
}

