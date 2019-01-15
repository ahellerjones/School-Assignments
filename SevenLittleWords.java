public class SevenLittleWords {
    public static void main(String[] args) { 
        System.err.println("No file provided, provide a .txt file in command line");
        GameInfo gameinfo = new GameInfo(args[0]); 
        GameBoard gameboard = new GameBoard(gameinfo);
        gameboard.setVisible(true);
    }
}
         
     
    