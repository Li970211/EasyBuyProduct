<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
  
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
                
	<script type="text/javascript" src="js/n_nav.js"></script>   
    
    <script type="text/javascript" src="js/num.js">
    	var jq = jQuery.noConflict();
    </script>     
    
    <script type="text/javascript" src="js/shade.js"></script>
    
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
<jsp:include page="head.jsp"></jsp:include>
<!--End Header End--> 
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav none">
            <ul>
						<c:forEach var="category" items="${listcategory }" varStatus="s">
							<li>
								<div class="fj">
									<span class="n_img"><span></span><img
										src="images/nav${s.index+1 }.png" /></span> <span class="fl">${category.name }</span>
								</div>

								<div class="zj" style="top:-${s.index*40 }px;">
									<div class="zj_l">
										<c:forEach var="c2" items="${category.list }">
											<div class="zj_l_c">
												<h2>${c2.name }</h2>
												<c:forEach var="c3" items="${c2.list }">
													<a href="#">${c3.name }</a>|
												</c:forEach>
											</div>
										</c:forEach>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--End 商品分类详情 End-->
			<ul class="menu_r">
				<li><a href="Index.html">首页</a></li>
				<li><a href="Food.html">美食</a></li>
				<li><a href="Fresh.html">生鲜</a></li>
				<li><a href="HomeDecoration.html">家居</a></li>
				<li><a href="SuitDress.html">女装</a></li>
				<li><a href="MakeUp.html">美妆</a></li>
				<li><a href="Digital.html">数码</a></li>
				<li><a href="GroupBuying.html">团购</a></li>
			</ul>
			<div class="m_ad">中秋送好礼！</div>
		</div>
	</div>
<!--End Menu End--> 
<div class="i_bg">  
    <div class="content mar_20">
    	<img src="images/img3.jpg" />        
    </div>
    <!--Begin 第三步：提交订单 Begin -->
    <div class="content mar_20">
        <!--Begin 银行卡支付 Begin -->
    	<div class="warning">        	
            <table border="0" style="width:1000px; text-align:center;" cellspacing="0" cellpadding="0">
              <tr height="35">
                <td style="font-size:18px;">
                	感谢您在本店购物！您的订单已提交成功，请记住您的订单号: <font color="#ff4e00">${order.orderId }</font>
                </td>
              </tr>
              <tr>
                <td style="font-size:14px; font-family:'宋体'; padding:10px 0 20px 0; border-bottom:1px solid #b6b6b6;">
                	您选定的配送方式为: <font color="#ff4e00">申通快递</font>； &nbsp; &nbsp;您选定的支付方式为: <font color="#ff4e00">支付宝</font>； &nbsp; &nbsp;您的应付款金额为: <font color="#ff4e00">￥${order.cost }</font>
                </td>
              </tr>
              <tr>
                <td style="padding:20px 0 30px 0; font-family:'宋体';">
                	银行名称 收款人信息：全称 ${user.userName } ；帐号或地址 ${order.userAddress } ； <br />
                    注意事项：办理电汇时，请在电汇单“汇款用途”一栏处注明您的订单号。
                </td>
              </tr>
              <tr>
                <td>
                	<a href="#">首页</a> &nbsp; &nbsp; <a href="#">用户中心</a>
                </td>
              </tr>
            </table>        	
        </div>
        <!--Begin 银行卡支付 Begin -->
    </div>
	<!--End 第三步：提交订单 End--> 
    
    
    <!--Begin Footer Begin -->
     <jsp:include page="foot.jsp"></jsp:include>
    <!--End Footer End -->    
</div>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
