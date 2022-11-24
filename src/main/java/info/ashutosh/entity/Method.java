package info.ashutosh.entity;

public enum Method {
	GET(1), POST(2), UPDATE(3), DELETE(4), PUT(5);

	final int methodValue;

	Method(int methodValue) {
		this.methodValue = methodValue;
	}

}
