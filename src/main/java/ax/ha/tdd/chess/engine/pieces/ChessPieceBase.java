package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

import java.util.Objects;

public abstract class ChessPieceBase implements ChessPiece {

    protected final Color color;
    protected final PieceType type;

    protected Square location;

    public ChessPieceBase(PieceType type, final Color player,
                          final Square location) {
        this.type = type;
        this.color = player;
        this.location = location;
    }

    public final String getSymbol() {
        return type.getSymbol();
    }

    public PieceType getType() { return type; }

    public Color getColor() {
        return color;
    }

    public Square getLocation() {
        return location;
    }


    /**
     * Suggestion of design:
     * Checks if the chessPiece can move to a certain destination.
     * I preferred to keep this logic tightly coupled to the pieces instead of the board,
     * since that makes the separation of logic easier.
     *
     * @param chessboard chessboard
     * @param destination destination
     * @return true if piece can move to the destination
     */
    public abstract boolean canMove(final Chessboard chessboard, final Square destination);

    protected boolean checkVerticalMove(Chessboard chessboard, Square destination) {
        int dir = (destination.getY() - location.getY()) > 0 ? 1 : -1;
        int y = location.getY() + dir;
        while (y != destination.getY()) {
            if (chessboard.getPieceAt(new Square(location.getX(), y)) != null) {
                return false; // There is a piece blocking the path
            }
            y += dir;
        }
        return true;
    }

    protected boolean checkHorizontalMove(Chessboard chessboard, Square destination) {
        int dir = (destination.getX() - location.getX()) > 0 ? 1 : -1;
        int x = location.getX() + dir;
        while (x != destination.getX()) {
            if (chessboard.getPieceAt(new Square(x, location.getY())) != null) {
                return false; // There is a piece blocking the path
            }
            x += dir;
        }
        return true;
    }

    protected boolean checkDiagonalMove(Chessboard chessboard, Square destination) {
        int dirX = (destination.getX() - location.getX()) > 0 ? 1 : -1;
        int dirY = (destination.getY() - location.getY()) > 0 ? 1 : -1;
        int x = location.getX() + dirX;
        int y = location.getY() + dirY;
        while (x != destination.getX() && y != destination.getY()) {
            if (chessboard.getPieceAt(new Square(x, y)) != null) {
                return false; // There is a piece blocking the path
            }
            x += dirX;
            y += dirY;
        }
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPieceBase that = (ChessPieceBase) o;
        return color == that.color && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public String toString() {
        return getColor().name() + " " + getClass().getSimpleName();
    }
}
