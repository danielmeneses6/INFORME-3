package informeguia3;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class reloj {
    
  public void Hora (){
    LocalDateTime locaDate =LocalDateTime.now();
    int hours = locaDate.getHour();
    int minutes = locaDate.getMinute();
    int seconds = locaDate.getSecond();
    System.out.println("Hora actual :"+ hours + ":" + minutes + ":" + seconds);
    }
    
 public void Alarma (){
     Scanner leer= new Scanner(System.in);
     LocalDateTime locaDate =LocalDateTime.now();
    int hours = locaDate.getHour();
    int minutes = locaDate.getMinute();
    int seconds = locaDate.getSecond();
     System.out.println("Por favor ingrese los datos que se le piden para configurar su alarma");
     System.out.println("Ingrese la hora");
     int h=leer.nextInt();
     System.out.println("Ingrese los minutos");
     int m=leer.nextInt();
     System.out.println("Ingrese los segundos");
     int s=leer.nextInt();
     System.out.println("Su alarma fue programada para : " + h + ":" + m+ ":"+ s);
    TimerTask timertask = new TimerTask()
    { int i=0;
      public void run()
              
     {
          LocalDateTime locaDate =LocalDateTime.now();
    int hours = locaDate.getHour();
    int minutes = locaDate.getMinute();
    int seconds = locaDate.getSecond(); 
      
      
      if(h == hours && m == minutes && s == seconds)
     {
         System.out.println("ES HORAAAAAA!!!!!!");
     }
      
     i++;
     }
     
    };
     Timer timer = new Timer();
     timer.scheduleAtFixedRate(timertask, 0, 1000);
    
    
    
    }
 public void dos (){
     Scanner leer= new Scanner(System.in);
     LocalDateTime locaDate =LocalDateTime.now();
    int hours = locaDate.getHour();
    int minutes = locaDate.getMinute();
    int seconds = locaDate.getSecond();
    
     System.out.println("en cuanto tiempo quiere que suene la alarma");
    System.out.println("Horas");
     int h=leer.nextInt();
     System.out.println("Minutos");
     int m=leer.nextInt();
     System.out.println("Segundos");
    int s=leer.nextInt();
     
     final int ho=hours;
     final int mi=minutes;
     final int se=seconds;
    
     
    TimerTask timertask = new TimerTask()
    { int i=0;
      public void run()
              
     {
    LocalDateTime locaDate =LocalDateTime.now();
    int hours = locaDate.getHour();
    int minutes = locaDate.getMinute();
    int seconds = locaDate.getSecond(); 
     
      
      if(ho == hours-h && mi == minutes-m )
     {
         if(h==0 && m==0)
         {
             if(se+s>60)
             {int sec;
                 sec=se+s-60;
                if(sec==seconds)
                {   TimerTask timertask = new TimerTask(){
                         
                         int i=0;
                         public void run(){
                             
                     System.out.println("ALARMA!!!!!!");
                         }
                     };
                     Timer timer = new Timer();
                     timer.scheduleAtFixedRate(timertask, 0000, 10000);
                      timer.schedule(new TimerTask() 
                        {
                        public void run() 
                        {
                        timer.cancel();
                        
                        }
                        }, 15000);
                               
                   
                }
             }
             else
             if(se+s==seconds)
             {
                 
                     TimerTask timertask = new TimerTask(){
                         
                         int i=0;
                         public void run(){
                             
                     System.out.println("ALARMA!!!!!!");
                         }
                     };
                     Timer timer = new Timer();
                     timer.scheduleAtFixedRate(timertask, 0000, 10000);
                      timer.schedule(new TimerTask() 
                        {
                        public void run() 
                        {
                        timer.cancel();
                        
                        }
                        }, 10000);
                 
                 
             }
         }
         if(se+s>60)
         {int sec;
         sec=se+s-60;
         if(sec==seconds)
         {
             
          TimerTask timertask = new TimerTask(){
                         
                         int i=0;
                         public void run(){
                             
                     System.out.println("ALARMA!!!!!!");
                         }
                     };
                     Timer timer = new Timer();
                     timer.scheduleAtFixedRate(timertask, 0000, 10000);
                      timer.schedule(new TimerTask() 
                        {
                        public void run() 
                        {
                        timer.cancel();
                        
                        }
                        }, 10000);
         }
         }
         else
             if(ho == hours-h && mi == minutes-m && se==seconds )
             {
                  TimerTask timertask = new TimerTask(){
                         
                         int i=0;
                         public void run(){
                             
                     System.out.println("ALARMA!!!!!!");
                         }
                     };
                     Timer timer = new Timer();
                     timer.scheduleAtFixedRate(timertask, 0000, 10000);
                      timer.schedule(new TimerTask() 
                        {
                        public void run() 
                        {
                        timer.cancel();
                        
                        }
                        }, 10000);
             }
     }
      
     i++;
     }
     
    };
     Timer timer = new Timer();
     timer.scheduleAtFixedRate(timertask, 0, 1000);
    
    
    
    }


}