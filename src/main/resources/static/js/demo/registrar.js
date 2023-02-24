// Call the dataTables jQuery plugin
$(document).ready(function() {
    //nada por ahora
});

async function registrarUser() {
    let userData = {};
    userData.nombre = document.getElementById("txtName").value;
    userData.apellido = document.getElementById("txtLastName").value;
    userData.correo = document.getElementById("txtEmail").value;
    userData.password = document.getElementById("txtPassword").value;

    let repetirPassword = document.getElementById("txtRepeatPassword").value;

    if (userData.password != repetirPassword) {
        alert("Las contraseñas no coinciden");
        return;//se sale de la función
    }
    const request = await fetch('api/users', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    });

}
function limpiarFormulario() {
    document.getElementById("userform").reset();
}
function limpiar() {
    alert("Registro exitoso");
    document.addEventListener('DOMContentLoaded', function () {
        let formulario = document.getElementById('userform');
        formulario.addEventListener('submit', function () {
            formulario.reset();
        });
    });
}