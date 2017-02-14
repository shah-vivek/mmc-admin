define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', '$stateParams' , 'ticketService' , 'eventService',
	function ( $scope ,  $location , $stateParams ,ticketService , eventService) {

                var eventSuccess = function(data) {
                    $scope.events = data;
                };

                var eventError = function(data) {

                };

                eventService.list().success( eventSuccess ).error( eventError );


                var ticketSuccess = function(data) {
                    $scope.ticket = data;
                };

                var ticketError = function(data ) {

                };
                ticketService.get( $stateParams.ticketId ).success( ticketSuccess).error( ticketError);




            var updateTicketSuccess = function(data) {
                alert(data.statusMsg);
            };

            var updateTicketError = function(data) {

            };

            $scope.add = function() {
                ticketService.update($scope.ticket).success( updateTicketSuccess ).error( updateTicketError );
            };

	}];
});