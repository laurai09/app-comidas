<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Login de Usuario</h2>
<form action="LoginServlet" method="post">
    Usuario:
    <input type="text" name="usuario">
    <br><br>
    Contraseña:
    <input type="password" name="password">
    <br><br>
    <button type="submit">Ingresar</button>
</form>
</body>
</html>