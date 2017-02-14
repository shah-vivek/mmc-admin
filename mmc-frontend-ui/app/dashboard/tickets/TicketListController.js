define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'ticketService' ,
	function ( $scope ,  $location , ticketService ) {

     var ticketSuccess = function ( data ) {
    	        $scope.tickets = data;
    	    };

    	    var ticketError = function( data ) {
    	    };

    	    ticketService.list().success( ticketSuccess ).error( ticketError );

             $scope.delete = function( ticket ) {
                            $scope.true = confirm('Delete '+ticket.ticketName+' ?');
                            if( $scope.true ){
                                ticketService.delete( ticket.ticketId ).success( deleteTicketSuccess ).error( deleteTicketError );
                            }
                        };


             var deleteTicketError = function( data ) {

             };

             var deleteTicketSuccess = function( data ) {
                ticketService.list().success( ticketSuccess ).error( ticketError );
             };

	}];
});