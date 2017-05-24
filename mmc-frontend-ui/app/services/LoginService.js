define([
	'angular'
], function (
	ng
) {
	'use strict';

	var loginService = ng.module('app.loginService' , []);

	return loginService.factory( 'loginService', ['$http',  function ( $http ) {

		// Adding a dev url for local, comment out in index.html before deployment!
		var url = 'http://www.mahamandalchicagomobile.org/mmc_ver_2/login/admin';

		return {
			login: function ( loginData ) {
				return $http.post( url, loginData );
			}
		};
	}]);
});
