/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alivingfile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author SydnaAgnehs
 */
public class ALivingFile implements ActionListener{
String name="Elios.uio", food="Food.uio", waste="Waste.uio", pond="Pond/", water="Water.uio", dead="Elios(dead).uio";
public File ToU_Loc=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/");
public File Home_Loc=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/");
public File Desktop_Loc=new File("/Users/"+System.getProperty("user.name")+"/Desktop/");

public File Storage=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Storage/");
public File Food=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Storage/Food.uio");

public File ToU_Name=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+name);
public File Home_Name=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/"+name);
public File Desktop_Name=new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+name);

public File ToU_F=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+food);
public File Home_F=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/"+food);
public File Desktop_F=new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+food);

public File ToU_W=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+waste);
public File Home_W=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/"+waste);
public File Desktop_W=new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+waste);

public File ToU_Wat=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+water);
public File ToU_Wat_P=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+pond+water);
public File Home_Wat=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/"+water);
public File Desktop_Wat=new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+water);
public File Storage_Wat=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Storage/"+water);


public File ToU_P=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+pond);

public File ToU_Dead=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Town of Uiol/"+dead);
public File Home_Dead=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/"+dead);
public File Desktop_Dead=new File("/Users/"+System.getProperty("user.name")+"/Desktop/"+dead);

int hunger=0, thirst=0, count=0;
public static Timer timer;
Calendar cal, tHunger, tThirst;
SimpleDateFormat dateformatter;
String setTime_hunger, setTime_water;
public File current;
public ALivingFile() throws IOException {
    hunger=500;
    thirst=200;
    count=0;
    this.initiate();
    JFrame frame=new JFrame();
    
    
}

public void act() {
    int r=(int)(Math.random()*15);
    //System.out.println(r);
    switch(r) {
        case 1:
            this.move("Desktop");
            break;
        case 2:
            this.move("Town of Uiol");
            break;
        case 3:
            this.move("Home");
            break;
        default:
            break;
            
    }
    
}

public void moveTo(File loc) {
   current.renameTo(new File(loc, current.getName())); 
   current=loc;
}

public void move(String loc) {
    if(loc.equalsIgnoreCase("Town of Uiol")) {
        if(!current.equals(ToU_Loc)) {
            this.moveTo(ToU_Loc);
        }
    }
    if(loc.equals("Home")){
        if(!current.equals(Home_Loc)) {
            this.moveTo(Home_Loc);
        }
    }
    if(loc.equals("Desktop")){
        if(!current.equals(Desktop_Loc)) {
            this.moveTo(Desktop_Loc);
        }
    }
}

public void initiate() throws IOException {
    Storage.mkdirs();
    ToU_Loc.mkdirs();
    Home_Loc.mkdirs();
    ToU_Loc.deleteOnExit();
    Home_Loc.deleteOnExit();
    Desktop_Loc.deleteOnExit();
    Storage.deleteOnExit();
    Food.deleteOnExit();
    ToU_Name.deleteOnExit();
    Home_Name.deleteOnExit();
    Desktop_Name.deleteOnExit();
    ToU_F.deleteOnExit();
    Home_F.deleteOnExit();
    Desktop_F.deleteOnExit();
    ToU_W.deleteOnExit();
    Home_W.deleteOnExit();
    Desktop_W.deleteOnExit();
    ToU_Wat.deleteOnExit();
    Home_Wat.deleteOnExit();
    Desktop_Wat.deleteOnExit();
    ToU_P.deleteOnExit();
    ToU_Wat_P.deleteOnExit();
    ToU_Dead.deleteOnExit();
    Home_Dead.deleteOnExit();
    Desktop_Dead.deleteOnExit();
    Storage_Wat.deleteOnExit();
    
    //File Home_Name_Txt=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/Elios.txt");
    //FileWriter file=new FileWriter(Home_Name_Txt, true);
    //file.close();
    File f=new File("/Users/"+System.getProperty("user.name")+"/Desktop/Home/Elios.uio");
    System.out.println(f.createNewFile());
    Food.createNewFile();
    ToU_P.mkdir();
    ToU_Wat_P.createNewFile();
    Storage_Wat.createNewFile();
    //Home_Name_Txt.renameTo(f);
    current=f;
    current.deleteOnExit();
     cal=Calendar.getInstance();
     tThirst=Calendar.getInstance();
     tHunger= Calendar.getInstance();
     tThirst.add(Calendar.MINUTE, 1);
     tHunger.add(Calendar.HOUR, 1);
     hunger=100;
     dateformatter = new SimpleDateFormat("hh:mm:ss");
     setTime_water=(String)dateformatter.format(tThirst.getTime());
     setTime_hunger=(String)dateformatter.format(tHunger.getTime());
     
     timer = new Timer(1000, this);
     timer.start();
    
}

public void hunger() {
    hunger-=10;
}

public void CanEat() throws IOException {
    if(ToU_F.exists()&&hunger<100&&(current.equals(ToU_Name))) {
        this.eat(ToU_F);
    }
    if(Home_F.exists()&&hunger<100&&(current.equals(Home_Name))) {
        this.eat(Home_F);
    }
    if(Desktop_F.exists()&&hunger<100&&(current.equals(Desktop_Name))) {
        this.eat(Desktop_F);
    }
    
}

public void eat(File loc) throws IOException {
    loc.delete();
    if(current.equals(ToU_Name)){
        ToU_W.createNewFile();
    }
    if(current.equals(Home_Name)){
        Home_W.createNewFile();
    }
    if(current.equals(Desktop_Name)){
        Desktop_W.createNewFile();
    }
    hunger=500;
    tHunger= Calendar.getInstance();
    tHunger.add(Calendar.MINUTE, 10);
    setTime_hunger=(String)dateformatter.format(tHunger.getTime());
    
}

public void health() throws IOException {
    if(hunger<=0||thirst<=0) {
        current.delete();
        if(current.equals(ToU_Name)){
           ToU_Dead.createNewFile();
            }
         if(current.equals(Home_Name)){
           Home_Dead.createNewFile();
         }
         if(current.equals(Desktop_Name)){
         Desktop_Dead.createNewFile();
         }
    }
    
}
public void water() {
    thirst-=1;
}

public void actionPerformed(ActionEvent e) {
    count++;
    if(count==200) {
         this.act();
         count=0;
    }
       
    this.locate();
    cal= Calendar.getInstance();
    try {
                this.thirst();
            } catch (IOException ex) {
                Logger.getLogger(ALivingFile.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        try {
            this.CanEat();
        } catch (IOException ex) {
            Logger.getLogger(ALivingFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    if(dateformatter.format(cal.getTime()).equals(setTime_hunger)) {
        
        this.hunger();
    }
    if(dateformatter.format(cal.getTime()).equals(setTime_water)) {
            this.water();
    }
        try {
            this.health();
        } catch (IOException ex) {
            Logger.getLogger(ALivingFile.class.getName()).log(Level.SEVERE, null, ex);
        }
   // System.out.println(dateformatter.format(cal.getTime())+"           "+setTime_hunger+"              "+hunger);
    
    
}
public void thirst() throws IOException {
     if(ToU_Wat.exists()&&thirst<100&&(current.equals(ToU_Name))) {
        this.drink(ToU_Wat);
    }
    if(Home_Wat.exists()&&thirst<100&&(current.equals(Home_Name))) {
        this.drink(Home_Wat);
    }
    if(ToU_Wat_P.exists()&&thirst<100&&(current.equals(ToU_Name))) {
        this.drink(ToU_Wat_P);
    }
    if(Desktop_Wat.exists()&&thirst<100&&(current.equals(Desktop_Name))) {
        this.drink(Desktop_Wat);
    }
    
}

public void drink(File loc) {
    if(!loc.equals(ToU_Wat_P))
    loc.delete();
    thirst=200;
    tThirst=Calendar.getInstance();
    tHunger.add(Calendar.MINUTE, 10);
    setTime_water=(String)dateformatter.format(tThirst.getTime());
}

public void locate() {
    if(ToU_Name.exists()) {
        current=ToU_Name;
    }
    if(Home_Name.exists()) {
        current=Home_Name;
    }
    if(Desktop_Name.exists()) {
        current=Desktop_Name;
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new ALivingFile();
    }
}
