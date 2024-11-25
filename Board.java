import java.awt.Dimension;
import javax.swing.JFrame;

public class Board extends JFrame{

    //Properties---------------------------------------
    private char[][] STATE = new char[][]{};
    
    //Constructor-------------------------------------
    public Board(){
        System.out.println("A New Board!!!");
        setTitle("My first Jframe");
        setSize(400,100);

        Location btn = new Location();
        Dimension d = new Dimension(50,50);
        btn.setSize(d);
        Location btn1 = new Location();
        Location btn2 = new Location();
        this.add(btn);
        this.add(btn1);
        this.add(btn2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    //Methods------------------------------------------

    
}
