define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'eventService' ,
	function ( $scope ,  $location , eventService ) {


            var listSuccess = function( data ){

                $scope.events = data;
            };

            var listError = function( data ){

            };

            eventService.list().success( listSuccess ).error( listError );

	}];
});