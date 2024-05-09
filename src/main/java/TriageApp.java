import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class TriageApp {
  private Triage triage = new Triage();
  Scanner input = new Scanner(System.in);

  private Severity severitySelector(String s) {
     Severity severity;
      if (s.equalsIgnoreCase("verde") || s.equalsIgnoreCase("green"))
        severity = Severity.GREEN;
      else if (s.equalsIgnoreCase("giallo") || s.equalsIgnoreCase("yellow"))
        severity = Severity.YELLOW;
      else if (s.equalsIgnoreCase("rosso") || s.equalsIgnoreCase("red"))
        severity = Severity.RED;
      else
        throw new TriageException("Severity non valida");

    return severity;
  }

  private void insertPatient() {
    System.out.println("\033[H\033[2J");
    System.out.print("Inserisci il nome: ");
    String nome = input.nextLine();

    System.out.print("Inserisci il cognome: ");
    String cognome = input.nextLine();

    System.out.print("Inserisci i sintomi: ");
    String sintomi = input.nextLine();

    System.out.print("Inserisci la gravità: ");
    String gravita = input.nextLine();

    Patient p = new Patient(nome, cognome, sintomi, severitySelector(gravita));
    triage.enqueue(p);
  }

  public void mainMenu() {

    boolean exit = false;

    while (!exit) {

      System.out.println("\033[H\033[2J");
      System.out.println(
          "Menu: \n1- Aggiungi un paziente alla coda \n2- Rimuovi il prossimo paziente \n3- Scarica coda \n4- Carica coda \n5- Stampa coda \n0- Exit");

      String number = input.nextLine();

      switch(number) {
        case "0" -> {
          exit = true;
        }
        case "1" -> {
          insertPatient();
        }
        case "2" -> {
          System.out.println(triage.dequeue());
          System.out.print("Premere invio per tornare al menù principale");
          input.nextLine();
        }
        case "3" -> {
          save();
        }
        case "4" -> {
          load();
        }
        case "5" -> {
          for (int i = 0; i < triage.size(); i++) {
            System.out.println(triage.get(i));
          }
          System.out.print("Premere invio per tornare al menù principale");
          input.nextLine();
        }
        default -> {
          System.out.println("Comando non riconosciuto\n\nPremere invio per tornare al menù principale");
          input.nextLine();
        }
      }
    }
  }

  private void save() {
    String filePath = "queue.txt";

    try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
      for (int i = 0; i < triage.size(); i++) {
        pw.println(triage.get(i).getName() + ";" + triage.get(i).getLname() + ";" + triage.get(i).getSymtoms() + ";"
            + triage.get(i).getSeverity());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

/*   private void load() {
    System.out.println("\033[H\033[2J");
    String filePath = "queue.txt";
    try (Scanner sc = new Scanner(new File(filePath))) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        System.out.println(line);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.print("Premere invio per tornare al menù principale");
    input.nextLine();
  } */


  private void load() {
    System.out.println("\033[H\033[2J");
    String filePath = "queue.txt";
    try (Scanner sc = new Scanner(new File(filePath))) {
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String[] split = line.split(";");
        Patient p = new Patient (split[0], split[1], split[2], severitySelector(split[3]));
        triage.enqueue(p);
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.print("Premere invio per tornare al menù principale");
    input.nextLine();
  }
  
}