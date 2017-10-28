// var ws0 = new WebSocket("ws://127.0.0.1:8000/");
// var ws1 = new WebSocket("ws://127.0.0.1:8001/");
// var ws2 = new WebSocket("ws://127.0.0.1:8002/");

var MIN = 0;
var MAX = 0;
var ws = [];
var maximum = 1000;



// ws = new WebSocket("ws://127.0.0.1:8000");
// var c1 = 0;
// var c2 = 0;
// ws.onopen = function() {
// 	console.log("Opened!");
// 	timeStart = performance.now();
// 	while (c1 < maximum) {
// 		++c1;
// 		ws.send("Hello Server " + c1);
// 	}
// };

// ws.onmessage = function (evt) {
// 	console.log("Message: " + evt.data);
// 	++c2;
// 	if (c2 === maximum) {
// 		timeEnd = performance.now();
// 		console.log("diff = " + (timeEnd - timeStart));
// 	}
// };

// ws.onclose = function() {
// 	console.log("Closed!");
// };

// ws.onerror = function(err) {
// 	console.log("Error: " + err);
// };

for (var i = 0; i <=2; ++i) {
	var ws = new WebSocket("ws://127.0.0.1:800" + i + "/");
	var c1 = 0;
	var c2 = 0;
	ws.onopen = function() {
		console.log("Opened!");
		timeStart = performance.now();
		while (c1 < maximum) {
			++c1;
			ws.send("Hello Server " + c1);
		}
	};

	ws.onmessage = function (evt) {
		console.log("Message: " + evt.data);
		++c2;
		if (c2 === maximum) {
			timeEnd = performance.now();
			console.log("diff = " + (timeEnd - timeStart));
		}
	};

	ws.onclose = function() {
		console.log("Closed!");
	};

	ws.onerror = function(err) {
		console.log("Error: " + err);
	};	
}

// for (var i = MIN; i <= MAX; ++i) {
// 	ws[i] = new WebSocket("ws://127.0.0.1:800" + i + "/");
// 	c1 = 0;
// 	c2 = 0;
// 	ws[i].onopen = function() {
// 		console.log("Opened!");
// 		timeStart = performance.now();
// 		while (c1 < maximum) {
// 			++c1;
// 			console.log("test");
// 			ws[i].send("Hello Server " + c1);
// 		}
// 	};

// 	ws[i].onmessage = function (evt) {
// 		console.log("Message: " + evt.data);
// 		++c2;
// 		if (c2 === maximum) {
// 			timeEnd = performance.now();
// 			console.log("diff = " + (timeEnd - timeStart));
// 		}
// 	};

// 	ws[i].onclose = function() {
// 		console.log("Closed!");
// 	};

// 	ws[i].onerror = function(err) {
// 		console.log("Error: " + err);
// 	};
// }




