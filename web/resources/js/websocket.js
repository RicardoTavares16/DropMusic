let websocket = null;

window.onload = function() {
    connect('ws://' + window.location.host + '/DropMusic/ws');
    console.log("Load");
}

function connect(host) {
    console.log("host:" + host);
    if('WebSocket' in window) {
        websocket = new WebSocket(host);
    } else if('MozWebSocket' in window) {
        websocket = new MozWebSocket(host);
    } else {
        console.log("Erro");
        return;
    }

    console.log("WebSocket Connected");
    websocket.onopen = onOpen;
    websocket.onclose = onClose;
    websocket.onerror = onError;
}

function onOpen(ev) {
    console.log("WebSocket - onOpen()");
    websocket.send($('#person-username'.text()));
}

function onClose(ev) {
    console.log("WebSocket - onClose()");
}

function onError(ev) {
    console.log("WebSocket - onError()");
}

function writeToLog(newText) {
    $('.person-log-history').html(newText);
}