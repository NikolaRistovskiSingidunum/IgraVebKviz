function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("demo").innerHTML = this.responseText;
        //document.cookie = this.responseText; 
    }
          
  };
  xhttp.open("POST", "http://localhost:4000/", true);
  //xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  //xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
//  xhttp.setRequestHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//    xhttp.setRequestHeader("Origin", "*");
  xhttp.send("{fname:Henry,lname:Ford," +document.cookie +"}"); 
    
    
}