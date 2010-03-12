package com.springinaction.springidol.performer.aspectj;

/**
 * User: moretajoo
 * Date: Mar 12, 2010
 * Time: 2:07:48 AM
 */
public class CriticismEngineImpl implements CriticismEngine {
	public CriticismEngineImpl () {
	}

	public String getCriticism() {
		int i  = (int) (Math.random() * criticismPool.length);
		return criticismPool[i];
	}

	//injected
	private String[] criticismPool;

	public void setCriticismPool (String[] criticismPool) {
		this.criticismPool = criticismPool;
	}
}
