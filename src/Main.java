import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        boolean salir = false;
        Scanner consola = new Scanner(System.in);

        List<Snack> productos = new ArrayList<>();
        System.out.println("Maquina de Snacks");
        Snacks.mostrarSnacks();// mostrar el inventario disponible

        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
            } catch (Exception e) {
                System.out.println("Ocurrio un error"+e.getMessage());
            }finally {
                System.out.println();
            }
        }

    }

    private static int mostrarMenu(Scanner consola){
        System.out.print(
                """
                    Menu
                    1. Comprar Snack
                    2. Mostrar ticket
                    3. Agregar nuevo snack 
                    4. salir
                    Elige una opción: \s 
                        """);

        return Integer.parseInt(consola.nextLine());
    }


    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack>productos){
        var salir = false;

        switch (opcion){
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa pronto");
                salir = true;
            }

        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos){
        System.out.println("Que snack quieres comprar? Selecciona el id: ");
        var idSnack = Integer.parseInt(consola.nextLine());
        var snackEncontrado = false;
        for(var snack: Snacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                productos.add(snack);
                System.out.println("Snack agregado: "+snack);
                snackEncontrado = true;
                break;
            }
        }

        if(!snackEncontrado){
            System.out.println("Id de snack no encontrado: "+idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "***** ticket de venta****";
        var total = 0.0;
        for(var producto: productos){
            ticket += "\n\t- "+producto.getNombreSnack()+" - $ "+ producto.getPrecioSnack();
            total += producto.getPrecioSnack();
        }

        ticket += "\n\tTotal: $"+total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola){
        System.out.println("Nombre del snack nuevo");
        var nombreNuevoSnack = consola.nextLine();
        System.out.println("Precio del snack ");
        var precioSnackNuevo = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombreNuevoSnack, precioSnackNuevo));

        System.out.println("Tu snack se ha agregado ");
        Snacks.mostrarSnacks();
    }
}
