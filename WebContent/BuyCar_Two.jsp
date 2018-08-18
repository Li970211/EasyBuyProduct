<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
    
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
                
	<script type="text/javascript" src="js/n_nav.js"></script>   
    
    <script type="text/javascript" src="js/select.js"></script>
    
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
    	<img src="images/img2.jpg" />        
    </div>
    <!--Begin 第二步：确认订单信息 Begin -->
    <div class="content mar_20">
    	<div class="two_bg">
        	<div class="two_t">
            	<span class="fr"><a href="#">修改</a></span>商品列表
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="550">商品名称</td>
                <td class="car_th" width="140">属性</td>
                <td class="car_th" width="150">购买数量</td>
                <td class="car_th" width="130">小计</td>
                <td class="car_th" width="140">返还积分</td>
              </tr>
            
            <c:set var="money" value="0"></c:set>
            <c:forEach items="${sessionScope.orderListForm}" var="orderList">
              <tr>
                <td>
                	<input type="hidden" id="orderId" value="${orderList.orderId }"/>
                    <div class="c_s_img"><img src="files/${orderList.product.fileName }" width="73" height="73" /></div>
                   ${orderList.product.name}
                </td>
                
                <td align="center">颜色：灰色</td>
                <td align="center">${orderList.quantity }</td>
                <td align="center" style="color:#ff4e00;">￥${orderList.product.price * orderList.quantity }元</td>
                <td align="center">26R</td>
              </tr>
             <c:set var="money" value="${money+ orderList.product.price * orderList.quantity}"></c:set>
             </c:forEach>
              <tr>
                <td colspan="5" align="right" style="font-family:'Microsoft YaHei';">
                    商品总价：￥${money } ； 返还积分 56R  
                </td>
             
            </table>
            
            <div class="two_t">
            	<span class="fr"><a href="#">修改</a></span>收货人信息
            </div>
            <input type="hidden" id="userId" value="${sessionScope.user.id }"/>
            <table border="0" class="peo_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="p_td" width="160">用户名称</td>
                <td width="395">${sessionScope.user.userName }</td>
                <td class="p_td" width="160">电子邮件</td>
                <td width="395">${sessionScope.user.email }</td>
              </tr>
              <tr>
                <td class="p_td">送货地址</td>
                <td><input type="text" id="address" />
                </td>
                <span id="address_span" style="color:red;font-size=12px;"></span>
                <td class="p_td">邮政编码</td>
                <td>6011111</td>
              </tr>
              <tr>
                <td class="p_td">电话</td>
                <td>${sessionScope.user.mobile }</td>
                <td class="p_td">手机</td>
                <td>${sessionScope.user.mobile }</td>
              </tr>
              <tr>
                <td class="p_td">标志建筑</td>
                <td></td>
                <td class="p_td">最佳送货时间</td>
                <td></td>
              </tr>
            </table>

            
            <div class="two_t">
            	配送方式
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="200">名称</td>
                <td class="car_th" width="370">订购描述</td>
                <td class="car_th" width="150">费用</td>
                <td class="car_th" width="135">免费额度</td>
                <td class="car_th" width="175">保价费用</td>
              </tr>
              <tr>
              	<td align="center"><input type="radio" name="ch" checked="checked" /></td>
                <td align="center" style="font-size:14px;"><b>申通快递</b></td>
                <td>江、浙、沪地区首重为15元/KG，其他地区18元/KG，续重均为5-6元/KG， 云南地区为8元</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td align="center"><input type="radio" name="ch" /></td>
                <td align="center" style="font-size:14px;"><b>城际快递</b></td>
                <td>运费固定</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td align="center"><input type="radio" name="ch" /></td>
                <td align="center" style="font-size:14px;"><b>邮局平邮</b></td>
                <td>运费固定</td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center">不支持保价</td>
              </tr>
              <tr>
              	<td colspan="6">
                	<span class="fr"><label class="r_rad"><input type="checkbox" name="baojia" /></label>
                	<label class="r_txt">配送是否需要保价</label></span>
                </td>
              </tr>
            </table> 
            
            <div class="two_t">
            	支付方式
            </div>
            <ul class="pay">
                <li class="checked">余额支付<div class="ch_img"></div></li>
                <li>银行亏款/转账<div class="ch_img"></div></li>
                <li>货到付款<div class="ch_img"></div></li>
                <li>支付宝<div class="ch_img"></div></li>
            </ul>
            
            <div class="two_t">
            	商品包装
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="490">名称</td>
                <td class="car_th" width="180">费用</td>
                <td class="car_th" width="180">免费额度</td>
                <td class="car_th" width="180">图片</td>
              </tr>
              <tr>
              	<td align="center"><input type="radio" name="pack" checked="checked" /></td>
                <td><b style="font-size:14px;">不要包装</b></td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center"></td>
              </tr>
              <tr>
              	<td align="center"><input type="radio" name="pack" /></td>
                <td><b style="font-size:14px;">精品包装</b></td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center"><a href="#" style="color:#ff4e00;">查看</a></td>
              </tr>
            </table> 
            
            <div class="two_t">
            	祝福贺卡
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td class="car_th" width="80"></td>
                <td class="car_th" width="490">名称</td>
                <td class="car_th" width="180">费用</td>
                <td class="car_th" width="180">免费额度</td>
                <td class="car_th" width="180">图片</td>
              </tr>
              <tr>
              	<td align="center"><input type="checkbox" name="wish" checked="checked" /></td>
                <td><b style="font-size:14px;">不要贺卡</b></td>
                <td align="center">￥15.00</td>
                <td align="center">￥0.00</td>
                <td align="center"></td>
              </tr>
              <tr>
              	<td align="center" style="border-bottom:0; padding-bottom:0;"><input type="checkbox" name="wish" /></td>
                <td style="border-bottom:0; padding-bottom:0;"><b style="font-size:14px;">祝福贺卡</b></td>
                <td align="center" style="border-bottom:0; padding-bottom:0;">￥15.00</td>
                <td align="center" style="border-bottom:0; padding-bottom:0;">￥0.00</td>
                <td align="center" style="border-bottom:0; padding-bottom:0;"><a href="#" style="color:#ff4e00;">查看</a></td>
              </tr>
              <tr valign="top">
              	<td align="center"></td>
                <td colspan="4">
                	<span class="fl"><b style="font-size:14px;">祝福语：</b></span>
                    <span class="fl"><textarea class="add_txt" style="width:860px; height:50px;"></textarea></span>
                </td>
              </tr>
            </table> 
            
            <div class="two_t">
            	其他信息
            </div>
            <table border="0" class="car_tab" style="width:1110px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="145" align="right" style="padding-right:0;"><b style="font-size:14px;">使用红包：</b></td>
                <td>
                	<span class="fl" style="margin-left:50px; margin-right:10px;">选择已有红包</span>
                    <select class="jj" name="city">
                      <option value="0" selected="selected">请选择</option>
                      <option value="1">50元</option>
                      <option value="2">30元</option>
                      <option value="3">20元</option>
                      <option value="4">10元</option>
                    </select>
                    <span class="fl" style="margin-left:50px; margin-right:10px;">或者输入红包序列号</span>
                    <span class="fl"><input type="text" value="" class="c_ipt" style="width:220px;" />
                    <span class="fr" style="margin-left:10px;"><input type="submit" value="验证红包" class="btn_tj" /></span>
                </td>
			  </tr>
              <tr valign="top">
                <td align="right" style="padding-right:0;"><b style="font-size:14px;">订单附言：</b></td>
                <td style="padding-left:0;"><textarea class="add_txt" style="width:860px; height:50px;"></textarea></td>
              </tr>
              <tr>
              	<td align="right" style="padding-right:0;"><b style="font-size:14px;">缺货处理：</b></td>
                <td>
                	<label class="r_rad"><input type="checkbox" name="none" checked="checked" /></label><label class="r_txt" style="margin-right:50px;">等待所有商品备齐后再发</label>
                    <label class="r_rad"><input type="checkbox" name="none" /></label><label class="r_txt" style="margin-right:50px;">取下订单</label>
                    <label class="r_rad"><input type="checkbox" name="none" /></label><label class="r_txt" style="margin-right:50px;">与店主协商</label>
                </td>
              </tr>
            </table>
            
            <table border="0" style="width:900px; margin-top:20px;" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right">
                	该订单完成后，您将获得 <font color="#ff4e00">1815</font> 积分 ，以及价值 <font color="#ff4e00">￥0.00</font> 的红包 <br />
                    商品总价: <font color="#ff4e00">￥${money }</font>  + 配送费用: <font color="#ff4e00">￥15.00</font>
                </td>
              </tr>
              <tr height="70">
                <td align="right">
                	<b style="font-size:14px;">应付款金额：<span style="font-size:22px; color:#ff4e00;">￥${money +15}</span></b>
                </td>
              </tr>
              <tr height="70">
                <td align="right"><img onclick="PayOrder()" src="images/btn_sure.gif" /></td>
              </tr>
            </table>

            
        	
        </div>
    </div>
	<!--End 第二步：确认订单信息 End-->
    
    
    <!--Begin Footer Begin -->
    <jsp:include page="foot.jsp"></jsp:include>
    <!--End Footer End -->    
</div>

<script type="text/javaScript">
	function PayOrder(){
		var address = $("#address").val();
		var orderId = $("#orderId").val();
		alert(address+":"+orderId)
		if(address == "" || address == null || address == undefined){
			alert("收货地址不能为空");
			return;
		}
		window.location.href="${pageContext.request.contextPath}/PayOrderServlet?address="+address+"&orderId="+orderId;
		
	}
	
</script>
	

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
