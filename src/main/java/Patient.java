public class Patient extends Person {
  private String symptomsDescription;
  private Severity severity;

  public Patient(String fs, String ls, String sd, Severity s) {
    super(fs, ls);
    symptomsDescription = sd;
    severity = s;
  }

  public String getSymtoms() {
    return symptomsDescription;
  }
  
  public Severity getSeverity() {
    return severity;
  } 

  public String toString() {
    String s = super.toString();
    return s + " " + symptomsDescription + " " + severity;
  }
}