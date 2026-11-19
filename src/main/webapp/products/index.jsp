<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品マスタ管理</title>
</head>
<body>
    <h1>商品マスタ管理</h1>
	<p>webapp/products/index.jsp</p>
	<table border="1">
	    <tr>
	        <th>商品ID</th>
	        <th>商品名</th>
	        <th>価格</th>
			<th>開始日時</th>
	        <th>在庫数</th>
			<th>説明</th>
		</tr>
		<c:forEach var="product" items="${products}">
		    <tr>
		        <td><c:out value="${product.id}"/></td>
		        <td><c:out value="${product.productName}"/></td>
		        <td><c:out value="${product.price}"/></td>
		        <td><c:out value="${product.startdate}"/></td>
		        <td><c:out value="${product.stock}"/></td>
		    </tr>
		</c:forEach>
	</table>
</body>
</html>
