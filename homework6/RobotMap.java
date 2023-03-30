package homework6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import homework6.Executions.PositionException;

public class RobotMap implements Iterable<RobotMap.Robot> {

    private final int n;
    private final int m;

    private final Map<UUID, Robot> robots;

    public RobotMap(int n, int m) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Недопустимые значения размера карты!");
        }
        this.n = n;
        this.m = m;
        this.robots = new HashMap<>();
    }

    public Robot createRobot(Point position) throws PositionException {
        checkPosition(position);

        Robot robot = new Robot(position);
        robots.put(robot.id, robot);
        return robot;
    }

    private void checkPosition(Point position) throws PositionException {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > n || position.getY() > m) {
            throw new PositionException("Некорректное значение точки: " + position);
        }
        if (!isFree(position)) {
            throw new PositionException("Точка " + position + " занята!");
        }
    }

    private boolean isFree(Point position) {
        return robots.values().stream()  // Robot
//                .map(robot -> robot.getPosition())
                .map(Robot::getPosition) // Point
                .noneMatch(position::equals);
    }

    public Robot findRobotById(UUID uuid) {
        return robots.get(uuid);
    }

    public class Robot {

        private final UUID id;
        private Point position;
        private Direction direction;

        public Robot(Point position) {
            this.id = UUID.randomUUID();
            this.position = position;
            this.direction = Direction.TOP;
        }

        public UUID getId() {
            return id;
        }

        public Point getPosition() {
            return position;
        }

        public void move() throws PositionException {
            Point newPosition = switch (direction) {
                case TOP -> new Point(position.getX() - 1, position.getY());
                case RIGHT -> new Point(position.getX(), position.getY() + 1);
                case BOTTOM -> new Point(position.getX() + 1, position.getY());
                case LEFT -> new Point(position.getX(), position.getY() - 1);
            };
            checkPosition(newPosition);

            position = newPosition;
        }

        public void changeDirection(Direction direction) throws IllegalArgumentException{
            this.direction = direction;
        }

        @Override
        public String toString() {
            return String.format("[id=%s] %s dir=%s", id.toString(), position.toString(), direction);
        }
    }

    public enum Direction {

        TOP, RIGHT, BOTTOM, LEFT

    }

    @Override
    public Iterator<Robot> iterator() {
        return robots.values().iterator();
    }

}
