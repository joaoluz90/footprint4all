window.onload = function() {
    loadAlbuns();
}

async function loadAlbuns() {
    try {
        let albuns = await $.ajax({
            url: "/api/escalas",
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
        "<h3>"+album.valor+"</h3>"+
        "<p>Descrição: "+album.descricao+"</p></section>";
    }
    elemMain.innerHTML = html;
}


function showAlbum(albumId) {
    sessionStorage.setItem("albumId",albumId.id);
    window.location = "index.html";
}

async function filtrar() {
}