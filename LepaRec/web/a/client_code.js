function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     //document.getElementById("demo").innerHTML = Object.keys(JSON.parse(this.responseText));
        document.getElementById("demo").innerHTML = "";
        
        var e = document.createElement("p");
        e.innerHTML = "player1" + JSON.parse(this.responseText).player1;
        var e1 = document.createElement("p");
        e1.innerHTML = "player2" + JSON.parse(this.responseText).player2;
        document.getElementById("demo").appendChild(e);
        document.getElementById("demo").appendChild(e1);
    }
          
  };
  xhttp.open("POST", "http://localhost:8084/LepaRec/test", true);
  //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  //xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
//  xhttp.setRequestHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//    xhttp.setRequestHeader("Origin", "*");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("fname=Henry&lname=Ford&wantsToStart=true"); 
    
    
}
function open_main_line()
{
    window.setInterval(main_line, 1000);
}

function main_line()
{
    var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     //document.getElementById("demo").innerHTML = Object.keys(JSON.parse(this.responseText));
        document.getElementById("demo").innerHTML = "";
        
        var e = document.createElement("p");
        e.innerHTML = "player1" + JSON.parse(this.responseText).player1;
        var e1 = document.createElement("p");
        e1.innerHTML = "player2" + JSON.parse(this.responseText).player2;
        
        var t1 = document.createElement("p");
        t1.innerHTML = "player1 time " + JSON.parse(this.responseText).time1;
        
        var t2 = document.createElement("p");
        t2.innerHTML = "player2 time " + JSON.parse(this.responseText).time2;
        
        
        document.getElementById("demo").appendChild(e);
        document.getElementById("demo").appendChild(e1);
        
        document.getElementById("demo").appendChild(t1);
        document.getElementById("demo").appendChild(t2);
        
        document.getElementById("A1").innerHTML = JSON.parse(this.responseText).A1;
        document.getElementById("A2").innerHTML = JSON.parse(this.responseText).A2;
        document.getElementById("A3").innerHTML = JSON.parse(this.responseText).A3;
        document.getElementById("A4").innerHTML = JSON.parse(this.responseText).A4;
        
        document.getElementById("B1").innerHTML = JSON.parse(this.responseText).B1;
        document.getElementById("B2").innerHTML = JSON.parse(this.responseText).B2;
        document.getElementById("B3").innerHTML = JSON.parse(this.responseText).B3;
        document.getElementById("B4").innerHTML = JSON.parse(this.responseText).B4;

        document.getElementById("C1").innerHTML = JSON.parse(this.responseText).C1;
        document.getElementById("C2").innerHTML = JSON.parse(this.responseText).C2;
        document.getElementById("C3").innerHTML = JSON.parse(this.responseText).C3;
        document.getElementById("C4").innerHTML = JSON.parse(this.responseText).C4;

        document.getElementById("D1").innerHTML = JSON.parse(this.responseText).D1;
        document.getElementById("D2").innerHTML = JSON.parse(this.responseText).D2;
        document.getElementById("D3").innerHTML = JSON.parse(this.responseText).D3;
        document.getElementById("D4").innerHTML = JSON.parse(this.responseText).D4;

    }
          
  };
  xhttp.open("POST", "http://localhost:8084/LepaRec/post/PlayerController/mainLine", true);

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("fname=Henry&lname=Ford&wantsToStart=true"); 
    
    
}
function test_controller()
{
    var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     //document.getElementById("demo").innerHTML = Object.keys(JSON.parse(this.responseText));
        document.getElementById("demo").innerHTML = this.response;
        
    }
          
  };
  xhttp.open("POST", "http://localhost:8084/LepaRec/post/PlayerController/startGame", true);

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("fname=Henry&lname=Ford&wantsToStart=true"); 
    
    
}