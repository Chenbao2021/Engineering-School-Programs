function tableau(){
    var myElement = document.getElementById("tableauDetaille");

    var tableau=    '<table border="8" id="table">'+
    '<th colspan="10">Voic les detailles concernent la puissance instantanée:</th>'+
    '<tr>'+
      '<td colspan="2">La courbe de 24h:</td><td ><img src="./images/detaille/ex_courbe.png"></td>'+
    '</tr> '+  
    '<tr>'+
        '<td colspan="2">Max:</td> <td>24kw</td>'+
   '</tr>'+
    '<tr>'+
        '<td colspan="2">Min:</td> <td>11kw</td>'+
    '</tr>'+
    '<tr>'+
        '<td colspan="2">moyenne:</td> <td>20kw</td>'+
      '</tr>'+
    '<tr>'+
        '<td colspan="2">étendue:</td> <td>13KW</td>'+
    '</tr>'+
    '<tr>'+
        '<td colspan="10"><button onclick="hide()">Fermer</button><button onclick="sauvegarder()">Sauvegarder</button></td>'+
    '</tr>'+
    '</table>';
    myElement.innerHTML=tableau;
}

function hide(){
    var myElement = document.getElementById("table");
    myElement.style.display="none";
}

function soir(){
    document.body.style.backgroundImage="url(images/background_soir.jpg)";
    document.getElementById("Bandeau").style.background="black";
}

function journee(){
    document.body.style.backgroundImage="url(images/background.jpg)";
    document.getElementById("Bandeau").style.background="white";
}

var x=0;
var y=0;
function displayParametres(){
    if(x%2==1){
        document.getElementById("parametre").style.display="none";
        x++;    
    }
    else{
        document.getElementById("parametre").style.display="initial";
        x++;
    }
}

function displayServices(){
    if(x%2==1){
        document.getElementById("detailleServices").style.display="none";
        x++;    
    }
    else{
        document.getElementById("detailleServices").style.display="initial";
        x++;
    }
}

function annonceoover(){
    document.getElementById("annonce").style.opacity=1;
}

function annoncemove(){
    document.getElementById("annonce").style.opacity=0;
}