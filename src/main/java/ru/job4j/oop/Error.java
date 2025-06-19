package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();

        Error error1 = new Error(true, 404, "Not Found");
        Error error2 = new Error(false, 200, "OK");
        Error error3 = new Error(true, 500, "Internal Server Error");

        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
