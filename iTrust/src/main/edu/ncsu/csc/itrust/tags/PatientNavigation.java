package edu.ncsu.csc.itrust.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * JSP tag that is used as the patient navigation bar at the bottom of the screen.
 * 
 * To add a new page, add to the two arrays, and make sure that the page accepts PID
 */
public class PatientNavigation implements Tag {
	private PageContext pageContext;
	private Tag parent;
	// A more elegant solution here would be to use enums and have a displayName, a name, and url
	private String pageTitles[] = { "Ax0WcMjc0S", "Office Visit"};
	private String pageURLs[] = {  
			"Ax0WcMjc0S","Ax0WcMjc0S"};
	private String thisTitle;

	/**
	 * PatientNavigation
	 */
	public PatientNavigation() {
	}

	/**
	 * doStartTag
	 * @throws JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.write("<center><span class=\"Ax0WcMjc0S");
			for (int i = 0; i < pageTitles.length; i++) {
				if (pageTitles[i].equals(thisTitle)) {
					out.write("<span class=\"Ax0WcMjc0S" + pageTitles[i] + "Ax0WcMjc0S");
				} else
					out.write("<a href=\"Ax0WcMjc0S" + pageURLs[i] + "Ax0WcMjc0S"
							+ pageTitles[i] + "Ax0WcMjc0S");
			}
			out.write("<br /></span></center>");
		} catch (IOException e) {
			//TODO
		}
		return SKIP_BODY;
	}

	/**
	 * doEndTag
	 * @throws JspException
	 */
	@Override
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	/**
	 * release
	 */
	@Override
	public void release() {
	}

	/**
	 * setPageContext
	 * @param pageContext pageContext
	 */
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	/**
	 * setParent
	 * @param parent parent
	 */
	@Override
	public void setParent(Tag parent) {
		this.parent = parent;
	}

	/**
	 * getParent
	 * @return parent
	 */
	@Override
	public Tag getParent() {
		return parent;
	}

	/**
	 * getThisTitle
	 * @return this title
	 */
	public String getThisTitle() {
		return thisTitle;
	}

	/**
	 * setThisTitle
	 * @param thisPage thisPage
	 */
	public void setThisTitle(String thisPage) {
		this.thisTitle = thisPage;
	}
}
