window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesPets');

    let dataTable =   new simpleDatatables.DataTable(datatablesSimple,);

    fetch('api/pets/')
        .then((response) => response.json())
        .then((dataResponse) =>   {

            let headings =Object.keys(dataResponse[0]);
            headings[0]= "Código";
            headings[1]= "Nome Pet";
            headings[2]= "Especie";
            headings[3]= "Raça";
            headings[4]= "Sexo";
            headings[5]= "Responsável";
            headings[6]= "Cor";
            headings[7]= "Porte";
            headings[8]= "Peso";
            headings[9]= "Observações";
            headings[10]= "Nascimento";
            headings.push("Detalhes");
            headings.push("Deletar");
            console.log(headings);
            const data= dataResponse.map(obj => {
                let arrayValues = Object.values(obj).map(val => val.toString());
                arrayValues[11]= "<a href='/pets/"  + arrayValues[0] + "'>Detalhes</a>";
                arrayValues[12]= " <a href='#' onclick='delete_pet("+arrayValues[0]+")'><i class=\"fa-solid fa-trash\"></i></a> ";
                return arrayValues;
            });
            console.log(data);
            dataTable.insert({headings, data})
        });
});

function delete_pet(id) {
    let confirmacao = confirm("Deseja realmente deletar este pet?");
    if (confirmacao) {
    console.log(id);
    fetch('api/pets/delete/' + id, {
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
