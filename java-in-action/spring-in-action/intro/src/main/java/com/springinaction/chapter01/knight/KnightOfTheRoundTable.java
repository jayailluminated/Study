package com.springinaction.chapter01.knight;

/**
 * User: jungjooseo
 * Date: Dec 14, 2009
 * Time: 1:24:44 AM
 */
public class KnightOfTheRoundTable implements Knight{
	private String name;
//	private HolyGrailQuest quest;
	private Quest quest;
	private Minstrel minstrel;


	public KnightOfTheRoundTable(String name) {
		this.name = name;
//		quest = new HolyGrailQuest();
	}


//	public HolyGrail embarkOnQuest() throws GrailNotFoundException {
	public Object embarkOnQuest() throws QuestFailedException {
//aspectj?????????????????
//		minstrel.singBefore(this);
//		HolyGrail grail = (HolyGrail) quest.embark();
//		minstrel.singAfter(this);
//		return grail;
		return quest.embark();
	}

	public String getName() {
		return this.name;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}




	public void setMinstrel(Minstrel minstrel) {
		this.minstrel = minstrel;
	}
}
