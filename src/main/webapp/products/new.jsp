
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>商品新規登録</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 40px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 300px;
            padding: 8px;
        }

        button {
            padding: 10px 25px;
            cursor: pointer;
        }

        .message {
            color: green;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>商品新規登録</h1>
    <% if (request.getAttribute("message") != null) { %>
        <p class="message">
            <%= request.getAttribute("message") %>
        </p>
    <% } %>
    <% if (request.getAttribute("error") != null) { %>
        <p class="error">
            <%= request.getAttribute("error") %>
        </p>
    <% } %>

    <form method="post"
          action="${pageContext.request.contextPath}/products">
        <div class="form-group">
            <label>商品名</label>
            <input type="text"
                   name="productName"
                   maxlength="100"
                   required>
        </div>
        <div class="form-group">
            <label>価格（円）</label>
            <input type="number"
                   name="price"
                   min="0"
                   required>
        </div>
        <div class="form-group">
            <label>開始日時</label>
            <input type="datetime-local"
                   name="startdate"
                   required>
        </div>
        <div class="form-group">
            <label>在庫数</label>
            <input type="number"
                   name="stock"
                   min="0"
                   required>
        </div>
        <button type="submit">商品を登録</button>
    </form>
</body>
</html>
