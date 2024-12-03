import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Location extends JButton implements ActionListener{
    //Properties-------------------------------------------
    private int x;
    private int y;
    private Board b;
    private String symbol;

    //Constructors---------------------------------------
    public Location(){
        super( );
        super.setText("e-X-cellent");
    }
    public Location(Board b, int x, int y){
        this.b = b;
        this.x = x;
        this.y = y;

        b.add(this); 
        this.setPreferredSize(new Dimension(100, 100));
        this.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(symbol == null){
            symbol = b.tellMeTheSymbol();
            this.setText(symbol);
            if(b.checkWin(b.tellMeYourState(x, y))){
                winStatement(symbol);
                System.exit(0);
            }
            if(b.checkTie()){
                tieStatement();
                System.exit(0);
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
        JFrame frame = new JFrame("Tie Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "It's a tie", "Tie", JOptionPane.WARNING_MESSAGE);
        frame.setVisible(false);
    }

    public void retry(){
        JFrame frame = new JFrame("Retry Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(frame, "Please choose another square.", "Warning", JOptionPane.WARNING_MESSAGE);

        frame.setVisible(false);
    }

}
