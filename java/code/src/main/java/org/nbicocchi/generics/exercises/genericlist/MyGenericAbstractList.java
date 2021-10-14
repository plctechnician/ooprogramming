package org.nbicocchi.generics.exercises.genericlist;

public abstract class MyGenericAbstractList<T> implements MyGenericList<T> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(String.format("[%s]", get(i).toString()));
        }
        return sb.toString();
    }
}
