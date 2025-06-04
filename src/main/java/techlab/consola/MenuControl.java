package techlab.consola;

import java.util.Scanner;

public class MenuControl {
  public static int seleccionadorDeOpciones(String menu, int valorMin, int valorMax) {
    Scanner sc = new Scanner(System.in);
    int seleccion = 0;
    boolean key = false;
    System.out.println(menu);
    do{
      System.out.print(">> Ingesar Opcion: ");
      try {
        seleccion = Integer.parseInt(sc.nextLine());
        if(seleccion >= valorMin && seleccion <= valorMax) {
          key = true;
        } else {
          key = false;
          System.out.println("Opción inválida. Reintente ...");
        }
      } catch (NumberFormatException e) {
        key = false;
        System.out.println("Opción no reconocida. Reintente ...");
      }
    }while(!key);
    return seleccion;
  }
}
