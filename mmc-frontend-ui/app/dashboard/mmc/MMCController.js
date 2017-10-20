define([
	'angular'
], function (
	ng
) {
	'use strict';
	return [ '$scope' , 'mmcService',
	function ( $scope , mmcService ) {

		var getSuccess = function(data) {
			$scope.mmc = data;
			$scope.mmcClone = ng.copy($scope.mmc);
			if( $scope.mmc.content != null ) {
				$scope.isDataPresent = true;
			}
		};

		var getError = function(data) {

		};

		mmcService.get().success( getSuccess ).error( getError );


		$scope.add = function() {

			if( $scope.isDataPresent ) {
				mmcService.update($scope.presidentClone).success( addSuccess ).error( addError );
			} else {
				mmcService.add($scope.presidentClone).success( addSuccess ).error( addError );
			}
			
		};

		var addSuccess = function(data) {

		};

		var addError = function(data) {

		};

		$scope.reset = function() {
			$scope.mmcClone = $scope.mmc;
		};
      

	}];
});