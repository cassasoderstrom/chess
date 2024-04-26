package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Rook;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class RookTests {
    @Test
    public void testMoveRookValid() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square(3, 3)); // Place the rook at the center of the board
        chessboard.addPiece(rook);

        // Act & Assert
        // Rook can move horizontally or vertically to any square
        assertTrue(rook.canMove(chessboard, new Square(3, 0))); // Move vertically up
        assertTrue(rook.canMove(chessboard, new Square(3, 7))); // Move vertically down
        assertTrue(rook.canMove(chessboard, new Square(0, 3))); // Move horizontally left
        assertTrue(rook.canMove(chessboard, new Square(7, 3))); // Move horizontally right
        assertFalse(rook.canMove(chessboard, new Square(0, 0))); // Move diagonally (invalid move)
    }

    @Test
    public void testMoveRookInvalid() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square(3, 3));


        chessboard.addPiece(rook);

        // Act & Assert
        // Rook cannot move diagonally or to squares blocked by other pieces
        assertFalse(rook.canMove(chessboard, new Square(0, 0))); // Diagonal move
        assertFalse(rook.canMove(chessboard, new Square(5, 5))); // Diagonal move

    }

    @Test
    public void testMoveRookCaptureOpponent() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square(3, 3)); // Place the rook at the center of the board
        Rook enemyRook = new Rook(Color.BLACK, new Square(3, 7)); // Place a black rook
        chessboard.addPiece(rook);
        chessboard.addPiece(enemyRook);

        // Act & Assert
        // Rook can capture opponent's piece
        assertTrue(rook.canMove(chessboard, new Square(3, 7)));
    }
}
