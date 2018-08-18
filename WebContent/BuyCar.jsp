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
        <!--End 商品分类详情 End-->                                                     
<!--End Menu End--> 
<div class="i_bg">  
	
    <div class="content mar_20">
    	<img src="images/img1.jpg" />        
    </div>
    
    <!--Begin 第一步：查看购物车 Begin -->
    <div class="content mar_20">
    	<table border="0" class="car_tab" style="width:1200px; margin-bottom:50px;" cellspacing="0" cellpadding="0">
          <tr>
            <td class="car_th" width="490">商品名称</td>
            <td class="car_th" width="140">属性</td>
            <td class="car_th" width="150">购买数量</td>
            <td class="car_th" width="130">小计</td>
            <td class="car_th" width="140">返还积分</td>
            <td class="car_th" width="150">操作</td>
          </tr>
          <c:if test="${empty sessionScope.cart}">
          <tr>
          		<td><h2><a href="${pageContext.request.contextPath }/categoryservlet">亲,您的购物空空如也！请先去挑点东西吧~~~</a></h2></td>
          </tr>
          </c:if>
          <c:if test="${not empty sessionScope.cart}">
          <c:set var="money" value="0"></c:set><!-- 在域属性中设置一个moeny，开始是0,循环遍历去累加 -->
          <c:forEach items="${sessionScope.cart}" var="cart">
          <tr>
            <td>
            	<div class="c_s_img"><img src="files/${cart.product.fileName }" width="73" height="73" /></div>
                ${cart.product.name}
            </td>
            <td align="center">颜色：灰色</td>
            <td align="center">
            	<span id="car_span" style="color:red;font-size=12px;"></span>
            	<div class="c_num">
            		<input type="hidden" name="product_stock" value="${cart.product.stock}">
                    <input type="button" value=""  class="car_btn_1" />
                	<input type="text" value="${cart.quantity }" name="changNum" class="car_ipt" />  
                    <input type="button" value="" class="car_btn_2" />
                    <input type="hidden" class="product_Id" value="${cart.product.id }"/>
                </div>
            </td>
            <td align="center" style="color:#ff4e00;">￥${cart.product.price * cart.quantity }元</td>
            <td align="center">26R</td>
            <td align="center"><a onclick="MyShowDiv('MyDiv','fade','${cart.product.id }')">删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
          </tr>
          <c:set var="money" value="${money+ cart.product.price * cart.quantity}"></c:set>
           </c:forEach>
          <tr height="70">
          	<td colspan="6" style="font-family:'Microsoft YaHei'; border-bottom:0;">
            	<label class="r_rad"></label><button onclick="ShowDiv('MyClear','fade')" class="r_txt">清空购物车</button>
                <span class="fr">商品总价：<b style="font-size:22px; color:#ff4e00;">￥${ money}</b></span>
            </td>
          </tr>
         
          <tr valign="top" height="150">
          	<td colspan="6" align="right">
            	<a href="Index.jsp"><img src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="${pageContext.request.contextPath}/AddOrderServlet?userId=${sessionScope.user.id }"><img src="images/buy2.gif" /></a>
            </td>
          </tr>
         </c:if>
        </table>
         
    </div>
	<!--End 第一步：查看购物车 End--> 
    
    
    <!--Begin 弹出层-删除商品 Begin-->
    <div id="fade" class="black_overlay"></div>
    <div id="MyDiv" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td>您确定要把该商品移除购物车吗？</td>
                  </tr>
                  <tr height="50" valign="bottom">
                    <td><a class="b_sure">确定</a><a href="#" class="b_buy">取消</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
        </div>
         <div id="fade" class="black_overlay"></div>
      <div id="MyClear" class="white_content">             
        <div class="white_d">
            <div class="notice_t">
                <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="images/close.gif" /></span>
            </div>
            <div class="notice_c">
           		
                <table border="0" align="center" style="font-size:16px;" cellspacing="0" cellpadding="0">
                  <tr valign="top">
                    <td>您确定要清空购物车吗？</td>
                  </tr>
                  <tr height="50" valign="bottom">
                    <td><a class="b_sure" id="clear_sure">确定</a><a href="#" class="b_buy">取消</a></td>
                  </tr>
                </table>
                    
            </div>
        </div>
    </div>    
    <!--End 弹出层-删除商品 End-->
    
    <!--Begin Footer Begin -->
   <jsp:include page="foot.jsp"></jsp:include>
    <!--End Footer End -->    
</div>
<script type="text/javascript">
	var jq = jQuery.noConflict();
	
	$(".car_ipt").blur(function(){
		var stock = parseInt($(this).siblings(":first").val());//库存
		
		var id = parseInt($(this).siblings(".product_Id").val());//商品id
		var val = parseInt($(this).val());
		if(val >= stock){
			val = stock;
			$(this).val(val);
			
		}else if(val <= 1){
			val = 1;
			$(this).val(val);
			
		}
		changNum(id,val);
	});
	$(".car_btn_2").click(function(){
		var stock = parseInt($(this).siblings(":first").val());//库存
		var id = parseInt($(this).siblings(".product_Id").val());//商品id
		var val =  parseInt($(this).parent().find(".car_ipt").val());
		val = val + 1;
		if(val > stock){
			val = stock;
    		$(this).parent().siblings(":first").text("存库不足");
    		return;
    	}else{
	    	$(this).parent().siblings(":first").text("");
	    	$(this).parent().find(".car_ipt").val(val);
    	}
		changNum(id,val);
	});
	$(".car_btn_1").click(function(){
		var stock = parseInt($(this).siblings(":first").val());//库存
		var id = parseInt($(this).siblings(".product_Id").val());//商品id
		var val =  parseInt($(this).parent().find(".car_ipt").val());
		$(this).parent().siblings(":first").text("");
		if(val== 1){    
			val=1; 
    	}else{    
    		val=val-1;    
    		$(this).parent().find(".car_ipt").val(val);
    	}
		changNum(id,val);
	});
	function changNum(id,val){
		window.location.href="${pageContext.request.contextPath}/ChangNumServlet?id="+id+"&buyNum="+val;
	}
	function deletePro(id){
		window.location.href="${pageContext.request.contextPath}/DeleteServlet?id="+id;
	}
	function clearCart(){
		window.location.href="${pageContext.request.contextPath}/ClearCarServlet";
	}
	function MyShowDiv(show_div,bg_div,id){
		document.getElementById(show_div).style.display='block';
		document.getElementById(bg_div).style.display='block' ;
		var bgdiv = document.getElementById(bg_div);
		bgdiv.style.width = document.body.scrollWidth;
		$("#"+bg_div).height($(document).height());
		$(".b_sure").attr("deletId",id);//给确定赋值一个属性，存储用户的id
	};
	//删除
	$(document).on("click",".b_sure",function(){
		//得到要删除商品的id
		var id = $(this).attr("deletId");
		deletePro(id);
	});
	//清空
	$(document).on("click","#clear_sure",function(){
		clearCart();
	});
	
</script>
</body>
</html>
