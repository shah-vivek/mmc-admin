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

            $scope.delete = function( event ) {
	        	$scope.true = confirm('Are you sure you want to delete' +  event.eventName +' ?');
	                if( $scope.true ){
	                    eventService.delete( event.eventId ).success( deleteEventSuccess ).error( deleteEventError );
	                }
        	};


        var deleteEventSuccess = function () {
        	eventService.list().success( listSuccess ).error( listError );
        };

        var deleteEventError = function () {
        	alert( 'Internal server error ... could not be deleted !!');
        };

	}];
});