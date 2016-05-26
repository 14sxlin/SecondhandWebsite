package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PictureChooser extends TagSupport {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getPath(int id)
	 {
		switch(id)
		{
		  case 1:return "book.jpg";
		  case 2:return "cloth.jpg";
		  case 3:return "ele.jpg";
		  case 4:return "food.jpg";
		  case 5:return "daily.jpg";
		  case 6:return "que.jpg";
		}
		return "que.jpg";
	 }
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().println(getPath(Integer.parseInt(type)));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
