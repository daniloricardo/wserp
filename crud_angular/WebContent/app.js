var app = angular.module('app',['ngRoute','ngResource','angularUtils.directives.dirPagination']);

app.config(['$routeProvider', function ($routeProvider) {    
	$routeProvider.
	when('/',{controller:'loginController',templateUrl:'login.html'}).
	when('/home',{controller:'pessoaController',templateUrl:'pessoas.html'}).
	when('/edit/:id_pessoa',{controller:'edita_pessoaController',templateUrl:'edita_pessoa.html'}).
	when('/new',{controller:'new_pessoaController',templateUrl:'nova_pessoa.html'}).
	otherwise({redirectTo:'/'});
	
}]);

app.run(['$rootScope',function($rootScope){
	
	$rootScope.menu = "Pessoas";
	console.log('app.run');
}]);
