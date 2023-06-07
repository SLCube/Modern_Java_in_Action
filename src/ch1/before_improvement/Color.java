package ch1.before_improvement;

public enum Color {
    GREEN("green"),
    RED("red"),
    YELLOW("yellow");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
