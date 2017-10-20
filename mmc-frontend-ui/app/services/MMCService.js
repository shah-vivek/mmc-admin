define([
	'angular'
], function (
	ng
) {
	'use strict';

	var mmcService = ng.module('app.mmcService' , []);

	return mmcService.factory( 'mmcService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/mmc';

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
