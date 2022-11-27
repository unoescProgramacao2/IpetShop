window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesServicos');

    let dataTable =   new simpleDatatables.DataTable(datatablesSimple,);

    fetch('api/servicos/')
        .then((response) => response.json())
        .then((dataResponse) =>   {

            let headings =Object.keys(dataResponse[0]);
            headings.push("Detalhes");
            headings.push("Deletar");
            console.log(headings);
            const data= dataResponse.map(obj => {
                let arrayValues = Object.values(obj).map(val => val.toString());
                arrayValues[4]= "<a href='/servicos/"  + arrayValues[0] + "'>Detalhes</a>";
                arrayValues[5]= "<a href='#' onclick='deleteServico(" + arrayValues[0] + ")'><i class=\"fa-solid fa-trash\"></i></a> ";
                return arrayValues;
            });
            console.log(data);
            dataTable.insert({headings, data})
        });
});

function deleteServico(id) {
    let confirmacao = confirm("Deseja realmente deletar este serviço?");
    if (confirmacao) {
    console.log(id);
    fetch('api/servicos/delete/' + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then((response) => response.text())
        .then((dataResponse) => {
            alert("Deletado com sucesso!");
            console.log(dataResponse);
            location.reload();
        });
} else
    alert("Operação cancelada!");
}