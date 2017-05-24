define([
	'angular'
], function (
	ng
) {
	'use strict';

	var eventService = ng.module('app.eventService' , []);

	return eventService.factory( 'eventService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/events';

		return {
			list: function (  ) {
				return $http.get( url+'/list' );
			},

			get: function( eventId ) {
			    return $http.get( url+'/get?eventId='+eventId );
			},

			update: function( event ) {
			    return $http.put( url+'/update' , event );
			},

			add: function( event ) {
			    return $http.post( url+'/add' , event );
			},

			delete: function( eventId ) {
			    return $http.delete( url+'/delete?eventId='+eventId , event );
			},
		};
	}]);
});
