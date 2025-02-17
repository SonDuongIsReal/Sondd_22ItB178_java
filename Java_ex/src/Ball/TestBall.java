package Ball;
public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball(50.0f, 50.0f, 10, 5.0f, 3.0f);
        System.out.println(ball);

        ball.move();
        System.out.println(ball);

        ball.reflectHorizontal();
        ball.move();
        System.out.println(ball);

        ball.reflectVertical();
        ball.move();
        System.out.println(ball);
    }
}
