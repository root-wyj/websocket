var stompClient = null;

function onload() {
	$("#btn_name").click(connect());
	$("#btn_msg").click(sendMsgToAll());
	
}

function connect() {
    var socket = new SockJS('/socketconnect');
    var userid = $("#name").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/chat/message', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        
        stompClient.subscribe('/user/' + userid + '/message',function(greeting){  
//            alert(JSON.parse(greeting.body).content);  
            showGreeting(JSON.parse(greeting.body).content);  
        });

        sendName();
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}


function sendName() {
    stompClient.send("/socket/signIn", {name:$("#name").val()}, JSON.stringify({'content': $("#name").val()}));
    $("#name").prop("disabled", true);
}

function sendMsgToAll() {
	stompClient.send("/socket/chat",{name:$("#name").val()},JSON.stringify({'content': $("#msg").val()}));
}

function showGreeting(message) {
    $("#content").append(message + "<br>");
}









