import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Location extends JButton implements ActionListener{
    //Properties-------------------------------------------
    private int x;
    private int y;
    private Board b;
    private String symbol;
    private PlayerManager pm;
    private int p1;
    private int p2;


//Constructor===================================================

    public Location(Board b, int x, int y , int p1, int p2){
        this.b = b;
        this.x = x;
        this.y = y;

        b.add(this); 
        this.setPreferredSize(new Dimension(100, 100));
        this.addActionListener(this);
       this.pm = b.getPlayerManager();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(symbol == null){
            try {
                symbol = b.tellMeTheSymbol();
                this.setText(symbol);
                win();
            } catch (IOException ex) {
            }
        }
        else{
            retry();
        }
    }

    public String getSymbol(){
        return symbol;
    };

    public void winStatement(String symbol){
        JFrame frame = new JFrame("Win Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, symbol + " wins!!!", "Win", JOptionPane.WARNING_MESSAGE);

        frame.setVisible(false);
    }

    public void tieStatement(){
        JFrame frame = new JFrame("Win Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "It's a tie!!!", "tie", JOptionPane.WARNING_MESSAGE);

        frame.setVisible(false);
    }

    public void retry(){
        JFrame frame = new JFrame("Retry Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Please choose another square.", "Warning", JOptionPane.WARNING_MESSAGE);

        frame.setVisible(false);
    }

    public void win()throws FileNotFoundException, IOException{
        if(b.checkWin(b.tellMeYourState(x, y))){
            winStatement(symbol);
            if(symbol.equals("x")){
                pm.setWinner(p1, p2);
            }
            else{
                pm.setWinner(p2, p1);
            }
            System.exit(0);
        }
        else if(b.checkTie()){
            pm.setTie(p1, p2);
            tieStatement();
            System.exit(0);
        }   
    }

}







