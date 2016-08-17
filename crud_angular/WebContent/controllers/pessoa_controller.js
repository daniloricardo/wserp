app.controller("pessoaController",function($rootScope,$scope,$resource){
	
	$rootScope.menu = "Pessoas";
	var Pessoa = $resource("http://localhost:8081/pessoas/:id");
	Pessoa.query(function (data){
		$("#loading").show();
		$scope.pessoas = data;
		$scope.tamanhoMaximo = 6;
		$scope.totalItems = 175;
		$scope.currentPage = 1;
		$("#loading").hide();
	});
});
app.controller("edita_pessoaController",function($rootScope, $scope,$resource,$routeParams,$http,$location){
	
	
	
	var Pessoa = $resource("http://localhost:8081/pessoa/:id");
	
	var id_pessoa = $routeParams.id_pessoa;
	
	$rootScope.menu = "Edita Pessoa";
	
	Pessoa.get({id:id_pessoa},function (data){

		$scope.pessoa = data;
		$scope.loading = false;
		var teste =angular.fromJson(data);
		$(document).ready(function(){
			$("#bairro").val($scope.pessoa.endereco.bairro.nome);
			
			
		});
		
		
	});
	
	$scope.salvar = function(){
	
	
		$scope.pessoa.$save();
		
	//$location.path('/');
	$("#loading").show();
	};
	//alert(pessoa);
	
	

	
	$("#bairro").typeahead({
		name : 'representantes',
		remote : 'http://localhost:8081/bairros.json?termo=%QUERY'
	});
	$('#bairro').bind('typeahead:selected',
			function(obj, datum, name) {
				$(obj).attr("selected", "y");
				
				$scope.pessoa.endereco.bairro.id = datum.id;
//				var tpconsulta = $("tpconsultavendedor").val();
//				$("#loading").showi();
//					 window.location =  "remessas_representante?nome="+datum.id;
		  	

			});
	
	
});


app.controller("new_pessoaController",function($rootScope,$scope,$resource,$location,$window){
	
	
	$scope.tp_pessoa = {
		dado: null,
		opcoes : [{id: '1',valor : 'Fisica'},{id: '2',valor : 'Juridica'}]
			
	};
	$scope.centro = null;
	var CentroCusto = $resource("http://localhost:8081/centros");
	CentroCusto.query(function (data){
		$("#loading").show();
		$scope.centros = data;
		
		$("#loading").hide();
	});
	
	var Pessoa = $resource("http://localhost:8081/pessoa/:id");
	
	var id_pessoa = '00001';
	
	$rootScope.menu = "Edita Pessoa";
	
	Pessoa.get({id:id_pessoa},function (data){
		$("#loading").show();
		$scope.pessoa = data;
		$("#loading").hide();
		});
	 
	
	 $scope.buscaCep = function() {

	        // verifica se o formulário é válido
	     
	    	var cdcep = $scope.pessoa.endereco.cep;
		  	
	    	var Cep = $resource("http://localhost:8081/cep/:cep");
	    	Cep.get({cep:cdcep},function (data){
	    		$("#loading").show();
	    		$scope.cep = data;
	    		$scope.pessoa.endereco.cep.id = $scope.cep.id;
	    		$("#loading").hide();
	    	});
	       

	    };
	    
	    $scope.submitForm = function(isValid) {

	        // verifica se o formulário é válido
	     
		  	if(isValid){
		  		$scope.pessoa.$save();
		  		//$location.path('/');
		  		$window.location.href = '#/home';
		  		$("#loading").show();
		  	}
	       

	    };
	
});

	function teste(){
		$('ul:first').find('li:visible:first').css('background','blue');
		/*
		$("ul:first").focus(function() {
			alert('teste');
	         $(this).css('color','red');
		});
		*/
	}
	function endereco($scope){
		alert(JSON.stringify($scope.pessoa));
			var endereco = $scope.pessoa.nome;
			
			
			
			
			
		
	}


