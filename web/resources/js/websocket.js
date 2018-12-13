var websocket = null;

window.onload = function() {
    connect('ws://' + window.location.host + '/DropMusic/ws');
    console.log("Load");
}

function connect(host) {
    console.log("host:" + host);
    if ('WebSocket' in window)
        websocket = new WebSocket(host);
    else if ('MozWebSocket' in window)
        websocket = new MozWebSocket(host);
    else {
        console.log('Get a real browser which supports WebSocket.');
        return;
    }

    websocket.onopen    = onOpen; // set the 4 event listeners below
    websocket.onclose   = onClose;
    websocket.onmessage = onMessage;
    websocket.onerror   = onError;
}

function onOpen(event) {
    console.log("Websocket onOpen() foi chamada!");
    websocket.send($('#eleitor-nome').text());
}

function onClose(event) {
    console.log("Websocket onClose() foi chamada!");
    document.getElementById('chat').onkeydown = null;
}

function onMessage(message) { // print the received message
    console.log("Websocket onMessage() foi chamada!");
    console.log(message);
}

function onError(event) {
    document.getElementById('chat').onkeydown = null;
}

