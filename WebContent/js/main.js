//Funções de Alteração
function alterarColaborador(id){
	window.location = "abrirCadastrarColaborador?id=" + id;
}

function alterarMonitor(id){
	window.location = "abrirCadastrarMonitor?id=" + id;
}

function alterarSoftware(id){
	window.location = "abrirCadastrarSoftware?id=" + id;
}

function alterarEquipamento(id){
	window.location = "abrirCadastrarEquipamento?id=" + id;
}

//Funções de Remoção
function removerColaborador(id, nome){
	if(confirm('Deseja realmente remover o colaborador [' + nome + ']?')){
		window.location = "desativarColaborador?id=" + id;
	}
}

function removerMonitor(id, marca, modelo){
	if(confirm('Deseja remover o monitor [' + marca + ' ' + modelo + ']?')){
		window.location = "removerMonitor?id=" + id;
	}
}

function removerSoftware(id, nome, versao){
	if(confirm('Deseja remover o software [' + nome + ' ' + versao + ']?')){
		window.location = "removerSoftware?id=" + id;
	}
}

function removerEquipamento(id){
	if(confirm('Deseja realmente remover o equipamento?')){
		window.location = "removerEquipamento?id=" + id;
	}
}