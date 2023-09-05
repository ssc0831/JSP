/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.75
 * Generated at: 2023-06-15 05:32:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.board.dao.BoardDAO;
import com.board.dto.Board;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.board.dao.BoardDAO");
    _jspx_imports_classes.add("com.board.dto.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Board List</title>\r\n");

BoardDAO dao = BoardDAO.getInstance();
String pageNum = request.getParameter("pageNum");
if(pageNum == null){
	pageNum = "1";
}
String field = "";
String word = "";
if(request.getParameter("word")!= null){
	field = request.getParameter("field");
	word = request.getParameter("word");
}
int pageSize = 5;
int currentPage = Integer.parseInt(pageNum); // 현재 페이지
int startRow = (currentPage-1) * pageSize+1; // 1 6 11 ...
int endRow = currentPage*pageSize; // 5 10 15 ...
ArrayList<Board> arr = dao.boardList(field, word, startRow, endRow);
int count = dao.getCount(field, word);

      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"right\">\r\n");
      out.write("	<a href=\"writeForm.jsp\">글쓰기</a>\r\n");
      out.write("</div>\r\n");
      out.write("<h2>게시글 목록(");
      out.print(count );
      out.write(")</h2>\r\n");
      out.write("<table border=1>\r\n");
      out.write("	<thead>\r\n");
      out.write("	  <tr>\r\n");
      out.write("		<th>번호</th>\r\n");
      out.write("		<th>제목</th>\r\n");
      out.write("		<th>작성자</th>\r\n");
      out.write("		<th>작성일</th>\r\n");
      out.write("		<th>조회수</th>\r\n");
      out.write("	</tr>	\r\n");
      out.write(" </thead>\r\n");
      out.write(" <tbody>\r\n");
      out.write(" ");

 	for(Board board:  arr){
 
      out.write("		\r\n");
      out.write(" 		<tr>\r\n");
      out.write("	 		<td>");
      out.print(board.getNum() );
      out.write("</td>\r\n");
      out.write("	 		<td><a href=\"boardView.jsp?num=");
      out.print(board.getNum() );
      out.write("\">\r\n");
      out.write("	 		");
      out.print(board.getSubject() );
      out.write("</a></td>\r\n");
      out.write("	 		<td>");
      out.print(board.getWriter() );
      out.write("</td>\r\n");
      out.write("	 		<td>");
      out.print(board.getReg_date() );
      out.write("</td>\r\n");
      out.write("	 		<td>");
      out.print(board.getReadcount());
      out.write("</td>\r\n");
      out.write("  		</tr>\r\n");
 		
 	}
  
      out.write("\r\n");
      out.write("  </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<br/><br/>\r\n");
      out.write("<form action=\"list.jsp\" name=\"search\" method=\"get\">\r\n");
      out.write("<select name=\"field\">\r\n");
      out.write("	<option value=\"subject\">제 목\r\n");
      out.write("	<option value=\"writer\">작성자\r\n");
      out.write("</select>\r\n");
      out.write("<input type=\"text\" size=\"16\" name=\"word\">\r\n");
      out.write("<input type=\"submit\" value=\"찾기\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");

if(count > 0){
	int pageCount = count/pageSize + (count%pageSize == 0 ? 0:1);
	int pageBlock = 3;
	int startPage = (int)((currentPage-1)/pageBlock) * pageBlock+1 ; 
	int endPage = startPage+pageBlock-1;
	if(endPage > pageCount){
		endPage = pageCount;
	}
	// 이전
	if(startPage > pageBlock){
	
      out.write("\r\n");
      out.write("	<a href=\"list.jsp?pageNum=");
      out.print(startPage-pageBlock );
      out.write("\" >[이전]</a>\r\n");
      out.write("	");

	}	
	for(int i = startPage; i<=endPage; i++){ // 페이지번호
		if(i == currentPage){ // 현재 페이지 고정시키기
	
      out.write("\r\n");
      out.write("	[");
      out.print(i);
      out.write("]\r\n");
      out.write("	");

	}else{
	
      out.write("\r\n");
      out.write("	<a href=\"list.jsp?pageNum=");
      out.print(i );
      out.write("&field=");
      out.print(field );
      out.write("&word=");
      out.print(word );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");

	}
	if(endPage < pageCount){ // 다음
	
      out.write("\r\n");
      out.write("	<a href=\"list.jsp?pageNum=");
      out.print(startPage+pageBlock );
      out.write("&field=");
      out.print(field );
      out.write("&word=");
      out.print(word );
      out.write("\">[다음]</a>\r\n");
      out.write("	");

	}
}
	
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
