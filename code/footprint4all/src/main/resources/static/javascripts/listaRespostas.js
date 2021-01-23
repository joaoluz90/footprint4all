window.onload = function() {
    loadRespostas();
}

async function loadRespostas() {
    try {
        let respostas = await $.ajax({
            url: "/api/respostas",
            method: "get",
            dataType: "json"
        });
        showRespostas(respostas);
        
    } catch(err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
    }
} 

function showRespostas(resposta) {
    let elemMain = document.getElementById("main");
    let html ="";
    for (let resposta of respostas) {
        html += "<section onclick='showAlbum("+resposta.id+")'>"+
        "<h3>"+resposta.nome+"</h3>"+
        "<p> Utilizador: "+resposta.utilizador.name+"</p></section>";
    }
    elemMain.innerHTML = html;
}


function showResposta(respostaId) {
    sessionStorage.setItem("respostaId",respostaId);
    window.location = "resposta.html";
}


async function filtrar() {
}