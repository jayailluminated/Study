package com.springinaction.chapter01.knight;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 1:37:56 AM
 */
public class KnightOfTheRoundTableTest extends TestCase {

	public void testEmbarkOnQuest() throws QuestFailedException {
		KnightOfTheRoundTable knight = new KnightOfTheRoundTable("Bedivere");

		knight.setQuest(new HolyGrailQuest());
		
		HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
		assertNotNull(grail);
		assertTrue(grail.isHoly());

	}
}
