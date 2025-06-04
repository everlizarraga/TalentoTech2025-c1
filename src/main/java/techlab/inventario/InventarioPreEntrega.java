package techlab.inventario;

import java.util.ArrayList;
import java.util.List;
import techlab.excepciones.ProductoNoEncontradoException;
import techlab.productos.Producto;

public class InventarioPreEntrega extends Inventario{

  private final List<Producto> listaProductos;

  public InventarioPreEntrega() {
    listaProductos = new ArrayList<>();
  }

  @Override
  public boolean agregarProducto(Producto unProducto) {
    try {
      if(unProducto != null) {
        this.listaProductos.add(unProducto);
        return true;
      } else {
        throw new RuntimeException("Producto NULL");
      }
    } catch (RuntimeException e) {
      System.out.println("ERROR al agregar un producto: " + e.getMessage());
      return false;
    }
  }

  @Override
  public boolean eliminarProducto(int id) {
    try {
      Producto productoObjetivo = this.buscarProducto(id);
      if(productoObjetivo != null) {
        return this.listaProductos.remove(productoObjetivo);
      } else {
        throw new ProductoNoEncontradoException("Prod id:" + id + " No encontrado");
      }
    } catch (ProductoNoEncontradoException e) {
      System.out.println("ERROR al intentar eliminar: " + e.getMessage());
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean actualizarCantidadProducto(int id, int nuevaCantidad) {
    try {
      Producto productoObjetivo = this.buscarProducto(id);
      if(productoObjetivo != null) {
        productoObjetivo.setStock(nuevaCantidad);
        return true;
      } else {
        throw new ProductoNoEncontradoException("Prod id:" + id + " No encontrado");
      }
    } catch (Exception e) {
      System.out.println("ERROR al actualizar cantidad del producto: " + e.getMessage());
      return false;
    }
  }

  @Override
  public boolean actualizarNombreProducto(int id, String nombreProducto) {
    try {
      Producto productoObjetivo = this.buscarProducto(id);
      if(productoObjetivo != null) {
        productoObjetivo.setNombre(nombreProducto);
        return true;
      } else {
        throw new ProductoNoEncontradoException("Prod id:" + id + " No encontrado");
      }
    } catch (Exception e) {
      System.out.println("ERROR al actualizar nombre del producto: " + e.getMessage());
      return false;
    }
  }

  @Override
  public boolean existeProductoId(int id) {
    return this.buscarProducto(id) != null;
  }

  @Override
  public Producto buscarProducto(int id) {
    for (Producto producto : listaProductos) {
      if (producto.getId() == id) {
        return producto;
      }
    }
    return null;
  }

  @Override
  public List<Producto> buscarProductoPorNombre(String nombreProducto) {
    if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
      return null;
    }
    List<Producto> productosSeleccionados = new ArrayList<>();
    for (Producto producto : listaProductos) {
      if (producto.getNombre().toLowerCase().contains(nombreProducto.toLowerCase().trim())) {
        productosSeleccionados.add(producto);
      }
    }
    return productosSeleccionados;
  }

  @Override
  public List<Producto> listarProductos() {
    return this.listaProductos;
  }

  public void simularPrecargaDeProductosTest() {
    this.agregarProducto(new Producto("Micrófono gamer", 2000, 10));
    this.agregarProducto(new Producto("Monitor gamer", 1000, 10));
    this.agregarProducto(new Producto("Teclado mecánico", 1500, 15));
    this.agregarProducto(new Producto("Mouse gamer", 1200, 20));
    /*
    this.agregarProducto(new Producto("Laptop", 15000, 5));
    this.agregarProducto(new Producto("Tablet", 8000, 7));
    this.agregarProducto(new Producto("Disco duro externo", 2500, 12));
    this.agregarProducto(new Producto("Memoria USB 64GB", 500, 25));
    this.agregarProducto(new Producto("Router Wi-Fi", 1800, 10));
    this.agregarProducto(new Producto("Smartphone", 12000, 8));
    this.agregarProducto(new Producto("Audífonos Bluetooth", 2200, 18));
    this.agregarProducto(new Producto("Cámara Web HD", 1300, 10));
    this.agregarProducto(new Producto("Impresora", 4000, 6));
    this.agregarProducto(new Producto("Proyector", 9000, 4));
    this.agregarProducto(new Producto("Reproductor multimedia", 3000, 9));
    this.agregarProducto(new Producto("Smartwatch", 3500, 11));
    this.agregarProducto(new Producto("Lector de tarjetas", 800, 14));
    this.agregarProducto(new Producto("Estabilizador de voltaje", 1100, 10));
    this.agregarProducto(new Producto("Cable HDMI", 300, 30));
    this.agregarProducto(new Producto("Panel táctil USB", 2000, 5));

     */
  }
}
