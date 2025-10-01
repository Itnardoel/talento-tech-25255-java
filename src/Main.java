package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  ArrayList<String> articles = new ArrayList<>();

  static String[] menuItems =
      {"1. Crear artículo", "2. Modificar artículo", "3. Listar artículo por posición",
          "4. Listar todos los artículos", "5. Eliminar artículo", "6. Salir"};

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int option = 0;

    while (option != 6) {
      showMenu();

      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          System.err.println("crearArticulos");
          break;

        case 2:
          System.err.println("modificarArticulos");
          break;

        case 3:
          System.err.println("listarArticulos");
          break;

        case 4:
          System.err.println("listarTodos");
          break;

        case 5:
          System.err.println("eliminarArticulo");
          break;

        case 6:
          System.err.println("👋 ¡Gracias por usar el sistema!");
          scanner.close();
          break;

        default:
          System.out.println("❌ Opción inválida.");
      }
    }
  }

  public static void showMenu() {
    System.out.println("\n===== MENÚ DE ARTÍCULOS =====");
    for (String item : menuItems) {
      System.out.println(item);
    }
    System.out.print("Elija una opción: ");
  }
}
