package techlab.pedidos;

import java.util.ArrayList;
import java.util.List;
import techlab.productos.Producto;

public class Pedido {
  private static int contadorID = 1;
  private final int ID;
  private final List<ItemPedido> listaDeItems;

  public Pedido() {
    this.listaDeItems = new ArrayList<>();
    this.ID = contadorID;
    contadorID += 1;
  }

  public void agregarProductoAlPedido(Producto producto, int cantidad) {
    ItemPedido nuevoItem = new ItemPedido(producto, cantidad);
    this.listaDeItems.add(nuevoItem);
  }

  public double calcularCostoTotal() {
    return 2.3;
  }
//"[%03d] %-20s [%d]"
  public void mostrarPedido() {
    System.out.printf("""
        =====================================
        Pedido ID: %s
        -------------------------------------
        """, this.ID);
    for (ItemPedido item : listaDeItems) {
      System.out.println(item.toString());
    }
    System.out.println("""
        -------------------------------------
        """);
  }
}
