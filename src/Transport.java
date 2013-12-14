
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Transport extends Cell implements IMonopoly {
   final private int price=200000;
  final  private int rate=25000;
    Transport()
    {
    
    }
     Transport(String s,int a)
    {
        super(s,a);
    super.setNumb_monopoly(4);
    }
     @Override
   public boolean monopoly_check(int n)
   {
       return true;
   }
    @Override
    void action()
    {
        Scanner c=new Scanner(System.in);
    if (super.getOwner()==null)
            {
            System.out.println("Do you want to buy it?");
            CommandLine.setCommand(c.nextLine());
            if(CommandLine.getCommand().equals("yes"))  
            {
            Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-price);
            super.setOwner(Player.getCurrentPlayer());
            Player.getCurrentPlayer().setMunic(Player.getCurrentPlayer().getTrans()+1);
            }
            else if(!CommandLine.getCommand().equals("no") || !CommandLine.getCommand().equals("yes"))
                CommandLine.error();
            }
     else if(super.getOwner()!=Player.getCurrentPlayer() && super.getOwner()!=null)
     {
     Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-rate*super.getOwner().getTrans());
     getOwner().setBalance(getOwner().getBalance()+rate*super.getOwner().getTrans());
     }
     else if(super.getOwner()==Player.getCurrentPlayer())
     {
     System.out.println("It's your cell!");
     }
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
}
