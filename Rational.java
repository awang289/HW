public class Rational {
    private int num, dem;
    public Rational() {
	num = 0;
	dem = 1;
    }
    public Rational(int a, int b) {
	this();
	if (b != 0) {
	    num = a;
	    dem = b;
	}
	else 
	    System.out.println("ERROR: INVALID DENOMINATOR. Number set to 0/1.");
    }
    public String toString() {
	return "" + num + "/" + dem; 
    }
    public double floatValue() {
	double n = 1.0 * num / dem;
	return n;
    }
    public void multiply(Rational n) {
	num *= n.num;
	dem *= n.dem;
    }
    public void divide(Rational n) {
	num /= n.num;
	dem /= n.dem;
    }
    public void add(Rational n) {
	num = num * n.dem + dem * n.num;
	dem *= n.dem;
    }
    public void subtract(Rational n) {
	num = num * n.dem - dem * n.num;
	dem *= n.dem;
    }
    public int gcd(){
	return gcd(num, dem);
    }
    public static int gcd(int a, int b) {
	if ( a < b ) 
	    return gcd(b,a);
	else if ((a % b) == 0)
	    return b;
	else 
	    return gcd(b, (a%b));
    }
    public void reduce() {
	int g = gcd();
	num /= g;
	dem /= g;
    }
    public int compareTo(Rational n) {
	int a = num * n.dem;
	int b = dem * n.num;
	return (a - b);
    }
    public static void main(String[] args) {
	Rational r = new Rational(2,3);
	Rational s = new Rational (1,2);
	System.out.println("r: " + r);
	System.out.println("s: " + s);
	System.out.println("Float value: " + r.floatValue());
	r.multiply(s);
	System.out.println("Multiplying 2/3 by 1/2: " + r);
	r.divide(s);
	System.out.println("Dividing 2/6 by 1/2: " + r);
	r.add(s);
	System.out.println("Adding 2/3 to 1/2: " + r);
	r.subtract(s);
	System.out.println("Subtracting 7/6 by 1/2: " + r);
	r.reduce();
	System.out.println("Reducing r: " + r);
	System.out.println("r.compareTo(s) : " + r.compareTo(s));
	System.out.println("s.compareTo(r) : " + s.compareTo(r));
	System.out.println("r.compareTo(r) : " + r.compareTo(r));
    }
}
