
const produtoId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);

let produto = {};

$.ajax({
    type: "GET",
    url: "/api/produtos/" + produtoId,
    success: function (response) {
        produto = response;
        console.log("produto", response);
        $("#id").val(produto.id)
        $("#nome").val(produto.nome),
            $("#descricao").val(produto.descricao),
            $("unidade").val(produto.unidade),
            $("#marca").val(produto.marca),
            $("#valor").val(produto.valor),
            $("#situacao").val(produto.situacao),
            $("#idcategoria").val(produto.idcategoria),
            $("#categoria").val(produto.categoria)

    },
    dataType: "json",
    contentType: "application/json"
});


const salvar = () => {

    produto.nome = $("#nome").val(),
        produto.descricao = $("#descricao").val(),
        produto.unidade = $("#unidade").val(),
        produto.marca = $("#marca").val(),
        produto.valor = $("#valor").val(),
        produto.situacao = $("#situacao").val(),
        produto.idcategoria = $("#idcategoria").val(),
        produto.categoria = $("#categoria").val()
    console.log(produto);
    $.ajax({
        type: "PATCH",
        url: "/api/produtos/",
        data: JSON.stringify(produto),
        success: function () {
            alert("Deu boa!");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // log the error to the console
            console.log("The following error occured: " + textStatus, errorThrown);
        },
        dataType: "json",
        contentType: "application/json"
    });

}
