import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Player {
    PlayerManager pm;
    private int playerNum;
    
    public Player() throws FileNotFoundException, IOException{
        pm = new PlayerManager();
        Scanner s = new Scanner(System.in);
        System.out.println("Which player do you want to be or press -1 to add another player: ");
        for(int i = 0; i < pm.listNum(); i++){
            System.out.println(i + ":" + pm.GetName(i));
        }
        playerNum = s.nextInt();
        if(playerNum == -1){
            addPlayer();
        }
    }

    public void addPlayer() throws FileNotFoundException, IOException{
        Scanner n = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = n.next();
        pm.addPlayer(name);
        pm.update();
        playerChange();
    }

    public int getPlayerNum(){
        return playerNum;
    }

    public int playerChange(){
        Scanner s = new Scanner(System.in);
        System.out.println("This player is taken choose another one or press -1 to add another player: ");
        for(int i = 0; i < pm.listNum(); i++){
            System.out.println(i + ":" + pm.GetName(i));
        }
        playerNum = s.nextInt();
        return playerNum;
    }
}
