package com.shark;
/**
 * 详情标签判断
 * @author shark
 *
 */
public class IqProductTagJudge {
    private Integer judgeId;

    private String content;

    private String proId;

    private Integer tagId;

    private Integer state;

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "IqProductTagJudge [judgeId=" + judgeId + ", content=" + content + ", proId=" + proId + ", tagId="
				+ tagId + ", state=" + state + "]";
	}

	public IqProductTagJudge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IqProductTagJudge(Integer judgeId, String content, String proId, Integer tagId, Integer state) {
		super();
		this.judgeId = judgeId;
		this.content = content;
		this.proId = proId;
		this.tagId = tagId;
		this.state = state;
	}
    
    
}