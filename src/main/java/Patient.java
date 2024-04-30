public class Patient extends Person {
  private String symptomsDescription;
  private Severity severity;

  public Severity getSeverity() {
    return severity;
  } 
}