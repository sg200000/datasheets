function loadAjax(){
    var component= document.getElementById("component").value;

    var url="hello-servlet?component="+component;
  //  alert(url);
/*
    if(window.XMLHttpRequest){

        request = new XMLHttpRequest();

    }
    else if(window.ActiveXObject){

        request = new ActiveXObject("Microsoft.XMLHTTP");
    }
*/
    try{
        request = new XMLHttpRequest()
        request.onreadystatechange= function (){
            var p =	document.getElementById("print");

            if(request.readyState ==1){
                var text = request.responseText;
                p.innerHTML="Please Wait.....";
                console.log("1");
            }

            if(request.readyState ==2){
                var text = request.responseText;
                console.log("2");

            }
            if(request.readyState ==3){
                var text = request.responseText;
                console.log("3");

            }
            if(request.readyState == 4 && request.status == 200){
                var text = request.responseText;
                p.innerText = " Request Processed  "+text;
            }
        };
        request.open("GET",url,true);
        request.send();

    }catch(e){
        alert("Unable to connect server");
    }

}

function sendInfo(){
    var p =	document.getElementById("print");

    if(request.readyState ==1){
        var text = request.responseText;
        p.innerHTML="Please Wait.....";
        console.log("1");
    }

    if(request.readyState ==2){
        var text = request.responseText;
        console.log("2");

    }
    if(request.readyState ==3){
        var text = request.responseText;
        console.log("3");

    }
    if(request.readyState ==4 && request.status == 200){
        var text = request.responseText;
        p.innerHTML=" Request Processed  "+text;
        alert("Success");
    }
}