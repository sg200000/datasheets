function loadAjax(action){
    let url;
    if (action=="add"){
        const reference = document.getElementById("reference").value;
        const category = document.getElementById("category").value;
        const voltage = document.getElementById("voltage").value;
        const voltage_unit = document.getElementById("voltage_unit").value;
        const packaging = document.getElementById("packaging").value;
        const datasheet = document.getElementById("datasheet").value;
        url = "AdminServlet?reference="+reference+"&category="+category+"&voltage="+voltage+"&voltage_unit="+voltage_unit+"&packaging="+packaging+"&datasheet="+datasheet+"&action="+action;
    }
    else if (action=="remove"){
        const idRm = document.getElementById("idRm").value;
        alert(idRm);
        url = "AdminServlet?idRm="+idRm+"&action="+action;
    //    alert("we are here");
    }

    let request;
    if (window.XMLHttpRequest) {

        request = new XMLHttpRequest();

    } else if (window.ActiveXObject) {

        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    try{
        request.onreadystatechange = function (){
            if(request.readyState === 4 && request.status === 200){
                alert(request.responseText);

            }
        };
        request.open("GET",url,true);
        request.send();

    }catch(e){
        alert("Unable to connect server");
    }

}