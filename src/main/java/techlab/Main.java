package techlab;

import java.util.List;
import java.util.Scanner;
import techlab.consola.MenuControl;
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
    int opcionElegida = 0;
    String menuPrincipal = """
        
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
        ===============================================""";
    do {
      opcionElegida = MenuControl.seleccionadorDeOpciones(menuPrincipal, 1, 7);
      manejarOpcionValida(opcionElegida);
    } while(opcionElegida != 7);

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

  }

  private static void agregarProducto() {
    Scanner sc = new Scanner(System.in);
    int opcion = 0;
    do{
      Utils.mostrarTituloPersonalizadoPorConsola("AGREGAR PRODUCTO");
      System.out.print("Nombre: ");
      String nombre = sc.nextLine();
      System.out.print("Precio: ");
      double precio = Double.parseDouble(sc.nextLine());
      System.out.print("Cantidad: ");
      int cantidad = Integer.parseInt(sc.nextLine());

      Producto nuevoProducto = new Producto(nombre, precio, cantidad);
      inventario.agregarProducto(nuevoProducto);
      nuevoProducto.mostrarInfo2();
      System.out.println("Producto Agregado Exitosamente !!! \n");

      String subMenu = """
          ----------------
          1) Agregar mas productos
          2) Regresar al menu principal
          ----------------""";
      opcion = MenuControl.seleccionadorDeOpciones(subMenu, 1, 2);
    } while(opcion == 1);


  }

  private static void listarProductos() {
    Utils.mostrarTituloPersonalizadoPorConsola("LISTAR PRODUCTOS");
    List<Producto> productos = inventario.listarProductos();
    System.out.println("[COD] [Nombre]               [Precio] [Stock]");
    for (Producto producto : productos) {
      System.out.println(producto.toString());
    }
    String subMenu = """
          ----------------
          1) Regresar al menu principal
          ----------------""";
    MenuControl.seleccionadorDeOpciones(subMenu, 1, 1);
  }

  private static void buscarActualizarProducto() {
    Producto productoSeleccionado = interfazDeBuscarProducto();
    if(productoSeleccionado != null) {
      String subMenu = """
          -----------------------------
          1) Actualizar Producto
          2) Regresar Al Menu Principal
          -----------------------------""";
      int opcion = MenuControl.seleccionadorDeOpciones(subMenu, 1, 2);
      switch(opcion) {
        case 1:
          interfazActualizarProducto(productoSeleccionado);
          break;
        case 2:
          break;
        default:
          System.out.println("Opcion inesperada");
      }
    }
  }

  private static void eliminarProducto() {
    Utils.mostrarTituloPersonalizadoPorConsola("ELIMINAR PRODUCTO");

  }

  private static void crearPedido() {}
  private static void listarPedidos() {}

  private static void interfazActualizarProducto(Producto unProducto) {
    Scanner sc = new Scanner(System.in);
    System.out.println("-------------------");
    unProducto.mostrarInfo();
    String subMenu = """
        --------------------------
        1) Actualizar Precio
        2) Actualizar Stock
        3) Actualizar Precio y Stock
        """;
    int opcionElegida = MenuControl.seleccionadorDeOpciones(subMenu, 1, 3);
    boolean key = true;
    switch (opcionElegida) {
      case 1:
        do {
          try {
            System.out.print("Ingresar Nuevo Precio: ");
            double nuevoPrecio = Double.parseDouble(sc.nextLine());
            unProducto.setPrecio(nuevoPrecio);
            key = false;
          } catch (Exception e) {
            System.out.println("Precio No valido");
            System.out.println(e.getMessage());
          }
        } while(key);
        break;
      case 2:
        do {
          try {
            System.out.print("Ingresar Nuevo Stock: ");
            int nuevoStock = Integer.parseInt(sc.nextLine());
            unProducto.setStock(nuevoStock);
            key = false;
          } catch (Exception e) {
            System.out.println("Precio No valido");
            System.out.println(e.getMessage());
          }
        } while(key);
        break;
      case 3:
        do {
          try {
            System.out.print("Ingresar Nuevo Precio: ");
            double nuevoPrecio = Double.parseDouble(sc.nextLine());
            unProducto.setPrecio(nuevoPrecio);
            key = false;
          } catch (Exception e) {
            System.out.println("Precio No valido");
            System.out.println(e.getMessage());
          }
        } while(key);
        key = true;
        do {
          try {
            System.out.print("Ingresar Nuevo Stock: ");
            int nuevoStock = Integer.parseInt(sc.nextLine());
            unProducto.setStock(nuevoStock);
            key = false;
          } catch (Exception e) {
            System.out.println("Precio No valido");
            System.out.println(e.getMessage());
          }
        } while(key);
        break;
      default:
        System.out.println("Opcion inesperada");
    }
    unProducto.mostrarInfo2();
    System.out.println("Producto actualizado exitosamente !!!");
  }

  private static Producto interfazDeBuscarProducto() {
    Producto productoSeleccionado = null;
    String subMenu = """
        
        ---------------------------
        BUSCAR PRODUCTO
        1) Buscar por ID
        2) Buscar por Nombre
        ---------------------------""";
    int opcionEleccionada = MenuControl.seleccionadorDeOpciones(subMenu, 1, 2);
    switch (opcionEleccionada) {
      case 1:
        productoSeleccionado = interfazBuscarProductoPorID();
        break;
      case 2:
        productoSeleccionado = interfazBuscarProductoPorNombre();
        break;
      default:
        System.out.println("Opcion desconocida [DEFAULT]");
    }
    if(productoSeleccionado == null) {
      System.out.println("Prodcuto No Encontrado !!!");
    } else {
      System.out.printf("""
          
          ----------------------------
          Producto Seleccionado:
          [Cod: %d] [Stock: %d] %s
          ----------------------------
          """, productoSeleccionado.getId(), productoSeleccionado.getStock(), productoSeleccionado.getNombre());
    }
    return productoSeleccionado;
  }

  private static Producto interfazBuscarProductoPorID() {
    Producto productoSeleccionado = null;
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresar ID del Producto: ");
    int id = Integer.parseInt(sc.nextLine());
    productoSeleccionado = inventario.buscarProducto(id);
    return productoSeleccionado;
  }

  private static Producto interfazBuscarProductoPorNombre() {
    Producto productoSeleccionado = null;
    List<Producto> productosEncontrados;
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingresar Nombre del Producto: ");
    String nombre = sc.nextLine();
    productosEncontrados = inventario.buscarProductoPorNombre(nombre);

    if(productosEncontrados == null) {
      System.out.println("Algo salio mal al buscar producto por nombre");
    } else {
      int contador = 0;
      if(!productosEncontrados.isEmpty()) {
        System.out.println("-----------------------------------------------");
        System.out.println("   [COD] [Nombre]               [Precio] [Stock]");
        for(Producto producto : productosEncontrados) {
          contador += 1;
          System.out.printf("%d) %s\n", contador, producto.toString());
        }
        System.out.println("-----------------------------------------------");
        int opcionElegida = MenuControl.seleccionadorDeOpciones("", 1, productosEncontrados.size());
        productoSeleccionado = productosEncontrados.get(opcionElegida - 1);
      }
    }

    return productoSeleccionado;
  }
}
