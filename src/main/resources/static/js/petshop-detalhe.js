
const petshopId = window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1);

let petshop = {};

$.ajax({
    type: "GET",
    url: "/api/petshop/" + petshopId,
    success: function (response) {
        petshop = response;
        console.log("petshop", response);
        $("#id").val(petshop.id),
        $("#cnpj").val(petshop.cnpj),
        $("#razaosocial").val(petshop.razaosocial),
        $("#nomefantasia").val(petshop.nomefantasia),
        $("#email").val(petshop.email),
        $("#telefone").val(petshop.telefone)
    },
    dataType: "json",
    contentType: "application/json"
});


const salvar_peshop = () => {
    petshop.cnpj = $("#cnpj").val(),
    petshop.razaosocial = $("#razaosocial").val(),
    petshop.nomefantasia = $("#nomefantasia").val(),
    petshop.email = $("#email").val(),
    petshop.telefone = $("#telefone").val()
    if (petshop.cnpj === "" || petshop.razaosocial === "" || petshop.nomefantasia === "" || petshop.email === "" || petshop.telefone === "") {
        alert("Preencha todos os campos");
    }
    console.log(petshop);
    $.ajax({
        type: "PATCH",
        url: "/api/petshop/",
        data: JSON.stringify(petshop),
        success: function () {
            alert("Atualizado com sucesso!");
            window.location.href = "/petshop";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // log the error to the console
            console.log("The following error occured: " + textStatus, errorThrown);
        },
        dataType: "json",
        contentType: "application/json"
    });
}
    const salvar_novo_petshop = () => {

        petshop.cnpj = $("#cnpj").val(),
        petshop.razaosocial = $("#razaosocial").val(),
        petshop.nomefantasia = $("#nomefantasia").val(),
        petshop.email = $("#email").val(),
        petshop.telefone = $("#telefone").val()
        if (petshop.cnpj === "" || petshop.razaosocial === "" || petshop.nomefantasia === "" || petshop.email === "" || petshop.telefone === "") {
            alert("Preencha todos os campos");
        }
        console.log(petshop);
        $.ajax({
            type: "POST",
            url: "/api/petshop/newpetshop/",
            data: JSON.stringify(petshop),
            success: function () {
                alert("Cadastrado com sucesso!");
                window.location.href = "/petshop";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // log the error to the console
                console.log("The following error occured: " + textStatus, errorThrown);
            },
            dataType: "json",
            contentType: "application/json"
        });
}
const tel = document.getElementById('telefone') // Seletor do campo de telefone

tel.addEventListener('keypress', (e) => mascaraTelefone(e.target.value)) // Dispara quando digitado no campo
tel.addEventListener('change', (e) => mascaraTelefone(e.target.value)) // Dispara quando autocompletado o campo

const mascaraTelefone = (valor) => {
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/^(\d{2})(\d)/g, "($1) $2")
    valor = valor.replace(/(\d)(\d{4})$/, "$1-$2")
    tel.value = valor // Insere o(s) valor(es) no campo
}
const cnpj = document.getElementById('cnpj') // Seletor do campo de cnpj

cnpj.addEventListener('keypress', (e) => mascaraCnpj(e.target.value)) // Dispara quando digitado no campo
cnpj.addEventListener('change', (e) => mascaraCnpj(e.target.value)) // Dispara quando autocompletado o campo

const mascaraCnpj = (valor) => {
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/^(\d{2})(\d)/, "$1.$2")
    valor = valor.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")
    valor = valor.replace(/\.(\d{3})(\d)/, ".$1/$2")
    valor = valor.replace(/(\d{4})(\d)/, "$1-$2")
    cnpj.value = valor // Insere o(s) valor(es) no campo
}