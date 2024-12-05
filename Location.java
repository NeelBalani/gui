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

//Constructor===================================================

    public Location(Board b, int x, int y){
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
                pm.addWin(0);
                pm.addLose(1);
            }
            else{
                pm.addWin(1);
                pm.addLose(0);
            }
            System.exit(0);
        }
        else if(b.checkTie()){
            pm.addTie(0);
            pm.addTie(1);
            tieStatement();
        }   
    }

}







