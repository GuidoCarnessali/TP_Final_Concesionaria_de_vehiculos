package Manager.Exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }

  @Override
  public String getMessage() {
    return "El nombre de usuario ingresado ya esta en uso. ";
  }
}
