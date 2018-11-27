angular.module("appHotel",[]);

angular.module("appHotel").controller("carrinhoCtrl", function($scope, $http){

	urlCarrinho = 'http://localhost:8080/ProjetoBancoDeDados/rest/carrinho';

	

	$scope.listarUsuarios = function () {
	    $http.get(urlCarrinho).then(successCallback, errorCallback);
	 
	    function successCallback(response){
	        $scope.produtos = response.data;
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
	
	
	$scope.adicionaProduto = function(produto){
		
		$http.post(urlCarrinho, produto).then(function (response){
	    });
	
		
		
		
	};

	$scope.limparCampos = function(){

		delete $scope.produto;
	}

	$scope.listarUsuarios();

});
