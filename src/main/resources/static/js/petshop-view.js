window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesPets');

    let dataTable =   new simpleDatatables.DataTable(datatablesSimple,);

    fetch('api/petshop/')
        .then((response) => response.json())
        .then((dataResponse) =>   {

            let headings =Object.keys(dataResponse[0]);
            headings[0]= "Código";
            headings.push("Detalhes");
            headings.push("Deletar");
            console.log(headings);
            const data= dataResponse.map(obj => {
                let arrayValues = Object.values(obj).map(val => val.toString());
                arrayValues[6]= "<a href='/petshop/"  + arrayValues[0] + "'>Detalhes</a>";
                arrayValues[7]= " <a href='#' onclick='delete_petshop("+arrayValues[0]+")'><i class=\"fa-solid fa-trash\"></i></a> ";
                return arrayValues;
            });
            console.log(data);
            dataTable.insert({headings, data})
        });
});

function delete_petshop(id) {
    let confirmacao = confirm("Deseja realmente deletar esta PetShop?");
    if (confirmacao) {
    console.log(id);
    fetch('api/petshop/delete/' + id, {
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
