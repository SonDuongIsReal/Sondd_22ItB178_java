package BallvsPlayer;
class Ball {
    private float x, y, z;

    public Ball(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getZ() { return z; }
    
    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}

class Player {
    private int number;
    private float x, y, z = 0.0f;

    public Player(int number, float x, float y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    public void jump(float zDisp) {
        this.z += zDisp;
    }

    public boolean near(Ball ball) {
        float dx = this.x - ball.getX();
        float dy = this.y - ball.getY();
        float dz = this.z - ball.getZ();
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        return distance < 8;
    }

    public void kick(Ball ball) {
        if (near(ball)) {
            ball.setXYZ(ball.getX() + 5, ball.getY() + 5, ball.getZ());
            System.out.println("Player " + number + " kicked the ball!");
        } else {
            System.out.println("Ball is too far to kick!");
        }
    }
}

public class SoccerGameTest {
    public static void main(String[] args) {
        Ball ball = new Ball(10, 10, 0);
        Player player1 = new Player(7, 12, 12);
        Player player2 = new Player(10, 30, 30);
        
        System.out.println("Initial Ball Position: " + ball);
        
        player1.kick(ball);
        System.out.println("Ball Position After Kick: " + ball);
        
        player2.kick(ball);
        System.out.println("Ball Position After Player 2 Kick: " + ball);
    }
}
