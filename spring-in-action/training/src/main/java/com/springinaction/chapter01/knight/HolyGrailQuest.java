package com.springinaction.chapter01.knight;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 1:26:13 AM
 */
public class HolyGrailQuest implements Quest{
	public HolyGrail embark() throws QuestFailedException {
//		HolyGrail grail = null;
////      Look for grail

//		return grail;

		//Do whatever it means to embark on a quest
		return new HolyGrail();
	}

}
