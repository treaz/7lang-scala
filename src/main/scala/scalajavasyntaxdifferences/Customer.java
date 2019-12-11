package scalajavasyntaxdifferences;


public class Customer {
    private final String name;
    private final String address;
    private String id;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        Customer news = new Customer("Eric", "n/a");
    }
}
