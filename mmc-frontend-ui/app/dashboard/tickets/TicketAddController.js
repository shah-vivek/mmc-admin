define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'eventService' , 'ticketService',
	function ( $scope ,  $location , eventService , ticketService ) {

            var eventSuccess = function(data) {
                $scope.events = data;
            };

            var eventError = function(data) {

            };

            eventService.list().success( eventSuccess ).error( eventError );


            var addTicketSuccess = function(data) {
                alert(data.statusMsg);
            };

            var addTicketError = function(data) {

            };

            $scope.add = function() {
                ticketService.add($scope.ticket).success( addTicketSuccess ).error( addTicketError );
            };

	}];
});