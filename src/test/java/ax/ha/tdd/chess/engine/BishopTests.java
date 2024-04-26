package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTests {

    @Test
    public void testMoveBishopValid() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square(3, 3)); // Place the bishop at the center of the board
        chessboard.addPiece(bishop);

        // Act & Assert
        // Bishop can move diagonally to any square
        assertTrue(bishop.canMove(chessboard, new Square(0, 0)));
        assertTrue(bishop.canMove(chessboard, new Square(6, 0)));
        assertTrue(bishop.canMove(chessboard, new Square(0, 6)));
        assertTrue(bishop.canMove(chessboard, new Square(7, 7)));
        assertTrue(bishop.canMove(chessboard, new Square(1, 5)));
        assertTrue(bishop.canMove(chessboard, new Square(5, 1)));
    }

    @Test
    public void testMoveBishopInvalid() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square(3, 3)); // Place the bishop at the center of the board
        chessboard.addPiece(bishop);

        // Act & Assert
        // Bishop cannot move to squares in a straight line or to squares blocked by other pieces
        assertFalse(bishop.canMove(chessboard, new Square(3, 0))); // Straight line
        assertFalse(bishop.canMove(chessboard, new Square(0, 3))); // Straight line
        assertFalse(bishop.canMove(chessboard, new Square(6, 3))); // Blocked by another piece
        assertFalse(bishop.canMove(chessboard, new Square(3, 6))); // Blocked by another piece
    }

    @Test
    public void testMoveBishopCaptureOpponent() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square(3, 3)); // Place the bishop at the center of the board
        Bishop enemyBishop = new Bishop(Color.BLACK, new Square(1, 1)); // Place a black bishop
        chessboard.addPiece(bishop);
        chessboard.addPiece(enemyBishop);

        // Act & Assert
        // Bishop can capture opponent's piece
        assertTrue(bishop.canMove(chessboard, new Square(1, 1)));
    }
}