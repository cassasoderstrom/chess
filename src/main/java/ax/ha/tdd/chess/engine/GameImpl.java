package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;

public class GameImpl implements Game{

    final ChessboardImpl board = ChessboardImpl.startingBoard();
    public String statusMessage;
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
        return statusMessage;
    }

    @Override
    public void move(String move) {
        //TODO this should trigger your move logic.
        String[] arrayMove = move.split("-");
        isNewGame = false;
        if (!arrayMove[0].matches("[a-h][1-8]")) {
                statusMessage = "Invalid starting square";
                return;
            }
        if (!arrayMove[1].matches("[a-h][1-8]")) {
            statusMessage = "Invalid destination square";
            return;
        }


        Square start = new Square(arrayMove[0]);
        Square end = new Square(arrayMove[1]);
        ChessPiece pieceToMove = board.getPieceAt(start);

        if(pieceToMove == null){
            statusMessage = "No piece there";
            return;
        }
        if(pieceToMove.getColor() != getPlayerToMove()){
            statusMessage = "Wrong color";
            return;
        }

        if(pieceToMove.canMove(board, end)) {

            if (board.getPieceAt(end) != null) {
                if (getPlayerToMove() == board.getPieceAt(end).getColor()) {
                    statusMessage = "Blocked";
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
        statusMessage = "Last move successful";
        if(getPlayerToMove() == Color.WHITE){
            setPlayerToMove(Color.BLACK);
        }
        else{
            setPlayerToMove(Color.WHITE);
        }

        System.out.println("Player tried to perform move: " + move);
    }
}
