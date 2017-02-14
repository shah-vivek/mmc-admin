define([
	'angular'

], function (
	ng
) {
	'use strict';
	return [ '$scope' , '$location',  'memberService' ,
	function ( $scope ,  $location ,  memberService) {

        $scope.member = {
                         "email": null,
                         "firstName": null,
                         "lastName": null,
                         "phone": null,
                         "address": null,
                         "type": null,
                         "status": true
        };


        $scope.add = function(){
            $scope.info.email = $scope.member.email;
            $scope.info.password = $scope.member.email;

            memberService.add( $scope.info ).success( addSuccess ).error( addError );
        };

        var addSuccess  = function( data ){

                alert( data.statusMsg );
                if( data.status == 'SUCCESS'){
                    $location.path('/dashboard/member/list');
                }
        };

        var addError = function( data ) {

        };


	}];
});