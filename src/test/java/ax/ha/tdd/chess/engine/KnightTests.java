package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTests {

    @Test
    public void testMoveKnight() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square(3, 3)); // Place the knight at the center of the board
        chessboard.addPiece(knight);

        // Act & Assert
        // Knight can move to (1, 2), (1, 4), (2, 1), (2, 5), (4, 1), (4, 5), (5, 2), (5, 4)
        assertTrue(knight.canMove(chessboard, new Square(1, 2)));
        assertTrue(knight.canMove(chessboard, new Square(1, 4)));
        assertTrue(knight.canMove(chessboard, new Square(2, 1)));
        assertTrue(knight.canMove(chessboard, new Square(2, 5)));
        assertTrue(knight.canMove(chessboard, new Square(4, 1)));
        assertTrue(knight.canMove(chessboard, new Square(4, 5)));
        assertTrue(knight.canMove(chessboard, new Square(5, 2)));
        assertTrue(knight.canMove(chessboard, new Square(5, 4)));

        // Knight cannot move to any other square
        assertFalse(knight.canMove(chessboard, new Square(3, 3))); // current position
        assertFalse(knight.canMove(chessboard, new Square(1, 1)));
        assertFalse(knight.canMove(chessboard, new Square(1, 3)));
        assertFalse(knight.canMove(chessboard, new Square(1, 5)));
        assertFalse(knight.canMove(chessboard, new Square(2, 2)));
        assertFalse(knight.canMove(chessboard, new Square(2, 3)));
        assertFalse(knight.canMove(chessboard, new Square(2, 4)));
        assertFalse(knight.canMove(chessboard, new Square(3, 2)));
        assertFalse(knight.canMove(chessboard, new Square(3, 4)));
        assertFalse(knight.canMove(chessboard, new Square(4, 2)));
        assertFalse(knight.canMove(chessboard, new Square(4, 3)));
        assertFalse(knight.canMove(chessboard, new Square(4, 4)));
        assertFalse(knight.canMove(chessboard, new Square(5, 1)));
        assertFalse(knight.canMove(chessboard, new Square(5, 3)));
        assertFalse(knight.canMove(chessboard, new Square(5, 5)));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveKnightEdgeOfBoard() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square(0, 0)); // Place the knight at the bottom left corner of the board
        chessboard.addPiece(knight);

        // Act & Assert
        // Knight can move to (1, 2) and (2, 1)
        assertTrue(knight.canMove(chessboard, new Square(1, 2)));
        assertTrue(knight.canMove(chessboard, new Square(2, 1)));

        // Knight cannot move to any other square
        assertFalse(knight.canMove(chessboard, new Square(0, 0))); // current position
        assertFalse(knight.canMove(chessboard, new Square(0, 1)));
        assertFalse(knight.canMove(chessboard, new Square(1, 0)));
        assertFalse(knight.canMove(chessboard, new Square(2, 2)));
    }

    //UNCOMMENT THIS WHEN LOGIC FOR CRASHING IS IN
    /*@Test
    public void testMoveKnightSameColorPiece() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square(3, 3)); // Place the knight at the center of the board
        Knight friendKnight = new Knight(Color.WHITE, new Square(1, 2)); // Place another white knight at a valid destination
        chessboard.addPiece(knight);
        chessboard.addPiece(friendKnight);

        // Act & Assert
        // Knight cannot move to a square occupied by a piece of the same color
        assertFalse(knight.canMove(chessboard, new Square(1, 2)));
    }*/

    @Test
    public void testMoveKnightOppositeColorPiece() {
        // Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square(3, 3)); // Place the knight at the center of the board
        Knight enemyKnight = new Knight(Color.BLACK, new Square(1, 2)); // Place a black knight at a valid destination
        chessboard.addPiece(knight);
        chessboard.addPiece(enemyKnight);

        // Act & Assert
        // Knight can capture an opponent's piece
        assertTrue(knight.canMove(chessboard, new Square(1, 2)));
    }

}
