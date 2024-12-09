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
import java.util.List;
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
         public int listNum(){
          return list.size();
         }

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
      update();
    }
    public void setTie(int p1, int p2) throws FileNotFoundException, IOException{
      addTie(p1);
      addTie(p2);
      update();
    }

    public void addLose(int index)throws FileNotFoundException, IOException{
           int PreLose = lossList.get(index);
           PreLose++;
           lossList.remove(index);
           lossList.add(index, PreLose);
         }

         public void addWin(int index)throws FileNotFoundException, IOException{
            int PreWins = winList.get(index);
            PreWins++;
            winList.remove(index);
            winList.add(index, PreWins);
          }
 
         public void addTie(int index) throws FileNotFoundException, IOException{
           int PreTie = tieList.get(index);
           PreTie++;
           tieList.remove(index);
           tieList.add(index, PreTie);
           
         }
 
        public void update() throws FileNotFoundException, IOException{
            FileWriter writer = new FileWriter("PlayerHub.csv", false);
            for(int i = 0; i < listNum(); i++){
              writer.write(GetName(i) + "," + getWins(i) + "," + getLosses(i) + "," + getTies(i));
              if(i +1 < listNum()){
                writer.write("\n");
              }
            }
            writer.close();
        }
 
 }
 
