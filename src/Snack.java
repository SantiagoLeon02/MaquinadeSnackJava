import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {

    private static int contadorSnack = 0;
    private int IdSnack;
    private String nombreSnack;
    private double precioSnack;

    public Snack(){
        this.IdSnack = ++Snack.contadorSnack;
    }

    public Snack(String nombre, double precio){
        this();
        this.nombreSnack = nombre;
        this.precioSnack = precio;

    }

    public static int getContadorSnack(){
        return contadorSnack;
    }

    public int getIdSnack(){
        return this.IdSnack;
    }

    public String getNombreSnack(){
        return this.nombreSnack;
    }

    public double getPrecioSnack(){
        return this.precioSnack;
    }

    public void setNombreSnack(String nombreSnack) {
        this.nombreSnack = nombreSnack;
    }

    public void setPrecioSnack(double precioSnack) {
        this.precioSnack = precioSnack;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "IdSnack=" + IdSnack +
                ", nombreSnack='" + nombreSnack + '\'' +
                ", precioSnack=" + precioSnack +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return IdSnack == snack.IdSnack && Double.compare(precioSnack, snack.precioSnack) == 0 && Objects.equals(nombreSnack, snack.nombreSnack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdSnack, nombreSnack, precioSnack);
    }
}
