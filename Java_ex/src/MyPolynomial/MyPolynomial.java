class MyPolynomial {
    private double[] coeffs;

    // Constructor with varargs
    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    // Get the degree of the polynomial
    public int getDegree() {
        return coeffs.length - 1;
    }

    // Evaluate the polynomial for a given x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    // Add two polynomials
    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] newCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            double c1 = (i < this.coeffs.length) ? this.coeffs[i] : 0;
            double c2 = (i < right.coeffs.length) ? right.coeffs[i] : 0;
            newCoeffs[i] = c1 + c2;
        }
        return new MyPolynomial(newCoeffs);
    }

    // Multiply two polynomials
    public MyPolynomial multiply(MyPolynomial right) {
        int newDegree = this.getDegree() + right.getDegree();
        double[] newCoeffs = new double[newDegree + 1];

        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    // Convert polynomial to string representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (sb.length() > 0) sb.append(" + ");
                sb.append(coeffs[i]).append("x^").append(i);
            }
        }
        return sb.toString().replace("x^0", "").replace("x^1", "x");
    }

    // Main method for testing
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        MyPolynomial p2 = new MyPolynomial(1.0, 1.0);

        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);
        System.out.println("Addition: " + p1.add(p2));
        System.out.println("Multiplication: " + p1.multiply(p2));
        System.out.println("Evaluation at x=2: " + p1.evaluate(2));
    }
}
