package techlab.pedidos;

import techlab.productos.Producto;

public class ItemPedido {
  private Producto producto;
  private int cantidad;

  public ItemPedido(Producto producto, int cantidad) {
    this.producto = producto;
    this.cantidad = cantidad;
  }

  public void mostrarInfo() {
    //System.out.println("CANT  | [ProdID] PRODUCTO");
    System.out.printf("""
                CANT: %s
                PorodID: %s
                Producto: %s
                """, this.getCantidad(), this.getId(), this.getNombre());
  }

  @Override
  public String toString() {
    return String.format("[%03d] %-20s [%d] %.2f  $%.2f",
        this.getId(),
        this.getNombre(),
        this.getCantidad(),
        this.getPrecio(),
        this.getCantidad()*this.getPrecio());
  }

  public int getId() {
    return this.producto.getId();
  }

  public String getNombre() {
    return this.producto.getNombre();
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecio() {
    return (double)this.getCantidad()*this.producto.getPrecio();
  }

  public Producto getProducto() {
    return this.producto;
  }
}
