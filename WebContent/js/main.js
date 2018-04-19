function alertaBotao(){
	alert("Cadastro realizado com sucesso!");
}

function mostrar(id){
	var div = document.getElementById(id);
	if (div.style.display == 'none') { 
	div.style.display = 'block' 
	}else { 
	div.style.display = 'none' 
	} 	
}