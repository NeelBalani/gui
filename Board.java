
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Board extends JFrame {

    //Properties---------------------------------------
    private Location[][] STATE = new Location[][]{
        {null, null, null},
        {null, null, null},
        {null, null, null}
    };
    private int count = 0;
    private PlayerManager pm;
    
    //Constructor-------------------------------------
    public Board() throws FileNotFoundException, IOException{
        super();
        pm = new PlayerManager();
        super.setTitle("My first Jframe");
        super.setSize(400,400);
        super.setLayout(new FlowLayout());
        

        for(int i = 0; i < 9 ;i++){
            this.STATE[i/3][i%3] = new Location(this, i/3, i%3);
        }

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }



    //Methods------------------------------------------
    public String tellMeYourState(int x, int y){
        return (STATE[x][y].getSymbol());
    }
    public void giveError(){
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(frame, "This sqaure is taken. Choose another one.", "Choose Again", JOptionPane.INFORMATION_MESSAGE);
        frame.setVisible(false);
    }

    public Location[][] returnState(){
        return STATE;
    }

    public String tellMeTheSymbol(){
        if(count % 2 == 0){
            count++;
            return "x";
        }
        else{
            count++;
            return "o";
            
        }
    }

    public boolean checkTie(){
        return count == 9;
    }
    public boolean checkWin(String symbol){
        if(checkHor(symbol) || checkVert(symbol) || checkDiagN(symbol) || checkDiagP(symbol)){
            return true;
        }
        return false;
    }
    
    public boolean checkHor(String symbol){
        for(int i = 0; i < STATE.length; i++){
            boolean checky = true;
            for(int j = 0; j < STATE[i].length; j++){
                if(STATE[i][j].getSymbol() == null || !STATE[i][j].getSymbol().equals(symbol)){
                    checky = false;
                    break;
                }
            }
            if(checky){
                return true;
            }
        }
        
        return false;
    }

    public boolean checkVert(String symbol){
        for(int i = 0; i < STATE.length; i++){
            boolean checky = true;
            for(int j = 0; j < STATE[i].length; j++){
                if(STATE[j][i].getSymbol() == null || !STATE[j][i].getSymbol().equals(symbol)){
                    checky = false;
                    break;
                }
            }
            if(checky){
                return true;
            }
        }
        
        return false;
    }

    public boolean checkDiagN(String symbol){
        for(int i = 0; i < STATE.length; i++){
            if(STATE[i][i].getSymbol() == null || !STATE[i][i].getSymbol().equals(symbol)){
                return false;
            }
        }
        return true;
    }
    
    public boolean checkDiagP(String symbol){
        for(int i = 0; i < STATE.length; i++){
            if(STATE[i][STATE.length - 1 - i].getSymbol() == null || !STATE[i][STATE.length - 1 - i].getSymbol().equals(symbol)){
                return false;
            }
        }
        return true;
    }
    
    
    
    public PlayerManager getPlayerManager() {
        return pm;
    }
}
