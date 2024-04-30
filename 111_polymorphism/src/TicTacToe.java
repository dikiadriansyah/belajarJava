class TicTacToe extends Game {
    public TicTacToe() {
        super();
    }

    public void initializeGame() {
        System.out.println("Child class: Initialized TicTacToe game");
    }

    protected void validatePlayerMove(Player p) {
        System.out.println("Child class: Validate TicTacToe move:" + p.getName());
    }
}
