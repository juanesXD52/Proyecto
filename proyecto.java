import java.util.ArrayList;
import java.util.Scanner;

public class proyecto {
    public static void main(String[] args) {
        // Herramientas para leer lo que escribes y una lista para anotar los nombres de los prodcutos
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        
        // Espacios para guardar la información del producto
        String producto = "";      // El nombre del producto
        int unidades = 0;          // Cuántos artículos hay guardados
        int precioPorUnidad = 0;   // Cuánto cuesta cada uno
        
        // Espacios para guardar los datos de la última venta hecha
        int cantidadVendida = 0;   // Cuántos se vendieron
        int totalVenta = 0;        // El dinero total que se cobró

        System.out.println("--- Sistema de Gestión de Inventario y Ventas ---");

        // Este ciclo hace que el menú aparezca una y otra vez hasta que elijas "Salir"
        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Ingresar nuevo producto");
            System.out.println("2. Realizar venta");
            System.out.println("3. Generar reporte de ventas");
            System.out.println("4. Generar reporte de stock");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = sc.nextInt();
            sc.nextLine(); // "Limpia" la memoria para que puedas escribir el nombre después

            // OPCIÓN 1: Registro del producto
            // Aquí es donde guardamos qué vendemos, cuánto tenemos y su precio
            if (opcion == 1){
                System.out.print("Ingrese nombre del producto: ");
                producto = sc.nextLine();
                lista.add(producto); // Se guarda el nombre del producto en la lista  
                
                System.out.print("Ingrese cantidad disponible: ");
                unidades = sc.nextInt(); // guardamos que cantidad tenemos 
                
                System.out.print("Ingrese precio por unidad: ");
                precioPorUnidad = sc.nextInt();
                sc.nextLine(); 
                
                System.out.println("Producto '" + producto + "' agregado exitosamente.");

            // OPCIÓN 2: Proceso para vender
            // El programa revisa si el producto existe y si hay suficientes para vender
            } else if (opcion == 2) {
                System.out.print("Ingrese nombre del producto a vender: ");
                String buscar = sc.nextLine();
                
                // Primero revisamos si el nombre que escribiste está en nuestra lista
                if (lista.contains(buscar)) {
                    System.out.print("Ingrese cantidad a vender: ");
                    int cantidadVenta = sc.nextInt();
                    sc.nextLine();
                    
                    // Solo vendemos si tenemos suficientes unidades en el estante
                    if (cantidadVenta <= unidades) {
                        totalVenta = cantidadVenta * precioPorUnidad; // Calculamos el precio total
                        unidades = unidades - cantidadVenta;         // Se restan los productos vendidos almacenados
                        cantidadVendida = cantidadVenta;            // Anotamos cuánto vendimos para el reporte
                        
                        System.out.println("Venta realizada. Total a pagar: " + totalVenta);
                    } else {
                        System.out.println("Error: No tienes suficientes productos."); //Si no se tiene suficiente cantidad del producto se muestra este mensaje
                    }
                } else {
                    System.out.println("Ese producto no está registrado.");
                }

            // OPCIÓN 3: Informe de ventas
            // Te muestra un resumen de la última venta que se hizo
            } else if (opcion == 3) {
                System.out.println("Reporte de Ventas:");
                // Si vendimos algo (más de 0), mostramos los datos
                if (cantidadVendida > 0) {
                    System.out.println("Producto vendido: " + producto + ", Cantidad: " + cantidadVendida + ", Total: " + totalVenta);
                } else {
                    System.out.println("Todavía no se ha vendido nada.");
                }

            // OPCIÓN 4: Informe de inventario en stock
            // Te dice cuántos productos te quedan en el stock actual
            } else if (opcion == 4) {
                System.out.println("Reporte de Stock:");
                if (lista.isEmpty()) {
                    System.out.println("No hay nada en el inventario.");
                } else {
                    // Muestra el nombre y la cantidad que quedó después de la venta
                    System.out.println("Producto: " + producto + ", Cantidad disponible: " + unidades);
                }

            // OPCIÓN 5: Salida
            // Despide al usuario y cierra el programa
            } else if (opcion == 5) {
                System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                break; // Detiene el programa por completo
            }
        }
    }
}