package Practica4;

import java.util.Scanner;

public class Domotica {
    //Variables llums
    static boolean llumMenjador = false;
    static boolean llumCuina = false;
    static boolean Habitacio1 = false;
    static boolean Dormitori = false;
  public static void main(String[] args) {
     Scanner p4 = new Scanner(System.in);
     while (true) {
     System.out.println("1. Control de Llums");
     System.out.println("2. Aire condicionat");
     System.out.println("3. Cameres de seguretat");
     System.out.println("4. Aspersor de jardi");
     System.out.println("5. Sortir");
     System.out.print("Escull una opció: ");

     int opcio = p4.nextInt();

     if (opcio == 1) {
      controlLlums (p4);
     }
     else if (opcio == 2) {
      aireCondicionat (p4);
     }
     else if (opcio == 3) {
      cameres (p4);
     }
     else if (opcio == 4) {
      aspersors (p4);
     }
     else if (opcio == 6) {
      System.out.println("Sortint del sistema domotic");
      break;
     }
     else {
      System.out.println("Opció no valida.");
     }
     p4.close();
     }
     }
     //llums
     public static void controlLlums(Scanner p4) {
      System.out.println("Control llums.");
      System.out.println("1. Encendre una habitació");
      System.out.println("2. Apaga una habitació");
      System.out.println("3. Encendre totes les llums");
      System.out.println("4. Apaga totes les llums");
      System.out.println("5. Mostra l'estat actual");
      System.out.print("Escull una opció: ");
      int op = p4.nextInt();

      if (op == 1) {
        encendreHabitacio (p4);
      }
      else if (op == 2) {
        apagaHabitacio (p4);
      }
      else if (op == 3) {
        llumMenjador = llumCuina = Habitacio1 = Dormitori = true;
        System.out.println("Totes les llums s'han ences correctament");
      }
      else if (op == 4) {
        llumMenjador = llumCuina = Habitacio1 = Dormitori = false;
        System.out.println("Totes les llums s'han apagat correctament");
      }
      else if (op == 5) {
        mostrarEstatLlums();
      }
      else {
        System.out.println("Opcio no valida");
      }
     }

     /**
     * @param p4
     */
    public static void encendreHabitacio(Scanner p4) {
      System.out.println("Escull la habitació desitjada (1.Menjador, 2.Cuina, 3.Habitació 4.Dormitori): ");
      int h = p4.nextInt();

      if (h == 1 && !llumMenjador) {
        llumMenjador = true;
        System.out.println("S'ha ences la llum del menjador");
      }
      else if (h == 2 && !llumCuina) {
        llumCuina = true;
        System.out.println("S'ha ences la llum de la cuina");
      }
      else if (h == 3 && !Habitacio1) {
        Habitacio1 = true;
        System.out.println("S'ha ences la llum de la Habitació 1");
      }
      else if (h == 4 && !Dormitori) {
        Dormitori = true;
        System.out.println("S'ha ences la llum del Dormitori");
      }
      else {
        System.out.println("Aquesta llum ja esta encesa o l'opcio no valida");
      }
     }
}