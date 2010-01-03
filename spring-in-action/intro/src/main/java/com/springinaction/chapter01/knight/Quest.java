package com.springinaction.chapter01.knight;

/**
 * User: jungjooseo
 * Date: Jan 2, 2010
 * Time: 4:16:16 AM
 */
public interface Quest {
	//A common technique used to reduce coupling  
	abstract Object embark() throws QuestFailedException;
}
