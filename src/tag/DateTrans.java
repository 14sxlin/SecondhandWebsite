package tag;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTrans extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final long TODAY = 24*60*60*1000;
	private static final long _YESTERDAY = 2*TODAY;
	private static final long _2DAYSAGO = 3*TODAY;
	private static final long _3DAYSAGO = 4*TODAY;
	private static final long WEEKIN = 8*TODAY;
	
	private String dateString;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	private void print(String message)
	{
		try {
			pageContext.getOut().println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int doStartTag() throws JspException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		try {
			Date date = sdf.parse(dateString);
			@SuppressWarnings("deprecation")
			long timelong = System.currentTimeMillis() - date.getSeconds();
			if(timelong<=TODAY)
				print("今天");
			else if(timelong<=_YESTERDAY)
				print("昨天");
			else if(timelong<=_2DAYSAGO)
				print("两天前");
			else if(timelong<=_3DAYSAGO)
				print("三天前");
			else if(timelong<=WEEKIN)
				print("一周内");
			else print("一周前");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageContext.getOut();
		return EVAL_PAGE;
	}
	
	
	
}
