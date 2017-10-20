define([
	'angular'
], function (
	ng
) {
	'use strict';

	var membershipTypeService = ng.module('app.membershipTypeService' , []);

	return membershipTypeService.factory( 'membershipTypeService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/membership';

		return {
			add: function ( membership ) {
				return $http.post( url+'/add', membership );
			},

			update: function ( membership ) {
               	return $http.put( url+'/update', membership );
            },

			list: function() {
			    return $http.get( url+'/list' );
			},

			get: function( id ) {
			    return $http.get( url+'/get?membershipTypeId='+id );
			},

			delete: function( id ) {
            	return $http.delete( url+'/delete?membershipTypeId='+id );
            }

		};
	}]);
});
