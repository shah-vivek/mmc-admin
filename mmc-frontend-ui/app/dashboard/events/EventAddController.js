define([
	'angular',
	'flatpickr',
	'moment',
], function (
	ng,
	flatpickr,
	moment
) {
	'use strict';
	return [ '$scope' , '$location', 'eventService' ,
	function ( $scope ,  $location , eventService ) {

        $scope.event = {};
        $scope.add = function() {
            $scope.event.eventStart = moment($scope.event.eventStart).toJSON();
            $scope.event.eventEnd = moment($scope.event.eventEnd).toJSON();
            eventService.add( $scope.event ).success( addSuccess ).error( addError );
        };

        var addSuccess = function( data ){
            alert(data.statusMsg);
        };

        var addError = function( data ){


        };



        document.getElementById("start").flatpickr( {
                                    enableTime: true,
                                    defaultDate: $scope.event.eventStart,

                                    altInput: true,
                                    altFormat: "Y-m-d h:i K"
                                });

        document.getElementById("end").flatpickr( {
                                    enableTime: true,
                                    utc: true,
                                    defaultDate: $scope.event.eventEnd,

                                    altInput: true,
                                    altFormat: "Y-m-d h:i K"
                                });
	}];
});