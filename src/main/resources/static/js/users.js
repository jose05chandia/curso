// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#dataTable').DataTable();
});

async function loadUsers(){
    const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });

    const users = await request.json();
    let  usersComplete="";
    for(let user of users){
        //console.log(users);
        usersComplete+="<tr><td>"+user.id+"</td><td>"+user.name+" "+user.lastname+"</td><td>Edinburgh</td> <td>61</td><td></td></tr>";
    }
    document.querySelector("#users tbody").outerHTML=usersComplete;
}