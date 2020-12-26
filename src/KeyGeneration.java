public class KeyGeneration {

    private int n, e;
    private int d;
    private int p, q, CarmichaelsTotient;
    private randomNumber rand = new randomNumber();

    public KeyGeneration() {
        p = rand.getPrimeNumber(500);
        q = rand.getPrimeNumber(500);

        while (q == p) {
            q = rand.getPrimeNumber(500);
        }
        n = p * q;

        CarmichaelsTotient = NOK(p - 1, q - 1);
        e = rand.getRandomNumberInRange(2, CarmichaelsTotient) % CarmichaelsTotient;

        while (e <= 1 || NOD(e, CarmichaelsTotient) != 1) {
            e = rand.getRandomNumberInRange(2, 1000) % CarmichaelsTotient;
        }
        d = secretExp(e, CarmichaelsTotient);

    }

    private int NOK(int a, int b) {
        return a * b / NOD(a, b);
    }

    private int NOD(int a, int b) {
        if (a == b) return a;
        else if (a % b == 0) return b;
        if (a > b) return divider(a, b);
        else return divider(b, a);
    }

    private int divider(int GreaterValue, int LowerValue) {
        int remainder;
        do {
            remainder = GreaterValue % LowerValue;
            GreaterValue = LowerValue;
            LowerValue = remainder;
        }
        while (remainder != 0);
        return GreaterValue;
    }

    private int secretExp(int e, int CarmichaelsTotient) {
        int t = 0, newT = 1;
        int r = CarmichaelsTotient, newR = e;
        int quotient, buffer;

        while (newR != 0) {
            quotient = r / newR;

            buffer = newT;
            newT = t - quotient * buffer;
            t = buffer;

            buffer = newR;
            newR = r - quotient * buffer;
            r = buffer;
        }
        if (r > 1) {
            System.out.println("error"); //TODO
        }
        if (t < 0) {
            t = t + CarmichaelsTotient;
        }
        return t;
    }

    public int getD() {
        return d;
    }

    public int getN() {
        return n;
    }

    public int getE() {
        return e;
    }
}