package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class QueenTests {
    @Test
    public void testMoveQueenDiagonal() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square(3, 3));
        chessboard.addPiece(queen);

        // Act & Assert
        assertTrue(queen.canMove(chessboard, new Square(0, 0))); // Top left diagonal
        assertTrue(queen.canMove(chessboard, new Square(6, 0))); // Top right diagonal
        assertTrue(queen.canMove(chessboard, new Square(0, 6))); // Bottom left diagonal
        assertTrue(queen.canMove(chessboard, new Square(7, 7))); // Bottom right diagonal
    }

    @Test
    public void testMoveQueenHorizontal() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square(3, 3));
        chessboard.addPiece(queen);

        // Act & Assert
        assertTrue(queen.canMove(chessboard, new Square(0, 3))); // Left horizontal
        assertTrue(queen.canMove(chessboard, new Square(7, 3))); // Right horizontal
    }

    @Test
    public void testMoveQueenVertical() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square(3, 3));
        chessboard.addPiece(queen);

        // Act & Assert
        assertTrue(queen.canMove(chessboard, new Square(3, 0))); // Top vertical
        assertTrue(queen.canMove(chessboard, new Square(3, 7))); // Bottom vertical
    }
}
