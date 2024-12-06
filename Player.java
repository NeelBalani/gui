import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Player {
    PlayerManager pm;
    private int playerNum;
    
    public Player() throws FileNotFoundException, IOException{
        pm = new PlayerManager();
        Scanner s = new Scanner(System.in);
        System.out.println("Which player do you want to be: ");
        for(int i = 0; i < pm.listNum(); i++){
            System.out.println(i + ":" + pm.GetName(i));
        }
        playerNum = s.nextInt();
    }

    public int getPlayerNum(){
        return playerNum;
    }

    public int playerChange(){
        Scanner s = new Scanner(System.in);
        System.out.println("This player is taken choose another one: ");
        for(int i = 0; i < pm.listNum(); i++){
            System.out.println(i + ":" + pm.GetName(i));
        }
        playerNum = s.nextInt();
        return playerNum;
    }
}
