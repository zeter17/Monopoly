
import java.util.HashMap;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Player {
  private  final static int player_number=2;
private Cell location;
private boolean isRolled;
private Map<String, Integer> map = new HashMap<String, Integer>();
private int key;
private int id;
private int balance;
private int active;
private static Player currentPlayer;
private int roll;
private int munic;
private int trans;
private int lastRoll;
Player()
{}
Player(int i)
{
id=i;
balance=1000000;
  map.put("lightgreen",0);
        map.put("green",0);
        map.put("yellow",0);
        map.put("blue",0);
        map.put("red",0);
        map.put("purple",0);
        map.put("orange",0);
        map.put("lightblue",0);
}
    /**
     * @return the player_number
     */
    public static int getPlayer_number() {
        return player_number;
    }
    /**
     * @return the lastRoll
     */
    public int getLastRoll() {
        return lastRoll;
    }
    /**
     * @param lastRoll the lastRoll to set
     */
    public void setLastRoll(int lastRoll) {
        this.lastRoll = lastRoll;
    }

    /**
     * @return the location
     */
    public Cell getLocation() {
        return location;
    }
  

    /**
     * @param location the location to set
     */
    public void setLocation(Cell location) {
        this.location = location;
    }
    public void setLocation(int i)
    {
    location=Game.getCells()[i];
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @return the roll
     */
    public int getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(int roll) {
        this.roll = roll;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the munic
     */
    public int getMunic() {
        return munic;
    }

    /**
     * @param munic the munic to set
     */
    public void setMunic(int munic) {
        this.munic = munic;
    }

    /**
     * @return the trans
     */
    public int getTrans() {
        return trans;
    }

    /**
     * @param trans the trans to set
     */
    public void setTrans(int trans) {
        this.trans = trans;
    }
      

    /**
     * @return the currentPlayer
     */
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param aCurrentPlayer the currentPlayer to set
     */
    public static void setCurrentPlayer(Player aCurrentPlayer) {
        currentPlayer = aCurrentPlayer;
    }

    /**
     * @return the map
     */
    public Map<String, Integer> getMap() {
        return map;
    }

    /**
     * @param aMap the map to set
     */
    public void setMap(String s,int i) {
        map.put(s, i);
    }
    @Override
    public String toString()
    {
    return "Player "+(id+1);
    }
    public void changePlayer()
    {
      if(Player.getCurrentPlayer().getId()==0) Player.setCurrentPlayer(Game.getP2());   
else Player.setCurrentPlayer(Game.getP1());
      Player.getCurrentPlayer().setIsRolled(false);
      Game.drawGameField();
            Game.displayPlayer();
    }
    public void roll()
    {
        if(isIsRolled()==true) System.out.println("You already rolled!");
        else{ setIsRolled(true);
        int check=0;
    int move,dice1,dice2;
    dice1=1 + (int)(Math.random() * ((6 - 1) + 1));
    dice2=1 + (int)(Math.random() * ((6 - 1) + 1));
    move = dice1 + dice2;
    System.out.printf("You rolled:%d",move);
    Player.getCurrentPlayer().setLastRoll(move);
    int finalLocation=Player.getCurrentPlayer().getLocation().getId();
      while (move > 0)
            {
                move--;
                finalLocation++;
                // Последняя ячейка 39 (0-39). Если положение > 39 тогда перемещаем на первую (0).
                if (finalLocation == 40)
                {
                    finalLocation = 0;
                    //Добавляем денег и обвновляем данные
                    Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                }
            }
     // Player.getCurrentPlayer().setLocation(finalLocation);
      goToLocation(finalLocation);
        //Если дубль то повторяем ход
            if (dice1 == dice2)
            {
                check++;
                if(check==3)
                { 
                    System.out.println("Cheater! You had 3 times double roll! Go to jail!");
                    goToLocation(30);
                }
                setIsRolled(false);
                    System.out.println("У вас дубль! Ходим еще раз!");      
            }
            else  check = 0;
        }
    }
    public void check_balance()
    {
    if (balance<0)
     {
       System.out.println("Ohh...you wasted all your money! You lose :(");
       active=-1;
     }
    }
    public void goToLocation()
    {
    
    }
    public void goToLocation(int id)
    {
          // int Groll = location;
    location.setParr(Player.getCurrentPlayer().getId());
    location=Game.getCells()[id];
    location.setParr(Player.getCurrentPlayer());
    Game.drawGameField();
            Game.displayPlayer();
    System.out.printf("You move to the cell %s\n",Game.getCells()[id].getName());
    Game.getCells()[id].action();
    }

    /**
     * @return the isRolled
     */
    public boolean isIsRolled() {
        return isRolled;
    }
    
    public void show_owns()
    {
        System.out.println("You have:");
   // Cell[] c=Game.getCells();
    for(Cell c:Game.getCells())
    {
    if(c.getOwner()==currentPlayer) System.out.printf("%s\n",c.getName());
    }
    }

    /**
     * @param isRolled the isRolled to set
     */
    public void setIsRolled(boolean isRolled) {
        this.isRolled = isRolled;
    }
}
