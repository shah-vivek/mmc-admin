define([
	'angular'
], function (
	ng
) {
	'use strict';

	var advertisementService = ng.module('app.appHomePageService' , []);

	return advertisementService.factory( 'appHomePageService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/home_page';

		return {
			add: function ( event ) {
                 return $http.post( url+'/add' , event);
			},

			update: function ( event ) {
               	return $http.put( url+'/update', event );
            },

			list: function() {
			    return $http.get( url+'/list' );
			},

			get: function( id ) {
			    return $http.get( url+'/get?eventId='+id );
			},

			delete: function( id ) {
            	return $http.delete( url+'/delete?eventId='+id );
            }

		};
	}]);
});
