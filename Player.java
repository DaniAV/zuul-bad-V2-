import java.util.Stack;
import java.util.ArrayList;

/**
 * Esta clase representa al jugador del juego. Realiza las acciones
 * relacionadas con el (examinar, comer, etc).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // La habitaci�n en la que se encuentra en ese momento el jugador
    private Room currentRoom;
    // Pila de habitaciones que ha visitado
    private Stack<Room> previusRooms;
    // Objetos que tiene el jugador
    private ArrayList<Item> inventory;

    /**
     * Constructor del jugador
     */
    public Player()
    {
        currentRoom = null;
        previusRooms = new Stack<Room>();
        inventory = new ArrayList<Item>();
    }

    /**
     * Coloca al jugador en una habitaci�n
     * @param room La habitaci�n en la que se encuentra el jugador.
     */
    public void setRoom(Room room)
    {
        if(currentRoom != null)
        {
            previusRooms.push(currentRoom);
        }
        this.currentRoom = room;
    }

    /**
     * El jugador vuelve a la habitaci�n anterior
     */
    public void goBack()
    {
        if(!previusRooms.empty())
        {
            currentRoom = previusRooms.pop();
            printLocationInfo();
            System.out.println();
        }
        else
        {
            System.out.println("No existen localizaciones a las que volver");
        }
    }

    /**
     * El jugador examina la localizaci�n en la que se encuentra
     */
    public void look()
    {
        printLocationInfo();
    }

    /**
     * El jugador come
     */
    public void eat()
    {
        System.out.println("Acabas de comer y ya no estas hambriento");
    }

    /**
     * El jugador intenta moverse a otra otra habitaci�n. Si existe una habitaci�n en esa
     * direcci�n lo hara, sino imprimira un mensaje avisando de que no puede ir en esa direcci�n.
     * @param direccion La direccion en la que intenta moverse
     */
    public void goRoom(String direccion)
    {
        Room nextRoom = currentRoom.getExit(direccion);

        if (nextRoom == null) {
            System.out.println("No puedes continuar por ah�");
        }
        else {
            setRoom(nextRoom);
            printLocationInfo();
            System.out.println();
        }
    }

    /**
     * Intenta a�adir un objeto al inventario del jugador. Si el objeto existe en la habitacion
     * y puede cogerlo, lo a�adira a su inventario.
     * @param El nombre del objeto que quiere a�adir
     */
    public void addItem(String objeto)
    {
        // busca el objeto en la habitacion
        Item tempObj = currentRoom.search(objeto);
        if(tempObj != null)
        {
            inventory.add(tempObj);
            currentRoom.remove(tempObj);
            System.out.println("Coges " + tempObj.getLongDescription());
        }
        else
        {
            System.out.println("No encuentras ese objeto en la localizaci�n actual");
        }
    }

    /**
     * Intenta soltar un objeto al inventario del jugador. Si el objeto esta en el inventario del jugador
     * lo soltara, sino mostrara un mensaje.
     * @param El nombre del objeto que quiere a�adir
     */
    public void dropItem(String objeto)
    {
        // busca el objeto en el inventario
        Item tempObj = search(objeto);
        if(tempObj != null)
        {
            inventory.remove(tempObj);
            currentRoom.addItem(tempObj);
            System.out.println("Sueltas " + tempObj.getLongDescription());
        }
        else
        {
            System.out.println("No tienes ese objeto en tu inventario");
        }
    }

    /**
     * Busca un objeto en el inventario del jugador
     * @param nombre El nombre del objeto a buscar
     * @return El objeto si lo encuentra, sino devolvera null
     */
    private Item search(String nombre)
    {
        boolean find = false;
        int index = 0;
        Item objeto = null;
        // Busca el objeto en el inventario
        while((index < inventory.size()) & (!find))
        {
            if(nombre.equals(inventory.get(index).getNombreObj()))
            {
                objeto = inventory.get(index);
                find = true;
            }
            index++;
        }
        return objeto;
    }

    /**
     * Imprime la informaci�n de la localizaci�n en la que se encuentra el jugador
     */
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
    }
}
