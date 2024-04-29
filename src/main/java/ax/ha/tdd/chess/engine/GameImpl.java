package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;

public class GameImpl implements Game{

    final ChessboardImpl board = ChessboardImpl.startingBoard();

    boolean isNewGame = true;
    private Color playerToMove = Color.WHITE;
    @Override
    public Color getPlayerToMove() {
        //TODO this should reflect the current state.
        return playerToMove;
    }

    public void setPlayerToMove(Color player){
        this.playerToMove = player;
    }
    @Override
    public Chessboard getBoard() {
        return board;
    }

    @Override
    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc. up to you!
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return "Last move was successful (default reply, change this)";
    }

    @Override
    public void move(String move) {
        //TODO this should trigger your move logic.
        String[] arrayMove = move.split("-");
        for (String s : arrayMove) {
            if (s.matches("[a-h][1-8]]")) {
                System.out.println("INVALID" + s);
                return;
            }
        }

        Square start = new Square(arrayMove[0]);
        Square end = new Square(arrayMove[1]);
        ChessPiece pieceToMove = board.getPieceAt(start);

        if(pieceToMove == null){
            return;
        }
        if(pieceToMove.getColor() != getPlayerToMove()){
            return;
        }

        if(pieceToMove.canMove(board, end)) {

            if (board.getPieceAt(end) != null) {
                if (getPlayerToMove() == board.getPieceAt(end).getColor()) {
                    return;
                } else {
                    board.removePieceAt(end);
                }
            }
            pieceToMove.setLocation(end);
            board.addPiece(pieceToMove);
            board.removePieceAt(start);

        }
        //3. If so, update board (and last move message), otherwise only update last move message to show that an illegal move was tried

        // Split the move string into source and destination squares


        // TODO: Update last move message
        if(getPlayerToMove() == Color.WHITE){
            setPlayerToMove(Color.BLACK);
        }
        else{
            setPlayerToMove(Color.WHITE);
        }
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
    }
}
