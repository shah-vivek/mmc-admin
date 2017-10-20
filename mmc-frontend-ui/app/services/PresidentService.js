define([
	'angular'
], function (
	ng
) {
	'use strict';

	var presidentService = ng.module('app.presidentService' , []);

	return presidentService.factory( 'presidentService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/presidentCorner';

		return {
			add: function ( presidentCorner ) {
				return $http.post( url+'/add', presidentCorner );
			},

			update: function ( presidentCorner ) {
               	return $http.put( url+'/update', presidentCorner );
            },
			get: function(  ) {
			    return $http.get( url+'/get');
			}

		};
	}]);
});
