
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
public class Cell {
    private int id=0;
    private int number_of_players=0;
    private String name=null;
    private String image=null;
    private Player[] parr=new Player[2];
    private Player owner=null;
    private  int numb_monopoly=0;
    Cell(){}
    Cell(String s,int i)
    {
    name=s;
    id=i;
    number_of_players=0;
    parr[0]=null;
    parr[1]=null;
    }
   void action(){}
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
     * @return the number_of_players
     */
    public int getNumber_of_players() {
        return number_of_players;
    }
    /**
     * @param number_of_players the number_of_players to set
     */
    public void setNumber_of_players(int number_of_players) {
        this.number_of_players = number_of_players;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the numb_monopoly
     */
    public int getNumb_monopoly() {
        return numb_monopoly;
    }
    /**
     * @param numb_monopoly the numb_monopoly to set
     */
    public void setNumb_monopoly(int numb_monopoly) {
        this.numb_monopoly = numb_monopoly;
    }
    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }
    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * @return the owner
     */
    public Player getOwner() {
        return owner;
    }
    /**
     * @param owner the owner to set
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }
   @Override
    public String toString()
    {
        //return drawed cell
        String s=new String();
        if(getParr()[0]==null && getParr()[1]==null) s="  ";
          else if(getParr()[0]!=null &&getParr()[1]!=null) s="/*";
          else if(getParr()[0]!=null && getParr()[1]==null)s="/ ";
          else s=" *";
        return s;
    }

    /**
     * @return the parr
     */
    public Player[] getParr() {
        return parr;
    }

    /**
     * @param parr the parr to set
     */
    public void setParr(int i) {
        
        this.parr[i] = null;
    }
    public void setParr(Player p)
    {
    this.parr[p.getId()]=p;
    }
}
