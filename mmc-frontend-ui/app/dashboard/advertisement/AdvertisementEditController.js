define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location','$stateParams' , 'advertisementService' ,
	function ( $scope ,  $location , $stateParams , advertisementService ) {




                var success = function( data ) {
                   $scope.ad = data;

                };

                var error = function( data ) {
                    console.log(data);
                };

                advertisementService.get( $stateParams.id ).success( success ).error( error );

                 var addSuccess = function( data ) {
                       alert(data.statusMsg);

                 };

                 var addError = function( data ) {
                        console.log(data);
                 };
                 advertisementService.update( $scope.imageData , $scope.ad ).success( success ).error( error );
	}];
});