import java.util.HashMap;

abstract class Game implements Runnable {
    protected boolean runGame = true;
    protected Player player1 = null;
    protected Player player2 = null;
    protected Player currentPlayer = null;

    public Game() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        currentPlayer = player1;
        initializeGame();
    }
    /*
     * Type 1: Let subclass define own implementation. Base class defines abstract
     * method to force
     * sub-classes to define implementation
     */

    protected abstract void initializeGame();

    /*
     * Type 2: Sub-class can change the behaviour. If not, base class behaviour is
     * applicable
     */
    protected void logTimeBetweenMoves(Player player) {
        System.out.println("Base class: Move Duration: player.PlayerActTime -player.MoveShownTime");
    }

    /*
     * Type 3: Base class provides implementation. Sub-class can enhance base class
     * implementation by
     * calling
     * super.methodName() in first line of the child class method and specific
     * implementation later
     */
    protected void logGameStatistics() {
        System.out.println("Base class: logGameStatistics:");
    }

    /*
     * Type 4: Template method: Structure of base class can't be changed but
     * sub-class can some part
     * of behaviour
     */
    protected void runGame() throws Exception {
        System.out.println("Base class: Defining the flow for Game:");
        while (runGame) {
            /*
             * 1. Set current player
             * 2. Get Player Move
             */
            validatePlayerMove(currentPlayer);
            logTimeBetweenMoves(currentPlayer);
            Thread.sleep(500);
            setNextPlayer();
        }
        logGameStatistics();
    }

    /* sub-part of the template method, which define child class behaviour */
    protected abstract void validatePlayerMove(Player p);

    protected void setRunGame(boolean status) {
        this.runGame = status;
    }

    public void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    public void setNextPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public void run() {
        try {
            runGame();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}