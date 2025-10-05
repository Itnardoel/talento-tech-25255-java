package clase5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  // listas para almacenar articulos y categorias
  // son private porque no queremos que se acceda directamente desde fuera de la clase Main
  // son static porque no necesitamos instanciar la clase Main para usarlas
  private static ArrayList<Articulo> articulos = new ArrayList<>();
  private static ArrayList<Categoria> categorias = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);


  // metodo main: punto de entrada del programa
  public static void main(String[] args) {
    // categorias predefinidas
    // las agregamos a la lista de categorias

    categorias.add(new Categoria("Tecnología"));
    categorias.add(new Categoria("Hogar"));
    categorias.add(new Categoria("Libros"));


    int opcion;
    // menu principal, bucle do-while para mostrar el menu hasta que el usuario elija salir
    do {
      // method static que muestra el menu
      mostrarMenu();
      opcion = scanner.nextInt();
      scanner.nextLine();

      // switch para manejar las opciones del menu
      switch (opcion) {
        case 1 -> crearArticulo();
        case 2 -> listarArticulos();
        case 3 -> actualizarArticulo();
        case 4 -> eliminarArticulo();
        // Desafio pre entrega: crear la opcion 5 con un method buscarArticulo(String nombre), que
        // busque un articulo por nombre, si tenemos mas de un articulo con el mismo nombre, los
        // muestra todos y si no encuentra ninguno, muestra un mensaje
        // case 5 -> buscarArticulo();
        case 0 -> System.out.println("¡Hasta luego!");
        default -> System.out.println("Opción inválida");
      }
    } while (opcion != 0);
  }


  // method static que muestra el menu
  private static void mostrarMenu() {
    System.out.println("\n=== CRUD de Artículos ===");
    System.out.println("1) Crear artículo");
    System.out.println("2) Listar artículos");
    System.out.println("3) Actualizar artículo");
    System.out.println("4) Eliminar artículo");
    System.out.println("0) Salir");
    System.out.print("Opción: ");
  }

  // method static que crea un articulo
  private static void crearArticulo() {
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Precio: ");
    double precio = scanner.nextDouble();
    scanner.nextLine();

    System.out.println("Categorías disponibles:");
    // mostramos las categorias disponibles al usuario para que pueda elegir una
    for (Categoria c : categorias) {
      System.out.println(c.getId() + ") " + c.getNombre());
    }
    System.out.print("Elegí id de categoría: ");
    int idCat = scanner.nextInt();
    scanner.nextLine();

    Categoria seleccionada = null;
    // buscamos la categoria seleccionada por el usuario en la lista de categorias
    for (Categoria c : categorias) {
      if (c.getId() == idCat) {
        seleccionada = c;
        break;
      }
    }

    // si la categoria no existe, mostramos un mensaje de error y salimos del metodo

    if (seleccionada == null) {
      System.out.println("Categoría inválida.");
      return;
    }
    Articulo a = new Articulo(nombre, precio, seleccionada);
    articulos.add(a);
    System.out.println("Artículo creado: " + a);

  }

  // method static que lista los articulos
  private static void listarArticulos() {
    System.out.println("\n-- Listado --");
    // si la lista de articulos esta vacia, mostramos un mensaje
    if (articulos.isEmpty()) {
      System.out.println("(sin artículos)");
      return;

    }
    // recorremos la lista de articulos y mostramos cada uno
    for (Articulo a : articulos) {
      System.out.println(a);
    }

  }

  // method static que actualiza un articulo
  private static void actualizarArticulo() {
    System.out.print("Id del artículo: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    // buscamos el articulo por id
    // si lo encontramos, pedimos los nuevos datos y los actualizamos
    // si no lo encontramos, mostramos un mensaje de error
    // recorremos la lista de articulos y buscamos el que tiene el id indicado
    for (Articulo a : articulos) {
      if (a.getId() == id) {
        System.out.print("Nuevo nombre: ");
        a.setNombre(scanner.nextLine());
        System.out.print("Nuevo precio: ");
        a.setPrecio(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Actualizado: " + a);
        return;
      }
    }
    System.out.println("No existe el artículo con id " + id);
  }

  // method static que elimina un articulo
  private static void eliminarArticulo() {
    System.out.print("Id del artículo a eliminar: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    // removeIf elimina todos los elementos que cumplen la condicion dada por el predicado
    // en este caso, elimina el articulo cuyo id coincide con el id dado
    // si no existe, no hace nada
    // predicado: a -> a.getId() == id
    // a es cada articulo de la lista
    // a.getId() == id es la condicion que debe cumplir para ser eliminado
    // no es una baja logica, es una baja fisica
    // si queremos hacer una baja logica, podemos agregar un atributo boolean activo a la clase
    // Articulo
    // y en vez de eliminar el articulo, ponemos activo = false
    // y en el metodo listarArticulos, mostramos solo los articulos activos
    articulos.removeIf(a -> a.getId() == id);
    System.out.println("Artículo eliminado (si existía).");
  }
}
