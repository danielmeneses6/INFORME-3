package informeguia3;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;


public class consola {

  
    public static void main(String[] args) {
        reloj reloj = new reloj();
        Scanner leer= new Scanner(System.in);
        int opcion1;
        int opt=1;
        int opti=1;
      do{
        System.out.println("===MENU DE OPCIONES===");
        System.out.println("1. opciones timers");
        System.out.println("2. animacion con fotogramas");
        System.out.println("0.salir");
        int option=leer.nextInt();
        opti=option;
        switch(option)
        {
            case 1:
    do
    {
        System.out.println("MENU");
        System.out.println("1. Hora Actual.");
        System.out.println("2. Programar Alarma.");
        System.out.println("3. Temporizador3");
        System.out.println("0. Volver.");
        int op=leer.nextInt();
        opt=op;
        
        switch(op)
        {
            case 1:
                do{
                     TimerTask timertask = new TimerTask()
                     { int i=0;
                     public void run()
                      {
                       reloj.Hora();
                       i++;
                      }
                     };
                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(timertask, 0, 1000);
                        timer.schedule(new TimerTask() 
                        {
                        public void run() 
                        {
                        timer.cancel();
                        
                        }
                        }, 10000);
                    opcion1=leer.nextInt();
                }while(opcion1!=0);
                break;
            case 2:
                do{
                reloj.Alarma();
                opcion1=leer.nextInt();
                }while(opcion1!=0);
               break;
            case 3:
                do{
                reloj.dos();
                opcion1=leer.nextInt();
                }while(opcion1!=0);   
        }
    }while(opt!=0);
break;
            case 2:
               new animacion();
               break;
}   
      }while(opti!=0);
}

}