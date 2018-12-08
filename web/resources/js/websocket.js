let websocket = null;

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

function onOpen(e) {
    console.log("WebSocket - onOpen()");
    websocket.send($('#person-username'.text()));
}

function onClose(e) {
    console.log("WebSocket - onClose()");
}

function onMessage(message) { // print the received message
    writeToLog(message.data);
}

function onError(e) {
    console.log("WebSocket - onError()");
}

function writeToLog(newText) {
    $('.person-log-history').html(newText);
}