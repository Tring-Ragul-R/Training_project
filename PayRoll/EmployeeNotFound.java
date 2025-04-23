public class EmployeeNotFound extends Exception {
    String exceptionName;

    public EmployeeNotFound(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionName() {
        return exceptionName;
    }
    
}
