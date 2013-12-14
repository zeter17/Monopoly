/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Turovskiy Vladyslav
 */
public class Municipal extends Cell implements IMonopoly {
  final  int price=150000;

   Municipal(String s,int i)
   {
       super(s,i);
   super.setNumb_monopoly(2);
   } 
   @Override
   public boolean monopoly_check(int n)
   {
       if(super.getOwner().getMunic()==n) return true;
       else return false;
   }
    @Override
    public void action()
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
            Player.getCurrentPlayer().setMunic(Player.getCurrentPlayer().getMunic()+1);
            }
            else if(CommandLine.getCommand().equals("no") || CommandLine.getCommand().equals("yes"))
                CommandLine.error();
            }
     else if(super.getOwner()!=Player.getCurrentPlayer() && super.getOwner()!=null)
     {
     if(monopoly_check(super.getNumb_monopoly())==true)
     {
     Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-Player.getCurrentPlayer().getLastRoll()*10);
     getOwner().setBalance(getOwner().getBalance()+Player.getCurrentPlayer().getLastRoll()*10);
     }
     else 
     {
     Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-Player.getCurrentPlayer().getLastRoll()*4);
     getOwner().setBalance(getOwner().getBalance()+Player.getCurrentPlayer().getLastRoll()*4);
     }
     }
     else if(super.getOwner()==Player.getCurrentPlayer())
     {
     System.out.println("It's your cell!");
     }
    }
}
