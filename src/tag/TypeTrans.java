package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TypeTrans extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	 public String typename(int id)
	 {
		switch(id)
		{
		  case 1:return "ͼ��";
		  case 2:return "��Ь��";
		  case 3:return "�����豸";
		  case 4:return "ʳƷ";
		  case 5:return "�Ҿ���Ʒ";
		  case 6:return "����";
		}
		return "����";
	 }
	 
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(typename(type));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
