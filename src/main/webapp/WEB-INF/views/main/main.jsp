<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- <h1>일단 해당 페이지의 모든 요소는 goods기능에서 데이터를 받아와서 출력하므로, 전부 지웠음.</h1> -->


<div id="ad_main_banner">
	<ul class="bjqs">	 	
	  <li><img width="775" height="145" src="${contextPath}/resources/image/main_banner01.jpg" ></li>
		<li><img width="775" height="145" src="${contextPath}/resources/image/main_banner02.jpg" ></li>
		<li><img width="775" height="145" src="${contextPath}/resources/image/main_banner03.jpg"></li> 
	</ul>
</div>
<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>인기상품</h3>
	<c:forEach var="item" items="${goodsMap.bestgoods}">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<%-- <img class="link"  src="${contextPath}/resources/image/1px.gif"> --%>

				<img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_image_fileName}">

				<div class="title">${item.goods_name }</div>
				<div class="price">
					<fmt:formatNumber value="${item.goods_price}" type="number"
						var="goods_price" />
					${goods_price}원
				</div>
		</div>
		</a>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>
<div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117" src="${contextPath}/resources/image/sub_banner01.jpg" >
</div>




<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>신상품</h3>
	<c:forEach var="item" items="${goodsMap.newgoods }">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<%-- <img class="link"  src="${contextPath}/resources/image/1px.gif">  --%>

				<img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_image_fileName}">
				<div class="title">${item.goods_name }</div>
				<div class="price">
					<fmt:formatNumber value="${item.goods_price}" type="number"
						var="goods_price" />
					${goods_price}원
				</div>
		</div>
		</a>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>

<div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117"  src="${contextPath}/resources/image/sub_banner02.jpg" >
</div>


<div class="main_book">
	<c:set var="goods_count" value="0" />
	<h3>추천상품</h3>
	<c:forEach var="item" items="${goodsMap.recommendgoods }">
		<c:set var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a
				href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
				<%-- <img class="link"  src="${contextPath}/resources/image/1px.gif"> --%>

				<img width="121" height="154"
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_image_fileName}">
				<div class="title">${item.goods_name }</div>
				<div class="price">
					<fmt:formatNumber value="${item.goods_price}" type="number"
						var="goods_price" />
					${goods_price}원
				</div>
		</div>
		</a>
		<c:if test="${goods_count==15   }">
			<div class="book">
				<font size=20> <a href="#">more</a></font>
			</div>
		</c:if>
	</c:forEach>
</div>
