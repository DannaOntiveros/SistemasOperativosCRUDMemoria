/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemasoperativos;

import java.util.InputMismatchException; //para lanzar excepciones cuanado no hay num enteros
import java.util.Scanner;

public class SistemasOperativos {

    static int tam, cont, opt;
    static int[] lista; // Cambié a int[] porque solo aceptará números enteros

    public SistemasOperativos(int tam) {
        this.tam = tam;
        lista = new int[tam];
        cont = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CONDICIÓNtamaño entero y positivo
        do {
            System.out.print("Digita el tamaño del arreglo entero y positivo: ");
            try {
                tam = sc.nextInt();
                if (tam <= 0) {
                    System.out.println("el tamaño debe ser mayor que 0."); // CONDICIÓN 
                }
            } catch (InputMismatchException e) {
                System.out.println("Digita un número entero."); // CONDICIÓN 
                sc.next(); // limpiar buffer
                tam = -1; 
            }
        } while (tam <= 0);

        SistemasOperativos so = new SistemasOperativos(tam);

        do {
            System.out.println("\n1- Agregar\n2- Eliminar\n3- Editar\n4- Mostrar\n5- Salir");
            System.out.print("Selecciona una opción: ");
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: opción inválida."); // CONDICIÓN AGREGADA
                sc.next();
                continue;
            }

            switch (opt) {
                case 1:
                    // CONDICIÓN : verificar si arreglo está lleno
                    if (cont >= tam) {
                        System.out.println("Error: el arreglo está lleno."); // CONDICIÓN 
                    } else {
                        System.out.print("Ingresa un número entero: ");
                        try {
                            int p = sc.nextInt();
                            agregar(p);
                        } catch (InputMismatchException e) {
                            System.out.println("solo números enteros."); // CONDICIÓN 
                            sc.next(); // limpiar buffer
                        }
                    }
                    break;
                case 2:
                    if (cont == 0) {
                        System.out.println("Error: el arreglo está vacío, no hay nada que eliminar."); // CONDICIÓN AGREGADA
                    } else {
                        System.out.println("Opciones eliminar:\n1- Primer dato\n2- Último dato\n3- Todo el arreglo");
                        System.out.print("Elige opción: ");
                        int delOpt = sc.nextInt();
                        switch (delOpt) {
                            case 1:
                                eliminarPrimero();
                                break;
                            case 2:
                                eliminarUltimo();
                                break;
                            case 3:
                                eliminarTodo();
                                break;
                            default:
                                System.out.println("opción de eliminar no valida"); // CONDICIÓN 
                        }
                    }
                    break;
                case 3:
                    if (cont == 0) {
                        System.out.println("arreglo vacío"); // CONDICIÓN 
                    } else {
                        System.out.print("Posición para editar (0 a " + (cont - 1) + "): ");
                        int pos = sc.nextInt();
                        // CONDICIÓN AGREGADA: verificar rango de posición
                        if (pos < 0 || pos >= cont) {
                            System.out.println("Error: posición no aceptada"); // CONDICIÓN 
                        } else {
                            System.out.print("Nuevo valor (entero): ");
                            try {
                                int p = sc.nextInt();
                                editar(pos, p);
                            } catch (InputMismatchException e) {
                                System.out.println("solo  números enteros."); // CONDICIÓN 
                                sc.next();
                            }
                        }
                    }
                    break;
                case 4:
                    if (cont == 0) {
                        System.out.println("El arreglo está vacío."); // CONDICIÓN a 
                    } else {
                        mostrar();
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Error: opción no válida."); // CONDICIÓN 
            }

        } while (opt != 5);

        sc.close();
    }

    public static void agregar(int p) {
        lista[cont] = p;
        System.out.println("Dato agregado: " + p + " en posición: " + cont);
        cont++;
    }

    public static void eliminarPrimero() {
        System.out.println("Dato eliminado: " + lista[0]);
        for (int i = 0; i < cont - 1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[cont - 1] = 0;
        cont--;
    }

    public static void eliminarUltimo() {
        System.out.println("Dato eliminado: " + lista[cont - 1]);
        lista[cont - 1] = 0;
        cont--;
    }

    public static void eliminarTodo() {
        for (int i = 0; i < cont; i++) {
            lista[i] = 0;
        }
        cont = 0;
        System.out.println("Todos los datos fueron eliminados.");
    }

    public static void editar(int pos, int p) {
        lista[pos] = p;
        System.out.println("Dato en posición " + pos + " modificado a: " + p);
    }

    public static void mostrar() {
        System.out.println("Contenido del arreglo:");
        for (int i = 0; i < cont; i++) {
            System.out.println(i + ": " + lista[i]);
        }
    }
}
