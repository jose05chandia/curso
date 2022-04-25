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
async function createUser(){
let datos={};
datos.name=document.getElementById("name").value;
datos.lastname=document.getElementById("lastname").value;
datos.email=document.getElementById("email").value;
datos.password=document.getElementById("password").value;
let repeat=document.getElementById("repeat").value;

if(repeat!=datos.password){
    alert("La contraseña es diferente");
    return;
}
    const request = await fetch('create', {
        method: 'POST',
        headers: getHeaders(),
         body: JSON.stringify(datos)
        });

        alert("cuenta creada");
        window.location.href="login.html";

}
