var $app = angular.module('app',['ngResource']);
$app.config(['$httpProvider', function ($httpProvider) {    
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/json; charset=UTF-8';
//	$httpProvider.defaults.headers.post['Accept'] = 'application/json';
//	$httpProvider.defaults.headers.post['dataType'] = 'application/json';
}]);


$app.controller("pessoaController",function ($scope,$http){
	
//	var Pessoa = $resource("http://localhost:8081/pessoas/:id");
//
//	$scope.getPessoas = function(){
//
//
//		$scope.loading = true;	
//
//		Pessoa.query(function (data){
//
//			$scope.pessoas = data;
//			$scope.loading = false;
//		});
//
//	}
	$scope.getPessoa = function(){


		$scope.loading = true;	

	   	Pessoa.get({id:'00A000002N'},function (data){

			$scope.pessoa = data;
			$scope.loading = false;
		});

	}
	$scope.savePessoa = function(){
		
		 var data = {
             "nome" : "Danilo" };
     
//         var config = {
//             headers : {
//            	 'Content-Type': 'application/json;'
//            	 
//             }
//         }
         
         $http.post('http://127.0.0.1:8081/pessoas', JSON.stringify(data))
         .success(function (data, status, headers, config) {
        	 alert(JSON.stringify(data));
        	 
         })
         .error(function (data, status, header, config) {
            alert(data);
         });
//         $http({
//             method: 'POST',
//             url: 'http://localhost:8081/pessoas',
//             data: JSON.stringify(data)
//             });
		
	}

});