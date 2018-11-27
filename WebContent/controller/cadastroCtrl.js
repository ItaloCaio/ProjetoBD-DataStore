angular.module("appHotel",[]);

angular.module("appHotel").controller("appCadastroCtrl", function($scope, $http){

	urlCadastro = 'http://localhost:8080/ProjetoBancoDeDados/rest/cadastro';

	$scope.listarUsuarios = function () {
	     $http.get(urlCadastro).then(successCallback, errorCallback);
	 
	     function successCallback(response){
	         $scope.clientes = response.data;
	     }
	     function errorCallback(error){
	         alert("erro no get");
	     }
	 }
	
	
	
	$scope.selecionaUsuario = function(usuarioSelecionado) {
		$scope.cliente = usuarioSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.cliente = "";
	}
	
	
	$scope.salvar = function(cliente){
		
		 $http.post(urlCadastro, cliente).then(function (response){
	    	
			 delete $scope.cliente;
		    	listarUsuarios();
	     });
	
		
		
		
	};

	$scope.listarUsuarios();

});
