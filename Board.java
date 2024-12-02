import java.awt.FlowLayout;
import javax.swing.JFrame;


public class Board extends JFrame {

    //Properties---------------------------------------
    private Location[][] STATE = new Location[][]{
        {null, null, null},
        {null, null, null},
        {null, null, null}
    };
    private int count = 0;
    
    //Constructor-------------------------------------
    public Board(){
        super();
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
    public void tellMeYourState(int x, int y){
        System.out.println(STATE[x][y].getSymbol());
    }

    public String tellMeTheSymbol(){
        if(count % 2 == 1){
            count++;
            return "o";
        }
        else{
            count++;
            return "x";
        }
        
    }


    
}
