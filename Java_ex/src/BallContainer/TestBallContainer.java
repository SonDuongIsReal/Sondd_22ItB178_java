package BallContainer;
class Ball {
    private float x, y;
    private int radius;
    private float xDelta, yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (float) (-speed * Math.sin(Math.toRadians(direction))); 
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }
    public float getXDelta() { return xDelta; }
    public void setXDelta(float xDelta) { this.xDelta = xDelta; }
    public float getYDelta() { return yDelta; }
    public void setYDelta(float yDelta) { this.yDelta = yDelta; }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return String.format("Ball at (%.2f, %.2f) with velocity (%.2f, %.2f)", x, y, xDelta, yDelta);
    }
}

class Container {
    private int x1, y1, x2, y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }

    public int getX() { return x1; }
    public int getY() { return y1; }
    public int getWidth() { return x2 - x1 + 1; }
    public int getHeight() { return y2 - y1 + 1; }

    public boolean collides(Ball ball) {
        boolean collided = false;
        if (ball.getX() - ball.getRadius() <= x1 || ball.getX() + ball.getRadius() >= x2) {
            ball.reflectHorizontal();
            collided = true;
        }
        if (ball.getY() - ball.getRadius() <= y1 || ball.getY() + ball.getRadius() >= y2) {
            ball.reflectVertical();
            collided = true;
        }
        return collided;
    }

    @Override
    public String toString() {
        return String.format("Container[(%d, %d), (%d, %d)]", x1, y1, x2, y2);
    }
}

public class TestBallContainer {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);

        for (int step = 0; step < 100; step++) {
            ball.move();
            box.collides(ball);
            System.out.println(ball);
        }
    }
}
