public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public void describe() {
        System.out.println("This is " + name);
    }
}