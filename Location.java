
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
        b.tellMeYourState(x, y);}
    }

    public String getSymbol(){
        return symbol;
    };

}
