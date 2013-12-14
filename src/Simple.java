/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Simple extends Free{
    Simple(){super();
    super.setNumb_monopoly(0);
    }
    Simple(String s,int i)
    {
    super(s,i);
    super.setNumb_monopoly(0);
    }
    @Override
    void action()
    {
        if(Player.getCurrentPlayer().getLocation().getId()!=0)
        {
        System.out.println("Oooops! You are going to jail!");
        Player.getCurrentPlayer().setActive(3);
        Player.getCurrentPlayer().setLocation(10);
        Player.getCurrentPlayer().getLocation().setNumber_of_players(Player.getCurrentPlayer().getLocation().getNumber_of_players()+1);
        }
        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
    }
}
