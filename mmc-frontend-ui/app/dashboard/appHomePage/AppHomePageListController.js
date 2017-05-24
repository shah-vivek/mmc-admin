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


        $scope.delete = function( id ) {
        	$scope.true = confirm('Are you sure you want to delete this ?');
                if( $scope.true ){
                    appHomePageService.delete( id ).success( deleteBannerSuccess ).error( deleteBannerError );
                }
        };


        var deleteBannerSuccess = function () {
        	appHomePageService.list().success( listSuccess ).error( listError );
        };

        var deleteBannerError = function () {
        	alert( 'Internal server error ... could not be deleted !!');
        };

	}];
});