app.controller("loginController",function($rootScope,$scope,$resource,$window){
	
	
	$scope.result = false;

	
	
	var Login = $resource("http://localhost:8081/login/:id");
	
	var id_pessoa = '00001';
	
	$rootScope.menu = "Edita Pessoa";
	
	Login.get({id:id_pessoa},function (data){
		$("#loading").show();
		$scope.login = data;
		$("#loading").hide();
		});
	 
	 
	    $scope.logar = function() {

	        // verifica se o formulário é válido
	     
	    	
	    	
		  	 $scope.login.$save().then(function(res){
		  		
		  		 	var user = res;
		  			
		  			if(user.valido){
		  				$window.location.href = '#/home';
		  			}
		  			else{
		  				$scope.result = true;	
		  			}
		  			
		  			
		  		
		  		
		  		
		  	});
		  		
		  	
		  		//$location.path('/');
		  		//$window.location.href = '#/';
		  		
		  	
	       

	    };
	
});




