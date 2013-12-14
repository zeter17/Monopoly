/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class Card extends Cell {
    Card(){}
    Card(int i,String name)
    {
    super(name,i);
    }
    @Override
    void action()
    {
    if(super.getName().equals("chance"))
    {
            int roll = 1 + (int)(Math.random() * ((15 - 1) + 1));

            switch (roll)
            {
                case 1:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+50000);
                        System.out.println("Bank send you dividents in amount of:50000");
                    }
                    break;
                case 2:
                    {
                       if (Player.getCurrentPlayer().getLocation().getId() >= 22) Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        
                        System.out.println("Вы отправляетесь в Хмельницк");
                        Player.getCurrentPlayer().goToLocation(14);
                    }
                    break;
                case 3:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-20000);
                        System.out.printf("Штраф за перебывание в нетрезвом состоянии 20000");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
                case 4:
                    {
                        if (Player.getCurrentPlayer().getLocation().getId() >= 17) Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        System.out.println("Вы отправляетесь на Западный вокзал");
                        Player.getCurrentPlayer().goToLocation(15);
                    }
                    break;
                case 5:
                    {
                        System.out.println("Вы отправляетесь в тюрягу");
                        Player.getCurrentPlayer().setActive(3);
                        Player.getCurrentPlayer().goToLocation(10);
                    }
                    break;
                case 6:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+150000);
                        System.out.println("За аренду земель.\nВы получаете 150000");
                    }
                    break;
                case 7:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-15000);
                        System.out.println("Штраф за превышение скорости 15000");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
                case 8:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+100000);
                        System.out.println("Вы выиграли в конкурсе журнала \"Орендатор\".\nВы получили 100000");
                    }
                    break;
                case 9:
                    {
                       int goback = 0;
                        System.out.println("Вы возвращаетесь на 3 сектора назад.");
                        goback = Player.getCurrentPlayer().getLocation().getId() - 3;
                        if (goback == -1) goback = 39;
                        Player.getCurrentPlayer().goToLocation(goback);
                    }
                    break;
                case 10:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-150000);
                        System.out.println("Вы купили новый автомобиль за 150000");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
                case 11:
                    {
                        if (Player.getCurrentPlayer().getId() >= 33) Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        System.out.println("Вы отправляетесь в Черкасы");
                        Player.getCurrentPlayer().goToLocation(24);
                    }
                    break;
                case 12:
                    {
                        System.out.println("Вы отправляетесь в Донецк");
                        Player.getCurrentPlayer().goToLocation(39);
                    }
                    break;
                case 13:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        System.out.println("Вы отправляетесь на старт");
                        Player.getCurrentPlayer().goToLocation(0);
                    }
                    break;
                case 14:
                    {
                        System.out.println("У вас появился знакомый в МВД.\nВы получаете отмаз от тюряги.");
                        Player.getCurrentPlayer().setKey(Player.getCurrentPlayer().getKey()+1);
                    }
                
            }
    }
    else
    {
    int lottery = 0;
            
            lottery = 1 + (int)(Math.random() * ((15 - 1) + 1));

            switch (lottery)
            {
                case 1:
                    {
                        System.out.println("Вы переходите на один сектор вперед");
                        Player.getCurrentPlayer().goToLocation(Player.getCurrentPlayer().getLocation().getId() - 3);
                    }
                    break;
                case 2:
                    {
                        System.out.println("У вас день рождения.\nВсе быстро скинулись по 10000");
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+10000);
                    }
                    break;
                case 3:
                    {
                        System.out.println("Вы отправляетесь в тюрягу");
                        Player.getCurrentPlayer().setActive(3);
                        Player.getCurrentPlayer().goToLocation(10);
                    }
                    break;
                case 4:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+10000);
                        System.out.println("Вы выиграли в конкурсе красоты.\nВы получили 10000");
                    }
                    break;
                case 5:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+20000);
                        System.out.println("Вы вернули налог на прибль.\nВы получили 20000");
                    }
                    break;
                case 6:
                    {
                        System.out.println("Вы отправляетесь в Херсон");
                        Player.getCurrentPlayer().goToLocation(39);
                    }
                    break;
                case 7:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-50000);
                        System.out.println("Вы отплатили страховку.\nС вашего счета снято 50000.");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
                case 8:
                    {
                        System.out.println("Оплатите штраф 10000 или выбирите \"шанс\".");
                        System.out.println("Do you want to pay tax?");
                       
                    }
                    break;
                case 9:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        System.out.println("Из за ошибки в банке вы получаете 200000.");
                    }
                    break;
                case 10:
                    {
                        System.out.println("У вас появился знакомый в МВД.\nВы получаете отмаз от тюряги.");
                        Player.getCurrentPlayer().setKey(Player.getCurrentPlayer().getKey()+1);
                    }
                    break;
                case 11:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+200000);
                        System.out.println("Вы получили наследство 200000.");
                    }
                    break;
                case 12:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+50000);
                        System.out.println("Вы получили 50000 от продажи акций.");
                    }
                    break;
                case 13:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+100000);
                        System.out.println("Вы получаете 100000 за оренду.");
                    }
                    break;
                case 14:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()+25000);
                        System.out.println("Вы получили 25000 от продажи акций.");
                    }
                    break;
                case 15:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-50000);
                        System.out.println("Вы отплатили лечение.\nС вашего счета снято 50000.");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
                case 16:
                    {
                        Player.getCurrentPlayer().setBalance(Player.getCurrentPlayer().getBalance()-100000);
                        System.out.println("Вы отплатили лечение.\nС вашего счета снято 100000.");
                        Player.getCurrentPlayer().check_balance();
                    }
                    break;
            }}
    }
}
