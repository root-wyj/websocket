var stompClient = null;

function onload() {
	$("#btn_name").click(sendName());
	$("#btn_msg").click(sendMsgToAll());
	
}

function connect() {
    var socket = new SockJS('/socketconnect');
    var userid = $("#name").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/message', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
        
        stompClient.subscribe('/user/' + userid + '/message',function(greeting){  
//            alert(JSON.parse(greeting.body).content);  
            showGreeting(JSON.parse(greeting.body).content);  
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function sendName() {
    stompClient.send("/socket/setName", {}, JSON.stringify({'name': $("#name").val()}));
    $("#name").prop("disabled", true);
}

function sendMsgToAll() {
	stompClient.send("/socket/sendMsgToAll",{},JSON.stringify({'message': $("#msg").val()}));
}

function showGreeting(message) {
    $("#content").append(message + "<br>");
}









