package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    @Test
    public void testMoveWhitePawnBackwardsShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square(4,6));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(pawn.canMove(chessboard, new Square(4,7)));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveBlackPawnBackwardsShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.BLACK, new Square(4,1));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(pawn.canMove(chessboard, new Square(4,0)));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveWhitePawnFirstMoveTwoSteps() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square(4,6));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(pawn.canMove(chessboard, new Square(4,4)));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveBlackPawnFirstMoveTwoSteps() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.BLACK, new Square(4,1));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(pawn.canMove(chessboard, new Square(4,3)));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }
}

