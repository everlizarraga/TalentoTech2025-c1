package techlab.productos;

import techlab.excepciones.CantidadInvalidaException;
import techlab.excepciones.NombreVacioException;

public class Producto {
  private static int contadorID = 1;
  private final int id;
  private String nombre;
  private double precio;
  private int stock;

  public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
    this.id = contadorID;
    contadorID += 1;
  }

  public void mostrarInfo(){
    System.out.printf("""
                Id: %s
                Nombre: %s
                Precio: %s
                Stock: %s
                """, this.id, this.nombre, this.precio, this.stock);
  }

  @Override
  public String toString() {
    return String.format("[%03d] %-20s   [%.2f] [%d]", this.id, this.nombre, this.precio, this.stock);
  }

  public void mostrarInfo2() {
    System.out.println("[COD] [Nombre]               [Precio] [Stock]");
    System.out.println(this.toString());
  }

  // GETTERS y SETTERS
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) throws NombreVacioException {
    if(nombre.equals("")) {
      throw new NombreVacioException("Nombre Vacio");
    }
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) throws CantidadInvalidaException {
    if(precio <= 0) {
      throw new CantidadInvalidaException("El Precio debe ser positivo");
    }
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) throws CantidadInvalidaException{
    if(stock < 0) {
      throw new CantidadInvalidaException("Se requiero un valor entero positivo");
    }
    this.stock = stock;
  }
}
