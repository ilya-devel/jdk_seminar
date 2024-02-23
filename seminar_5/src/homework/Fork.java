package homework;

public class Fork {
    private final String name;
    volatile private boolean isUsing;

    public Fork(String name) {
        this.name = name;
        this.isUsing = false;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }

    public String getName() {
        return name;
    }

    public boolean isUsing() {
        return !isUsing;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "name='" + name + '\'' +
                '}';
    }
}
