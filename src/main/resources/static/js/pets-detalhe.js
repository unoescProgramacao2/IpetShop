
const petsId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);

let pets = {};

$.ajax({
    type: "GET",
    url: "/api/pets/" + petsId,
    success: function (response) {
        pets = response;
        console.log("pets", response);
        $("#id").val(pets.id)
        $("#nome").val(pets.nome),
            $("#especie").val(pets.especie),
            $("#raca").val(pets.raca),
            $("#sexo").val(pets.sexo),
            $("#responsavel").val(pets.responsavel),
            $("#cor").val(pets.cor),
            $("#porte").val(pets.porte),
            $("#peso").val(pets.peso),
            $("#observacao").val(pets.observacao),
            $("#nascimento").val(pets.nascimento)

    },
    dataType: "json",
    contentType: "application/json"
});


const salvar = () => {

    pets.nome = $("#nome").val(),
        pets.especie = $("#especie").val(),
        pets.raca = $("#raca").val(),
        pets.sexo = $("#sexo").val(),
        pets.responsavel = $("#responsavel").val(),
        pets.cor = $("#cor").val(),
        pets.porte = $("#porte").val(),
        pets.peso = $("#peso").val(),
        pets.observacao = $("#observacao").val(),
        pets.nascimento = $("#nascimento").val()
    console.log(pets);
    $.ajax({
        type: "PATCH",
        url: "/api/pets/",
        data: JSON.stringify(pets),
        success: function () {
            alert("Atualizado com sucesso!");
            window.location.href = "/pets";
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

        pets.nome = $("#nome").val(),
            pets.especie = $("#especie").val(),
            pets.raca = $("#raca").val(),
            pets.sexo = $("#sexo").val(),
            pets.responsavel = $("#responsavel").val(),
            pets.cor = $("#cor").val(),
            pets.porte = $("#porte").val(),
            pets.peso = $("#peso").val(),
            pets.observacao = $("#observacao").val(),
            pets.nascimento = $("#nascimento").val()
        console.log(pets);
        $.ajax({
            type: "POST",
            url: "/api/pets/newpet",
            data: JSON.stringify(pets),
            success: function () {
                alert("Cadastrado com sucesso!");
                window.location.href = "/pets";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // log the error to the console
                console.log("The following error occured: " + textStatus, errorThrown);
            },
            dataType: "json",
            contentType: "application/json"
        });
}
