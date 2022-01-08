<%--
  Created by IntelliJ IDEA.
  User: Lila
  Date: 08/01/2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Les températures</h1>
    <p>Température en France :${temperatureFR}</p>
    <p>Hashcode:${hashCodeFR} </p>
    <br>
    <p>Température en Allemagne :${temperatureDE}</p>
    <p>Hashcode:${hashCodeDE} </p>
    <br>
    <p>Température en Angleterre :${temperatureEN}</p>
    <p>Hashcode:${hashCodeEN} </p>

    <button onClick="window.location.reload();">Rafraichir</button>
</body>
</html>
