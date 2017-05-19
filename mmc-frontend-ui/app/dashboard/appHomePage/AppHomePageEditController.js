define([
	'angular'
], function (
	ng
) {
	'use strict';
	return [ '$scope' , 'appHomePageService' , '$stateParams' ,
	function ( $scope , appHomePageService , $stateParams) {
      

	var getSuccess = function ( data ) {
		$scope.event = data;
		$scope.eventClone = ng.copy( $scope.event );
	};

	var getError = function( data ) {

	};


    appHomePageService.get($stateParams.id).success(getSuccess).error(getError);


    $scope.reset = function () {
    	$scope.eventClone = ng.copy( $scope.event );
    };


    var addSuccess = function () {
    	alert('Updated');
    	$scope.event = ng.copy($scope.eventClone);
    };

    var addError = function ( data ) {
    	alert('Error happenede');
    };
    $scope.add = function () {

    	appHomePageService.update( $scope.eventClone ).success( addSuccess ).error( addError );
    };

	}];
});