package org.nbicocchi.oop;

/**
 * Per un programma di geometria piana, realizzare la classe Shape che dispone
 * dei metodi getWidth(), getHeight(), getPosX() e getPosY(), che restituiscono
 * rispettivamente la larghezza, l’altezza, la posizione sulle ascisse e sulle
 * ordinate del più piccolo rettangolo che contiene interamente la figura in
 * questione (le coordinate restituite da getPosX() e getPosY() si riferiscono
 * al vertice in basso a sinistra del rettangolo).
 * <p>
 * Fornire infine la classe di metodo main dimostrativo.
 *
 * @author Nicola Bicocchi
 */
public class Shape {
    double width;
    double height;
    double posX;
    double posY;

    public Shape(double width, double height, double posX, double posY) {
        super();
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "width=" + width +
                ", height=" + height +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }

    public static void main(String[] args) {
        Shape s1 = new Shape(100, 100, 0, 0);
        Shape s2 = new Shape(200, 120, 10, 10);

        s1.setPosX(5);
        s1.setPosY(5);
        System.out.println(s1.getPosX() + " " + s1.getPosY());
        System.out.println(s1.getWidth() + " " + s1.getHeight());
    }
}
