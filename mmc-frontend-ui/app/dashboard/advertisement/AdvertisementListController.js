define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'advertisementService' ,
	function ( $scope ,  $location , advertisementService ) {




                var success = function( data ) {
                   $scope.ads = data;

                };

                var error = function( data ) {
                    console.log(data);
                };

                advertisementService.list().success( success ).error( error );

	}];
});