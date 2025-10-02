package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<String> articles = new ArrayList<>();

  static String[] menuItems = {"Crear artículo", "Modificar artículo",
      "Listar artículo por posición", "Listar todos los artículos", "Eliminar artículo", "Salir"};

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int option = 0;

    while (option != 6) {
      showMenu();

      if (!isNextInputInt()) {
        continue;
      }

      option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {
        case 1:
          addArticle();
          break;

        case 2:
          updateArticle();
          break;

        case 3:
          getArticle();
          break;

        case 4:
          getAllArticles();
          break;

        case 5:
          removeArticle();
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

  static void showMenu() {
    System.out.println("\n===== MENÚ DE ARTÍCULOS =====");

    for (int i = 0; i < menuItems.length; i++) {
      System.out.println((i + 1) + ". " + menuItems[i]);
    }

    System.out.print("Elija una opción: ");
  }

  static void addArticle() {
    System.out.print("Ingrese el nombre del artículo: ");

    String newArticle = scanner.nextLine();

    if (newArticle.trim().isEmpty()) {
      System.out.println("❌ El nombre no puede estar vacío.");
      return;
    }

    articles.add(newArticle);
    System.out.println("✅ Artículo agregado correctamente.");
  }

  static void updateArticle() {
    if (isListEmpty()) {
      return;
    }

    while (true) {
      System.out.print("Ingrese la posición a modificar (0 a " + (articles.size() - 1) + "): ");

      if (!isNextInputInt()) {
        continue;
      }

      int position = scanner.nextInt();
      scanner.nextLine();

      if (position < 0 || position >= articles.size()) {
        System.out.println("❌ Posición inválida.");
        continue;
      }

      System.out.print("Ingrese el nuevo nombre: ");
      String updatedArticle = scanner.nextLine();

      if (updatedArticle.trim().isEmpty()) {
        System.out.println("❌ El nombre no puede estar vacío.");
        continue;
      }

      articles.set(position, updatedArticle);
      System.out.println("✅ Artículo modificado correctamente.");
      break;
    }
  }

  static void getArticle() {
    if (isListEmpty()) {
      return;
    }

    while (true) {
      System.out.print("Ingrese la posición a consultar (0 a " + (articles.size() - 1) + "): ");

      if (!isNextInputInt()) {
        continue;
      }

      int position = scanner.nextInt();
      scanner.nextLine();

      if (position < 0 || position >= articles.size()) {
        System.out.println("❌ Posición inválida.");
        continue;
      }

      System.out.println("📦 Artículo en posición " + position + ": " + articles.get(position));
      break;
    }
  }

  static void getAllArticles() {
    if (isListEmpty()) {
      return;
    }

    System.out.println("===== LISTADO DE ARTÍCULOS =====");

    for (int i = 0; i < articles.size(); i++) {
      System.out.println("Posición " + i + ": " + articles.get(i));
    }
  }

  static void removeArticle() {
    if (isListEmpty()) {
      return;
    }

    getAllArticles();

    while (true) {
      System.out.print(
          "Ingrese la posición del artículo a eliminar (0 a " + (articles.size() - 1) + "): ");

      if (!isNextInputInt()) {
        continue;
      }

      int position = scanner.nextInt();
      scanner.nextLine();

      if (position < 0 || position >= articles.size()) {
        System.out.println("❌ Posición inválida.");
        continue;
      }

      articles.remove(position);
      System.out.println("✅ Artículo eliminado.");
      break;
    }
  }

  static boolean isNextInputInt() {
    if (!scanner.hasNextInt()) {
      System.out.println("❌ Entrada inválida. Por favor, ingresa un número.");
      scanner.nextLine();
      return false;
    }

    return true;
  }

  static boolean isListEmpty() {
    if (articles.isEmpty()) {
      System.out.println("❌ No hay artículos cargados.");
      return true;
    }

    return false;
  }
}
