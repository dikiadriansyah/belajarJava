public class Polymotphism_and_different_types_of_overriding {
    // Polymorphism and dierent types of overriding/Polimorfisme dan berbagai jenis
    // overriding

    // dari tutorial java

    /*
     * Definisi kamus tentang polimorfisme mengacu pada prinsip dalam biologi di
     * mana suatu organisme atau spesies
     * dapat memiliki banyak bentuk atau tahapan yang berbeda. Prinsip ini juga
     * dapat diterapkan pada pemrograman berorientasi objek dan bahasa seperti
     * bahasa Java. Subkelas dari suatu kelas dapat menentukan perilaku uniknya
     * sendiri namun tetap berbagi beberapa fungsi yang sama dengan kelas induknya
     */

    /*
     * Lihat contoh ini untuk memahami berbagai jenis penggantian.
     * 1. Kelas dasar tidak menyediakan implementasi dan subkelas harus mengganti
     * metode lengkap - (abstrak)
     * 2. Kelas dasar menyediakan implementasi default dan subkelas dapat mengubah
     * perilaku
     * 3. Subkelas menambahkan ekstensi ke implementasi kelas dasar dengan memanggil
     * super.methodName() sebagai pernyataan pertama
     * 4. Kelas dasar mendefinisikan struktur algoritma (metode Template) dan
     * sub-kelas akan mengambil alih bagian dari algoritma
     */

    // cuplikan kode:

    /*
     * import java.util.HashMap;
     * abstract class Game implements Runnable{
     * protected boolean runGame = true;
     * protected Player player1 = null;
     * protected Player player2 = null;
     * protected Player currentPlayer = null;
     * 
     * public Game(){
     * player1 = new Player("Player 1");
     * player2 = new Player("Player 2");
     * currentPlayer = player1;
     * initializeGame();
     * }
     * 
     * // Type 1: Let subclass define own implementation. Base class defines
     * //abstract method to force sub-classes to define implementation
     * 
     * protected abstract void initializeGame();
     * 
     * // Type 2: Sub-class can change the behaviour. If not, base class behaviour
     * //is applicable
     * 
     * protected void logTimeBetweenMoves(Player player){
     * System.out.println("Base class: Move Duration: player.PlayerActTime -
     * player.MoveShownTime");
     * }
     * 
     * //Type 3: Base class provides implementation. Sub-class can enhance base
     * // class implementation by calling super.methodName() in first line of the
     * //child class method and specific implementation later
     * 
     * protected void logGameStatistics(){
     * System.out.println("Base class: logGameStatistics:");
     * }
     * 
     * //Type 4: Template method: Structure of base class can't be changed but
     * // sub-class can some part of behaviour
     * 
     * 
     * protected void runGame() throws Exception{
     * System.out.println("Base class: Defining the flow for Game:");
     * while (runGame) {
     * //1. Set current player
     * //2. Get Player Move
     * validatePlayerMove(currentPlayer);
     * logTimeBetweenMoves(currentPlayer);
     * Thread.sleep(500);
     * setNextPlayer();
     * }
     * logGameStatistics();
     * }
     * 
     * //sub-part of the template method, which define child class behaviour
     * 
     * protected abstract void validatePlayerMove(Player p);
     * 
     * protected void setRunGame(boolean status){
     * this.runGame = status;
     * }
     * public void setCurrentPlayer(Player p){
     * this.currentPlayer = p;
     * }
     * 
     * public void setNextPlayer(){
     * if (currentPlayer == player1) {
     * currentPlayer = player2;
     * }else{
     * currentPlayer = player1;
     * }
     * }
     * public void run(){
     * try{
     * runGame();
     * }catch(Exception err){
     * err.printStackTrace();
     * }
     * }
     * }
     * class Player{
     * String name;
     * Player(String name){
     * this.name = name;
     * }
     * public String getName(){
     * return name;
     * }
     * }
     * 
     * 
     * //Concrete Game implementation
     * 
     * 
     * class Chess extends Game{
     * public Chess(){
     * super();
     * }
     * public void initializeGame(){
     * System.out.println("Child class: Initialized Chess game");
     * }
     * protected void validatePlayerMove(Player p){
     * System.out.println("Child class: Validate Chess move:" + p.getName());
     * }
     * protected void logGameStatistics(){
     * super.logGameStatistics();
     * System.out.println("Child class: Add Chess specific logGameStatistics:");
     * }
     * }
     * class TicTacToe extends Game{
     * public TicTacToe(){
     * super();
     * }
     * public void initializeGame(){
     * System.out.println("Child class: Initialized TicTacToe game");
     * }
     * protected void validatePlayerMove(Player p){
     * System.out.println("Child class: Validate TicTacToe move:" + p.getName());
     * }
     * }
     * public class Polymorphism{
     * public static void main(String args[]){
     * try{
     * 
     * Game game = new Chess();
     * Thread t1 = new Thread(game);
     * t1.start();
     * Thread.sleep(1000);
     * game.setRunGame(false);
     * Thread.sleep(1000);
     * 
     * game = new TicTacToe();
     * Thread t2 = new Thread(game);
     * t2.start();
     * Thread.sleep(1000);
     * game.setRunGame(false);
     * 
     * }catch(Exception err){
     * err.printStackTrace();
     * }
     * }
     * }
     * 
     * 
     */

    // hasil:
    /*
     * Child class: Initialized Chess game
     * Base class: Defining the flow for Game:
     * Child class: Validate Chess move:Player 1
     * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
     * Child class: Validate Chess move:Player 2
     * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
     * Base class: logGameStatistics:
     * Child class: Add Chess specific logGameStatistics:
     * Child class: Initialized TicTacToe game
     * Base class: Defining the flow for Game:
     * Child class: Validate TicTacToe move:Player 1
     * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
     * Child class: Validate TicTacToe move:Player 2
     * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
     * Base class: logGameStatistics:
     */

    public static void main(String[] args) throws Exception {
        try {

            Game game = new Chess();
            Thread t1 = new Thread(game);
            t1.start();
            Thread.sleep(1000);
            game.setRunGame(false);
            Thread.sleep(1000);

            game = new TicTacToe();
            Thread t2 = new Thread(game);
            t2.start();
            Thread.sleep(1000);
            game.setRunGame(false);

        } catch (Exception err) {
            err.printStackTrace();
        }
        /*
         * output:
         * Child class: Initialized Chess game
         * Base class: Defining the flow for Game:
         * Child class: Validate Chess move:Player 1
         * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
         * Child class: Validate Chess move:Player 2
         * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
         * Base class: logGameStatistics:
         * Child class: Add Chess specific logGameStatistics:
         * 
         * Child class: Initialized TicTacToe game
         * Base class: Defining the flow for Game:
         * Child class: Validate TicTacToe move:Player 1
         * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
         * Child class: Validate TicTacToe move:Player 2
         * Base class: Move Duration: player.PlayerActTime - player.MoveShownTime
         * Base class: logGameStatistics:
         */
    }
}
