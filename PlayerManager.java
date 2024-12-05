//Neel
//Project: TticTacToe
//11-5-2024
//Period 7

//The player manager manages the player
//Some methods include finding the players information
/*
 * This should be an easy project
 * We use a ArrayList to get information from a csv slap to here
 * IDK what to write for the 3rd bullet
 */

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Scanner;
 
 public class PlayerManager {
  //Properties------------------------------
  private ArrayList<String> list = new ArrayList<String>();
  private ArrayList<Integer> winList = new ArrayList<Integer>();
  private ArrayList<Integer> lossList = new ArrayList<Integer>();
  private ArrayList<Integer> tieList = new ArrayList<Integer>();
  String[] WordList;
 
   //Constructors----------------------------
  public PlayerManager() throws FileNotFoundException, IOException{
     File f = new File("PlayerHub.csv");
 
     Scanner s = new Scanner(f);
     
 
     while (s.hasNextLine()){
       while(s.hasNext()){
         WordList = s.nextLine().split(",");
         list.add(WordList[0]);
         winList.add(Integer.parseInt(WordList[1]));
         lossList.add(Integer.parseInt(WordList[2]));
         tieList.add(Integer.parseInt(WordList[3]));
       }
     }      
  }
         //Methods---------------------------------
  public String GetName(int index){
           if(index < list.size()){
             return list.get(index);
           }
           else{
           return "\u0000";
         }
  }
 
  public int getWins(int index){
    if(index < list.size()){
      return winList.get(index);
    }
    else{
      return (Integer) null;
    }
  }
 
 
        public int getLosses(int index){
           if(index < list.size()){
             return lossList.get(index);
           }
           else{
           return (Integer) null;
         }
         }
 
         @SuppressWarnings("null")
        public int getTies(int index){
           if(index < list.size()){
             return tieList.get(index);
           }
           else{
           return (Integer) null;
           }
         }
 

    public void setWinner(int winner, int looser)throws FileNotFoundException, IOException{
      addLose(looser);
      addWin(winner);
      
    }

    public void addLose(int index)throws FileNotFoundException, IOException{
           int PreLose = lossList.get(index);
           System.out.println(PreLose);
           PreLose++;
           System.out.println(PreLose);
           lossList.add(index, PreLose);
           System.out.println(getLosses(1));
           update();
         }

         public void addWin(int index)throws FileNotFoundException, IOException{
            int PreWins = winList.get(index);
            PreWins++;
            winList.add(index, PreWins);
          }
 
         public void addTie(int index) throws FileNotFoundException, IOException{
           int PreTie = tieList.get(index);
           PreTie++;
           tieList.add(index, PreTie);
           update();
         }
 
         public void update() throws FileNotFoundException, IOException{
           FileWriter writer = new FileWriter("PlayerHub.csv", false);
           writer.write(GetName(0) + "," + getWins(0) + "," + getLosses(0) + "," + getTies(0));
           writer.write("\n");
           writer.write(GetName(1) + "," + getWins(1) + "," + getLosses(1) + "," + getTies(1));
           writer.close();
         }
 
 }
 
