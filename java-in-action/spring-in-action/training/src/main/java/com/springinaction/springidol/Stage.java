package com.springinaction.springidol;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 22, 2010
 * Time: 2:04:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class Stage {
	// private constructor
	private Stage () {
	}

	// Lazily loads instance
	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}
	// return instance
	public static Stage getInstance() {
		return StageSingletonHolder.instance;
	}
}
