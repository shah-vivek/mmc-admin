define([
	'angular'
], function (
	ng
) {
	'use strict';
	return [ '$scope' , 'presidentService',
	function ( $scope , presidentService ) {

		var getSuccess = function(data) {
			$scope.president = data;
			$scope.presidentClone = ng.copy($scope.president);
			if( $scope.president.content !== null ) {
				$scope.isDataPresent = true;
			}
		};

		var getError = function(data) {

		};

		presidentService.get().success( getSuccess ).error( getError );


		$scope.add = function() {

			if( $scope.isDataPresent ) {
				presidentService.update($scope.presidentClone).success( addSuccess ).error( addError );
			} else {
				presidentService.add($scope.presidentClone).success( addSuccess ).error( addError );
			}
			
		};

		var addSuccess = function(data) {
			alert(data.statusMsg);
		};

		var addError = function(data) {

		};

		$scope.reset = function() {
			$scope.presidentClone = $scope.president;
		};
      

	}];
});