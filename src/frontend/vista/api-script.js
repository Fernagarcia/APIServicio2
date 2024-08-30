document.getElementById("dataForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar recarga de la página

    const minPuntos = document.getElementById("minPuntos").value;
    const minDonacionesUltMes = document.getElementById("minDonaciones").value;
    const cantidadMaxADevolver = document.getElementById("cantColaboradores").value;

    fetch('http://localhost:8080/colaborador', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                    minPuntos: minPuntos,
                    minDonacionUltMes: minDonacionesUltMes,
                    cantidadMaxADevolver: cantidadMaxADevolver
                  })
    })
        .then(response => response.json())
        .then(data => {
            // Mostrar los datos en pantalla
            const resultadosDiv = document.getElementById("resultados");
            resultadosDiv.innerHTML = ''; // Limpiar los resultados previos

            // Iterar sobre cada usuario en la respuesta
            data.forEach(usuario => {
                resultadosDiv.innerHTML += `
                    <p><strong>Nombre:</strong> ${usuario.nombre}</p>
                    <p><strong>Apellido:</strong> ${usuario.apellido}</p>
                    <p><strong>Email:</strong> ${usuario.email}</p>
                    <p><strong>Puntaje:</strong> ${usuario.puntaje}</p>
                    <hr> <!-- Separador entre usuarios -->
                `;
            });
        })
});
