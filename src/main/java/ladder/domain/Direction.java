package ladder.domain;

import java.util.Objects;

public class Direction {
    private final Link left;
    private final Link right;

    private Direction(Link left, Link right) {
        if (left == Link.CLOSE && right == Link.CLOSE) {
            throw new IllegalArgumentException("이전링크와 현재링크 모두 닫혀있을 수 없습니다");
        }

        this.left = left;
        this.right = right;
    }

    public static Direction of(Link left, Link right) {
        return new Direction(left, right);
    }

    public static Direction first(Link right) {
        return of(Link.OPEN, right);
    }

    public static Direction first() {
        return first(RandomLinkSelector.link());
    }

    public Direction last() {
        return of(right, Link.OPEN);
    }

    public Direction next(Link right) {
        return of(this.right, right);
    }

    public Direction next() {
        if (this.right == Link.CLOSE) {
            return of(this.right, Link.OPEN);
        }

        return of(this.right, RandomLinkSelector.link());
    }

    public Link right() {
        return this.right;
    }

    public Side move() {
        if (isLeft()) {
            return Side.LEFT;
        }

        if (isRight()) {
            return Side.RIGHT;
        }

        return Side.STRAIGHT;
    }

    boolean isStraight() {
        return left.isOpened() && right.isOpened();
    }

    boolean isRight() {
        return left.isOpened() && right.isClosed();
    }

    boolean isLeft() {
        return left.isClosed() && right.isOpened();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}