function executeXMLHttpRequest() {
    var http = new XMLHttpRequest();
    var url = "/executeByXMLHttpRequest";
    var command = document.getElementById('command').value
    var params = 'command=' + command
    http.open("POST", url, true);

    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    http.onreadystatechange = function() { //Call a function when the state changes.
        if (http.readyState == 4 && http.status == 200) {
            document.getElementById("result").value = http.responseText
        }
    }
    http.send(params);
}

var webSocket;

function connect() {
    // open the connection if one does not exist
    if (webSocket !== undefined &&
        webSocket.readyState !== WebSocket.CLOSED) {
        return;
    }
    // Create a websocket
    webSocket = new WebSocket("ws://localhost:8080/executeByWebSocket");

    webSocket.onopen = function(event) {
        document.getElementById("webSocket").disabled = false;
    };

    webSocket.onmessage = function(event) {
        document.getElementById("result").value = event.data;
    };

}

function executeWebSocket() {
    connect();
    var command = document.getElementById("command").value;
    webSocket.send(command);
}