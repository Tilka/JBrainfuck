import java.io.IOException;

class Number {
    private int value;

    public Number add(Number a) {
	return add(a.get());
    }

    public Number add(int a) {
	value = (value + a) % 256;
	if(value < 0) value += 256;
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

public class helloworld {
    private static Number[] data = new Number[256];
    private static Number ptr = new Number();
    
    public static void main(String[] args) throws IOException {
	for(int i = 0 ; i < 256 ; i++)
	    data[i] = new Number();
        // end of header
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        while (data[ptr.get()].get() != 0) {
            ptr.add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            ptr.add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            ptr.add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            data[ptr.get()].add(1);
            ptr.add(1);
            data[ptr.get()].add(1);
            ptr.add(-1);
            ptr.add(-1);
            ptr.add(-1);
            ptr.add(-1);
            data[ptr.get()].add(-1);
        }
        ptr.add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        System.out.print((char) data[ptr.get()].get());
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(-1);
        ptr.add(-1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(1);
        System.out.print((char) data[ptr.get()].get());
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        System.out.print((char) data[ptr.get()].get());
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        data[ptr.get()].add(-1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(1);
        data[ptr.get()].add(1);
        System.out.print((char) data[ptr.get()].get());
        ptr.add(1);
        System.out.print((char) data[ptr.get()].get());
        // start of footer
    }
}
