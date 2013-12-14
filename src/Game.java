
/**
 *
 * @author Turovskiy Vladyslav
 */
import java.util.Map;
import java.util.Scanner;

public class Game {
 final static int n=40; 
private static Player p1=new Player(0);
private static Player p2=new Player(1);
    private static Cell[]  cells=new Cell[n];
    private static int turn=1;

    /**
     * @return the turn
     */
    public static int getTurn() {
        return turn;
    }

    /**
     * @param aTurn the turn to set
     */
    public static void setTurn(int aTurn) {
        turn = aTurn;
    }
    /**
     * @param args the command line arguments
     */
     void refresh(Cell c)
    {
    cells[c.getId()]=c;
    }
    static Cell[] initializationOfData(Cell[] c)
    {
         c[0] = new Simple("start",0);
         c[0].setNumber_of_players(2);
         c[1] = new Country("Belarus",1,60000,"lightblue",32,50000,100000,2);
        c[2]= new Card(2, "lottery");
        c[3] = new Country("Moldova",3,60000, "lightblue", 34,50000,100000,2);
        c[4] = new Taxes("tax",4, 200000);
        c[5]= new Transport("South station",5);
        c[6]= new Country("Bulgaria",6,100000, "orange", 36,50000,150000,3);
        c[7]= new Card(7, "chance");
        c[8]= new Country("Greece",8,100000, "orange", 38,50000,150000,3);
        c[9] = new Country("Albania",9,120000, "orange", 40,50000,150000,3);
        c[10]= new Free("jail",10);
        c[11]= new Country("Ukraine",11,140000, "purple", 42,100000,200000,3);
        c[12]= new Municipal("Electric station",12);
        c[13]= new Country("Poland",13,140000, "purple", 44,100000,200000,3);
        c[14] = new Country("Czech Republic",14,160000, "purple", 46,100000,200000,3);
        c[15]= new Transport("West station",15);
        c[16] = new Country("Croatia",16,180000, "red", 46,100000,200000,3);
        c[17]= new Card(17, "lottery");
        c[18] = new Country("Serbia",18,180000, "red", 48,100000,200000,3);
        c[19]= new Country("Montenegro",19,200000, "red", 50,100000,200000,3);
        c[20]= new Free("parking",20);
        c[21]= new Country("Latvia",21,220000,"blue", 52,150000,250000,3);
        c[22]= new Card(22, "chance");
        c[23]= new Country("Lithuania",23,220000, "blue", 54,150000,250000,3);
        c[24]= new Country("Estonia",24,240000, "blue", 56,150000,250000,3);
        c[25]= new Transport("North station",25);
        c[26]= new Country("Sweden",26,260000, "yellow", 56,150000,250000,3);
        c[27]= new Country("Denmark",27,260000, "yellow", 58, 150000,250000,3);
        c[28]= new Municipal("Storage pool",28);
        c[29]= new Country("Finland",29,280000, "yellow", 60,150000,250000,3);
        c[30]= new Simple("go to jail",30);
        c[31]= new Country("Spain",31,300000, "green", 62,200000,300000,3);
        c[32]= new Country("Italy",32,300000, "green", 64,200000,300000,3);
        c[33]= new Card(33, "lottery");
        c[34]= new Country("France",34,320000, "green", 66,200000,300000,3);
        c[35]= new Transport("Восточный вокзал",35);
        c[36] = new Card(36, "chance");
        c[37]= new Country("United Kingdom",37,350000, "lightgreen", 68,200000,300000,2);
        c[38] = new Taxes("tax",38, 100000);
        c[39]= new Country("Germany",39,400000, "lightgreen", 70,200000,300000,2);
        
        
        Map<String, Integer> map =Country.getMap();
        //set info about cells monopoly
        map.put("lightgreen",2);
        map.put("green",3);
        map.put("yellow",3);
        map.put("blue",3);
        map.put("red",3);
        map.put("purple",3);
        map.put("orange",3);
        map.put("lightblue",2);
        Country.setMap(map);
        //start position
         getP1().setLocation(cells[0]);
        getP2().setLocation(cells[0]);
        cells[0].setParr(p1);
        cells[0].setParr(p2);
        //set first player like  current in the beginning of the game
        Player.setCurrentPlayer(getP1());
    return c;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner s=new Scanner(System.in);
       initializationOfData(cells);
       drawGameField();
            displayPlayer();
        do{   
            System.out.printf("Enter the command. List of commands you can check with command \"help\"\n-");
            CommandLine.setCommand(s.nextLine());
         }
        while(!CommandLine.getCommand().equals("exit"));
     
    }
    public static void drawGameField()
    {
                    System.out.printf("      Free Zone->[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]<-Pointer to Jail\n",cells[20].toString(),cells[21].toString(),cells[22].toString(),cells[23].toString(),cells[24].toString(),cells[25].toString(),cells[26].toString(),cells[27].toString(),cells[28].toString(),cells[29].toString(),cells[30].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[19].toString(),cells[31].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[18].toString(),cells[32].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[17].toString(),cells[33].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[16].toString(),cells[34].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[15].toString(),cells[35].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[14].toString(),cells[36].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[13].toString(),cells[37].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[12].toString(),cells[38].toString());
                    System.out.printf("                 [%s]                                    [%s]\n",cells[11].toString(),cells[39].toString());
                    System.out.printf("           jail->[%s][%s][%s][%s][%s][%s][%s][%s][%s][%s][%s]<-Start\n",cells[10].toString(),cells[9].toString(),cells[8].toString(),cells[7].toString(),cells[6].toString(),cells[5].toString(),cells[4].toString(),cells[3].toString(),cells[2].toString(),cells[1].toString(),cells[0].toString());
    }
    public static void displayPlayer()
    {
    System.out.printf("Turn: %s\n", getTurn());    
    System.out.printf("Player: %s\n",Player.getCurrentPlayer().toString());
    System.out.printf("Balance: %s\n",Player.getCurrentPlayer().getBalance());
    System.out.printf("Location: %s\n",Player.getCurrentPlayer().getLocation().getName());
    }

    /**
     * @return the cells
     */
    public static Cell[] getCells() {
        return cells;
    }

    /**
     * @param aCells the cells to set
     */
    public static void setCells(Cell[] aCells) {
        cells = aCells;
    }

    /**
     * @return the p1
     */
    public static Player getP1() {
        return p1;
    }

    /**
     * @param aP1 the p1 to set
     */
    public static void setP1(Player aP1) {
        p1 = aP1;
    }

    /**
     * @return the p2
     */
    public static Player getP2() {
        return p2;
    }

    /**
     * @param aP2 the p2 to set
     */
    public static void setP2(Player aP2) {
        p2 = aP2;
    }
}
