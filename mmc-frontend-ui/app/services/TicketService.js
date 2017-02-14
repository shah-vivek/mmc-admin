define([
	'angular'
], function (
	ng
) {
	'use strict';

	var ticketService = ng.module('app.ticketService' , []);

	return ticketService.factory( 'ticketService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://localhost:8081/ticket';

		return {
			add: function ( ticket ) {
				return $http.post( url+'/add', ticket );
			},

			update: function ( ticket ) {
               	return $http.put( url+'/update', ticket );
            },

			list: function() {
			    return $http.get( url+'/list' );
			},

			get: function( id ) {
			    return $http.get( url+'/get?ticketId='+id );
			},

			delete: function( id ) {
            	return $http.delete( url+'/delete?ticketId='+id );
            }

		};
	}]);
});
