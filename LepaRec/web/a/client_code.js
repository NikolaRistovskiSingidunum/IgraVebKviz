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
function start_communication()
{
    window.setInterval(test_post, 100);
}

function test_post()
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
    }
          
  };
  xhttp.open("POST", "http://localhost:8084/LepaRec/test", true);

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("fname=Henry&lname=Ford&wantsToStart=true"); 
    
    
}
