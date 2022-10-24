package net.aionstudios.hestia.data;

public class Either<L,R> {
	
	private L left;
	private R right;
	
	private Either() {}
	
	public static <L,R> Either<L,R> ofLeft(L value) {
		return new Either<L,R>().setLeft(value);
	}
	
	public static <L,R> Either<L,R> ofRight(R value) {
		return new Either<L,R>().setRight(value);
	}
	
	public L getLeft() {
		return isLeft() ? left : null;
	}
	
	public R getRight() {
		return isRight() ? right : null;
	}
	
	public boolean isLeft() {
		return left != null;
	}
	
	public boolean isRight() {
		return !isLeft();
	}

	private Either<L,R> setLeft(L value) {
		if (value == null) throw new NullPointerException("Either assignment cannot be null!");
		left = value;
		return this;
	}
	
	private Either<L,R> setRight(R value) {
		if (value == null) throw new NullPointerException("Either assignment cannot be null!");
		right = value;
		return this;
	}
	
}
