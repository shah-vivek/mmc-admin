define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location' , 'loginService', 'localStorageService',
	function ( $scope ,  $location , loginService , localStorageService) {

	    $scope.loginData = {
	        email: '',
	        password: ''
	    };

        var successCallback = function( data ) {
            if( data.status ) {
               $scope.errorMsg = data.status.statusMsg;
               alert($scope.errorMsg);
            } else {

                localStorageService.set('user',data.userDetails);
                $location.path('/dashboard/member/list');
            }
        };

        var errorCallback = function( data ) {
            console.log(data);
        };

	    $scope.login = function() {
            loginService.login($scope.loginData).success( successCallback ).error( errorCallback );
	    };

	}];
});