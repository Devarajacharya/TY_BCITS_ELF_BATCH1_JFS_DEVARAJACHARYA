package com.bcits.constructor.abstraction;

public class ClassY implements Connection {

	@Override
	public Statement createStatement() {
		return new ClassB();
	}
}
