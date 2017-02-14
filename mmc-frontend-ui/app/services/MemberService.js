define([
	'angular'
], function (
	ng
) {
	'use strict';

	var memberService = ng.module('app.memberService' , []);

	return memberService.factory( 'memberService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://localhost:8081/members';

		return {
			add: function ( member ) {
				return $http.post( url+'/add', member );
			},

			update: function ( member ) {
               	return $http.put( url+'/update', member );
            },

			list: function() {
			    return $http.get( url+'/list' );
			},

			get: function( id ) {
			    return $http.get( url+'/get?email='+id );
			},

			delete: function( id ) {
            	return $http.delete( url+'/delete?email='+id );
            }

		};
	}]);
});
