function loadAjax(){
    const component = document.getElementById("component").value;

    const url = "hello-servlet?component=" + component;

    let request;
    if (window.XMLHttpRequest) {

        request = new XMLHttpRequest();

    } else if (window.ActiveXObject) {

        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    try{
      //  request = new XMLHttpRequest()
        request.onreadystatechange = function (){
            console.log("hi");
            const dataDisplay = document.getElementById("data");
            if(request.readyState === 4 && request.status === 200){
                console.log("4");
              //  console.log(request.responseText);
                const result = request.response;
                dataDisplay.innerHTML = "";
                for (let record in result){
                    dataDisplay.innerHTML += '<tr>\
                    <td>'+result[record].id+'</td> \
                    <td>'+result[record].reference+'</td> \
                    <td>'+result[record].voltage+'</td> \
                    <td>'+result[record].voltage_unit+'</td> \
                    <td>'+result[record].category+'</td> \
                    <td>'+result[record].packaging+'</td> \
                    <td><a href='+result[record].datasheet+'>Dowload</a></td></tr>';
                }
            }
        };
        request.open("GET",url,true);
        request.responseType = "json";
        request.send();

    }catch(e){
        alert("Unable to connect server");
    }

}