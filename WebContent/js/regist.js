    function changeImg(){
    	var img = document.getElementById("ValiImg");
    	alert("${pageContext.request.contextPath }/ValiImg?time="+new Date().getTime())
    	img.setAttribute("src","${pageContext.request.contextPath }/ValiImg?time="+new Date().getTime());
    	
    }