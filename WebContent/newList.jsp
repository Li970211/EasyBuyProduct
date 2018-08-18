<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String basePath = request.getContextPath();
String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+basePath+"/";
%> 
<%@taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网--新闻资讯</title>
<style type="text/css">
	.p_conetnt{
	display: -webkit-box;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 3;
	overflow: hidden;
	width: 900px;
	word-break:break-all;
	}
</style>
</head>
<body>
<jsp:include page="head.jsp"/>
<hr/>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<div class="m_left">
        	<a href="${pageContext.request.contextPath }/NewsInfoServlet?nowpage=1"><div class="left_n" >新闻资讯</div></a>
            <div class="left_m">
            	<div class="left_m_t t_bg1">新闻中心</div>
                <ul>
                <c:forEach items="${sumNews}" var="news">
                    <li><a href="${pageContext.request.contextPath }/NewsDetailedServlet?id=${news.id}">${news.title}&nbsp;&nbsp;&nbsp;&nbsp;
                    	<span style="font-size: 11px;color: #c1c1c1;">
                    	<fmt:formatDate value="${news.createTime}"
                    		pattern="yyyy-MM-dd"/>
                    	</span>
                    </a></li>
                </c:forEach> 
                </ul>
            </div>
        </div>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">新闻资讯</div>
            <table border="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
            <c:if test="${news != null }">
            	<tr>
            		<td><h1><a href="${pageContext.request.contextPath }/NewsDetailedServlet?id=${news.id}">${news.title}</a></h1>
                	<p class="p_conetnt">${news.content}</p>
                	</td>
            	</tr>
            </c:if>
            <c:if test="${page != null }">
            <c:forEach items="${page.list}" var="news">
              <tr>
                <td>
                	<h1><a href="${pageContext.request.contextPath }/NewsDetailedServlet?id=${news.id}">${news.title}</a></h1>
                	<p class="p_conetnt">${news.content}</p>
                	<div align="center">
                		<div align="left"><a href="${pageContext.request.contextPath }/NewsDetailedServlet?id=${news.id}" style="color: #fe785b">详情>></a></div>
                		<div align="right" style="color: #c1c1c1">
                		<fmt:formatDate value="${news.createTime}"
                		pattern="yyyy-MM-dd"/>
                		</div>
                	</div>
                </td>
              </tr>
              </c:forEach>
              <tr align="center">
                <td >
                	总共${page.sumcount}条记录 ${page.nowpage}/${page.sumpage } 
                	<c:if test="${page.nowpage>1}">
                	<a href="${pageContext.request.contextPath }/NewsInfoServlet?nowpage=${page.firstpage}">首页 </a>	
                	<a href="${pageContext.request.contextPath }/NewsInfoServlet?nowpage=${page.prepage}">上一页</a> 
                	</c:if>
                	<c:if test="${page.sumpage>page.nowpage}">
                	<a href="${pageContext.request.contextPath }/NewsInfoServlet?nowpage=${page.nextpage}">下一页</a>
                	<a href="${pageContext.request.contextPath }/NewsInfoServlet?nowpage=${page.lastpage}"> 尾页</a>   
                	</c:if>
                </td>
              </tr>
             </c:if>
            </table>
    </div>
<jsp:include page="foot.jsp"/>
</body>
</html>