
const servicoId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);

let servico = {};

$.ajax({
    type: "GET",
    url: "/api/servicos/" + servicoId,
    success: function (response) {
        servico = response;
        console.log("pets", response);
        $("#id").val(servico.id)
        $("#nome").val(servico.nome),
            $("#descricao").val(servico.descricao),
            $("#valor").val(servico.valor)

    },
    dataType: "json",
    contentType: "application/json"
});


const salvar = () => {

    servico.nome = $("#nome").val(),
        servico.descricao = $("#descricao").val(),
        servico.valor = $("#valor").val()
    console.log(servico);
    $.ajax({
        type: "PATCH",
        url: "/api/servicos/",
        data: JSON.stringify(servico),
        success: function () {
            alert("Atualizado com sucesso!");
            window.location.href = "/servicos";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // log the error to the console
            console.log("The following error occured: " + textStatus, errorThrown);
        },
        dataType: "json",
        contentType: "application/json"
    });

}
