public class Triage {
  private Queue red = new Queue();
  private Queue green = new Queue();
  private Queue yellow = new Queue();

  public void enqueue(Patient p) {
    if (p.getSeverity() == Severity.RED) {
      red.enqueue(p);
    } else if (p.getSeverity() == Severity.YELLOW) {
      yellow.enqueue(p);
    } else {
      green.enqueue(p);
    }
  }

  public int size() {
    return red.size() + green.size() + yellow.size();
  }

  public Patient dequeue() {
    if (!red.isEmpty()) {
      return red.dequeue();
    } else if (!yellow.isEmpty()) {
      return yellow.dequeue();
    } else if (!green.isEmpty()) {
      return green.dequeue();
    } else {
      throw new TriageException("Il triage è vuoto");
    }
  }

  public boolean isEmpty() {
    return red.isEmpty() && yellow.isEmpty() && green.isEmpty();
  }

  public Patient get(int i) {
    if (i > size()) {
      throw new TriageException("Paziente non trovato");
    } else if (i < red.size()) {
      return red.get(i);
    } else if (i - red.size() < yellow.size()) {
      return yellow.get(i - red.size());
    } else {
      return green.get(i - red.size() - yellow.size());
    }
  }
}