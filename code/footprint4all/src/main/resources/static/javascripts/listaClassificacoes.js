window.onload = function() {
    loadAlbuns();
}

async function loadAlbuns() {
    try {
        let albuns = await $.ajax({
            url: "/api/classificacoes",
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
        "<h3>"+album.utilizador.nome+"</h3>"+
        "<p> Data da última classificação: "+album.data+"</p>"+
        "<p> Descrição: "+album.escala.descricao+"</p>"+
        "<p> Valor: "+album.escala.valor+"</p></section>";
    }
    elemMain.innerHTML = html;
}


function showAlbum(albumId) {
    sessionStorage.setItem("albumId",albumId);
    window.location = "album.html";
}

async function filtrar() {
}