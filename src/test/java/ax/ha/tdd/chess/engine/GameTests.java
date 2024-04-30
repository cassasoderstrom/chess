package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTests {
    @Test
    public void testMoveOpponentsPieceShouldBeIllegal() {
        //Arrange
        Game game = new GameImpl();
        assertEquals(Color.WHITE, game.getPlayerToMove());

        //Act
        game.move("e7-e6");

        //Assert
        assertEquals(Color.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e7"));
        assertEquals(Color.BLACK, piece.getColor());
        assertEquals(PieceType.PAWN, piece.getType());


        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }

    @Test
    public void testValidMoves() {
        Game game = new GameImpl();
        assertEquals(Color.WHITE, game.getPlayerToMove());

        game.move("a1-a2");
        assertTrue(game.getLastMoveResult().contains("Blocked"));
        game.move("c1-d2");
        assertTrue(game.getLastMoveResult().contains("Blocked"));
        game.move("a7-a6");
        assertTrue(game.getLastMoveResult().contains("Wrong color"));
        game.move("a3-a4");
        assertTrue(game.getLastMoveResult().contains("No piece there"));

        game.move("t7-a6");
        assertTrue(game.getLastMoveResult().contains("Invalid starting square"));
        game.move("a3-t4");
        assertTrue(game.getLastMoveResult().contains("Invalid destination square"));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));
    }
}
