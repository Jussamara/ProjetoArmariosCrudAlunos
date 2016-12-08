/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Baseado em W3Schools - Deem uma olhada!
function buscaListaAlunos() {
    var xhttp = new XMLHttpRequest();
    var url = "http://localhost:8080/SistemaArmarios/webresources/alunos";
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            carregaAlunos(this);
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}
function carregaAlunos(xml) {
    var i;
    var xmlDoc = xml.responseXML;
    var tabela = "<thead><tr><th>NOME</th><th>EMAIL</th><th>MATRICULA</th><th>TELEFONE</th></tr></thead>";
    var aluno = xmlDoc.getElementsByTagName("aluno");
    for (i = 0; i < aluno.length; i++) {
        tabela += "<tr><td>" +
                aluno[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue +
                "</td><td>" +
                aluno[i].getElementsByTagName("email")[0].childNodes[0].nodeValue +
                "</td><td>" +
                aluno[i].getElementsByTagName("matricula")[0].childNodes[0].nodeValue +
                "</td><td>" +
                aluno[i].getElementsByTagName("telefone")[0].childNodes[0].nodeValue +
                "</td></tr>";
    }
    document.getElementById("tabelaAlunos").innerHTML = tabela;
}

