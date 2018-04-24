<html>

<head>
    <script type="text/javascript" src="main.js"></script>
</head>

<body onload="connect()">
    <br/>
    <form action="/execute" method="POST">
        Command: <input id="command" type="text" name="command">
        <input type="submit" value="Execute" />
    </form>
    <br/>
    <button onclick="executeXMLHttpRequest()">Execute using XMLHttpRequest</button>
    <br/>
    <br/>
    <button id="webSocket" disabled="true" onclick="executeWebSocket()">Execute using WebSocket</button>
    <br/>
    <br/>
    <textarea id="result" rows="10" cols="50">${result}</textarea>
</body>

</html>