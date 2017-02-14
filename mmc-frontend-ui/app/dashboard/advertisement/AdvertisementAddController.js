define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'advertisementService' ,
	function ( $scope ,  $location , advertisementService ) {



                $scope.add = function(){
                    advertisementService.add($scope.adImage , $scope.ad).success( addSuccess ).error( addError );
                };

                var addSuccess = function( data ) {
                    console.log(data);
                    alert(data.statusMsg);

                };

                var addError = function( data ) {
                    console.log(data);
                };

	}];
});