
const produtosId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);

let produtos = {};

$.ajax({
    type: "GET",
    url: "/api/produtos/" + produtosId,
    success: function (response) {
        produtos = response;
        console.log("produto", response);
        $("#id").val(produtos.id)
        $("#nome").val(produtos.nome),
            $("#descricao").val(produtos.descricao),
            $("#unidade").val(produtos.unidade),
            $("#marca").val(produtos.marca),
            $("#situacao").val(produtos.situacao),
            $("#categoriaId").val(produtos.categoriaId),
            $("#valor").val(produtos.valor)
    },
    dataType: "json",
    contentType: "application/json"
});


const salvar = () => {

    produtos.nome = $("#nome").val(),
        produtos.descricao = $("#descricao").val(),
        produtos.unidade = $("#unidade").val(),
        produtos.marca = $("#marca").val(),
        produtos.situacao = $("#situacao").val(),
        produtos.categoriaId = $("#categoriaId").val(),
        produtos.valor = $("#valor").val()

    console.log(produtos);
    $.ajax({
        type: "PATCH",
        url: "/api/produtos/",
        data: JSON.stringify(produtos),
        success: function () {
            alert("Atualizado com sucesso!");
            window.location.href = "/produtos";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // log the error to the console
            console.log("The following error occured: " + textStatus, errorThrown);
        },
        dataType: "json",
        contentType: "application/json"
    });

}
