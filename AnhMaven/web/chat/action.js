/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var wsUri = "ws://" + document.location.host + document.location.pathname + "chatEP";
var websocket = new WebSocket(wsUri);
//Define listeners for open, message (received) and error events
websocket.onopen = function (event) {
    onOpen(event);
};
websocket.onmessage = function (event) {
    onMessage(event);
};
websocket.onerror = function (event) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + event.data);
};
function onMessage(event) {
    $('#chatOutput').append(event.data + '<br>');
}
$(document).ready(function () {
    $('#sendButton').click(function () {
        sendMsg($('#username').val() + ": " + $('#message').val());
    });
});
function sendMsg(msg) {
    console.log('Sending message: ' + msg);
    websocket.send(msg);
}
// For testing purposes
function onOpen(event) {
    writeToScreen('Connected to ' + wsUri);
}
function writeToScreen(message) {
    $('#chatOutput').append(message + '<br>');
}