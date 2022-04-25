// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
    cargarMailUser();
  $('#dataTable').DataTable();
});

function cargarMailUser(){
document.getElementById("mailUser").outerHTML=localStorage.email;
}
function getHeaders(){
    return {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
             'Authorization':localStorage.token
           };
}
async function loadUsers(){

    const request = await fetch('users', {
    method: 'GET',
    headers: getHeaders()
    });

    const users = await request.json();
    let  usersComplete="";
    for(let user of users){
    let button='<a href="#" onclick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
        //console.log(users);
        usersComplete+="<tr><td>"+user.id+"</td><td>"+user.name+" "+user.lastname+"</td><td>"+user.email+"</td> <td>"+user.phone+"</td><td>"+button+"</td></tr>";
    }
    document.querySelector("#users tbody").outerHTML=usersComplete;
}

async function deleteUser(id){
    if(!confirm("¿Desea eliminar?")){
        return;
    }
    const request = await fetch('delete/'+id, {
        method: 'DELETE',
        headers: getHeaders()
    });
        location.reload();
}