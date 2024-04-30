import java.util.ArrayList;

public class Queue {
  ArrayList<Patient> list = new ArrayList<Patient>();

  public void enqueue(Patient p) {
    list.add(p);
  }

  public Patient dequeue() {
    if (!list.isEmpty()) {
      return list.remove(0);
    }
    throw new QueueException("La lista è vuota");
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public Patient get(int i) {
    if (list.get(i) != null) {
      return list.get(i);
    }
    throw new QueueException("Nessun paziente trovato");
  }
}