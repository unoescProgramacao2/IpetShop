
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
    if (servico.nome === "" || servico.descricao === "" || servico.valor === "") {
        alert("Preencha todos os campos!");
    }
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
const salvar_novo = () => {

    servico.nome = $("#nome").val(),
        servico.descricao = $("#descricao").val(),
        servico.valor = $("#valor").val()
    if (servico.nome === "" || servico.descricao === "" || servico.valor === "") {
        alert("Preencha todos os campos!");
    }
    console.log(servico);
    $.ajax({
        type: "POST",
        url: "/api/servicos/newservice",
        data: JSON.stringify(servico),
        success: function () {
            alert("Cadastrado com sucesso!");
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
function formatarMoeda() {
    var elemento = document.getElementById('valor');
    var valor = elemento.value;

    valor = valor + '';
    valor = parseInt(valor.replace(/[\D]+/g, ''));
    valor = valor + '';
    valor = valor.replace(/([0-9]{2})$/g, ",$1");

    if (valor.length > 6) {
        valor = valor.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");
    }

    elemento.value = valor;
    if(valor == 'NaN') elemento.value = '';
}