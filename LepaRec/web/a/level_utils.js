

function mount_level_1()
{


    var container = document.getElementById("level");
    container.innerHTML = "";
    container.removeAttribute("style");
    container.classList.add("grid");

    create_element("A1", "A1", container,"button");
    create_element("A2", "A2", container,"button");
    create_element("A3", "A3", container,"button");
    create_element("A4", "A4", container,"button");
    create_element("AF", "AF", container,"input");
    

    create_element("B1", "B1", container,"button");
    create_element("B2", "B2", container,"button");
    create_element("B3", "B3", container,"button");
    create_element("B4", "B4", container,"button");
    create_element("BF", "BF", container,"input");
    
    create_element("C1", "C1", container,"button");
    create_element("C2", "C2", container,"button");
    create_element("C3", "C3", container,"button");
    create_element("C4", "C4", container,"button");
    create_element("CF", "CF", container,"input");
    
    create_element("D1", "D1", container,"button");
    create_element("D2", "D2", container,"button");
    create_element("D3", "D3", container,"button");
    create_element("D4", "D4", container,"button");
    create_element("DF", "DF", container,"input");

    create_element("F1", "F1", container,"input");

}
function create_element(name, css_klass, container, elm_klass)
{
    var e = document.createElement(elm_klass);
    e.innerHTML = name;
    e.classList.add(css_klass);
    container.appendChild(e);
    
}


function openField(position) {
  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://localhost:8084/LepaRec/post/PlayerController/openField", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("open="+position); 
    
    
}