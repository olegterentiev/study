public class Arithmetic {
    private final int first;
    private final int second;

    public Arithmetic(int first, int second) {
        this.first = first;
        this.second = second;
    }

    int sum() {
        return first + second;
    }

     int multiplication() {
        return first * second;
    }
     int max() {
        return first > second ? first : second;
    }
     int min() {
        return first < second ? first : second;
    }
}
