define([
	'angular'
], function (
	ng
) {
	'use strict';
	return [ '$scope' , 'appHomePageService' ,
	function ( $scope , appHomePageService ) {
       
        var addSuccess = function () {
	    	alert('Added');
	    	$scope.event = {};
	    };

    var addError = function ( data ) {
    	alert('Error happenede');
    };
    $scope.add = function () {

    	appHomePageService.add( $scope.event ).success( addSuccess ).error( addError );
    };

	}];
});