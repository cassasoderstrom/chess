package ax.ha.tdd.chess.engine;
import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class KingTests {
    @Test
    public void testMoveKingOneSquare() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square(3, 3));
        chessboard.addPiece(king);

        // Act & Assert
        assertTrue(king.canMove(chessboard, new Square(4, 3))); // Move right
        assertTrue(king.canMove(chessboard, new Square(2, 3))); // Move left
        assertTrue(king.canMove(chessboard, new Square(3, 4))); // Move up
        assertTrue(king.canMove(chessboard, new Square(3, 2))); // Move down
        assertTrue(king.canMove(chessboard, new Square(4, 4))); // Move up-right
        assertTrue(king.canMove(chessboard, new Square(2, 2))); // Move down-left
        assertTrue(king.canMove(chessboard, new Square(4, 2))); // Move down-right
        assertTrue(king.canMove(chessboard, new Square(2, 4))); // Move up-left
    }

    @Test
    public void testMoveKingInvalid() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square(3, 3));
        chessboard.addPiece(king);


        // Act & Assert
        assertFalse(king.canMove(chessboard, new Square(1, 1))); // Move more than one square
        assertFalse(king.canMove(chessboard, new Square(5, 5))); // Move more than one square
    }
}
