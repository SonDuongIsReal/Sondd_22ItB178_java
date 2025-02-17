package MovableRectangle;
// Giao diện Movable
interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

// Lớp MovablePoint triển khai Movable
class MovablePoint implements Movable {
    int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Lớp MovableRectangle triển khai Movable
class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    private boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed && topLeft.ySpeed == bottomRight.ySpeed;
    }

    @Override
    public void moveUp() {
        if (hasSameSpeed()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (hasSameSpeed()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        if (hasSameSpeed()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (hasSameSpeed()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    @Override
    public String toString() {
        return "TopLeft: " + topLeft + ", BottomRight: " + bottomRight;
    }
}

// Kiểm thử lớp MovableRectangle
public class Main {
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(0, 0, 5, 5, 2, 2);
        System.out.println("Trước khi di chuyển: " + rectangle);
        rectangle.moveRight();
        rectangle.moveDown();
        System.out.println("Sau khi di chuyển: " + rectangle);
    }
}
