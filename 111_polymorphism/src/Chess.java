class Chess extends Game {
    public Chess() {
        super();
    }

    public void initializeGame() {
        System.out.println("Child class: Initialized Chess game");
    }

    protected void validatePlayerMove(Player p) {
        System.out.println("Child class: Validate Chess move:" + p.getName());
    }

    protected void logGameStatistics() {
        super.logGameStatistics();
        System.out.println("Child class: Add Chess specific logGameStatistics:");
    }
}