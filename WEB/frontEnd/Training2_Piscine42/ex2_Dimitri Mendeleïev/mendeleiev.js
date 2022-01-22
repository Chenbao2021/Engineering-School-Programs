function changeParent(x){
    var y=x.cloneNode(true);
    y.style.backgroundColor="red";
	var frag = document.getElementById("affichage");
    frag.innerHTML="";
	//将frag的父节点由storagePlace改为container
    frag.appendChild(y);
}
const btn = document.querySelector('td');
btn.onmouseover = function(x) {
    const rndCol = 'rgb(' + random(255) + ',' + random(255) + ',' + random(255) + ')';
    document.body.style.backgroundColor = rndCol;
  }

