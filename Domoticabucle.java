package Practica4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Domoticabucle {
    //Variables llums
    static boolean llumMenjador = false;
    static boolean llumCuina = false;
    static boolean Habitacio1 = false;
    static boolean Dormitori = false;
    //Variables aire
    static boolean aire = false;
    //Variable cameres
    static boolean cameres = false;
    //variable aspersors
    static boolean aspersors = false;
  public static void main(String[] args) {
    boolean sortir = false;
    while (!sortir) { 
    Scanner p4 = new Scanner(System.in);
     System.out.println("1. Control de Llums");
     System.out.println("2. Aire condicionat");
     System.out.println("3. Cameres de seguretat");
     System.out.println("4. Aspersor de jardi");
     System.out.println("5. Sortir");
     System.out.print("Escull una opció: ");
      try {
        int opcio = p4.nextInt();
     switch (opcio) {
      
     case 1 -> controlLlums (p4);
     case 2 -> aireCondicionat(p4);
     case 3 -> cameres (p4);
     case 4 -> aspersors(p4);
     case 5 -> {
      System.out.println("Sortint del sistema domotic");
      sortir = true;
     }
     default -> System.out.println("Opció no valida.");
    }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
      }
     }
     }
     //llums
     public static void controlLlums(Scanner p4) {
        boolean sortir = false;
        while (!sortir) {
      System.out.println("Control llums.");
      System.out.println("1. Encendre una habitació");
      System.out.println("2. Apaga una habitació");
      System.out.println("3. Encendre totes les llums");
      System.out.println("4. Apaga totes les llums");
      System.out.println("5. Mostra l'estat actual");
      System.out.println("6. Tornar al Menú principal");
      System.out.print("Escull una opció: ");
      try {
      int op = p4.nextInt();

      switch (op) {
        case 1 -> encendreHabitacio (p4);
        case 2 -> apagaHabitacio(p4);
        case 3 -> {
        llumMenjador = llumCuina = Habitacio1 = Dormitori = true;
        System.out.println("Totes les llums s'han ences correctament");
      }
        case 4 -> {
        llumMenjador = llumCuina = Habitacio1 = Dormitori = false;
        System.out.println("Totes les llums s'han apagat correctament");
      }
        case 5 -> mostrarEstatLlums(p4);
        case 6 -> sortir = true;
        default -> System.out.println("Opcio no valida");
      }
      
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
      }
    }
     }
    
      public static void encendreHabitacio(Scanner p4) {
        boolean sortir = false;
        while (!sortir) {
      System.out.println("Escull la habitació desitjada (1.Menjador, 2.Cuina, 3.Habitació 4.Dormitori 5.Menú principal): ");
      try {
      int h = p4.nextInt();
      
      switch (h) {
        case 1 -> canviaLlum("Menjador", true);
        case 2 -> canviaLlum("Cuina", true);
        case 3 -> canviaLlum("Habitacio1", true);
        case 4 -> canviaLlum("Dormitori", true);
        case 5 -> sortir = true;
        default -> System.out.println("Aquesta llum ja esta encesa o l'opcio no valida");
      }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
    }
  }
  }
  public static void canviaLlum(String nom, boolean encendre) {
        boolean estatAnterior = false;
        switch (nom) {
            case "Menjador" -> {
                estatAnterior = llumMenjador;
                llumMenjador = encendre;
            }
            case "Cuina" -> {
                estatAnterior = llumCuina;
                llumCuina = encendre;
            }
            case "Habitacio1" -> {
                estatAnterior = Habitacio1;
                Habitacio1 = encendre;
            }
            case "Dormitori" -> {
                estatAnterior = Dormitori;
                Dormitori = encendre;
            }
        }

        if (encendre && !estatAnterior)
            System.out.println("S'ha encès la llum del " + nom + ".");
        else if (!encendre && estatAnterior)
            System.out.println("S'ha apagat la llum del " + nom + ".");
        else
            System.out.println("La llum del " + nom + " ja estava " + (encendre ? "encesa." : "apagada."));
    }

     public static void apagaHabitacio(Scanner p4) {
        boolean sortir = false;
        while (!sortir) {
      System.out.println("Escull la habitació desitjada (1.Menjador, 2.Cuina, 3.Habitació 4.Dormitori 5.Menú principal): ");
      try {
      int h = p4.nextInt();

      switch (h) {
        case 1 -> canviaLlum("Menjador", false);
        case 2 -> canviaLlum("Cuina", false);
        case 3 -> canviaLlum("Habitacio1", false);
        case 4 -> canviaLlum("Dormitori", false);
        case 5 -> sortir = true;
        default -> System.out.println("LLum ja apagada o l'opcio no es valida");
      }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
     }
    }
    }

     public static void mostrarEstatLlums(Scanner p4) {
      System.out.println("Estat de les llums");
      System.out.println("Menjador: " + (llumMenjador ? "ences" : "apagat"));
      System.out.println("Cuina: " + (llumCuina ? "encesa" : "apagada"));
      System.out.println("Habitacio1: " + (Habitacio1 ? "encesa" : "apagada"));
      System.out.println("Dormitori: " + (Dormitori ? "ences" : "apagat"));
     }
     public static void aireCondicionat(Scanner p4) {
      while (true) {
      System.out.println("Aire Condicionat");
      System.out.println("1. Encendre aire condicionat");
      System.out.println("2. Apagar aire condicionat");
      System.out.println("3. Estat actual del aire");
      System.out.println("4. Menú Principal");
      System.out.println("Escull una opció: ");
      try {
      int op = p4.nextInt();

      if (op == 1 && !aire) {
        aire = true;
        System.out.println("L'aire s'ha encés");
      }
      else if (op == 2 && aire) {
        aire = false;
        System.out.println("L'aire s'ha apagat");
      }
      else if (op == 3) {
        mostrarEstatAire(p4);
      }
      else if (op == 4) {
        return;
      }
      else {
        System.out.println("L'aire ja esta encés o apagat o l'Opció no es valida");
      }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
    }
  }
     }
 public static void mostrarEstatAire(Scanner p4) {
      System.out.println("Estat de l'aire");
      System.out.println("Aire: " + (aire ? "ences" : "apagat"));
 }
     public static void cameres(Scanner p4) {
      while (true) {
      System.out.println("Control de cameres");
      System.out.println("1. Activar cameres");
      System.out.println("2. Apagar cameres");
      System.out.println("3. Mostrar estat Cameres");
      System.out.println("4. Menú Principal");
      System.out.println("Escull una opció");
      try {
      int op = p4.nextInt();

      if (op == 1 && !cameres) {
        cameres = true;
        System.out.println("Les cameres de seguretat s'han activat");
      }
      else if (op == 2 && cameres) {
        cameres = false;
        System.out.println("Les cameres de seguretat s'han desactivat");
      }
      else if (op == 3) {
        mostrarEstatCameres(p4);
      }
      else if (op == 4) {
        return;
      }
      else {
        System.out.println("Les cameres ja estan activades o desactivades o l'Opcio no valida");
      }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
    }
  }
     }
      public static void mostrarEstatCameres(Scanner p4) {
      System.out.println("Estat de les cameres");
      System.out.println("Cameres: " + (cameres ? "ences" : "apagat"));
      }
     public static void aspersors(Scanner p4) {
      while (true) {
      System.out.println("Aspersors del jardi");
      System.out.println("1. Activar aspersors");
      System.out.println("2. Desactivar aspersors");
      System .out.println("3. Mostrar estat dels aspersors");
      System.out.println("4. Menú Principal");
      System.out.println("Escull una opció: ");
      try {
      int op = p4.nextInt();

      if (op == 1 && !aspersors) {
        aspersors = true;
        System.out.println("Els aspersors s'han activat");
      }
      else if (op == 2 && aspersors) {
        aspersors = false;
        System.out.println("Els aspersors s'han desactivat");
      }
      else if (op == 3) {
        mostrarEstatAspersors(p4);
      }
      else if (op == 4) {
        return;
      }
      else {
        System.out.println("Els aspersors estan ences o apagats o l'Opció no valida");
      }
     } catch (InputMismatchException e) {
        System.out.println("Error Format no valid utilitza numero valid");
        p4.nextLine();
    }
  }
     }
     public static void mostrarEstatAspersors(Scanner p4) {
      System.out.println("Estat dels aspersors");
      System.out.println("Aspersors: " + (aspersors ? "ences" : "apagat"));
}
}