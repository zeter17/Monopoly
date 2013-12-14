/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Turovskiy Vladyslav
 */
public class CommandLine {
    private  static String command;

    public static void error()
    {
    System.out.println("You entered wrong command!");
    }
    /**
     * @return the command
     */
    public static String getCommand() {
        return command;
    }

    /**
     * @param aCommand the command to set
     */
    public static void setCommand(String aCommand) {
        command = aCommand;
        if(command.equals("roll"))
        {  
        Player.getCurrentPlayer().roll();
        }
        else if(command.equals("end"))
        {
            Game.setTurn(Game.getTurn()+1);
        Player.getCurrentPlayer().changePlayer();
        }
        else if(command.equals("show"))
        {
         Player.getCurrentPlayer().show_owns();
        }
        else if(command.equals("clear"))
        {
        Game.drawGameField();
            Game.displayPlayer();
        }
        else if(command.equals("help"))
        {
            System.out.println("\"roll\" to get random roll.");
            System.out.println("\"end\" to finish your turn. Change active player.");
            System.out.println("\"exit\" finish game. Exit from the program");
            System.out.println("\"show\" Display all aviable owns");
            System.out.println("\"clear\" refresh game filed and player's properties");
        }
    }
    String[] array=new String[0];

    
}
