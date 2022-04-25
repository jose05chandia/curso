// Call the dataTables jQuery plugin
$(document).ready(function() {

});
function getHeaders(){
    return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Authorization':localStorage.token
           };
}
async function login(){
let datos={};
datos.email=document.getElementById("email").value;
datos.password=document.getElementById("password").value;


    const request = await fetch('login', {
        method: 'POST',
        headers: getHeaders(),
         body: JSON.stringify(datos)
        });

        const response = await request.text();
        if(response!="fail"){
            localStorage.token=response;
            localStorage.email=datos.email;
            window.location.href="users.html";
        }else{
            alert("no log");
        }
}
