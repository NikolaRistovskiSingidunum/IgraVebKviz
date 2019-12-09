
function solveColumn(event)
{
    alert(event.keyCode);
}
function mount_level_1()
{

    
    var container = document.getElementById("level");
    container.innerHTML = "";
    container.removeAttribute("style");
    container.classList.add("grid");
    
    
    //var html = $.parseHTML("<p>Koji Kuraca</p><p>Koji Kuraca SDASDas</p>"); 
    var html = "\
    <button id='A1' class='A1 polje_stil' onclick=openField('A1') > A1 </button>\
    <button id='A2' class='A2 polje_stil' onclick=openField('A2')>A2</button> \
    <button id='A3' class='A3 polje_stil' onclick=openField('A3') > A3</button>\
    <button id='A4' class='A4 polje_stil' onclick=openField('A4') > A3</button>\
    <input id='AF' class='AF fokus' ></input>\
    <button id='B1' class='B1 polje_stil' onclick=openField('B1') > B1 </button>\
    <button id='B2' class='B2 polje_stil' onclick=openField('B2')>B2</button> \
    <button id='B3' class='B3 polje_stil' onclick=openField('B3') > B3</button>\
    <button id='B4' class='B4 polje_stil' onclick=openField('B4') > B3</button>\
    <input id='BF' class='BF fokus'/>\
    <button id='C1' class='C1 polje_stil' onclick=openField('C1') > C1 </button>\
    <button id='C2' class='C2 polje_stil' onclick=openField('C2')>C2</button> \
    <button id='C3' class='C3 polje_stil' onclick=openField('C3') > C3</button>\
    <button id='C4' class='C4 polje_stil' onclick=openField('C4') > C4</button>\
    <input id='CF' class='CF fokus'/>\
    <button id='D1' class='D1 polje_stil' onclick=openField('D1') > D1 </button>\
    <button id='D2' class='D2 polje_stil' onclick=openField('D2')>D2</button> \
    <button id='D3' class='D3 polje_stil' onclick=openField('D3') > D3</button>\
    <button id='D4' class='D4 polje_stil' onclick=openField('D4') > D3</button>\
    <input id='DF' class='DF fokus'/>\
    <input id='F1' class='F1 fokus' />\
    " ;
//            <button id="A2" class="A2 polje_stil" onclick="openField('A2')"> A2</button>
//            <button id="A3" class="A3 polje_stil" onclick="openField('A3')" > A3</button>
//            <button id="A4" class="A4 polje_stil" onclick="openField('A4')" > A4</button>
//            <input id="AF" class="AF fokus"/>
//            <button id="B1" class="B1" onclick="openField('B1')" > B1</button>
//            <button id="B2" class="B2" onclick="openField('B2')" > B2</button>
//            <button id="B3" class="B3" onclick="openField('B3')" > B3</button>
//            <button id="B4" class="B4"onclick="openField('B4')" > B4</button>
//            <input id="BF" class="BF fokus" />
//
//            <input class="F1 fokus" />
//
//            <button id="C1" class="C1" onclick="openField('C1')" > C1</button>
//            <button id="C2" class="C2" onclick="openField('C2')" > C2</button>
//            <button id="C3" class="C3" onclick="openField('C3')" > C3</button>
//            <button id="C4" class="C4" onclick="openField('C4')" > C4</button>
//            <input class="CF fokus" />
//            
//            <button id="D1" class="D1" onclick="openField('D1')" > D1</button>
//            <button id="D2" class="D2" onclick="openField('D2')" > D2</button>
//            <button id="D3" class="D3" onclick="openField('D3')" > D3</button>
//            <button id="D4" class="D4" onclick="openField('D4')" > D4</button>
//            <input id="DF" class="DF fokus" />" 
    //container.appendChild(html);
    $("#level").append(html);

//    create_element("A1", "A1", container,"button");
//    create_element("A2", "A2", container,"button");
//    create_element("A3", "A3", container,"button");
//    create_element("A4", "A4", container,"button");
//    create_element("AF", "AF", container,"input");
//    
//
//    create_element("B1", "B1", container,"button");
//    create_element("B2", "B2", container,"button");
//    create_element("B3", "B3", container,"button");
//    create_element("B4", "B4", container,"button");
//    create_element("BF", "BF", container,"input");
//    
//    create_element("C1", "C1", container,"button");
//    create_element("C2", "C2", container,"button");
//    create_element("C3", "C3", container,"button");
//    create_element("C4", "C4", container,"button");
//    create_element("CF", "CF", container,"input");
//    
//    create_element("D1", "D1", container,"button");
//    create_element("D2", "D2", container,"button");
//    create_element("D3", "D3", container,"button");
//    create_element("D4", "D4", container,"button");
//    create_element("DF", "DF", container,"input");
//
//    create_element("F1", "F1", container,"input");
    initSolutions();
}
//function create_element(name, css_klass, container, elm_klass)
//{
//    var e = document.createElement(elm_klass);
//    e.innerHTML = name;
//    e.classList.add(css_klass);
//    //e.addEventListener("onclick",openField(name));
//    e.setAttribute("onclick","openField("+name+")");
//    //e.onclick=openField(name);
//    container.appendChild(e);
//    
//}


function openField(position) {
  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", "http://localhost:8084/LepaRec/post/PlayerController/openField", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("open="+position); 
    
    
}
//incijalizuje resenje kolona i konacno resenje
function initSolutions()
{
    initOneSolution("AF");
    initOneSolution("BF");
    initOneSolution("CF");
    initOneSolution("DF");
    initOneSolution("F1");
    
    
    
}
function initOneSolution(id)
{
        $("#"+id).keyup(function(event) {
    if (event.keyCode === 13) {
        checkSolution(id,$("#"+id).val() );
        //$("#" + id).
       
        
    }
});
}

function checkSolution(id,val)
{
    alert(id+"   " +val);
    var classPositin = id;
    var playerSolverColor ="player1Color";
    $("#" + id).replaceWith("<button class='"+id +" "+ playerSolverColor +"'> Mozda sa resen </button>")
}
function nullAllOtherSolutions(beside)
{
    //var solutions = ["AF", "BF",]
}