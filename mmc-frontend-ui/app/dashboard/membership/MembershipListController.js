define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'membershipTypeService',
	function ( $scope ,  $location , membershipTypeService) {



		var listSuccess = function( data ){

            $scope.memberships = data;
        };

        var listError = function( data ){

        };

        membershipTypeService.list().success( listSuccess ).error( listError );

        $scope.delete = function( membership ) {
	        $scope.true = confirm('Are you sure you want to delete' +  membership.name +' ?');
	        if( $scope.true ){
	            membershipTypeService.delete( membership.id ).success( deleteMembershipSuccess ).error( deleteMembershipError );
	        }
        };


        var deleteMembershipSuccess = function () {
        	membershipTypeService.list().success( listSuccess ).error( listError );
        };

        var deleteMembershipError = function () {
        	alert( 'Internal server error ... could not be deleted !!');
        };



	}];
});