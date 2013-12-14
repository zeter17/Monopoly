/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Taxes extends Cell {
    private int rate;
    Taxes()
    {
    
    }
    Taxes(String s,int a,int r)
    {
    super(s,a);
    rate=r;
    super.setNumb_monopoly(0);
    }
    @Override
    void action()
    {
    Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-rate);
    }
}
