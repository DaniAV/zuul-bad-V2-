import java.util.HashMap;
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words

    private HashMap<String,Option> comands; 

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
        comands = new HashMap<>();
        comands.put("go", Option.IR);
        comands.put("quit", Option.TERMINAR);
        comands.put("help", Option.AYUDA);
        comands.put("look", Option.EXAMINAR);
        comands.put("eat", Option.COMER);
        comands.put("return", Option.VOLVER);
        comands.put("teak", Option.COGER);
        comands.put("drop", Option.SOLTAR);
        comands.put("objets", Option.OBJETOS);
        comands.put("unknow", Option.UNKNOW);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        if(comands.containsKey(aString))
        {
            return true;
        }
        // if we get here, the string was not found in the commands
        else
        {
            return false;
        }
    }

    /**
     * Print all valid commands to System.out
     */
    public void showAll()
    {
        String com = "Los comandos son: \n" + comands.keySet();
        System.out.println(com);
    }

    /**
     * Return the object Option associated with a word.
     * @param commandWord The word to look up (as a string).
     * @return the object Option correspondng to the paramater commandWord, or the object Option.UNKNOWN
     *         if it is not a valid command word
     */
    public Option getCommandWord(String commandWord)
    {
        Option valor = Option.UNKNOW;
        if(comands.containsKey(commandWord))
        {
            valor = comands.get(commandWord);
        }
        return valor;
    }
}
