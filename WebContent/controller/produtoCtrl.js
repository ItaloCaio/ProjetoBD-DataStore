angular.module("appHotel",[]);

angular.module("appHotel").controller("produtoCtrl", function($scope, $http){

	urlProduto = 'http://localhost:8080/ProjetoBancoDeDados/rest/produto';
	urlCarrinho = 'http://localhost:8080/ProjetoBancoDeDados/rest/carrinho';
	urlCliente = 'http://localhost:8080/ProjetoBancoDeDados/rest/login';
	
	
	$scope.categorias = 
		[
			 'Telefonia',
			'Informática',
			'Tv e Acessórios',
			'Eletrodomésticos',
			'Móveis',
			'Eletroportáteis',
			'Outros'
		];
	
	
	$scope.listarProdutos = function () {
	    $http.get(urlProduto).then(successCallback, errorCallback);
	 
	    function successCallback(response){
	        $scope.produtos = response.data;
	     }
	     function errorCallback(error){
	         alert("erro no get");
	     }
	}
	     
	  $scope.removeCliente = function(){
	 		
	 		$http.delete(urlCliente).then(function (response){
	 		
	 		
	
	 		});


	 }
	  
	$scope.listarUsuario = function () {
	    $http.get(urlCliente).then(successCallback, errorCallback);
	 
	    function successCallback(response){
	        $scope.clientes = response.data;
	        
	      
	        
		        var teste = function(cliente){
		        	$scope.cliente = cliente;
		        }
		        
		        
		      $scope.clientes.forEach(teste) ;
		      console.log($scope.cliente);
	        
	     }
	     function errorCallback(error){
	         alert("erro no get");
	     }
	}

	
	$scope.listarProCar = function () {
	    $http.get(urlCarrinho).then(successCallback, errorCallback);
	 
	    function successCallback(response){
	        $scope.produtosCar = response.data;
	     }
	     function errorCallback(error){
	         alert("erro no get");
	     }



	 }
	
	$scope.selecionaUsuario = function(usuarioSelecionado) {
		$scope.clientes= usuarioSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.cliente = "";
	}
	
	
	$scope.adicionaProduto = function(produto){
		produto.cliente = $scope.cliente;
		$http.post(urlProduto, produto).then(function (response){
	    	
	    	

			 delete $scope.produto;
		    $scope.listarProdutos();
	    });
	
		
		
		
	};
	
	$scope.adicionaNoCarrinho = function(produto, cliente){
		
		$http.post(urlCarrinho, produto, cliente).then(function (response){
			
			
			
			
	    });
	
		
		
		
	};
	
	

	$scope.limparCampos = function(){

		delete $scope.produto;
	}
	
	$scope.listarUsuario();
	$scope.listarProdutos();

});
