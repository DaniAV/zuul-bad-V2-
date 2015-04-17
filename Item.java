
/**
 * Esta clase representa los objetos que se pueden encontrar en el juego.
 * Todos los objetos estan definidos por una descripcion y un peso.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // El nombre del objeto;
    private String nombreObj;
    // Descripcion del objeto
    private String descripcionObj;
    // Peso del objeto
    private float peso;

    /**
     * Constructor de items. Crea un objeto item con una descripci�n y un peso dados.
     */
    public Item( String nombreObj, String desc, float peso)
    {
        this.nombreObj = nombreObj;
        this.descripcionObj = desc;
        this.peso = peso;
    }

    /**
     * Devuelve la descripci�n del objeto.
     * @return La descripci�n del objeto.
     */
    public String getDescripcionObj()
    {
        return descripcionObj;
    }

    /**
     * Devuelve el peso del objeto.
     * @return El peso del objeto.
     */
    public float getPeso()
    {
        return peso;
    }
    
    /**
     * Devuelve el nombre del objeto.
     * @return El nombre del objeto.
     */
    public String getNombreObj()
    {
        return nombreObj;
    }

    /**
     * Devuelve una descripci�n con toda la informaci�n del item.
     * @return La informaci�n del objeto.
     */
    public String getLongDescription()
    {
        String info = descripcionObj + " que pesa " + peso;
        return info;
    }

}
