package BigInteger;
import java.math.BigInteger;

public class TestBigInteger {
    public static void main(String[] args) {
        // Khởi tạo hai số BigInteger
        BigInteger i1 = new BigInteger("111111111111111111111111111111111111111111111111111111");
        BigInteger i2 = new BigInteger("222222222222222222222222222222222222222222222222222222");

        // Thực hiện phép cộng
        BigInteger sum = i1.add(i2);
        System.out.println("Sum: " + sum);

        // Thực hiện phép nhân
        BigInteger product = i1.multiply(i2);
        System.out.println("Product: " + product);
    }
}
