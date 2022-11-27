// Simple-DataTables
// https://github.com/fiduswriter/Simple-DataTables/wiki

const datatablesSimple = document.getElementById('datatablesProdutos');

let dataTable =   new simpleDatatables.DataTable(datatablesSimple,);

fetch('api/produtos/')
    .then((response) => response.json())
    .then((dataResponse) =>   {
        let headings =Object.keys(dataResponse[0]);
        headings[0]= "Código";
        headings[1]= "Nome Produto";
        headings[2]= "Descrição";
        headings[3]= "Unidade";
        headings[4]= "Marca";
        headings[5]= "Preço";
        headings[6]= "Status";
        headings.splice(headings.indexOf("categoriaId"), 1);
        headings.splice(headings.indexOf("categoria"), 1);
        headings[8]= "Categoria";
        headings.push("Detalhes");
        headings.push("Deletar");

        console.log(headings);
        const data= dataResponse.map(obj => {
            let arrayValues = Object.values(obj).map(val => val.toString());
            arrayValues.splice(7, 1);
            arrayValues[8]= "<a href='/produtos/"  + arrayValues[0] + "'>Detalhes</a>";
            arrayValues[9]= " <a href='#' onclick='delete_produto("+arrayValues[0]+")'><i class=\"fa-solid fa-trash\"></i></a> ";
            if (arrayValues[6] == "Inativo") {
                arrayValues[6]= "<span class=\"badge bg-danger\">Inativo</span>";
            }
            return arrayValues;
        });
        console.log(data);
        dataTable.insert({headings, data})
    });

function delete_produto(id) {
    let confirmacao = confirm("Deseja realmente deletar este produto?");
    if (confirmacao) {
    console.log(id);
    fetch('api/produtos/' + id + '/delete', {
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
