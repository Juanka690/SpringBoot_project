// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsers();

  $('#users').DataTable();
});

async function cargarUsers() {
  const request = await fetch('api/users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

//let botonEliminar = '<button type="button" class="btn btn-danger" onclick="deleteUser('+usuario.id+')">Eliminar</button>';
  let listadoHtml = '';
  for (let usuario of usuarios) {
    let botonEliminar='<a href=\"#" onClick="deleteUser('+usuario.id+')" class=\"btn btn-danger btn-circle\"><i class=\"fas fa-trash\"></i></a>';
    //let botonEliminar='<a href=\"# onClick="deleteUser(666)" class=\"btn btn-danger btn-circle\"><i class=\"fas fa-trash\"></i></a>';
    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'
        +usuario.telefono+'</td><td>'+usuario.correo
        +'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#users tbody').outerHTML = listadoHtml;
}

async function deleteUser(id) {
  alert("Seleccionó usuario:"+id);

  if(!confirm("¿Está seguro de eliminar el usuario?")){
    return;
  }

  const request = await fetch('api/del_user/'+id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  location.reload();//actualizamos la página luego de eliminar el usuario
}