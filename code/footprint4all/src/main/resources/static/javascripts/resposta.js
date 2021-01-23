window.onload = async function() {
    let respostaId = sessionStorage.getItem("respostaId");
    try {
        
        let resposta = await $.ajax({
            url: "/api/respostas/"+respostaId,
            method: "get",
            dataType: "json"
        });
        console.log(resposta);
        //document.getElementById("cover").src = "/images/cover" + album.AlbumId + ".jpg";  
        
        
        //if (album.Cover != null) {
        //     document.getElementById("cover").src = album.Cover;
        //}
        

        document.getElementById("resposta").innerHTML = resposta.nome;
        document.getElementById("utilizador").innerHTML = resposta.utilizador.nome;


        let tracks = await $.ajax({
            url: "/api/respostas/"+utilizadorId+"/classificacoes",
            method: "get",
            dataType: "json"
        });

        
        let html = "";
        for(let classificacao of classificacoes) {
            html+= "<p onclick='showClassificacao("+classificacao.escala.id+")'>"+classificacao.data+" - "+classificacao.utilizador.id+" €</p>";
        }
        document.getElementById("classificacoes").innerHTML = html;
    } catch(err) {
        console.log(err);
    }
}


function showClassificacao(id) {
    // TODO: open page with track info
} 