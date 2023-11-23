<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>




function fn_member_detail(order_id){
	//alert(order_id);
	var frm_delivery_list=document.frm_delivery_list;
	

	var formObj=document.createElement("form");
	var i_order_id = document.createElement("input");
	
	i_order_id.name="order_id";
	i_order_id.value=order_id;
	
    formObj.appendChild(i_order_id);
    document.body.appendChild(formObj); 
    formObj.method="post";
    formObj.action="/aboutcat/admin/member/memberDetail.do";
    formObj.submit();
	
}



</script>
</head>
<body>
	<H3>회원 조회</H3>
	
<div class="clear"></div>
<table class="list_view">
		<tbody align=center >
			<tr align=center bgcolor="#ffcc00">
				<td class="fixed" >회원아이디</td>
				<td class="fixed">회원이름</td>
				<td>휴대폰번호</td>
				<td>주소</td>
				<td>가입일</td>
				<td>탈퇴여부</td>
			</tr>
   <c:choose>
     <c:when test="${empty membersList}">			
			<tr>
		       <td colspan=5 class="fixed">
				  <strong>조회된 회원이 없습니다.</strong>
			   </td>
		     </tr>
	 </c:when>
	 <c:otherwise>
	     <c:forEach var="item" items="${membersList}" varStatus="item_num">
	            <tr >       
					<td width=10%>
					
					  <a href="${pageContext.request.contextPath}/admin/member/memberDetail.do?member_id=${item.member_id}">
					     <strong>${item.member_id}</strong>
					  </a>
					</td>
					<td width=10%>
					  <strong>${item.member_name}</strong><br>
					</td>
					<td width=10% >
					  <strong>${item.phone}</strong><br>
					</td>
					<td width=50%>
					  <strong>${item.address1_new}</strong><br>
					  <strong>${item.address2}</strong><br>
					</td>
					<td width=10%>
					   <c:set var="join_date" value="${item.member_add_date}" />
				    </td>
				    <td width=10%>
				       <c:choose>
				         <c:when test="${item.del_yn==0 }">
				           <strong>활동중</strong>  
				         </c:when>
				         <c:otherwise>
				           <strong>탈퇴</strong>
				         </c:otherwise>
				       </c:choose>
				    </td>
				</tr>
		</c:forEach>
	</c:otherwise>
  </c:choose>	
         <tr>
  <!-- 이 아래부터는 페이징부분 -->
             <td colspan=8 class="fixed">
                 <c:forEach   var="page" begin="1" end="10" step="1" >
                 <!--  section를 section으로 수정  -->
		         <c:if test="${section >1 && page==1 }">
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp;pre &nbsp;</a>
		         </c:if>
		         
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section}&pageNum=${page}">${(section-1)*10 +page } </a>
		        
		         <c:if test="${page ==10 }">
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section+1}&pageNum=${section*10+1}">&nbsp; next</a>
		         </c:if> 
	      		</c:forEach> 
           </td>
        </tr>  		   
		</tbody>
	</table>
  </form>   	
	<div class="clear"></div>
<c:choose>
 <c:when test="${not empty order_goods_list }">	
   <DIV id="page_wrap">
		 <c:forEach   var="page" begin="1" end="10" step="1" >
		         <c:if test="${section >1 && page==1 }">
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section-1}&pageNum=${(section-1)*10 +1 }">&nbsp;pre &nbsp;</a>
		         </c:if>
		         
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section}&pageNum=${page}">${(section-1)*10 +page } </a>
		         
		         <c:if test="${page ==10 }">
		          <a href="${pageContext.request.contextPath}/admin/member/adminMemberMain.do?section=${section+1}&pageNum=${section*10+1}">&nbsp; next</a>
		         </c:if> 
	      </c:forEach> 
	</DIV>	
 </c:when>
</c:choose>
</body>
</html>

