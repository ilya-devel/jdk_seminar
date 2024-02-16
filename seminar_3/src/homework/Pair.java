package homework;

public class Pair <T1, T2> {
    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + getFirst() + " - " + getFirst().getClass().getSimpleName() +
                ", second=" + getSecond() + " - " + getSecond().getClass().getSimpleName() +
                '}';
    }
}
