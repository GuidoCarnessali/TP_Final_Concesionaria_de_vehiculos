package Manager.Exceptions;

public class IncorrectUserNameOrPasswordException extends Exception {
    public IncorrectUserNameOrPasswordException(String message) {
        super(message);
    }

  @Override
  public String getMessage() {
    return "El nombre de usuario o la contrasena ingresados no son correctos. ";
  }
}
