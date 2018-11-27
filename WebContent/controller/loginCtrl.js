angular.module("appLogin",[]);

angular.module("appLogin").controller("appLoginCtrl", function($scope, $http){

	
	urlUsuario = 'http://localhost:8080/ProjetoBancoDeDados/rest/login';

	$scope.listarUsuarios = function () {
	     $http.get(urlUsuario).then(successCallback, errorCallback);
	 
	     function successCallback(response){
	         $scope.clientes = response.data;
	     }
	     function errorCallback(error){
	         alert("erro no get");
	     }
	 }
	

	
	
	
	$scope.entrar = function(cliente){
		
		  $http.post(urlUsuario, cliente).then(function (response){
		    	$scope.cliente = response.data;
//		    	
		    	
		    	
		    	if($scope.cliente.nome === undefined){
		    		alert("Email ou senha incorretos");
		    	}else{
		    		window.location.replace("http://localhost:8080/ProjetoBancoDeDados/");
		    		
		    	}
		    	

		    	$scope.listarUsuarios();
	     });
	
		
		
		
		
		
	};

	$scope.listarUsuarios();

});
