package rs.raf.gerumap.model;

import java.util.Objects;

public class Pair<FirstType, SecondType> {

    private FirstType first;
    private SecondType second;

    public Pair(FirstType first, SecondType second) {
        this.first  = first;
        this.second = second;
    }

    public void setFirst(FirstType first) {
        this.first = first;
    }

    public void setSecond(SecondType second) {
        this.second = second;
    }

    public FirstType getFirst() {
        return first;
    }

    public SecondType getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pair<?, ?>))
            return false;

        Pair<FirstType, SecondType> pair = (Pair<FirstType, SecondType>) obj;
        return Objects.equals(first, pair.first);
    }

    @Override
    public String toString() {
        return "First: " + first + " | Second: " + second;
    }

}
