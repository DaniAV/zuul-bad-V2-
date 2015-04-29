import java.lang.System;
import java.lang.Math;
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        // initialise instance variables
  
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static String currentTimeMil()
    {
          long hora1 = 0;
          long hora2 = 0;
        hora1 = System.currentTimeMillis();
        for(int i = 0; i<1000000; i++)
        {
            System.out.println(i);
        }
        hora2 = System.currentTimeMillis();
        long milisegundos = hora2-hora1;
        int segundos = (int)milisegundos/1000;
        int minutos = (int)segundos/60;
        segundos = segundos - (minutos*60);
        String valor  = "El tiempo transcurrido ha sido " + minutos + " minutos, " + segundos + " segundos.";
        return valor;
    }
}
