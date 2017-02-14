define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location', 'memberService',
	function ( $scope ,  $location , memberService) {

            var getListSuccess = function( data ) {
                $scope.members = data;
            };

            var getListError = function( data ) {
                console.log(data);
            };

            memberService.list().success( getListSuccess ).error( getListError );


            var deleteMemberSuccess = function( data ) {
                memberService.list().success( getListSuccess ).error( getListError );
            };

            var deleteMemberError = function( data ) {

            };

            $scope.delete = function( email ) {
                $scope.true = confirm('Delete '+email+' ?');
                if( $scope.true ){
                    memberService.delete( email ).success( deleteMemberSuccess ).error( deleteMemberError );
                }
            };

	}];
});