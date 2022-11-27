package rs.raf.gerumap.model;

import java.util.Objects;

/**
 * Par allows storing two different objects into one.
 * @param <FirstType> the type of the first object
 * @param <SecondType> the type of the second object
 */
public class Pair<FirstType, SecondType> {

    private FirstType first;
    private SecondType second;

    /**
     * Creates a pair.
     * @param first first value
     * @param second second value
     */
    public Pair(FirstType first, SecondType second) {
        this.first  = first;
        this.second = second;
    }

    /**
     * Sets the value of the first.
     * @param first first value
     */
    public void setFirst(FirstType first) {
        this.first = first;
    }

    /**
     * Sets the value of the second.
     * @param second second value
     */
    public void setSecond(SecondType second) {
        this.second = second;
    }

    /**
     * Returns first value.
     * @return first value
     */
    public FirstType getFirst() {
        return first;
    }

    /**
     * Returns second value.
     * @return second value
     */
    public SecondType getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair<?, ?> pair))
            return false;

        return Objects.equals(first, pair.first);
    }

    @Override
    public String toString() {
        return "First: " + first + " | Second: " + second;
    }

}
