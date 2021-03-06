window.onload = function() {
    loadAlbuns();
}

async function loadAlbuns() {
    try {
        let albuns = await $.ajax({
            url: "/api/respostas",
            method: "get",
            dataType: "json"
        });
        showAlbuns(albuns);
        
    } catch(err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
    }
} 

function showAlbuns(albuns) {
    let elemMain = document.getElementById("main");
    let html ="";
    for (let album of albuns) {
        html += "<section onclick='showAlbum("+album.id+")'>"+
        "<h3>"+album.string+"</h3>"+
        "<p> Utilizador: "+album.utilizador.nome+"</p>"+
        "<p> Questionário nº: "+album.questionario.id+"</p>"+
        "<p> Formulário nº: "+album.questionario.formulario.id+"</p>"+
        "<p> Secção: "+album.questionario.seccao.nome+"</p>"+
        "<p> Pergunta: "+album.questionario.pergunta.string+"</p></section>";
    }
    elemMain.innerHTML = html;
}


function showAlbum(albumId) {
    sessionStorage.setItem("albumId",albumId);
    window.location = "index.html";
}

async function filtrar() {
}