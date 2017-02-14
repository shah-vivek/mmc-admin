define([
	'angular'
], function (
	ng
) {
	'use strict';

	var localStorageService = ng.module('app.localStorage' , []);

	return localStorageService.factory( 'localStorageService', [  function (  ) {


        var setItem = function( key , value ) {
            if( typeof value === 'object' ) {
                localStorage.setItem( key , JSON.stringify(value));
            } else {
                localStorage.setItem( key , value );
            }

        };

        var getItem = function( key ) {
            var returnValue = localStorage.getItem( key );

            if( returnValue && returnValue[0] == '{' ) {
                return JSON.parse( returnValue );
            } else {
                return returnValue;
            }
        };


		return {

			set : function ( key , value ){

			    setItem(key, value);
			},

			get : function( key  ) {

			    return getItem( key );
			},

			remove : function ( key ) {

			    localStorage.removeItem( key );
			}

		};
	}]);
});
