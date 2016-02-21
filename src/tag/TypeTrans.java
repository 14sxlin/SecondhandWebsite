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
		  case 1:return "图书";
		  case 2:return "衣鞋包";
		  case 3:return "电子设备";
		  case 4:return "食品";
		  case 5:return "家居用品";
		  case 6:return "其他";
		}
		return "其他";
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
