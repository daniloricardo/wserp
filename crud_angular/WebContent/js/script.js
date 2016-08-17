$(document).ready(function(){

	$(function(){
		$('.tablesorter').tablesorter();
	});

	$("#marcaAll").click(function(){

		//$(".marcar").attr("checked", true);.
	});
	$('.sonumsdecimal').mask("#.##0,00", {reverse: true});
	$('.sonums').keypress(function(event) {
        var tecla = (window.event) ? event.keyCode : event.which;
        if ((tecla > 47 && tecla < 58)) return true;
        else {
            if (tecla != 8) return false;
            else return true;
        }
    });
	
	$("#loading").hide();
	$("#sxa").click(function(){
		window.location="../sxa";
	});
	$("#new").click(function(){
		window.location="../new";
	});
	$("#all").click(function(){
		var data = $("#dataatual").val();
		window.location = "/extrato?status=all&data="+data;	
		});
	$("#ap").click(function(){
		var data = $("#dataatual").val();
		window.location = "/extrato?status=APROVADO&data="+data;	
		});
	$("#ag").click(function(){
		var data = $("#dataatual").val();
		window.location = "/extrato?status=PENDENTE&data="+data;	
		});
	$("#projeto").change(function(){
		var id = this.value;
		$("#loading").show();
		$.ajax({
			data: {id : id},
			url:"/alteraprojeto",success:function(result){
				$("#loading").hide();
				window.location="../";
			}});

	});



	$("#produto").change(function(){
		var acao = document.getElementById('acao');
		$(acao).val('alteraproduto');
		$("#principal").submit();
		/*var id = this.value;
		$("#loading").show();
		$.ajax({
			data: {produto : id},
			url:"new",success:function(result){
				$("#loading").hide();
				$("#versao").bind();
			}});
		 */

	});
	$("#copiar").click(function(){
		$("#principal").submit();	
	});
	$("#remover").click(function(){
		$("#principal").submit();	
	});
	$("#gravanew").click(function(){
		var acao = document.getElementById('acao');
		$(acao).val('grava');
		$("#principal").submit();
	});
	$("#home").click(function(){
		window.location="../";
	});
	$("#cancelar").click(function(){
		window.location="./adm";
	});
	$("#adm_users").click(function(){
		$("#loading").show();
		$.ajax({
			url:"adm_user/1",success:function(result){
				$("#loading").hide();
				$("#titulo").append(" - Usuários");
				$("#admprincipal").html(result);
			}});
	});
	$("#adm_projects").click(function(){
		$("#loading").show();
		$.ajax({
			url:"adm_projects/1",success:function(result){
				$("#loading").hide();
				$("#titulo").append(" - Projetos");
				$("#admprincipal").html(result);
			}});
	});

	$("#relatorioexcel").click(function(){
		var dtini = $("#datainicio").val();
		var dtfim = $("#datafim").val();
		if(dtini==''||dtfim==''){
			bootbox.alert('O período deve ser informado! Verifique');
			return false;
		}
		window.location="relatorioexcel?dtini="+dtini+"&dtfim="+dtfim;
	});
	//Grava o Vinculo do Serviço x Componente
	$("#grava").click(function(){
		var tipo = $("#tipo2").val();
		var dados = $(".marcar");
		var dadosdesmarcados = $(".desmarcar");
		var dadossplit = new String("");
		var dadosdesmarcadossplit = new String("");
		for(var i=0;i<dados.length;i++){
			if(dados[i].checked==true){
				dadossplit = dadossplit +dados[i].id+"_";
			}
		}
		for(var i=0;i<dadosdesmarcados.length;i++){
			if(dadosdesmarcados[i].checked==true){
				dadosdesmarcadossplit = dadosdesmarcadossplit +dadosdesmarcados[i].id+"_";
			}
		}

		bootbox.confirm('Você deseja Salvar os Vinculos? ',
				function(result){
			if(result){
				$("#loading").show();
				$.ajax({
					data: {tipo : tipo, dados : dadossplit,dadosdesmarcados : dadosdesmarcadossplit},
					url:"gravavinculocompserv",success:function(result){
						$("#loading").hide();
						bootbox.alert("Vinculos Processados com sucesso!");
					}});
			}

		});

	});
	// Grava o Vinculo do Servico x Ambiente
	$("#gravasxa").click(function(){
		var tipo = $("#tipo").val();
		var dados = $(".marcar");
		var dadosdesmarcados = $(".desmarcar");
		var dadossplit = new String("");
		var dadosdesmarcadossplit = new String("");
		for(var i=0;i<dados.length;i++){
			if(dados[i].checked==true){
				dadossplit = dadossplit +dados[i].id+"_";
			}
		}
		for(var i=0;i<dadosdesmarcados.length;i++){
			if(dadosdesmarcados[i].checked==true){
				dadosdesmarcadossplit = dadosdesmarcadossplit +dadosdesmarcados[i].id+"_";
			}
		}

		bootbox.confirm('Você deseja Salvar os Vinculos? ',
				function(result){
			if(result){
				$("#loading").show();
				$.ajax({
					data: {tipo : tipo, dados : dadossplit,dadosdesmarcados : dadosdesmarcadossplit},
					url:"gravavinculoservamb",success:function(result){
						$("#loading").hide();
						bootbox.alert("Vinculos Processados com sucesso!");
					}});
			}

		});

	});
	$("#gravaaxm").click(function(){
		var tipo = $("#tipo3").val();

		var dadosdesmarcados = $(".desmarcar");
		var dados = $(".marcar");
		var dadossplit = new String("");
		var dadosdesmarcadossplit = new String("");
		for(var i=0;i<dados.length;i++){
			if(dados[i].checked==true){
				dadossplit = dadossplit +dados[i].id+"_";
			}
		}
		for(var i=0;i<dadosdesmarcados.length;i++){
			if(dadosdesmarcados[i].checked==true){
				dadosdesmarcadossplit = dadosdesmarcadossplit +dadosdesmarcados[i].id+"_";
			}
		}

		bootbox.confirm('Você deseja Salvar os Vinculos? ',
				function(result){
			if(result){
				$("#loading").show();
				$.ajax({
					data: {tipo : tipo, dados : dadossplit,dadosdesmarcados : dadosdesmarcadossplit},
					url:"gravavinculoambmod",success:function(result){
						$("#loading").hide();
						bootbox.alert("Vinculos Processados com sucesso!");
					}});
			}

		});

	});
	//Efetuado o Cadastro
	$("#gravacadastro").click(function(){
		var tipo = $("input:radio[name='tipo']");
		for(var i=0;i<tipo.length;i++){
			//bootbox.alert("Existem campos em branco Verifique! ");
			if(tipo[i].checked==true){
				tipo = tipo[i].value; 
			}
		}
		var nome = $("#nome").val();
		bootbox.confirm('Você deseja Salvar os Vinculos? ',
				function(result){
			if(result){
				$("#loading").show();
				$.ajax({
					data: {tipo : tipo, nome : nome},
					url:"../grava_tabela",success:function(result){
						$("#loading").hide();

					}});
			}

		});
	});
	$("#tipo2").change(function(){
		$("#loading").show();
		$.ajax({
			data: {idservico : $("#tipo2").val(), idprojeto : $("#projeto").val()},
			url:"produtoajax",success:function(result){
				$("#loading").hide();
				$("#produtos").html(result);
			}});
	});
	//ajax que consulta os ambientes por servico
	$("#tipo").change(function(){
		$("#loading").show();
		$.ajax({
			data: {idpai : $("#tipo").val()},
			url:"ambienteajax",success:function(result){
				$("#loading").hide();
				$("#produtos").html(result);
			}});
	});
	//ajax que consulta os produtos por ambiente
	$("#tipo3").change(function(){
		$("#loading").show();
		$.ajax({
			data: {idpai : $("#tipo3").val()},
			url:"produtoxambienteajax",success:function(result){
				$("#loading").hide();
				$("#produtos").html(result);
			}});
	});
	//pesquisa o produto da tela de cadastro

	$("#loading").css({
		position : 'absolute',
		top : '50%',
		left: '50%',
		color : 'red'
	});
	$("#processa").click(function(){
		var dtini = $("#datainicio").val();
		var dtfim = $("#datafim").val();
		if(dtini==''||dtfim==''){
			bootbox.alert('O período deve ser informado! Verifique');
			return false;
		}
		$("#loading").show();
		$.ajax({data: {dtini : dtini , dtfim : dtfim},
			url:"processa",success:function(result){
				$("#resultado").html(result);
				$("#loading").hide();
			}});
	});
	$("#btSalva").click(function(){

		bootbox.confirm('Deseja Gravar?',function(result){
			if(result){
				var mes = $("#mes").val();
				var ano = $("#ano").val();
				$.ajax({data: {mes : mes , ano : ano},
					url:"fechamento",success:function(result){
						$("#loading").hide();
						bootbox.alert(result);

					}});
			}
		});
	});
	$("#relatorio").click(function(){
		var mes = $("#mesano").val();
		var dados = $("#centro").val();
		var msg = "";
		if(mes==""){
			msg += "Favor selecionar o Mês/Ano! \n";
		}

		if(dados=="" || dados == null){
			msg += "<br/>Favor selecionar um ou mais Centro de Custo!";
		}
		if(msg!=""){
			bootbox.alert(msg);
		}
		else{
			var centro = $("#centro").val();
			var funcionario = $("#funcionario").val();
			var status = $("#status").val();
			window.open("espelho?mes="+mes+"&centro="+centro+"&funcionario="+funcionario+"&status="+status);
		}
	});
//	=================Sincronização===========================================
	$("#bt_sinc_servico").click(function(){
		$("#loading").show();
		var servico = $("#servico").val();
		var dados = $(".dados").val();
		$.ajax({
			data: {servico : servico, dados : dados},
			url:"http://172.22.0.88:8091/index.asp",success:function(result){
				$("#resultado").html(result);
				$("#loading").hide();

			}});

	});	

});



function consulta(x){
	if(window.event.keyCode == 13){
		var qtde = $("#qtde").val();
		$.ajax({
			data: {codigo : x.value,qtde : qtde},
			url:"findproduto",
			success:function(result){
				$("#resultado").html(result);	
				limpa();	
			}


		});
	}
	else{
		return false;
	}
}
function novo(){
	$.ajax({
		url:"novo",
		success:function(result){
			$("#resultado").html(result);	
		}
	});
}
function limpa(){
	var entra = document.getElementById("entra");
	var qtde = document.getElementById("qtde");
	qtde.value = "1";
	entra.value = "";
}

function desmarcatodos(){
	var dados = $(".desmarcar");
	dados.prop("checked", true);
	$("#marcaAll").prop("checked", false);

}
function marcatodos(x){
	var dados = $(".marcar");
	if(x.checked){
		dados.prop("checked", true);
		$("#desmarcaAll").prop("checked", false);
	}
	else{
		dados.prop("checked", false);
	}

}
function remover(x){
	bootbox.confirm('Confirma a Exclusão do Id: '+x.id+' ?',function(result){
		if(result){
			$.ajax({
				data: {id : x.id},
				url:"../remove",
				success:function(result){

					bootbox.alert('removido com sucesso!');

				}});
		}
	});

}
function avancar(){
	var titulo = $("#titulo").text();
	var projeto = titulo.indexOf("Projetos");
	var url = "";
	if(projeto>0){
		url= "adm_projects/";
	}
	else{
		url= "adm_user/";
	}
	$("#loading").show();
	var pagina = document.getElementById('pagina');
	var valor = parseInt(pagina.value);
	valor = valor +parseInt(1);
	$(pagina).val(valor);
	$.ajax({
		url:url+valor,success:function(result){
			$("#loading").hide();
			$("#admprincipal").html(result);
		}});

}
function voltar(){
	var titulo = $("#titulo").text();
	var projeto = titulo.indexOf("Projetos");
	var url = "";
	if(projeto>0){
		url= "adm_projects/";
	}
	else{
		url= "adm_user/";
	}
	$("#loading").show();
	var pagina = document.getElementById('pagina');
	var valor = parseInt(pagina.value);
	valor = valor -parseInt(1);
	$(pagina).val(valor);
	$.ajax({
		url:url+valor,success:function(result){
			$("#loading").hide();
			$("#admprincipal").html(result);
		}});

}

function pesquisacadastro(){
	var nome = $("#nome").val();

	$("#loading").show();
	$.ajax({data: {nome : nome },
		url:"../consulta",success:function(result){
			$("#pesquisa").html(result);
			$("#loading").hide();
		}});

};
function assumir(){
	var dados = $(".marcado");
	var dadossplit = new String("");
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			dadossplit = dadossplit +dados[i].id+"_";
		}
	}
	$("#chamados").val(dadossplit);
	$("#principal").submit();
}
function ir(mes,funcionario){
	var url = "/lancamento?idfunc="+funcionario+"&mes="+mes;
	window.location= url;

}	
function ir2(mes,funcionario){
	var url = "/lancamento?idfunc="+funcionario+"&mes="+mes;
	$("#loading").show();	
	$.ajax({
		data: {acao : "detalhe"},
		url:url,
		success:function(result){
			$("#resultado").html(result);
			$("#loading").hide();	
		}
	});

}	
function pendentes(funcionario,status,datafinal){
	var url = "/lancamento?idfunc="+funcionario+"&mes=&status="+status+"&data="+datafinal;
	$("#loading").show();	
	$.ajax({
		data: {acao : "detalhe"},
		url:url,
		success:function(result){
			$("#resultado").html(result);
			$("#loading").hide();	
		}
	});

}	
function lancamentosPorPeriodo(funcionario,dataini,datafim){
	var url = "/lancamento?acao=extrato&idfunc="+funcionario+"&dataini="+dataini+"&datafim="+datafim;
	$("#loading").show();	
	$.ajax({
		data: {acao : "detalhe"},
		url:url,
		success:function(result){
			$("#resultado").html(result);
			$("#loading").hide();	
		}
	});

}	
function extratodetalhecentrocusto(centro,dataini,datafim){
	var dataini = $("#dataini").val();
	var datafim = $("#datafim").val();
	var url = "/extrato?acao=detalhe&centro="+centro+"&dataini="+dataini+"&datafim="+datafim;
	$("#loading").show();	
	$.ajax({
		url:url,
		success:function(result){
			$("#resultado").html(result);
			$("#loading").hide();	
		}
	});

}	
function aprovar(){
	var matricula = $("#matricula").val();
	var dados = $(".marcar");
	var data = $("#dataselecionada").val();
	var valores = "";
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			valores += dados[i].id+"_";
		}
	}
	bootbox.confirm('Confirma a aprovação?',function(result){
		if(result){
			$("#loading").show();
			$.ajax({
				data: {matricula : matricula,dados: valores,data : data},
				url:"../libera?param=l",success:function(result){
					$("#loading").hide();

					retornar();		
				}});
		
		}
	});
}
function reprovar(){
	var matricula = $("#matricula").val();
	var dados = $(".marcar");
	var data = $("#dataselecionada").val();
	var valores = "";
	var motivo = $("#motivo").val();
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			valores += dados[i].id+"_";
		}
	}
	bootbox.confirm('Confirma a reprovação?',function(result){
		
		if(result){
			$("#loading").show();
			$.ajax({
				data: {matricula : matricula,dados: valores,data : data, motivo : motivo},
				url:"../libera?param=r",success:function(result){
					$("#loading").hide();

					retornar();		
				}});
			retornar();
		}
	});
}
function fechar(){
	var matricula = $("#matricula").val();
	var data = $("#dataselecionada").val();
	var dados = $(".marcar");
	var valores = "";
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			valores += dados[i].id+"_";
		}
	}
	bootbox.confirm('Confirma Incluir no Fechamento?',function(result){
		if(result){
			$("#loading").show();
			$.ajax({
				data: {matricula : matricula,dados: valores,data: data},
				url:"../fecha",success:function(result){
					$("#loading").hide();

					window.location ="/extrato?status=APROVADO&data="+data;
				}});
		}
	});
}
function cancelaAprovacao(){
	var mesano = $("#mesanoselecionado").val();
	var matricula = $("#matricula").val();
	var dados = $(".marcar");
	var valores = "";
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			valores += dados[i].id+"_";
		}
	}
	bootbox.confirm('Confirma o Cancelamento da Aprovação?',function(result){
		if(result){
			$("#loading").show();
			$.ajax({
				data: {mesano : mesano,matricula : matricula,dados: valores},
				url:"../cancela",success:function(result){
					$("#loading").hide();

					window.location ="/extrato?status=APROVADO";
				}});
			retornar();
		}
	});
}
function reabrir(){
	var idfechamento = $("#idfechamento").val();
	var matricula = $("#matricula").val();
	var dados = $(".marcar");
	var valores = "";
	for(var i=0;i<dados.length;i++){
		if(dados[i].checked==true){
			valores += dados[i].id+"_";
		}
	}
	bootbox.confirm('Confirma Excluir do Fechamento?',function(result){
		if(result){
			$("#loading").show();
			$.ajax({
				data: {idfechamento : idfechamento,matricula : matricula,dados: valores},
				url:"../reabre",success:function(result){
					$("#loading").hide();

					window.location ="/fechamentos";
				}});
		}
	});
}
function validaTamanho(){
	$("form").submit(function () { return false; });
	var remessas = $(".marcar");
	var tamanho = 0;
	for(var i=0;i<remessas.length;i++){
		if(remessas[i].checked==true){
			tamanho = tamanho +1; 
		}
	}
	if(tamanho==0){
		bootbox.alert('Favor selecionar um ou mais lançamentos');
		return false;
	}
	else{
		return true;
	}
}
function retornar(){
	var status = $("#status").val();
	var data = $("#dataselecionada").val();	
	window.location ="/extrato?status="+status+"&data="+data;

}
function retornaextratoajax(){
	var dataini = $("#dataini").val();
	var datafim = $("#datafim").val();
	window.location="/extratocentrocusto?dataini="+dataini+"&datafim="+datafim;
}

function carregaFuncionarios(){
	$("#loading").show();
	var dados = $("#centro").val();
	var valores = "";
	for(var i=0;i<dados.length;i++){
		valores += dados[i] +"_";
	}
	$.ajax({
		data: {centro: valores},
		url:"funcionarioporccustojax",
		success:function(result){
			$("#funcionario").html(result);
			$("#loading").hide();	
		}
	});
}
function filtraExtrato(){

	var mes = $("#mesano").val();
	var dados = $("#centro").val();

	var funcionario = $("#funcionario").val();
	var status = $("#status").val();
	var msg = "";
	if(mes==""){
		msg += "Favor selecionar o Mês/Ano! \n";
	}

	if(dados=="" || dados == null){
		msg += "<br/>Favor selecionar um ou mais Centro de Custo!";
	}
	if(msg!=""){
		bootbox.alert(msg);
	}
	else{
		var valores = "";
		for(var i=0;i<dados.length;i++){
			valores += dados[i] +"_";
		}
		$("#loading").show();	
		$.ajax({
			data: {mes : mes,centro : valores,funcionario : funcionario,status : status},
			url:"consultalancamentoajax",
			success:function(result){
				$("#resultado").html(result);
				$("#loading").hide();	
			}
		});
	}
}
function logout(){
	
	$("#loading").show();
	$.ajax({
		url:"/logoutsucess",success:function(result){
			$("#loading").hide();
			document.forms.formlogout.submit();
		}});


}
