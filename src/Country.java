
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Country extends Cell implements IMonopoly {

    /**
     * @return the map
     */
    public static Map<String, Integer> getMap() {
        return map;
    }

    /**
     * @param aMap the map to set
     */
    public static void setMap(Map<String, Integer> aMap) {
        map = aMap;
    }
    private int price=0;
    private String section=null;
    
    private static Map<String, Integer> map = new HashMap<String, Integer>();
    private int rate=0;
    private int priceHouse=0;
    private int priceHotel=0;
    private int numbHouses=0;
    private boolean isHotel;
    Country(){}
    Country(String s,int i,int p,String sec,int r,int prH,int prHotel,int mon)
    {
    super(s,i);
    super.setNumber_of_players(0);
    price=p;
    section=sec;
    rate=r;
    priceHouse=prH;
    priceHotel=prHotel;
    numbHouses=0;
    super.setNumb_monopoly(mon);
    }
   public boolean monopoly_check(int n)
   {
       if(Player.getCurrentPlayer().getMap().get(this.section)==Country.getMap().get(this.section)) return true;
       else return false;
   }
    @Override
    void action()
    {
        Scanner c=new Scanner(System.in);
        //first check, do that cell has a owner?
        //if no, we ask player, do he wants to buy it
    if (super.getOwner()==null)
            {
              while(CommandLine.getCommand().equals("no") || !CommandLine.getCommand().equals("yes")){ 
            System.out.printf("This is free cell!Price:%d \nDo you want to buy it?\n",price);
            CommandLine.setCommand(c.nextLine());
            //if yes...
            if(CommandLine.getCommand().equals("yes"))  
            {
                //balance - price
            Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-price);
            //that cell now has an owner
            super.setOwner(Player.getCurrentPlayer());
            //+1 to monopoly
            Player.getCurrentPlayer().setMap(this.section,Player.getCurrentPlayer().getMap().get(this.section)+1);
             System.out.printf("Congratilations! You bought: %s\n",super.getName());
            }
            else if(CommandLine.getCommand().equals("no")) break;
            //if no we just keep going our game
            else if(CommandLine.getCommand().equals("no") || !CommandLine.getCommand().equals("yes"))
                CommandLine.error();}
            }
    //if cell has an owner player should to pay tax
     else if(super.getOwner()!=Player.getCurrentPlayer() && super.getOwner()!=null)
     { 
         //if owner has a monopoly, current play has to pay double price
     if(monopoly_check(super.getNumb_monopoly())==true)
     {
         System.out.printf("Oooh...cells owner is another player! You have to pay:",rate*2*(getNumbHouses()+1));
     Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-rate*2*(getNumbHouses()+1));
     getOwner().setBalance(getOwner().getBalance()+rate*2*(getNumbHouses()+1));
     }
     else 
     {
         System.out.printf("Oooh...cells owner is another player! You have to pay:",rate);
     Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-rate);
     getOwner().setBalance(getOwner().getBalance()+rate);
     }
     }
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * @return the priceHouse
     */
    public int getPriceHouse() {
        return priceHouse;
    }

    /**
     * @param priceHouse the priceHouse to set
     */
    public void setPriceHouse(int priceHouse) {
        this.priceHouse = priceHouse;
    }

    /**
     * @return the priceHotel
     */
    public int getPriceHotel() {
        return priceHotel;
    }

    /**
     * @param priceHotel the priceHotel to set
     */
    public void setPriceHotel(int priceHotel) {
        this.priceHotel = priceHotel;
    }

    /**
     * @return the numbHouses
     */
    public int getNumbHouses() {
        return numbHouses;
    }

    /**
     * @param numbHouses the numbHouses to set
     */
    public void setNumbHouses(int numbHouses) {
        this.numbHouses = numbHouses;
    }

    /**
     * @return the isHotel
     */
    public boolean isIsHotel() {
        return isHotel;
    }

    /**
     * @param isHotel the isHotel to set
     */
    public void setIsHotel(boolean isHotel) {
        this.isHotel = isHotel;
    }
}
