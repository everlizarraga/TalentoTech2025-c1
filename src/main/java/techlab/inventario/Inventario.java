package techlab.inventario;

import java.util.ArrayList;
import java.util.List;
import techlab.productos.Producto;

public abstract class Inventario {
  public abstract boolean agregarProducto(Producto unProducto);
  public abstract boolean eliminarProducto(int id);
  public abstract Producto buscarProducto(int id);
  public abstract List<Producto> buscarProductoPorNombre(String nombreProducto);
  public abstract boolean actualizarNombreProducto(int id, String nombreProducto);
  public abstract boolean actualizarCantidadProducto(int id, int nuevaCantidad);
  public abstract boolean existeProductoId(int id);
  public abstract void simularPrecargaDeProductosTest();
  public abstract List<Producto> listarProductos();
}
