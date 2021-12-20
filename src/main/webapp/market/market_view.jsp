<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/global_head.jsp" %>


 <body>
	<center>
	<div id="wrap">
		<%@ include file="../include/top.jsp" %>

		<img src="../images/market/sub_image.jpg" id="main_visual" />

		<div class="contents_box">
			<div class="left_contents">
				
				<%@ include file = "../include/market_leftmenu.jsp" %>
			</div>
			<div class="right_contents">

				<div class="top_title">
					<img src="../images/market/sub01_title.gif" alt="수아밀 제품 주문" class="con_title" />
					<p class="location"><img src="../images/center/house.gif" />&nbsp;&nbsp;열린장터&nbsp;>&nbsp;수아밀 제품 주문<p>
				</div>
				<div class="market_view_box">
					<div class="market_left">
						<img src="${ dto.img }" width="300px" alt="이미지 입니당" />
						<p class="plus_btn"></p>
					</div>
					<div class="market_right">
						<p class="m_title">${ dto.name }
						<p>- ${ dto.exp }</p>
						<ul class="m_list">
							<li>
								<dl>
									<dt>가격</dt>
									<dd class="p_style">${ dto.price }원</dd>
								</dl>
								<dl>
									<dt>적립금</dt>
									<dd>${ dto.point }원</dd>
								</dl>
								<dl>
									<dt>수량</dt>
									<dd><input type="number" name="count" value="1" class="n_box" /></dd>
								</dl>
								<div style="clear:both;"></div>
							</li>
						</ul>
						<p class="btn_box"><a href="../market/buy.do"><img src="../images/market/m_btn01.gif" alt="바로구매" /></a>&nbsp;&nbsp;<a href="../market/basket.do"><img src="../images/market/m_btn02.gif" alt="장바구니" /></a></p>
					</div>
				</div>
				<img src="${ dto.img }" width="750px" alt="이미지 입니당" />

			</div>
		</div>
		<%@ include file="../include/quick.jsp" %>
	</div>
	

	<%@ include file="../include/footer.jsp" %>
	</center>
 </body>
</html>