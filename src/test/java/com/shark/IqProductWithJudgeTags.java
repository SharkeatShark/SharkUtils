package com.shark;

import java.util.List;

public class IqProductWithJudgeTags extends IqProduct {
	
	private static final long serialVersionUID = 1L;

	private List<IqProductTag> allTags;
	
	private List<IqProductTagJudge> allJudgeTags;

	public List<IqProductTagJudge> getAllJudgeTags() {
		return allJudgeTags;
	}

	public void setAllJudgeTags(List<IqProductTagJudge> allJudgeTags) {
		this.allJudgeTags = allJudgeTags;
	}

	public List<IqProductTag> getAllTags() {
		return allTags;
	}

	public void setAllTags(List<IqProductTag> allTags) {
		this.allTags = allTags;
	}

	public IqProductWithJudgeTags(List<IqProductTag> allTags, List<IqProductTagJudge> allJudgeTags) {
		super();
		this.allTags = allTags;
		this.allJudgeTags = allJudgeTags;
	}

	public IqProductWithJudgeTags() {
		super();
	}
}
