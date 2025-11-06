package Practica4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;

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
    // Metodes automatics
    static boolean modeAutoAspersors = true;
    static boolean modeAutoCameres = true;

  public static void main(String[] args) {
    boolean sortir = false;
    iniciarSistemaAutomatic();
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
     private static void iniciarSistemaAutomatic() {
        Thread sistema = new Thread(() -> {
            while (true) {
                LocalTime hora = LocalTime.now();

                // Aspersors a les 7:00
                if (hora.getHour() == 7 && hora.getMinute() == 0 && !aspersors) {
                    aspersors = true;
                    System.out.println("Els aspersors s'han activat automàticament (07:00)");
                }

                // Apagar aspersors a les 7:10
                if (hora.getHour() == 7 && hora.getMinute() == 10 && aspersors) {
                    aspersors = false;
                    System.out.println("Els aspersors s'han desactivat automàticament (07:10)");
                }

                // Activar càmeres a les 22:00
                if (hora.getHour() == 22 && hora.getMinute() == 0 && !cameres) {
                    cameres = true;
                    System.out.println("Les càmeres de seguretat s'han activat automàticament (22:00)");
                }

                // Apagar càmeres a les 6:00
                if (hora.getHour() == 6 && hora.getMinute() == 0 && cameres) {
                    cameres = false;
                    System.out.println("Les càmeres de seguretat s'han desactivat automàticament (06:00)");
                }

                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sistema.setDaemon(true);
        sistema.start();
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

if (encendre && !estatAnterior) {
    System.out.println("S'ha encès la llum del " + nom + ".");
} else if (!encendre && estatAnterior) {
    System.out.println("S'ha apagat la llum del " + nom + ".");
} else {
    if (encendre) {
        System.out.println("La llum del " + nom + " ja estava encesa.");
    } else {
        System.out.println("La llum del " + nom + " ja estava apagada.");
        }
    }
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
    if (llumMenjador) {
    System.out.println("Menjador: ences");
    } else {
    System.out.println("Menjador: apagat");
    }
    if (llumCuina) {
    System.out.println("Cuina: encesa");
    } else {
    System.out.println("Cuina: apagada");
    }
    if (Habitacio1) {
    System.out.println("Habitació1: encesa");
    } else {
    System.out.println("Habitació1: apagada");
    }
    if (Dormitori) {
    System.out.println("Dormitori: ences");
    } else {
    System.out.println("Dormitori: apagat");
    }
}

     public static void aireCondicionat(Scanner p4) {
      while (true) {
        System.out.println("\n--- Aire Condicionat ---");
        System.out.println("1. Encendre");
        System.out.println("2. Apagar");
        System.out.println("3. Estat actual");
        System.out.println("4. Tornar");
        System.out.print("Escull una opció: ");
            try {
            int op = p4.nextInt();
            switch (op) {
                case 1 -> { if (!aire) { aire = true; System.out.println("Aire encès."); } else System.out.println("Ja està encès."); }
                case 2 -> { if (aire) { aire = false; System.out.println("Aire apagat."); } else System.out.println("Ja està apagat."); }
                case 3 -> System.out.println("Estat: " + (aire ? "Encès" : "Apagat"));
                case 4 -> { return; }
                default -> System.out.println("Opció no vàlida.");
            }
        } catch (InputMismatchException e) {
        System.out.println("Format incorrecte.");
        p4.nextLine();
        }
    }
    }
     public static void cameres(Scanner p4) {
      while (true) {
        System.out.println("\n--- Càmeres de Seguretat ---");
        System.out.println("1. Activar càmeres");
        System.out.println("2. Desactivar càmeres");
        System.out.println("3. Mostrar estat");
        if (modeAutoCameres) {
        System.out.println("4. Mode automàtic: Activat");
        } else {
        System.out.println("4. Mode automàtic: Desactivat");
        }
        System.out.println("5. Tornar");
        System.out.print("Escull una opció: ");
        try {
        int op = p4.nextInt();
        switch (op) {
        case 1 -> {  if (cameres) {
                        System.out.println("Les càmeres ja estan activades.");
                    } else {
                        cameres = true;
                        System.out.println("Les càmeres s'han activat correctament.");
                    } }
        case 2 -> { if (!cameres) {
                        System.out.println("Les càmeres ja estan desactivades.");
                    } else {
                        cameres = false;
                        System.out.println("Les càmeres s'han desactivat correctament.");
                    } }
        case 3 -> System.out.println("Estat: " + (cameres ? "Actives" : "Inactives"));
        case 4 -> { modeAutoCameres = !modeAutoCameres; System.out.println("Mode automàtic càmeres: " + (modeAutoCameres ? "activat" : "desactivat")); }
        case 5 -> { return; }
        default -> System.out.println("Opció no vàlida.");
         }
        } catch (InputMismatchException e) {
                System.out.println("Format incorrecte.");
                p4.nextLine();
            }
        }
    }
     public static void aspersors(Scanner p4) {
      while (true) {
        System.out.println("\n--- Aspersors del Jardí ---");
        System.out.println("1. Activar aspersors");
        System.out.println("2. Desactivar aspersors");
        System.out.println("3. Mostrar estat");
        System.out.println("4. Mode automàtic: " + (modeAutoAspersors ? "Activat" : "Desactivat"));
        System.out.println("5. Tornar");
        System.out.print("Escull una opció: ");
        try {
        int op = p4.nextInt();
        switch (op) {
            case 1 -> { if (aspersors) {
                        System.out.println("Els aspersors ja estan activats.");
                    } else {
                        aspersors = true;
                        System.out.println("Els aspersors s'han activat correctament.");
                    } }
            case 2 -> { if (!aspersors) {
                        System.out.println("Els aspersors ja estan desactivats.");
                    } else {
                        aspersors = false;
                        System.out.println("Els aspersors s'han desactivat correctament.");
                    } }
            case 3 -> System.out.println("Estat: " + (aspersors ? "Actius" : "Inactius"));
            case 4 -> { modeAutoAspersors = !modeAutoAspersors; System.out.println("Mode automàtic aspersors: " + (modeAutoAspersors ? "activat" : "desactivat")); }
            case 5 -> { return; }
            default -> System.out.println("Opció no vàlida.");
        }
        } catch (InputMismatchException e) {
            System.out.println("Format incorrecte.");
            p4.nextLine();
        }
    }
}
}