package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class StateTrans extends TagSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String state;
	

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	private String statename(String state)
	{
		switch (state) {
		case "displaying": return "展示中";
		case "cancel":return "取消";
		case "finish": return "完成";
		}
		return "未知";
	}
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(statename(state));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
