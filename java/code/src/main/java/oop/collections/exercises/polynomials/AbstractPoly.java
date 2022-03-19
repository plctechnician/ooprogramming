package oop.collections.exercises.polynomials;

import java.util.Objects;

/**
 * An abstract class providing an implementation for shared parts of ArrayPoly
 * and ListPoly
 *
 * @author Nicola Bicocchi
 */
public abstract class AbstractPoly implements Poly {

    double[] derive() {
        double[] tmp = new double[Math.max(1, degree())];
        for (int i = 1; i <= degree(); i++) {
            tmp[i - 1] = coefficient(i) * i;
        }
        return tmp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Poly p)) {
            return false;
        }
        if (degree() != p.degree()) {
            return false;
        }
        for (int i = 0; i <= degree(); i++) {
            if (coefficient(i) != p.coefficient(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coefficients());
    }

    @Override
    public String toString() {
        if (degree() == 0)
            return "" + coefficient(0);

        String out = (coefficient(0) == 0) ? "" : "" + coefficient(0) + " + ";
        for (int i = 1; i < degree(); i++) {
            if (coefficient(i) != 0)
                out += coefficient(i) + "x^" + i + " + ";
        }

        out += coefficient(degree()) + "x^" + degree();
        return out;
    }
}
