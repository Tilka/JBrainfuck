import java.io.IOException;

class Number {
    public static int limit = 512;
    private int value;

    public Number add(Number a) {
	return add(a.get());
    }

    public Number add(int a) {
	value = (value + a) %% limit;
	if(value < 0) value += limit;
	return this;
    }

    public int get() {
	return value;
    }
    public void set(int i) {
	value = i;
        add(0); //make it between 0 and 255
    }
}

public class %s {
    private static Number[] data = new Number[ Number.limit ];
    private static Number ptr = new Number();
    
    public static void main(String[] args) throws IOException {
	for(int i = 0 ; i < Number.limit ; i++)
	    data[i] = new Number();
        // end of header
