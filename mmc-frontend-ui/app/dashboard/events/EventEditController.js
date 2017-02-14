define([
	'angular',
	'flatpickr',
	'moment'

], function (
	ng,
	flatpickr,
	moment
) {
	'use strict';
	return [ '$scope' , '$location', '$stateParams' , 'eventService' ,
	function ( $scope ,  $location ,  $stateParams ,eventService ) {

            var startPicker , endPicker;
            var getEventSuccess = function( data ) {

                $scope.event = data;
                $scope.eventClone = ng.copy( $scope.event );


               startPicker =  document.getElementById("start").flatpickr( {
                            enableTime: true,
                            utc: true,
                            defaultDate: $scope.eventClone.eventStart,

                            altInput: true,
                            altFormat: "Y-m-d h:i K"
                        });

               endPicker = document.getElementById("end").flatpickr( {
                            enableTime: true,
                            utc: true,
                            defaultDate: $scope.eventClone.eventEnd,

                            altInput: true,
                            altFormat: "Y-m-d h:i K"
                         });

            };

            var getEventError = function( data ) {

            };

            eventService.get( $stateParams.id ).success( getEventSuccess ).error( getEventError );

            $scope.save = function(){
                    $scope.eventClone.eventStart = moment($scope.eventClone.eventStart).toJSON();
                    $scope.eventClone.eventEnd = moment($scope.eventClone.eventEnd).toJSON();
                    eventService.update( $scope.eventClone ).success( saveSuccess ).error( saveError );
            };

            var saveSuccess = function( data ){
                 alert(data.statusMsg);
                 $scope.event = ng.copy( $scope.eventClone );
            };

            var saveError = function( data ){

            };

            $scope.reset = function(){
                $scope.eventClone = ng.copy( $scope.event );
                startPicker.destroy();
                endPicker.destroy();
                startPicker =  document.getElementById("start").flatpickr( {
                                            enableTime: true,
                                            defaultDate: $scope.eventClone.eventStart,

                                            altInput: true,
                                            altFormat: "Y-m-d h:i K"
                                        });

                endPicker = document.getElementById("end").flatpickr( {
                                            enableTime: true,
                                            utc: true,
                                            defaultDate: $scope.eventClone.eventEnd,

                                            altInput: true,
                                            altFormat: "Y-m-d h:i K"
                                         });
            };

	}];
});