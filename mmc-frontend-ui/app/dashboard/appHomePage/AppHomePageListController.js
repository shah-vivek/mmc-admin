define([
	'angular'
], function (
	ng
) {
	'use strict';
	return [ '$scope' , 'appHomePageService' ,
	function ( $scope , appHomePageService) {


       var listSuccess = function(data) {
       		$scope.events = data;
       };

       var listError = function(data) {

       };

        appHomePageService.list().success( listSuccess ).error( listError );

	}];
});