package techlab;

import java.util.List;
import java.util.Scanner;
import techlab.inventario.Inventario;
import techlab.inventario.InventarioPreEntrega;
import techlab.pedidos.ItemPedido;
import techlab.productos.Producto;
import techlab.utils.Utils;

public class Main {
  private static Inventario inventario = new InventarioPreEntrega();
  public static void main(String[] args) {
    inventario.simularPrecargaDeProductosTest();
    Scanner sc = new Scanner(System.in);
    mostrarMenuPrincipal();
    int opcionElegida = 0;
    //System.out.println("Opcion Elegida: " + opcionElegida);
    do {
      try {
        opcionElegida = Integer.parseInt(sc.nextLine());
        if(opcionElegida >= 1 && opcionElegida < 7) {
          manejarOpcionValida(opcionElegida);
        } else if(opcionElegida != 7){
          System.out.print("Elegir una opcion valida: ");
        }

      } catch (NumberFormatException e) {
        System.out.println("ERROR al ingresar opcion: " + e.getMessage());
        System.out.print("Elegir una opcion valida: ");
      }
    }while(opcionElegida != 7);
    System.out.println("\nSaliendo del Menu !!!");
  }

  private static void manejarOpcionValida(int opcion) {
    switch (opcion) {
      case 1:
        agregarProducto();
        break;
      case 2:
        listarProductos();
        break;
      case 3:
        buscarActualizarProducto();
        break;
      case 4:
        eliminarProducto();
        break;
      case 5:
        crearPedido();
        break;
      case 6:
        listarPedidos();
        break;
      default:
        System.out.println("Opcion desconocida");
    }
    mostrarMenuPrincipal();
  }

  private static void agregarProducto() {
    Scanner sc = new Scanner(System.in);
    Utils.mostrarTituloPersonalizadoPorConsola("AGREGAR PRODUCTO");
    System.out.print("Nombre: ");
    String nombre = sc.nextLine();
    System.out.print("Precio: ");
    double precio = Double.parseDouble(sc.nextLine());
    System.out.print("Cantidad: ");
    int cantidad = Integer.parseInt(sc.nextLine());

    Producto nuevoProducto = new Producto(nombre, precio, cantidad);
    inventario.agregarProducto(nuevoProducto);
    //System.out.printf("Producto Agregado Exitosamente: \n%s\n", nuevoProducto.toString());
    nuevoProducto.mostrarInfo2();
    System.out.println("Producto Agregado Exitosamente !!! \n");

  }

  private static void listarProductos() {
    Utils.mostrarTituloPersonalizadoPorConsola("LISTAR PRODUCTOS");
    List<Producto> productos = inventario.listarProductos();
    System.out.println("[COD] [Nombre]               [Precio] [Stock]");
    for (Producto producto : productos) {
      System.out.println(producto.toString());
    }
  }

  private static void buscarActualizarProducto() {

  }

  private static void eliminarProducto() {
    Utils.mostrarTituloPersonalizadoPorConsola("ELIMINAR PRODUCTO");

  }

  private static void crearPedido() {}
  private static void listarPedidos() {}


  private static void mostrarMenuPrincipal() {
    System.out.println("""
        ===============================================
        SISTEMA DE GESTIÓN - TECHLAB - PREENTREGA
        ===============================================
        1) Agregar Producto
        2) Listar productos
        3) Buscar / Actualizar producto
        4) Eliminar producto
        5) Crear pedido
        6) Listar Pedidos
        7) Salir
        ===============================================""");
    System.out.print("Elija una opción: ");
  }

}
