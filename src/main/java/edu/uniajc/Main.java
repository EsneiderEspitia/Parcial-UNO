package edu.uniajc;

import edu.uniajc.model.Libro;
import edu.uniajc.model.LibroTexto;
import edu.uniajc.model.LibroTextoUNIAC;
import edu.uniajc.model.Novela;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("   SISTEMA DE GESTION DE BIBLIOTECA   ");
        System.out.println("======================================\n");

        // 1. Crear libro1 utilizando el constructor con parámetros (Requisito parcial)
        Libro libro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 5, 2);

        // 2. Crear libro2 utilizando el constructor por defecto y obtener datos por
        // consola (Requisito parcial)
        Libro libro2 = new Libro();
        System.out.println(">>> REGISTRO INICIAL: Ingrese los datos de 'libro2' por consola <<<");
        System.out.print("Ingrese el título del libro: ");
        libro2.setTitulo(scanner.nextLine());

        System.out.print("Ingrese el autor del libro: ");
        libro2.setAutor(scanner.nextLine());

        int ejemplares = -1;
        while (ejemplares < 0) {
            System.out.print("Ingrese el total de ejemplares (mínimo 0): ");
            try {
                ejemplares = Integer.parseInt(scanner.nextLine().trim());
                if (ejemplares < 0) {
                    System.out.println("[!] El total de ejemplares no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Entrada inválida. Ingrese un número entero.");
            }
        }
        libro2.setNumeroEjemplares(ejemplares);

        int prestados = -1;
        while (prestados < 0 || prestados > ejemplares) {
            System.out.print("Ingrese el número de ejemplares prestados (0 a " + ejemplares + "): ");
            try {
                prestados = Integer.parseInt(scanner.nextLine().trim());
                if (prestados < 0) {
                    System.out.println("[!] Los ejemplares prestados no pueden ser negativos.");
                } else if (prestados > ejemplares) {
                    System.out.println("[!] Error: No puedes tener más ejemplares prestados (" + prestados
                            + ") que el total disponible (" + ejemplares + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Entrada inválida. Ingrese un número entero.");
            }
        }
        libro2.setNumeroEjemplaresPrestados(prestados);

        System.out.println("\n[OK] Libro 2 registrado correctamente: " + libro2 + "\n");

        // 3. Crear libroTextoUNIAC con todos sus atributos (Requisito parcial)
        LibroTextoUNIAC libroTextoUNIAC = new LibroTextoUNIAC(
                "Estructuras de Datos y Algoritmos",
                "Ing. Docente UNIAJC",
                10,
                3,
                "Programación II",
                "Facultad de Ingeniería");

        // 4. Crear novela indicando su tipo (Requisito parcial)
        Novela novela = new Novela(
                "El Resplandor",
                "Stephen King",
                4,
                3,
                "policíaca");

        // Lista de inventario de libros para interactuar
        List<Libro> inventario = new ArrayList<>();
        inventario.add(libro1);
        inventario.add(libro2);
        inventario.add(libroTextoUNIAC);
        inventario.add(novela);

        // Menú interactivo para el usuario
        boolean salir = false;
        while (!salir) {
            System.out.println("===============================================================");
            System.out.println("                      MENU PRINCIPAL");
            System.out.println("===============================================================");
            System.out.println("1. Ver inventario completo de libros");
            System.out.println("2. Realizar préstamo de un libro");
            System.out.println("3. Realizar devolución de un libro");
            System.out.println("4. Modificar datos de libro2");
            System.out.println("5. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();
            System.out.println();

            switch (opcion) {
                case "1":
                    mostrarInventario(inventario);
                    break;

                case "2":
                    mostrarInventario(inventario);
                    System.out.print("Seleccione el número del libro a prestar (1-" + inventario.size() + "): ");
                    int idxPrestamo = leerIndice(scanner, inventario.size());
                    if (idxPrestamo != -1) {
                        Libro libroSel = inventario.get(idxPrestamo);
                        System.out.println("Intentando prestar ejemplar de: \"" + libroSel.getTitulo() + "\"...");
                        boolean resultado = libroSel.prestamo();
                        if (resultado) {
                            System.out.println(">>> [ÉXITO] Préstamo realizado correctamente.");
                        } else {
                            System.out.println(
                                    ">>> [ERROR] No se pudo realizar el préstamo. No quedan ejemplares disponibles.");
                        }
                        System.out.println("Estado actual: " + libroSel);
                    }
                    break;

                case "3":
                    mostrarInventario(inventario);
                    System.out.print("Seleccione el número del libro a devolver (1-" + inventario.size() + "): ");
                    int idxDevolucion = leerIndice(scanner, inventario.size());
                    if (idxDevolucion != -1) {
                        Libro libroSel = inventario.get(idxDevolucion);
                        System.out.println("Intentando devolver ejemplar de: \"" + libroSel.getTitulo() + "\"...");
                        boolean resultado = libroSel.devolucion();
                        if (resultado) {
                            System.out.println(">>> [ÉXITO] Devolución realizada correctamente.");
                        } else {
                            System.out.println(
                                    ">>> [ERROR] No se pudo realizar la devolución. No hay ejemplares prestados registrados.");
                        }
                        System.out.println("Estado actual: " + libroSel);
                    }
                    break;

                case "4":
                    System.out.println(">>> MODIFICAR LIBRO 2 <<<");
                    System.out.print("Nuevo título (Enter para mantener '" + libro2.getTitulo() + "'): ");
                    String nuevoTitulo = scanner.nextLine();
                    if (!nuevoTitulo.trim().isEmpty()) {
                        libro2.setTitulo(nuevoTitulo);
                    }

                    System.out.print("Nuevo autor (Enter para mantener '" + libro2.getAutor() + "'): ");
                    String nuevoAutor = scanner.nextLine();
                    if (!nuevoAutor.trim().isEmpty()) {
                        libro2.setAutor(nuevoAutor);
                    }

                    System.out.print(
                            "Nuevo total ejemplares (Enter para mantener " + libro2.getNumeroEjemplares() + "): ");
                    String nuevoEj = scanner.nextLine().trim();
                    if (!nuevoEj.isEmpty()) {
                        try {
                            libro2.setNumeroEjemplares(Integer.parseInt(nuevoEj));
                        } catch (NumberFormatException e) {
                            System.out.println("Número no válido, se mantiene el anterior.");
                        }
                    }

                    System.out.print("Nuevo número prestados (Enter para mantener "
                            + libro2.getNumeroEjemplaresPrestados() + "): ");
                    String nuevoPrest = scanner.nextLine().trim();
                    if (!nuevoPrest.isEmpty()) {
                        try {
                            libro2.setNumeroEjemplaresPrestados(Integer.parseInt(nuevoPrest));
                        } catch (NumberFormatException e) {
                            System.out.println("Número no válido, se mantiene el anterior.");
                        }
                    }

                    System.out.println("\n[OK] Libro 2 actualizado: " + libro2);
                    break;

                case "5":
                    System.out.println("¡Gracias por utilizar el sistema de biblioteca! Saliendo...");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor seleccione una opción del 1 al 5.");
                    break;
            }
            System.out.println();
        }
    }

    private static void mostrarInventario(List<Libro> inventario) {
        System.out.println("----------------- INVENTARIO DE LIBROS -----------------");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i).toString());
        }
        System.out.println("--------------------------------------------------------");
    }

    private static int leerIndice(Scanner scanner, int total) {
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            if (opcion >= 1 && opcion <= total) {
                return opcion - 1;
            } else {
                System.out.println("Número fuera de rango. Debe ser entre 1 y " + total + ".");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero.");
            return -1;
        }
    }
}
