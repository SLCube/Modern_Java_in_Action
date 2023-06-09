package lambda.ch1.common;

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
